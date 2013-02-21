package interviews.sorts;

import java.util.Comparator;
import java.util.List;

/**
 * Class to call sorting algorithms over a List providing a comparator.
 * @author Francois Rousseau
 */
public class Sorts {

  public static Comparator<Integer> getComparatorOfIntegers() {
    return new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };
  }

  public static <E> void bstTraversalSort(List<E> list, Comparator<E> comparator) {
    BSTTraversalSort.f(list, comparator);
  }

  public static <E> void bucketsort(List<E> list, Selector<E> selector) {
    BucketSort.f(list, selector);
  }
  
  public static <E> void heapsort(List<E> list, Comparator<E> comparator) {
    Heapsort.f(list, comparator);
  }

  public static <E> void insertionSort(List<E> list, Comparator<E> comparator) {
    InsertionSort.f(list, comparator);
  }

  public static <E> void mergesort(List<E> list, Comparator<E> comparator, Mergesort.TYPE type) {
    Mergesort.f(list, comparator, type);
  }

  public static <E> void quicksort(List<E> list, Comparator<E> comparator, int type) {
    Quicksort.f(list, comparator, type);
  }

  public static <E> void selectionSort(List<E> list, Comparator<E> comparator) {
    SelectionSort.f(list, comparator);
  }

  public static <E> void shellsort(List<E> list, Comparator<E> comparator) {
    Shellsort.f(list, comparator);
  }

  public static <E> boolean isSorted(List<E> list, Comparator<E> comparator) {
    for(int i=0; i < list.size()-1; i++) {
      if(comparator.compare(list.get(i), list.get(i+1)) > 0) {
        return false;
      }
    }
    return true;
  }

  public static <E> boolean isSorted(List<E> list, Comparator<E> comparator, int lo, int hi) {
    for(int i=lo; i < hi-1; i++) {
      if(comparator.compare(list.get(i), list.get(i+1)) > 0) {
        return false;
      }
    }
    return true;
  }
}
