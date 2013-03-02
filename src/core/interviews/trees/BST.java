package interviews.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Binary Search Tree.
 * @author Francois Rousseau
 */
public class BST<E> {
  protected Node root;
  protected final Comparator<E> comparator;

  public BST(Comparator<E> comparator) {
    this.comparator = comparator;
  }

  public BST(E e, Comparator<E> comparator) {
    this(comparator);
    root = new Node(e);
  }

  public BST(Collection<E> collection, Comparator<E> comparator) {
    this(comparator);
    for(E e : collection) {
      root = insert(root, e);
    }
  }

  /**
   * Return the comparator used to order the elements in this BST.
   */
  public Comparator<E> comparator() {
    return comparator;
  }

  /**
   * Insert the specified element into this BST.
   */
  public boolean insert(E e) throws NullPointerException {
    if(e == null) {
      throw new NullPointerException();
    }
    root = insert(root, e);
    return true;
  }

  /**
   * Return the minimal element of this BST.
   */
  public E min() {
    if(root == null) {
      throw new NoSuchElementException();
    }
   return min(root);
  }

  /**
   * Return the maximal element of this BST.
   */
  public E max() {
    if(root == null) {
      throw new NoSuchElementException();
    }
    return max(root);
  }

  /**
   * Remove a single instance of the specified element from this BST, if it is present.
   * Uses Hibbard deletion: it is not symmetric and can yield to a height of sqrt(N) instead of log(N)
   */
  public boolean remove(E e) {
    if(e == null) {
      throw new NullPointerException();
    }
    if(root == null) {
      return false;
    }
    final int result = comparator.compare(e, root.value);
    if(result == 0) {  // we found the node
      if(root.left == null && root.right == null) {  // no children, the root should be null
        root = null;
      } else if(root.left == null) {  // no left child, the root should become the right child
        root = root.right;
      } else if(root.right == null) {  // no right child, the root should become the left child
        root = root.left;
      } else {  // two children, this is the tricky part
        root.value = min(root.right);
        remove(root.right, root.value, root);
      }
      return true;
    } else if(result > 0) {  // move to the right
      if(root.right == null) {  // no right child, nothing to remove
        return false;
      }
      return remove(root.right, e, root);
    } else {  // move to the left
      if(root.left == null) {  // no left child, nothing to remove
        return false;
      }
      return remove(root.left, e, root);
    }
  }

  /**
   * Search a given element in this BST.
   * Returns a boolean value accordingly.
   */
  public boolean search(E e) {
    if(root == null) {
      return false;
    }
    return search(root, e);
  }

  /**
   * In-order traversal of this BST with recursion.
   * Return a sorted collection of the values in the BST.
   */
  public List<E> traversalInOrderRecursive() {
    if(root == null) {
      return null;
    }
    List<E> list = new ArrayList<E>();
    traversalInOrderRecursive(root, list);
    return list;
  }

  /**
   * In-order traversal of this BST without recursion (Morris traversal).
   * Return a sorted collection of the values in the BST.
   */
  public List<E> traversalInOrderNonRecursive() {
    if(root == null) {
      return null;
    }
    List<E> list = new ArrayList<E>();
    traversalInOrderNonRecursive(list);
    return list;
  }

  /**
   * Breadth-first traversal of this BST.
   */
  @Override
  public String toString() {
    if(root == null) {
      return "";
    }
    final StringBuilder buffer = new StringBuilder();
    final Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(!queue.isEmpty()) {
      Node current = queue.poll();
      buffer.append(current.value + " ");
      if(current.left != null) {
        queue.add(current.left);
      }
      if(current.right != null) {
        queue.add(current.right);
      }
    }
    return buffer.deleteCharAt(buffer.length() - 1).toString();
  }


  /**
   * Insert the specified element under this Node and returns it.
   */
  private Node insert(Node node, E value) {
    if(node == null) {
      return new Node(value);
    }
    final int result = comparator.compare(value, node.value);
    // we consider our BST as a Set
    // Hence, we don't insert an element already in the BST (i.e. result == 0)
    // we just increment is frequency
    if(result == 0) {
      node.frequency++;
    } else if(result > 0) {
      node.right = insert(node.right, value);          
    } else {  // (result < 0)
      node.left = insert(node.left, value);
    }
    return node;
  }

