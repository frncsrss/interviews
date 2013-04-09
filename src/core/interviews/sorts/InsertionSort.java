package interviews.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Insertion sort.
 * Run in O(n^2). Stable sort.
 * @author Francois Rousseau
 */
public class InsertionSort {
  public static <E> void f(List<E> list, Comparator<E> comparator) {
    for(int i = 0; i < list.size(); i++) {
      for(int j = i; j > 0 && comparator.compare(list.get(j), list.get(j - 1)) < 0; j--) {
        Collections.swap(list, j, j - 1);
      }
    }
  }
}
