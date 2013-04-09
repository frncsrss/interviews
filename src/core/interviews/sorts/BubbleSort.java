package interviews.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Bubble sort.
 * Run in O(n^2). Stable sort.
 * @author Francois Rousseau
 */
public class BubbleSort {
  public static <E> void f(List<E> list, Comparator<E> comparator) {
    for(int i = 0; i < list.size() - 1; i++) {
      for(int j = 0; j < list.size() - 1 - i; j++) {
        if(comparator.compare(list.get(j), list.get(j + 1)) > 0) {
          Collections.swap(list, j, j + 1);
        }
      }  // element at index n - 1 - i is at its final place
    }
  }
}
