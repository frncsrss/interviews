package interviews.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Binary Search Tree.
 * @author Francois Rousseau
 */
public class BST<E> {
  private BSTNode<E> root;
  private final Comparator<E> comparator;

  public BST(Comparator<E> comparator) {
    this.comparator = comparator;
  }

  public BST(E e, Comparator<E> comparator) {
    this(comparator);
    root = new BSTNode<E>(e, comparator);
  }

  public BST(Collection<E> collection, Comparator<E> comparator) {
    this(comparator);
   for(E e : collection) {
      if(root == null) {
        root = new BSTNode<E>(e, comparator);
      } else {
        root.add(e);
      }
    }
  }

  /**
   *  Inserts the specified element into this BST.
   */
  public boolean add(E e) throws NullPointerException {
    if(e == null) {
      throw new NullPointerException();
    }
    if(root == null) {
      root = new BSTNode<E>(e, comparator);
    } else {
      root.add(e);
    }
    return true;
  }

  /**
   *  Returns the comparator used to order the elements in this BST.
   */
  public Comparator<E> comparator() {
    return comparator;
  }

  /**
   *  Returns the minimal element of this BST.
   */
  public E min() {
    if(root == null) {
      throw new NoSuchElementException();
    }
   return root.min();
  }

  /**
   *  Returns the maximal element of this BST.
   */
  public E max() {
    if(root == null) {
      throw new NoSuchElementException();
    }
    return root.max();
  }

  /**
   * Removes a single instance of the specified element from this BST, if it is present.
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
        root.value = root.right.min();
        root.right.remove(root.value, root);
      }
      return true;
    } else if(result > 0) {  // move to the right
      if(root.right == null) {  // no right child, nothing to remove
        return false;
      }
      return root.right.remove(e, root);
    } else {  // move to the left
      if(root.left == null) {  // no left child, nothing to remove
        return false;
      }
      return root.left.remove(e, root);
    }
  }

  /**
   *  Search a given element in this BST.
   *  Returns a boolean value accordingly.
   */
  public boolean search(E e) throws NullPointerException {
    if(root == null) {
      return false;
    }
    return root.search(e);
  }

  /**
   *  In-order traversal of this BST.
   *  Append the values to a given collection sorted at the end.
   */
  public void traversal(Collection<E> collection) {
    if(root == null) {
      return;
    }
    root.traversal(collection);
  }

  /**
   *  In-order traversal of this BST.
   *  Return a sorted collection of the values in the BST.
   */
  public Collection<E> traversal() {
    if(root == null) {
      return null;
    }
    Collection<E> collection = new ArrayList<E>();
    root.traversal(collection);
    return collection;
  }

  /**
   *  Breadth-first traversal of this BST.
   */
  @Override
  public String toString() {
    if(root == null) {
      return "";
    }
    final StringBuilder buffer = new StringBuilder();
    final Queue<BSTNode<E>> queue = new LinkedList<BSTNode<E>>();
    queue.add(root);
    while(!queue.isEmpty()) {
      BSTNode<E> current = queue.poll();
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
}