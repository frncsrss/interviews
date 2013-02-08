package interviews.sorts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Mergesort.
 * @author Francois Rousseau
 */
public class Mergesort {

  public static <E> void f(
      List<E> list, Comparator<E> comparator, int type) {
    f(list, comparator, 0, list.size()-1, type);
  }

  private static <E> void f(
      List<E> list, Comparator<E> comparator, int start, int end, int type) {
    if (start < end) {
      final int middle = (start + end) >>> 1;  // prevent possible overflow
      f(list, comparator, start, middle, type);
      f(list, comparator, middle + 1, end, type);

      if(comparator.compare(list.get(middle), list.get(middle + 1)) <= 0) {
        return;
      }  // no need to merge the two lists

      switch(type) {
        case 1:
          merge1(list, comparator, start, end, middle);
          break;
        case 2:
          merge2(list, comparator, start, end, middle);
          break;
        default:
          break;
      }
    }
  }
  
  private static <E> void merge1(
      List<E> list, Comparator<E> comparator, int start, int end, int middle) {
    final List<E> buffer = new ArrayList<E>(list.subList(start, end+1));
    
    int left = start;
    int right = middle + 1;
    int current = start;
    
    while (left <= middle && right <= end) {
      if(comparator.compare(buffer.get(left - start), buffer.get(right - start)) <= 0) {
        list.set(current++, buffer.get(left - start));
        left++;
      } else {
        list.set(current++, buffer.get(right - start));  
        right++;
      }
    }

    for(;left <= middle;) {
      list.set(current++, buffer.get(left - start));
      left++;
    } // no need to do the same for the remaining elements of the right
    // since they are already in place.
  }
  
  private static <E> void merge2(
      List<E> list, Comparator<E> comparator, int start, int end, int middle) {
    final Queue<E> buffer1 = new LinkedList<E>();
    final Queue<E> buffer2 = new LinkedList<E>();

    for(int i=start; i<=middle; i++) {
      buffer1.add(list.get(i));
    }
    for(int i=middle+1; i<=end; i++) {
      buffer2.add(list.get(i));
    }

    while (!buffer1.isEmpty() && !buffer2.isEmpty()) {
      if(comparator.compare(buffer1.peek(), buffer2.peek()) <= 0) {
        list.set(start++, buffer1.poll());
      } else {
        list.set(start++, buffer2.poll());        
      }
    }

    while (!buffer1.isEmpty()) {
      list.set(start++, buffer1.poll());
    } // no need to do the same for the remaining elements of the right
    // since they are already in place.
  }
}
