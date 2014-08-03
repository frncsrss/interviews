package interviews.sorts;

import interviews.sorts.Quicksort.METHOD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class QuicksortTest {
  @Test
  public void test_10()  {
    List<Integer> actuals = Arrays.asList(7, 2, 1, 4, 5, 0, 3, 4, 7, 6);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), METHOD.PIVOT_AS_FIRST);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), METHOD.PIVOT_AS_LAST);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), METHOD.PIVOT_AS_MIDDLE);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), METHOD.PIVOT_AS_MEDIAN);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), METHOD.SKIENA);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), METHOD.DIJKSTRA);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
  }

  @Test
  public void test_select_10()  {
    List<Integer> list = new ArrayList<Integer>(10);
    for (int i = 0; i < 10; i++) {
      list.add(new Integer(i));
    }
    Collections.shuffle(list, new Random(1234));
    Assert.assertEquals(Arrays.asList(9, 0, 6, 1, 3, 2, 4, 7, 5, 8), list);
    Comparator<Integer> comparator = Sorts.getComparatorOfIntegers();
    Assert.assertEquals(new Integer(0), Quicksort.select(list, comparator, 1));
    Assert.assertEquals(new Integer(1), Quicksort.select(list, comparator, 2));
    Assert.assertEquals(new Integer(2), Quicksort.select(list, comparator, 3));
    Assert.assertEquals(new Integer(3), Quicksort.select(list, comparator, 4));
    Assert.assertEquals(new Integer(4), Quicksort.select(list, comparator, 5));
    Assert.assertEquals(new Integer(5), Quicksort.select(list, comparator, 6));
    Assert.assertEquals(new Integer(6), Quicksort.select(list, comparator, 7));
    Assert.assertEquals(new Integer(7), Quicksort.select(list, comparator, 8));
    Assert.assertEquals(new Integer(8), Quicksort.select(list, comparator, 9));
    Assert.assertEquals(new Integer(9), Quicksort.select(list, comparator, 10));
  }
}
