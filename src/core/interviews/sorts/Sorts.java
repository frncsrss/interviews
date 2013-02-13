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

  public static <E> void bstTraversal(List<E> list, Comparator<E> comparator) {
    BSTTraversalSort.f(list, comparator);
  }

  public static <E> void bucketsort(List<E> list, Selector<E> selector) {
    BucketSort.f(list, selector);
  }
  
  public static <E> void heapsort(List<E> list, Comparator<E> comparator) {
    Heapsort.f(list, comparator);
  }

  public static <E> void mergesort(
      List<E> list, Comparator<E> comparator, int type) {
    Mergesort.f(list, comparator, type);
  }

  public static <E> void quicksort(
      List<E> list, Comparator<E> comparator, int type) {
    Quicksort.f(list, comparator, type);
  }

  public static <E> void selectionsort(List<E> list, Comparator<E> comparator) {
    SelectionSort.f(list, comparator);
  }

  public static <E> void benchmark(
      List<E> list, Comparator<E> comparator, Selector<E> selector) {
    final double factor = 1000000000.0;
    System.out.println("Benchmarking...");
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
    mergesort(new ArrayList<E>(list), comparator, 1);
    System.out.println("Mergesort1\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    mergesort(new ArrayList<E>(list), comparator, 2);
    System.out.println("Mergesort2\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    bstTraversal(new ArrayList<E>(list), comparator);
    System.out.println("BST traversal\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    bucketsort(new ArrayList<E>(list), selector);
    System.out.println("Bucketsort\t"+(System.nanoTime() - start)/factor);
    start = System.nanoTime();
    Collections.sort(new ArrayList<E>(list), comparator);
    System.out.println("Javasort\t"+(System.nanoTime() - start)/factor);
  }

}
