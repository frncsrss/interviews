package interviews.trees;

import java.util.Collection;
import java.util.Comparator;

/**
 * BSTNode.
 * @author Francois Rousseau
 */
public class BSTNode<E> extends BTNode<E> {
  protected BSTNode<E> left;
  protected BSTNode<E> right;
  protected int frequency;
  protected Comparator<E> comparator;

  public BSTNode(E e, Comparator<E> comparator) {
    this.comparator = comparator;
    add(e);
  }

  /**
   * Inserts the specified element under this BSTNode.
   */
  protected void add(E e) {
    if(value == null) {
      value = e;
      frequency++;
    } else {
      final int result = comparator.compare(e, value);
      // we consider our BST as a Set
      // Hence, we don't insert an element already in the BST (i.e. result == 0)
      // we just increment is frequency
      if(result == 0) {
        frequency++;
      } else if(result > 0) {
        if(right == null) {
          right = new BSTNode<E>(e, comparator);
        } else {
          right.add(e);          
        }
      } else {  // (result < 0)
        if(left == null) {
          left = new BSTNode<E>(e, comparator);
        } else {
          left.add(e);
        }
      }
    }
  }

  /**
   * Returns the minimal element under this BSTNode.
   */
  protected E min() {
    if(left == null) {
      return value;
    }
    return left.min();
  }

  /**
   * Returns the maximal element under this BSTNode.
   */
  protected E max() {
    if(right == null) {
      return value;
    }
    return right.max();
  }

  /**
   * Search a given element under this BSTNode.
   * Returns a boolean value accordingly.
   */
  protected boolean search(E e) throws NullPointerException {
    final int result = comparator.compare(e, value);
    if(result == 0) {  // search hit
      return true;
    }
    if(result > 0) {
      return (right == null) ? false : right.search(e);
    }
    return (left == null) ? false : left.search(e);
  }

  /**
   * In-order traversal of the subtree under this BSTNode with recursion.
   * Append the value to a given collection sorted at the end.
   */
  protected void traversalInOrderRecursive(Collection<E> collection) {
    if(left != null) {
      left.traversalInOrderRecursive(collection);
    }
    for(int i = 0; i < frequency; i++) {
      collection.add(value);
    }
    if(right != null) {
      right.traversalInOrderRecursive(collection);
    }
  }

  /**
   * Removes a single instance of the specified element from under this BSTNode, if it is present.
   * Uses Hibbard deletion: it is not symmetric and can yield to a height of sqrt(N) instead of log(N)
   */
  protected boolean remove(E e, BSTNode<E> parent) {
    final int result = comparator.compare(e, value);
    if(result == 0) {  // we found the node
      if(left == null && right == null) {  // no children, the parent should point to null
        if(parent.left == this) {
          parent.left = null;
        } else {
          parent.right = null;
        }
      } else if(left == null) {  // no left child, the parent should point to the right child
        if(parent.left == this) {
          parent.left = right;
        } else {
          parent.right = right;
        }
      } else if(right == null) {  // no right child, the parent should point to the left child
        if(parent.left == this) {
          parent.left = left;
        } else {
          parent.right = left;
        }
      } else {  // two children, this is the tricky part
        value = right.min();
        right.remove(value, this);
      }
      return true;
    } else if(result > 0) {  // move to the right
      if(right == null) {  // no right child, nothing to remove
        return false;
      }
      return right.remove(e, this);
    } else {  // move to the left
      if(left == null) {  // no left child, nothing to remove
        return false;
      }
      return left.remove(e, this);
    }    
  }

  /**
   * In-order traversal of the subtree under this BSTNode without recursion (Morris traversal).
   * Append the value to a given collection sorted at the end.
   */
  public static <E> void traversalInOrderNonRecursive(Collection<E> collection, BSTNode<E> root) {
    if(root == null) {
      return;
    }
    BSTNode<E> current, tmp;  // current root and temporary parent
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
}
