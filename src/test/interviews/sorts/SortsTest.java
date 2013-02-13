package interviews.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static interviews.sorts.Sorts.benchmark;
import static interviews.sorts.Sorts.bstTraversalSort;
import static interviews.sorts.Sorts.bucketsort;
import static interviews.sorts.Sorts.heapsort;
import static interviews.sorts.Sorts.insertionSort;
import static interviews.sorts.Sorts.mergesort;
import static interviews.sorts.Sorts.quicksort;
import static interviews.sorts.Sorts.selectionSort;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SortsTest {
  private static final Comparator<Integer> comparator = getComparatorOfIntegers();
  private static final Selector<Integer> selector = BucketSort.selectorOfIntegers();
  private static final List<Integer> list = getShuffledListOfIntegers(10000);
  private static final List<Integer> golden = getSortedListOfIntegers(list, comparator);

  private static List<Integer> getShuffledListOfIntegers(int max_value) {
    List<Integer> list = new ArrayList<Integer>(max_value);
    for (int i = 0; i < max_value; i++) {
      list.add(new Integer(i));
    }
    Collections.shuffle(list);
    return list;
  }

  private static List<Integer> getSortedListOfIntegers(
      List<Integer> list, Comparator<Integer> comparator) {
    List<Integer> sorted = new ArrayList<Integer>(list);
    Collections.sort(sorted, comparator);
    return sorted;
  }

  private static Comparator<Integer> getComparatorOfIntegers() {
    return new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };
  }

  @Test
  public void test_quicksort1()  {
    List<Integer> test;
    quicksort(test = new ArrayList<Integer>(list), comparator, 1);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_quicksort2()  {
    List<Integer> test;
    quicksort(test = new ArrayList<Integer>(list), comparator, 2);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_quicksort3()  {
    List<Integer> test;
    quicksort(test = new ArrayList<Integer>(list), comparator, 3);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_quicksort4()  {
    List<Integer> test;
    quicksort(test = new ArrayList<Integer>(list), comparator, 4);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_mergesort1()  {
    List<Integer> test;
    mergesort(test = new ArrayList<Integer>(list), comparator, 1);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_mergesort2()  {
    List<Integer> test;
    mergesort(test = new ArrayList<Integer>(list), comparator, 2);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_bstTraversalSort()  {
    List<Integer> test;
    bstTraversalSort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_buckesort()  {
    List<Integer> test;
    bucketsort(test = new ArrayList<Integer>(list), selector);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_heapsort()  {
    List<Integer> test;
    heapsort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_selectionSort()  {
    List<Integer> test;
    selectionSort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_insertionSort()  {
    List<Integer> test;
    insertionSort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_benchmark()  {
    List<Integer> list = getShuffledListOfIntegers(1000000);
    benchmark(list, comparator, selector);
  }
}
