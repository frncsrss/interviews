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
   * Return the smallest element greater than the given element in this BST.
   */
  public E ceiling(E e) throws NullPointerException {
    if(e == null) {
      throw new NullPointerException();
    }
    Node ceiling = ceiling(root, e);
    return (ceiling == null) ? null : ceiling.e;
  }

  /**
   * Return the number of elements in this BST between the two given elements (inclusive).
   */
  public int count(E lo, E hi) throws NullPointerException {
    if(lo == null || hi == null) {
      throw new NullPointerException();
    }
    if(search(hi)) {
      return rank(hi) - rank(lo) + 1;
    }
    return rank(hi) - rank(lo);
  }

  /**
   * Insert the specified element into this BST.
   */
  public void insert(E e) throws NullPointerException {
    if(e == null) {
      throw new NullPointerException();
    }
    root = insert(root, e);
  }

  /**
   * Return the largest element less than the given element in this BST.
   */
  public E floor(E e) throws NullPointerException {
    if(e == null) {
      throw new NullPointerException();
    }
    Node floor = floor(root, e);
    return (floor == null) ? null : floor.e;
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
   * Return the number of elements strictly less than the given element in this BST.
   */
  public int rank(E e) throws NullPointerException {
    if(e == null) {
      throw new NullPointerException();
    }
    return rank(root, e);
  }

  /**
   * Delete the given element from this BST, if it is present.
   * Uses Hibbard deletion: it is not symmetric and can yield to a height of sqrt(N) instead of log(N)
   */
  public void delete(E e) {
    if(e == null) {
      throw new NullPointerException();
    }
    root = delete(root, e);
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
   * Return the number of elements in this BST.
   */
  public int size() {
    return size(root);
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
      buffer.append(current.e + " ");
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
   * Return the smallest element greater than the given element under this Node.
   */
  private Node ceiling(Node node, E e) {
    if(node == null) {
      return null;
    }
    final int result = comparator.compare(e, node.e);
    if(result == 0) {
      return node;
    } else if(result > 0) {
      return ceiling(node.right, e);
    } else {  // (result > 0)
      Node tmp = ceiling(node.left, e);
      return (tmp == null) ? node : tmp;
    }
  }

  /**
   * Delete the given element from under this Node, if it is present.
   * Uses Hibbard deletion: it is not symmetric and can yield to a height of sqrt(N) instead of log(N)
   */
  protected Node delete(Node node, E e) {
    if(node == null) {
      return null;
    }
    final int result = comparator.compare(e, node.e);
    if(result == 0) {  // we found the node
      if(node.right == null) {
        return node.left;
      }
      if(node.left == null) {
        return node.right;
      }
      // two children, this is the tricky part
      node.e = min(node.right);  // set the current value to the leftmost node of the right subtree
      node.right = delete(node.right, node.e);  //delete the leftmost node of the right subtree
    } else if(result > 0) {  // move to the right
      node.right = delete(node.right, e);
    } else {  // move to the left
      node.left = delete(node.left, e);
    }
    node.size = 1 + size(node.left) + size(node.right);
    return node;
  }

  /**
   * Insert the specified element under this Node and returns it.
   */
  protected Node insert(Node node, E e) {
    if(node == null) {
      return new Node(e);
    }
    final int result = comparator.compare(e, node.e);
    // we consider our BST as a Set
    // Hence, we don't insert an element already in the BST (i.e. result == 0)
    // we just increment is frequency
    if(result == 0) {
      node.frequency++;
    } else if(result > 0) {
      node.right = insert(node.right, e);          
    } else {  // (result < 0)
      node.left = insert(node.left, e);
    }
    node.size = 1 + size(node.left) + size(node.right);
    return node;
  }

  /**
   * Return the largest element less than the given element under this Node.
   */
  private Node floor(Node node, E e) {
    if(node == null) {
      return null;
    }
    final int result = comparator.compare(e, node.e);
    if(result == 0) {
      return node;
    } else if(result < 0) {
      return floor(node.left, e);
    } else {  // (result > 0)
      Node tmp = floor(node.right, e);
      return (tmp == null) ? node : tmp;
    }
  }

  /**
   * Return the minimal element under this Node.
   */
  private E min(Node node) {
    if(node.left == null) {
      return node.e;
    }
    return min(node.left);
  }

  /**
   * Return the maximal element under this Node.
   */
  private E max(Node node) {
    if(node.right == null) {
      return node.e;
    }
    return max(node.right);
  }

  /**
   * Return the number of elements strictly less than the given element under this Node.
   */
  private int rank(Node node, E e) {
    if(node == null) {
      return 0;
    }
    final int result = comparator.compare(e, node.e);
    if(result == 0) {  // search hit
      return size(node.left);  // strictly less than
    }
    if(result > 0) {
      return 1 + size(node.left) + rank(node.right, e);
    }
    return rank(node.left, e);
  }

  /**
   * Search a given element under this Node.
   * Returns a boolean value accordingly.
   */
  private boolean search(Node node, E e) {
    final int result = comparator.compare(e, node.e);
    if(result == 0) {  // search hit
      return true;
    }
    if(result > 0) {
      return (node.right == null) ? false : search(node.right, e);
    }
    return (node.left == null) ? false : search(node.left, e);
  }

  /**
   * Return the number of elements under this Node.
   */
  protected int size(Node node) {
    if(node == null) {
      return 0;
    }
    return node.size;
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
      collection.add(node.e);
    }
    if(node.right != null) {
      traversalInOrderRecursive(node.right, collection);
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
        collection.add(current.e);
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
          collection.add(current.e);
          current = current.right;
        } 
      } 
    } 
  }


  /**
   * Protected inner class for an internal BST node.
   */
  protected class Node {
    protected E e;
    protected Node left;
    protected Node right;
    protected int frequency;
    protected int size;

    protected Node(E e) {
      this.e = e;
      this.frequency = 1;
      this.size = 1;
    }
  }
}