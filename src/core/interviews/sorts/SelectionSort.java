package interviews.sorts;

import interviews.arrays.Swap;

import java.util.Comparator;
import java.util.List;

/**
 * Selection sort.
 * @author Francois Rousseau
 */
public class SelectionSort {

  public static <E> void f(List<E> list, Comparator<E> comparator) {
    for(int i=0; i < list.size() - 1; i++) {
      Swap.f(list, i, minIndex(list, comparator, i));
    }
  }

  private static <E> int minIndex(List<E> list, Comparator<E> comparator, int start) {
    int index = start;
    E min = list.get(start);
    for(int i = start+1; i < list.size(); i++) {
      if(comparator.compare(min, list.get(i)) > 0) {
        index = i;
        min = list.get(i);
      }
    }  
    return index;
  }
}
