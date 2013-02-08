package interviews.sorts;

import interviews.trees.Heap;

import java.util.Comparator;
import java.util.List;

/**
 * Heapsort.
 * @author Francois Rousseau
 */
public class Heapsort {
  public static <E> void f(List<E> list, Comparator<E> comparator) {
    Heap<E> heap = new Heap<E>(list, comparator);
    for (int i = list.size()-1; i >= 0 ; i--) {
      list.set(i, heap.remove());
    }
  }
}
