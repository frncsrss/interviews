package interviews.sorts;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class InsertionSortTest {
  @Test
  public void test_10()  {
    List<Integer> actuals = Arrays.asList(7, 2, 1, 4, 5, 0, 3, 4, 7, 6);
    InsertionSort.f(actuals, Sorts.getComparatorOfIntegers());
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
  }
}