  /**
   * Return the minimal element under this Node.
   */
  private E min(Node node) {
    if(node.left == null) {
      return node.value;
    }
    return min(node.left);
  }

  /**
   * Return the maximal element under this Node.
   */
  private E max(Node node) {
    if(node.right == null) {
      return node.value;
    }
    return max(node.right);
  }

  /**
   * Search a given element under this Node.
   * Returns a boolean value accordingly.
   */
  private boolean search(Node node, E e) {
    final int result = comparator.compare(e, node.value);
    if(result == 0) {  // search hit
      return true;
    }
    if(result > 0) {
      return (node.right == null) ? false : search(node.right, e);
    }
    return (node.left == null) ? false : search(node.left, e);
  }

  /**
   * In-order traversal of the subtree under this Node with recursion.
   * Append the value to a given collection sorted at the end.
   */
  private void traversalInOrderRecursive(Node node, Collection<E> collection) {
    if(node.left != null) {
      traversalInOrderRecursive(node.left, collection);
    }
    for(int i = 0; i < node.frequency; i++) {
      collection.add(node.value);
    }
    if(node.right != null) {
      traversalInOrderRecursive(node.right, collection);
    }
  }

  /**
   * Remove a single instance of the specified element from under this Node, if it is present.
   * Uses Hibbard deletion: it is not symmetric and can yield to a height of sqrt(N) instead of log(N)
   */
  private boolean remove(Node node, E e, Node parent) {
    final int result = comparator.compare(e, node.value);
    if(result == 0) {  // we found the node
      if(node.left == null && node.right == null) {  // no children, the parent should point to null
        if(parent.left == node) {
          parent.left = null;
        } else {
          parent.right = null;
        }
      } else if(node.left == null) {  // no left child, the parent should point to the right child
        if(parent.left == node) {
          parent.left = node.right;
        } else {
          parent.right = node.right;
        }
      } else if(node.right == null) {  // no right child, the parent should point to the left child
        if(parent.left == node) {
          parent.left = node.left;
        } else {
          parent.right = node.left;
        }
      } else {  // two children, this is the tricky part
        node.value = min(node.right);
        remove(node.right, node.value, node);
      }
      return true;
    } else if(result > 0) {  // move to the right
      if(node.right == null) {  // no right child, nothing to remove
        return false;
      }
      return remove(node.right, e, node);
    } else {  // move to the left
      if(node.left == null) {  // no left child, nothing to remove
        return false;
      }
      return remove(node.left, e, node);
    }    
  }

  /**
   * In-order traversal of the subtree under this Node without recursion (Morris traversal).
   * Append the value to a given collection sorted at the end.
   */
  private void traversalInOrderNonRecursive(Collection<E> collection) {
    if(root == null) {
      return;
    }
    Node current, tmp;  // current root and temporary parent
    current = root;
    while(current != null) {
      if(current.left == null) {  // we reached the leftmost child
        collection.add(current.value);
        current = current.right;
      } else {  // find the in-order predecessor of current
        tmp = current.left;
        // make tmp the rightmost child of the left subtree (in-order predecessor of current)
        while(tmp.right != null && tmp.right != current) {
          tmp = tmp.right;
        }
        if(tmp.right == null) {  // make current the right child of its in-order predecessor
          tmp.right = current;
          current = current.left;
        } else {  // tmp.right == current - a temporary parent has been found
          tmp.right = null;  // cut the right pointer of the current parent - no longer a parent
          collection.add(current.value);
          current = current.right;
        } 
      } 
    } 
  }


  /**
   * Private inner class for an internal BST node.
   */
  private class Node {
    private E value;
    private Node left;
    private Node right;
    private int frequency;

    private Node(E value) {
      this.value = value;
      this.frequency++;
    }
  }
}