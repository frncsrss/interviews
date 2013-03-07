package interviews.sorts;

import interviews.arrays.Swap;

import java.util.Comparator;
import java.util.List;

/**
 * Shellsort.
 * @author Francois Rousseau
 */
public class Shellsort {
  public static <E> void f(List<E> list, Comparator<E> comparator) {
    int h = 1;
    while(h < list.size()/3) {  // biggest element smaller than N in the sequence
      h = 3*h + 1;  // sequence 1, 4, 13, 40, 121, 364...
    }

    while(h >= 1) {  // h-sort the list
      for(int i = h; i < list.size(); i++) {  // insertion sort with a h-window
        for(int j = i; j >= h && comparator.compare(list.get(j), list.get(j-h)) < 0; j-=h) {
          Swap.f(list, j, j-h);
        }
      }
      h /= 3;
    }
  }
}
