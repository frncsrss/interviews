package interviews.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SortsTest {
  private static final Comparator<Integer> comparator = getComparatorOfIntegers();
  private static final Selector<Integer> selector = BucketSort.selectorOfIntegers();
  private static final List<Integer> list = getShuffledListOfIntegers(20000);
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
    Sorts.quicksort(test = new ArrayList<Integer>(list), comparator, 1);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_quicksort2()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(list), comparator, 2);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_quicksort3()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(list), comparator, 3);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_quicksort4()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(list), comparator, 4);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_mergesort1()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(list), comparator, Mergesort.TYPE.AUX_ARRAY);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_mergesort2()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(list), comparator, Mergesort.TYPE.AUX_QUEUE);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_mergesort3()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(list), comparator, Mergesort.TYPE.AUX_ONCE);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_mergesort4()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(list), comparator, Mergesort.TYPE.BOTTOM_UP);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_bstTraversalSort()  {
    List<Integer> test;
    Sorts.bstTraversalSort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_buckesort()  {
    List<Integer> test;
    Sorts.bucketsort(test = new ArrayList<Integer>(list), selector);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_heapsort()  {
    List<Integer> test;
    Sorts.heapsort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_shellsort()  {
    List<Integer> test;
    Sorts.shellsort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_insertionSort()  {
    List<Integer> test;
    Sorts.insertionSort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_selectionSort()  {
    List<Integer> test;
    Sorts.selectionSort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_JavaSort()  {
    List<Integer> test;
    Collections.sort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_benchmark()  {
    List<Integer> list = getShuffledListOfIntegers(1000000);
    Sorts.benchmark(list, comparator, selector);
  }
}
