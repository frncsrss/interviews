package interviews.sorts;

import interviews.trees.BST;

import java.util.Comparator;
import java.util.List;

/**
 * BSTTraversalsort.
 * @author Francois Rousseau
 */
public class BSTTraversalSort {
  public static <E> void f(List<E> list, Comparator<E> comparator) {
    BST<E> tree = new BST<E>(list, comparator);
    list.clear();
    tree.traversal(list);
  }
}
