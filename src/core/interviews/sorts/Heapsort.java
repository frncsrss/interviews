package interviews.sorts;

import interviews.arrays.Heap;

import java.util.Comparator;
import java.util.List;

/**
 * Heapsort.
 * @author Francois Rousseau
 */
public class Heapsort {
  public static <E> void f(List<E> list, Comparator<E> comparator) {
    Heap<E> heap = new Heap<E>(list, comparator);  // heapify takes linear time (bottom-up)
    for (int i = 0; i < list.size(); i++) {
      list.set(i, heap.remove());  // maintaining the heap order takes logarithmic time
    }
  }
}
