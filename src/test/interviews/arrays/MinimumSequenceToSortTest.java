package interviews.arrays;

import static interviews.arrays.MinimumSequenceToSort.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MinimumSequenceToSortTest {

  @Test
  public void test() {
    Assert.assertNull(f(new int[]{1, 2}));
    Assert.assertArrayEquals(new int[]{0, 1}, f(new int[]{2, 1}));
    Assert.assertArrayEquals(
        new int[]{5, 6}, f(new int[]{1, 2, 4, 7, 10, 12, 11, 13, 14, 15, 16, 18, 19}));
    Assert.assertArrayEquals(
        new int[]{3, 9}, f(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}));
  }
}
