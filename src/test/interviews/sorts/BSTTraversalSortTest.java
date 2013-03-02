package interviews.sorts;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BSTTraversalSortTest {
  @Test
  public void test_random() {
    List<Integer> list =  Arrays.asList(2, 5, 0, 1, 3, 9, 7, 8, 6, 4);
    BSTTraversalSort.f(list, Sorts.getComparatorOfIntegers());
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), list);
  }
}
