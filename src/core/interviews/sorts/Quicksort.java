package interviews.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Quicksort.
 * @author Francois Rousseau
 */
public class Quicksort {

  public static <E> void f(List<E> list, Comparator<E> comparator, int type) {
    Collections.shuffle(list);
    switch(type) {
      case 1:
        sort1(list, comparator, 0, list.size()-1);
        break;
      case 2:
        sort2(list, comparator, 0, list.size()-1);
        break;
      case 3:
        sort3(list, comparator, 0, list.size()-1);
        break;
      case 4:
        sort4(list, comparator, 0, list.size()-1);
        break;
      case 5:
        sort5(list, comparator, 0, list.size()-1);
        break;
      case 6:
        sort6(list, comparator, 0, list.size()-1);
        break;
      default:
        break;
    }
  }

  public static <E> E select(List<E> list, Comparator<E> comparator, int k) {
    if(k < 0 || k > list.size() - 1) {
      throw new IndexOutOfBoundsException();
    }
    Collections.shuffle(list);
    int lo = 0;
    int hi = list.size() - 1;
    while(lo < hi) {
      final int p = partition5(list, comparator, lo, hi);
      if(k < p) {
        hi = p - 1;
      } else if (k > p) {
        lo = p + 1;
      } else {
        break;
      }
    }
    return list.get(k);
  }


  private static <E> void sort1(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition1(list, comparator, lo, hi);
      sort1(list, comparator, lo, p-1);
      sort1(list, comparator, p+1, hi);
    }
  }

  private static <E> int partition1(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    final E pivot = list.get(hi);
    int i = lo;
    int j = hi-1;

    while(i < j) {
      while(comparator.compare(list.get(i), pivot) < 0 && i < j) {
        i++;
      }
      while(comparator.compare(list.get(j), pivot) > 0 && i < j) {
        j--;
      }
      if(i < j) {
        Collections.swap(list, i, j);
        i++;
        j--;
      }
    }
    if(comparator.compare(list.get(i), pivot) > 0) {
      Collections.swap(list, i, hi);  // put the pivot in its final place
      return i;
    } else {
      Collections.swap(list, ++i, hi);  // put the pivot in its final place
      return i;
    }
  }


  private static <E> void sort2(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition2(list, comparator, lo, hi);
      sort2(list, comparator, lo, p-1);
      sort2(list, comparator, p, hi);
    }
  }

  private static <E> int partition2(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    final E pivot = list.get((lo + hi) >>> 1);  // prevent possible overflow
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


  private static <E> void sort3(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition3(list, comparator, lo, hi);
      sort3(list, comparator, lo, p-1);
      sort3(list, comparator, p+1, hi);
    }
  }

  private static <E> int partition3(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    int firsthigh = lo;
    for(int i = lo; i < hi; i++) {
      if(comparator.compare(list.get(i), list.get(hi)) < 0) {
        Collections.swap(list, firsthigh, i);
        firsthigh++;
      }
    }
    Collections.swap(list, firsthigh, hi);
    return firsthigh;
  } 


  private static <E> void sort4(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition4(list, comparator, lo, hi);
      sort4(list, comparator, lo, p-1);
      sort4(list, comparator, p+1, hi);
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
    for(int i = firsthigh; i < p; i++) {
      if(comparator.compare(list.get(i), list.get(p)) < 0) {
        Collections.swap(list, firsthigh, i);
        firsthigh++;
      }
    }
    Collections.swap(list, firsthigh, p);
    return firsthigh;
  } 


  private static <E> void sort5(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      final int p = partition5(list, comparator, lo, hi);
      sort5(list, comparator, lo, p-1);
      sort5(list, comparator, p+1, hi);
    }
  }

  private static <E> int partition5(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    final E pivot = list.get(lo);
    int i = lo;
    int j = hi + 1;

    while(true) {
      while(comparator.compare(list.get(++i), pivot) < 0) {  // find leftmost item to swap
        if(i == hi) {  // all the elements are lesser than the pivot
          break;
        }
      }
      while(comparator.compare(list.get(--j), pivot) > 0) {  // find rightmost item to swap
        if(j == lo) {  // all the elements are greater than the pivot, redundant since pivot in lo
          break;
        }
      }
      if(i >= j) {  // break if pointers cross
        break;
      }
      Collections.swap(list, i, j);
    }
    Collections.swap(list, lo, j);  // put the pivot in its final place
    return j;
  }


  /**
   * 3-way Dijkstra quicksort.
   */
  private static <E> void sort6(
      List<E> list, Comparator<E> comparator, int lo, int hi) {
    if (lo < hi) {
      int lt = lo;
      int gt = hi;
      final E pivot = list.get(lo); 
      int i = lo;
      while(i <= gt) {  // while pointers don't cross
        final int cmp = comparator.compare(list.get(i), pivot);
        if(cmp < 0) {
          Collections.swap(list, lt++, i++);
        } else if (cmp > 0) {
          Collections.swap(list, i, gt--);          
        } else {
          i++;
        }
      }
      sort6(list, comparator, lo, lt-1);
      sort6(list, comparator, gt+1, hi);
    }
  }
}
