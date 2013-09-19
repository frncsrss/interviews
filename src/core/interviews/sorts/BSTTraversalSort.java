package interviews.sorts;

import interviews.trees.BST;

import java.util.Comparator;
import java.util.List;

/**
 * BSTTraversalsort.
 * @author Francois Rousseau
 */
public class BSTTraversalSort {
  public static <E> void f(final List<E> list, Comparator<E> comparator) {
    BST<E> tree = new BST<E>(list, comparator);
    List<E> tmp = tree.traversalInOrderRecursive();
    for (int i = 0; i < list.size(); i++) {
      list.set(i, tmp.get(i));
    }
  }
}
