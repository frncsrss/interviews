package interviews.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Quicksort.
 * @author Francois Rousseau
 */
public class Quicksort {

  public static <E> void f(List<E> list, Comparator<E> comparator) {
    quicksort3(list, comparator, 0, list.size()-1);
  }

  public static <E> void f(List<E> list, Comparator<E> comparator, int type) {
    Collections.shuffle(list);
    switch(type) {
      case 1:
        quicksort1(list, comparator, 0, list.size()-1);
        break;
      case 2:
        quicksort2(list, comparator, 0, list.size()-1);
        break;
      case 3:
        quicksort3(list, comparator, 0, list.size()-1);
        break;
      case 4:
        quicksort4(list, comparator, 0, list.size()-1);
        break;
      default:
        quicksort3(list, comparator, 0, list.size()-1);
        break;
    }
  }


  private static <E> void quicksort1(
      List<E> list, Comparator<E> comparator, int start, int end) {
    if (start < end) {
      final int p = partition1(list, comparator, start, end);
      if(start < p-1) {
        quicksort1(list, comparator, start, p-1);
      }
      if(p+1 < end) {
        quicksort1(list, comparator, p+1, end);
      }
    }
  }

  private static <E> int partition1(
      List<E> list, Comparator<E> comparator, int start, int end) {
    int low = start;
    int high = end-1;
    int p = end;

    while(low < high) {
      while(comparator.compare(list.get(low), list.get(p)) < 0
            && low < high) low++;
      while(comparator.compare(list.get(high), list.get(p)) > 0
          && low < high) high--;
      if(low < high) {
        Collections.swap(list, low, high);
        low++;
        high--;
      }
    }
    if(comparator.compare(list.get(low), list.get(p)) > 0) {
      Collections.swap(list, low, p);
      return low;
    } else {
      Collections.swap(list, ++low, p);
      return low;
    }
  }


  private static <E> void quicksort2(
      List<E> list, Comparator<E> comparator, int start, int end) {
    if (start < end) {
      final int p = partition2(list, comparator, start, end);
      if(start < p-1) {
        quicksort2(list, comparator, start, p-1);
      }
      if(p < end){
        quicksort2(list, comparator, p, end);
      }
    }
  }

  private static <E> int partition2(
      List<E> list, Comparator<E> comparator, int start, int end) {
    E pivot = list.get((start + end) >>> 1);  // prevent possible overflow
    while(start <= end) {
      while(comparator.compare(list.get(start), pivot) < 0) {
        start++;
      }
      while(comparator.compare(list.get(end), pivot) > 0) {
        end--;
      }
      if(start <= end) {
        Collections.swap(list, start, end);
        start++;
        end--;
      }
    }
    return start;
  }


  private static <E> void quicksort3(
      List<E> list, Comparator<E> comparator, int start, int end) {
    if (start < end) {
      final int p = partition3(list, comparator, start, end);
      if(start < p-1) {
        quicksort3(list, comparator, start, p-1);
      }
      if(p+1 < end) {
        quicksort3(list, comparator, p+1, end);
      }
    }
  }

  private static <E> int partition3(
      List<E> list, Comparator<E> comparator, int start, int end) {
    int firsthigh = start;
    for(int i=start; i<end; i++) {
      if(comparator.compare(list.get(i), list.get(end)) < 0) {
        Collections.swap(list, firsthigh, i);
        firsthigh++;
      }
    }
    Collections.swap(list, firsthigh, end);
    return firsthigh;
  } 


  private static <E> void quicksort4(
      List<E> list, Comparator<E> comparator, int start, int end) {
    if (start < end) {
      final int p = partition4(list, comparator, start, end);
      if(start < p-1) {
        quicksort4(list, comparator, start, p-1);
      }
      if(p+1 < end) {
        quicksort4(list, comparator, p+1, end);
      }
    }
  }

  private static <E> int partition4(
      List<E> list, Comparator<E> comparator, int start, int end) {
    int p = (start + end) >>> 1;  // prevent possible overflow
    if(comparator.compare(list.get(p), list.get(start)) < 0) {
      p = start;
    }
    if(comparator.compare(list.get(end), list.get(p)) < 0) {
      p = end;
    }
    Collections.swap(list, p, end);
    p = end;

    int firsthigh=start;
    for(int i=firsthigh;i<p;i++) {
      if(comparator.compare(list.get(i), list.get(p)) < 0) {
        Collections.swap(list, firsthigh, i);
        firsthigh++;
      }
    }
    Collections.swap(list, firsthigh, p);
    return firsthigh;
  } 
}
