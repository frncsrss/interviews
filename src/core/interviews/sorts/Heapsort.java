package interviews.sorts;

import interviews.arrays.Heap;
import interviews.arrays.HeapMax;

import java.util.Comparator;
import java.util.List;

/**
 * Heapsort.
 * @author Francois Rousseau
 */
public class Heapsort {
  public static <E> void f(List<E> list, Comparator<E> comparator) {
    Heap<E> heap = new HeapMax<E>(list, comparator);  // heapify takes linear time (bottom-up)
    for (int i = list.size()-1; i >= 0 ; i--) {
      list.set(i, heap.remove());  // maintaining the heap order takes logarithmic time
    }
  }
}
