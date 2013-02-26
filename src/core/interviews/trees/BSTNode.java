package interviews.trees;

import java.util.Collection;
import java.util.Comparator;

/**
 * BSTNode.
 * @author Francois Rousseau
 */
public class BSTNode<E> {
  protected E value;
  protected BSTNode<E> left;
  protected BSTNode<E> right;
  protected int frequency;
  protected Comparator<E> comparator;

  public BSTNode(E e, Comparator<E> comparator) {
    this.comparator = comparator;
    add(e);
  }

  /**
   *  Inserts the specified element into this BST.
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
      } else if (result < 0){
        if(left == null) {
          left = new BSTNode<E>(e, comparator);
        } else {
          left.add(e);
        }
      }
    }
  }

  /**
   *  Returns the minimal element of this BST.
   */
  protected E min() {
    if(left == null) {
      return value;
    }
    return left.min();
  }

  /**
   *  Returns the maximal element of this BST.
   */
  protected E max() {
    if(right == null) {
      return value;
    }
    return right.max();
  }

  /**
   *  Search a given element in this BST.
   *  Returns a boolean value accordingly.
   */
  protected boolean search(E e) throws NullPointerException {
    final int result = comparator.compare(e, value);
    if(result == 0) {
      return true;
    }
    if(result > 0) {
      return (right == null) ? false : right.search(e);
    }
    else {
      return (left == null) ? false : left.search(e);
    }
  }

  /**
   *  In-order traversal of this BST.
   *  Append the value to a given collection sorted at the end.
   */
  protected void traversal(Collection<E> collection) {
    if(left != null) {
      left.traversal(collection);
    }
    for(int i=0; i<frequency; i++) {
      collection.add(value);
    }
    if(right != null) {
      right.traversal(collection);
    }
  }

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
}
