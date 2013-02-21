package interviews.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class QuicksortTest {
  private static final Comparator<Integer> comparator = Sorts.getComparatorOfIntegers();

  @Test
  public void test_select_10()  {
    List<Integer> list = new ArrayList<Integer>(10);
    for (int i = 0; i < 10; i++) {
      list.add(new Integer(i));
    }
    Collections.shuffle(list, new Random(1234));
    Assert.assertEquals(Arrays.asList(9, 0, 6, 1, 3, 2, 4, 7, 5, 8), list);
    int i = 0;
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
