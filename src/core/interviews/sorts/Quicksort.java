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
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition1(list, comparator, lo, hi);
      if(lo < p-1) {
        quicksort1(list, comparator, lo, p-1);
      }
      if(p+1 < hi) {
        quicksort1(list, comparator, p+1, hi);
      }
    }
  }

  private static <E> int partition1(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    int low = lo;
    int high = hi-1;
    int p = hi;

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
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition2(list, comparator, lo, hi);
      if(lo < p-1) {
        quicksort2(list, comparator, lo, p-1);
      }
      if(p < hi){
        quicksort2(list, comparator, p, hi);
      }
    }
  }

  private static <E> int partition2(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    E pivot = list.get((lo + hi) >>> 1);  // prevent possible overflow
    while(lo <= hi) {
      while(comparator.compare(list.get(lo), pivot) < 0) {
        lo++;
      }
      while(comparator.compare(list.get(hi), pivot) > 0) {
        hi--;
      }
      if(lo <= hi) {
        Collections.swap(list, lo, hi);
        lo++;
        hi--;
      }
    }
    return lo;
  }


  private static <E> void quicksort3(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition3(list, comparator, lo, hi);
      if(lo < p-1) {
        quicksort3(list, comparator, lo, p-1);
      }
      if(p+1 < hi) {
        quicksort3(list, comparator, p+1, hi);
      }
    }
  }

  private static <E> int partition3(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    int firsthigh = lo;
    for(int i=lo; i<hi; i++) {
      if(comparator.compare(list.get(i), list.get(hi)) < 0) {
        Collections.swap(list, firsthigh, i);
        firsthigh++;
      }
    }
    Collections.swap(list, firsthigh, hi);
    return firsthigh;
  } 


  private static <E> void quicksort4(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition4(list, comparator, lo, hi);
      if(lo < p-1) {
        quicksort4(list, comparator, lo, p-1);
      }
      if(p+1 < hi) {
        quicksort4(list, comparator, p+1, hi);
      }
    }
  }

  private static <E> int partition4(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    int p = (lo + hi) >>> 1;  // prevent possible overflow
    if(comparator.compare(list.get(p), list.get(lo)) < 0) {
      p = lo;
    }
    if(comparator.compare(list.get(hi), list.get(p)) < 0) {
      p = hi;
    }
    Collections.swap(list, p, hi);
    p = hi;

    int firsthigh=lo;
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
