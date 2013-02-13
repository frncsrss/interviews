package interviews.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static interviews.sorts.Sorts.benchmark;
import static interviews.sorts.Sorts.bstTraversal;
import static interviews.sorts.Sorts.bucketsort;
import static interviews.sorts.Sorts.heapsort;
import static interviews.sorts.Sorts.mergesort;
import static interviews.sorts.Sorts.quicksort;
import static interviews.sorts.Sorts.selectionsort;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SortsTest {
  private List<Integer> getListOfIntegers(int max_value) {
    List<Integer> list = new ArrayList<Integer>(max_value);
    for (int i = 0; i < max_value; i++) {
      list.add(new Integer(i));
    }
    Collections.shuffle(list);
    return list;
  }

  private Comparator<Integer> getComparatorOfIntegers() {
    return new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };
  }

  @Test
  public void test_basic()  {
    List<Integer> golden = getListOfIntegers(10000);
    List<Integer> list = new ArrayList<Integer>(golden);
    Comparator<Integer> comparator = getComparatorOfIntegers();
    Selector<Integer> selector = BucketSort.selectorOfIntegers();
    Collections.sort(golden, comparator);
    
    List<Integer> test;
    quicksort(test = new ArrayList<Integer>(list), comparator, 1);
    Assert.assertEquals(golden, test);
    quicksort(test = new ArrayList<Integer>(list), comparator, 2);
    Assert.assertEquals(golden, test);
    quicksort(test = new ArrayList<Integer>(list), comparator, 3);
    Assert.assertEquals(golden, test);
    quicksort(test = new ArrayList<Integer>(list), comparator, 4);
    Assert.assertEquals(golden, test);
    mergesort(test = new ArrayList<Integer>(list), comparator, 1);
    Assert.assertEquals(golden, test);
    mergesort(test = new ArrayList<Integer>(list), comparator, 2);
    Assert.assertEquals(golden, test);
    bstTraversal(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
    bucketsort(test = new ArrayList<Integer>(list), selector);
    Assert.assertEquals(golden, test);
    heapsort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
    selectionsort(test = new ArrayList<Integer>(list), comparator);
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_benchmark()  {
    List<Integer> list = getListOfIntegers(1000000);
    Comparator<Integer> comparator = getComparatorOfIntegers();
    Selector<Integer> selector = BucketSort.selectorOfIntegers();
    benchmark(list, comparator, selector);
  }
}
