package interviews.sorts;

import java.util.ArrayList;
import java.util.Collections;
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

  public static <E> void mergesort(
      List<E> list, Comparator<E> comparator, Mergesort.TYPE type) {
    Mergesort.f(list, comparator, type);
  }

  public static <E> void quicksort(
      List<E> list, Comparator<E> comparator, int type) {
    Quicksort.f(list, comparator, type);
  }

  public static <E> void selectionSort(List<E> list, Comparator<E> comparator) {
    SelectionSort.f(list, comparator);
  }

  public static <E> void shellsort(List<E> list, Comparator<E> comparator) {
    Shellsort.f(list, comparator);
  }

  public static <E> void benchmark(
      List<E> list, Comparator<E> comparator, Selector<E> selector) {
    final double factor = 1000000000.0;
    System.out.println("Benchmarking on "+ list.size() +" elements...");
    long start = System.nanoTime();
    quicksort(new ArrayList<E>(list), comparator, 1);
    System.out.println("Quicksort1\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    quicksort(new ArrayList<E>(list), comparator, 2);
    System.out.println("Quicksort2\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    quicksort(new ArrayList<E>(list), comparator, 3);
    System.out.println("Quicksort3\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    quicksort(new ArrayList<E>(list), comparator, 4);
    System.out.println("Quicksort4\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    mergesort(new ArrayList<E>(list), comparator, Mergesort.TYPE.AUX_ARRAY);
    System.out.println("Mergesort1\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    mergesort(new ArrayList<E>(list), comparator, Mergesort.TYPE.AUX_QUEUE);
    System.out.println("Mergesort2\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    mergesort(new ArrayList<E>(list), comparator, Mergesort.TYPE.TOP_DOWN);
    System.out.println("Mergesort3\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    mergesort(new ArrayList<E>(list), comparator, Mergesort.TYPE.BOTTOM_UP);
    System.out.println("Mergesort4\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    bstTraversalSort(new ArrayList<E>(list), comparator);
    System.out.println("BST traversal\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    bucketsort(new ArrayList<E>(list), selector);
    System.out.println("Bucketsort\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    shellsort(new ArrayList<E>(list), comparator);
    System.out.println("Shellsort\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    Collections.sort(new ArrayList<E>(list), comparator);
    System.out.println("Collections.sort\t"+(System.nanoTime() - start)/factor);
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
