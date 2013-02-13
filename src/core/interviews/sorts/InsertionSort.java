package interviews.sorts;

import interviews.arrays.Swap;

import java.util.Comparator;
import java.util.List;

/**
 * Insertion sort.
 * @author Francois Rousseau
 */
public class InsertionSort {
  public static <E> void f(List<E> list, Comparator<E> comparator) {
    for(int i=0; i < list.size(); i++) {
      for(int j = i; j > 0 && comparator.compare(list.get(j), list.get(j-1)) < 0; j--) {
        Swap.f(list, j, j-1);
      }
    }
  }
}
