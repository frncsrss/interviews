package interviews.sorts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Quicksort.
 * @author Francois Rousseau
 */
public class Quicksort {
  public static enum METHOD {
    PIVOT_AS_LAST() {
      @Override
      protected <E> int partition(List<E> list, Comparator<E> comparator, int lo, int hi) {
        E pivot = list.get(hi);  // pivot is the last element
        int i = lo - 1;
        int j = hi;

        while(true) {
          while(comparator.compare(list.get(++i), pivot) < 0) {
            if(i == hi) {  // all the elements are lesser than the pivot
              break;
            }
          }
          while(comparator.compare(list.get(--j), pivot) > 0) {
            if(j == lo) {  // all the elements are greater than the pivot
              break;
            }
          }
          if(i >= j) {  // while the pointers don't cross each other
            break;
          }
          Collections.swap(list, i, j);
        }
        Collections.swap(list, i, hi);  // put the pivot in its final place
        return i;
      }
    }, PIVOT_AS_FIRST() {
      @Override
      protected <E> int partition(List<E> list, Comparator<E> comparator, int lo, int hi) {
        E pivot = list.get(lo);  // pivot is the first element
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
        Collections.swap(list, j, lo);  // put the pivot in its final place
        return j;
      }
    }, PIVOT_AS_MIDDLE() {
      @Override
      public <E> void sort(List<E> list, Comparator<E> comparator, int lo, int hi) {
        if (lo < hi) {
          int p = partition(list, comparator, lo, hi);
          sort(list, comparator, lo, p - 1);
          sort(list, comparator, p, hi);
        }
      }

      @Override
      protected <E> int partition(List<E> list, Comparator<E> comparator, int lo, int hi) {
        E pivot = list.get(lo + hi >>> 1);  // pivot is the middle element
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
    }, PIVOT_AS_MEDIAN() {
      @Override
      protected <E> int partition(List<E> list, Comparator<E> comparator, int lo, int hi) {
        int p = lo + hi >>> 1;  // pivot is the median element between lo, mid and hi
        if(comparator.compare(list.get(p), list.get(lo)) < 0) {
          p = lo;
        }
        if(comparator.compare(list.get(hi), list.get(p)) < 0) {
          p = hi;
        }
        Collections.swap(list, p, hi);
        p = hi;

        int firsthigh = lo;
        for(int i = firsthigh; i < p; i++) {
          if(comparator.compare(list.get(i), list.get(p)) < 0) {
            Collections.swap(list, firsthigh, i);
            firsthigh++;
          }
        }
        Collections.swap(list, firsthigh, p);
        return firsthigh;
      }
    }, SKIENA() {
      @Override
      protected <E> int partition(List<E> list, Comparator<E> comparator, int lo, int hi) {
        E pivot = list.get(hi);  // pivot is the last element
        int firsthigh = lo;
        for(int i = lo; i < hi; i++) {
          if(comparator.compare(list.get(i), pivot) < 0) {
            Collections.swap(list, firsthigh, i);
            firsthigh++;
          }
        }
        Collections.swap(list, firsthigh, hi);
        return firsthigh;
      }
    }, DIJKSTRA() {
      @Override
      public <E> void sort(List<E> list, Comparator<E> comparator, int lo, int hi) {
        if (lo < hi) {
          int lt = lo;
          int gt = hi;
          E pivot = list.get(lo);  // pivot is the first element
          int i = lo;
          while(i <= gt) {  // while pointers don't cross
            int cmp = comparator.compare(list.get(i), pivot);
            if(cmp < 0) {
              Collections.swap(list, lt++, i++);
            } else if (cmp > 0) {
              Collections.swap(list, i, gt--);
            } else {
              i++;
            }
          }
          sort(list, comparator, lo, lt - 1);
          sort(list, comparator, gt + 1, hi);
        }
      }

      @Override
      protected <E> int partition(List<E> list, Comparator<E> comparator, int lo, int hi) {
        throw new UnsupportedOperationException();
      }
    };


    public <E> void sort(List<E> list, Comparator<E> comparator, int lo, int hi) {
      if (lo < hi) {
        int p = partition(list, comparator, lo, hi);
        sort(list, comparator, lo, p - 1);
        sort(list, comparator, p + 1, hi);
      }
    }
    protected abstract <E> int partition(List<E> list, Comparator<E> comparator, int lo, int hi);
  }

  /**
   * Sort the array using the specified quicksort implementation.
   */
  public static <E> void f(List<E> list, Comparator<E> comparator, METHOD m) {
    Collections.shuffle(list);
    m.sort(list, comparator, 0, list.size() - 1);
  }

  /**
   * @return the kth smallest element of the list in linear time.
   */
  public static <E> E select(List<E> list, Comparator<E> comparator, int k) {
    if(k < 0 || k > list.size() - 1) {
      throw new IndexOutOfBoundsException();
    }
    Collections.shuffle(list);
    int lo = 0;
    int hi = list.size() - 1;
    while(lo < hi) {
      final int p = METHOD.SKIENA.partition(list, comparator, lo, hi);
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
}
