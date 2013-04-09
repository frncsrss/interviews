package interviews.sorts;

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
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), 1);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), 2);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), 3);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), 4);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), 5);
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
    Quicksort.f(actuals, Sorts.getComparatorOfIntegers(), 6);
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
    int i = 0;
    Comparator<Integer> comparator = Sorts.getComparatorOfIntegers();
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
    Assert.assertEquals(new Integer(i), Quicksort.select(list, comparator, i++));    
  }
}
