package interviews.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Binary Search Tree.
 * @author Francois Rousseau
 */
public class BST<E> {
  private E value;
  private BST<E> left;
  private BST<E> right;
  private int frequency;
  private Comparator<E> comparator;
  
  public BST(E e, Comparator<E> comparator) {
    this.comparator = comparator;
    insert(e);
  }
  public BST(Collection<E> collection, Comparator<E> comparator) {
    this.comparator = comparator;
    for(E e : collection) {
      insert(e);
    }
  }

  /**
   *  Inserts the specified element into this BST.
   */
  public boolean add(E e) throws NullPointerException {
    if(e == null) throw new NullPointerException();
    insert(e);
    return true;
  }

  /**
   *  Returns the comparator used to order the elements in this heap.
   */
  public Comparator<E> comparator() {
    return comparator;
  }

  /**
   *  Returns the minimal element of this BST.
   */
  public E min() {
    if(left == null) {
      return value;
    }
    return left.min();
  }

  /**
   *  Returns the maximal element of this BST.
   */
  public E max() {
    if(right == null) {
      return value;
    }
    return right.max();
  }

  /**
   * Removes a single instance of the specified element from this BST, if it is present.
   * TODO: some work to do when a parent gets removed
   */
  public boolean remove(E e) {
    int result = comparator.compare(e, value);
    if(result == 0) {
      if(left == null && right == null) {
        //TODO
      } else if(left == null) {
        value = right.value;
        right = null;
      } else if(right == null) {
        value = left.value;
        left = null;
      } else {
        //TODO        
      }
      return true;
    }
    if(result > 0) {
      if(right == null) {
        return false;
      }
      return right.remove(e);
    }
    else {
      if(left == null) {
        return false;
      }
      return left.remove(e);
    }
  }

  /**
   *  Search a given element in this BST.
   *  Returns a boolean value accordingly.
   */
  public boolean search(E e) throws NullPointerException {
    int result = comparator.compare(e, value);
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
  public void traversal(Collection<E> collection) {
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

  public String toString() {
    StringBuilder buffer = new StringBuilder();
    List<E> list = new ArrayList<E>();
    buffer.append("[");
    traversal(list);
    for(E e : list) {
      buffer.append(e+", ");
    }
    buffer.append("]");
    return buffer.toString();
  }

  private void insert(E e) {
    if(value == null) {
      value = e;
      frequency++;
    }
    else {
      int result = comparator.compare(e, value);
      // we consider our BST as a Set
      // Hence, we don't insert an element already in the BST (i.e. result == 0)
      // we just increment is frequency
      if(result == 0) {
        frequency++;
      }
      else if(result > 0) {
        if(right == null) {
          right = new BST<E>(e, comparator);
        } else {
          right.insert(e);          
        }
      }
      else if (result < 0){
        if(left == null) {
          left = new BST<E>(e, comparator);
        } else {
          left.insert(e);
        }
      }
    }
  }
}