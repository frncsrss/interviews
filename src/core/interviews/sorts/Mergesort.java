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
  public static enum TYPE {AUX_ARRAY, AUX_QUEUE, TOP_DOWN, BOTTOM_UP};

  public static <E> void f(List<E> list, Comparator<E> comparator, TYPE type) {
    switch(type) {
      case AUX_ARRAY:
        sort1(list, comparator, 0, list.size()-1);
        break;
      case AUX_QUEUE:
        sort2(list, comparator, 0, list.size()-1);
        break;
      case TOP_DOWN:
        sort3(list, comparator, new ArrayList<E>(list), 0, list.size()-1);
        break;
      case BOTTOM_UP:
        sort4(list, comparator);
        break;
      default:
        break;
    }
  }

  private static <E> void sort1(List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      int mid = (lo + hi) >>> 1;  // prevent possible overflow
      sort1(list, comparator, lo, mid);
      sort1(list, comparator, mid + 1, hi);

      if(comparator.compare(list.get(mid), list.get(mid + 1)) <= 0) {
        return;
      }  // no need to merge the two lists

      merge1(list, comparator, lo, hi, mid);
    }
  }

  private static <E> void sort2(List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      int mid = (lo + hi) >>> 1;  // prevent possible overflow
      sort2(list, comparator, lo, mid);
      sort2(list, comparator, mid + 1, hi);

      if(comparator.compare(list.get(mid), list.get(mid + 1)) <= 0) {
        return;
      }  // no need to merge the two lists

      merge2(list, comparator, lo, hi, mid);
    }
  }

  private static <E> void sort3(
      List<E> list, Comparator<E> comparator, List<E> aux, int lo, int hi) {
    if (lo < hi) {
      int mid = (lo + hi) >>> 1;  // prevent possible overflow
      sort3(list, comparator, aux, lo, mid);
      sort3(list, comparator, aux, mid + 1, hi);

      if(comparator.compare(list.get(mid), list.get(mid + 1)) <= 0) {
        return;
      }  // no need to merge the two lists

      merge3(list, comparator, aux, lo, hi, mid);
    }
  }

  private static <E> void sort4(List<E> list, Comparator<E> comparator) {
    int N = list.size();
    List<E> aux = new ArrayList<E>(list);
    for(int sz = 1; sz < N; sz <<= 1) {  // log(N) sizes of subarrays considered
      for(int lo = 0; lo < N - sz; lo += sz + sz) {  // each subarray is of size sz + sz
        merge3(list, comparator, aux, lo, Math.min(lo + sz + sz - 1, N - 1), lo +sz - 1);
      }
    }
  }

  private static <E> void merge1(
      List<E> list, Comparator<E> comparator, int lo, int hi, int mid) {
    assert Sorts.isSorted(list, comparator, lo, mid);
    assert Sorts.isSorted(list, comparator, mid+1, hi);

    List<E> aux = new ArrayList<E>(list.subList(lo, hi+1));
    
    int left = lo;
    int right = mid + 1;
    int current = lo;
    
    while (left <= mid && right <= hi) {
      if(comparator.compare(aux.get(left - lo), aux.get(right - lo)) <= 0) {
        list.set(current++, aux.get(left - lo));
        left++;
      } else {
        list.set(current++, aux.get(right - lo));  
        right++;
      }
    }

    for(;left <= mid;) {
      list.set(current++, aux.get(left - lo));
      left++;
    }  // no need to do the same for the right since they are already in place.

    assert Sorts.isSorted(list, comparator, lo, hi);
  }
  
  private static <E> void merge2(
      List<E> list, Comparator<E> comparator, int lo, int hi, int mid) {
    assert Sorts.isSorted(list, comparator, lo, mid);
    assert Sorts.isSorted(list, comparator, mid+1, hi);

    Queue<E> aux1 = new LinkedList<E>();
    Queue<E> aux2 = new LinkedList<E>();

    for(int i = lo; i <= mid; i++) {
      aux1.add(list.get(i));
    }
    for(int i = mid + 1; i <= hi; i++) {
      aux2.add(list.get(i));
    }

    while (!aux1.isEmpty() && !aux2.isEmpty()) {
      if(comparator.compare(aux1.peek(), aux2.peek()) <= 0) {
        list.set(lo++, aux1.poll());
      } else {
        list.set(lo++, aux2.poll());        
      }
    }

    while (!aux1.isEmpty()) {
      list.set(lo++, aux1.poll());
    }  // no need to do the same for the right since they are already in place.

    assert Sorts.isSorted(list, comparator, lo, hi);
  }

  private static <E> void merge3(
      List<E> list, Comparator<E> comparator, List<E> aux, int lo, int hi, int mid) {
    assert Sorts.isSorted(list, comparator, lo, mid);
    assert Sorts.isSorted(list, comparator, mid+1, hi);

    for(int i = lo; i <= hi; i++) {
      aux.set(i, list.get(i));
    }

    int left = lo;
    int right = mid + 1;
    int current = lo;
    
    while (left <= mid && right <= hi) {
      if(comparator.compare(aux.get(left), aux.get(right)) <= 0) {
        list.set(current++, aux.get(left));
        left++;
      } else {
        list.set(current++, aux.get(right));  
        right++;
      }
    }

    for(;left <= mid;) {
      list.set(current++, aux.get(left));
      left++;
    }  // no need to do the same for the right since they are already in place.

    assert Sorts.isSorted(list, comparator, lo, hi);
  }
}
