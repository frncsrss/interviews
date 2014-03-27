package interviews.arrays;

import static interviews.arrays.MaximumSubarray.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaximumSubarrayTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(new int[]{0, 0}, f(new int[]{2}));
    Assert.assertArrayEquals(new int[]{0, 0}, f(new int[]{-3}));
    Assert.assertArrayEquals(new int[]{0, 0}, f(new int[]{3, -2}));
    Assert.assertArrayEquals(new int[]{1, 1}, f(new int[]{-3, 2}));
    Assert.assertArrayEquals(new int[]{1, 1}, f(new int[]{-3, -2, -5}));
    Assert.assertArrayEquals(new int[]{1, 2}, f(new int[]{-3, 2, 5}));
    Assert.assertArrayEquals(new int[]{1, 2}, f(new int[]{-1, 1, 5}));
    Assert.assertArrayEquals(new int[]{0, 4}, f(new int[]{4, -3, 5, -2, 9, -8, -6, 4}));
    Assert.assertArrayEquals(new int[]{0, 7}, f(new int[]{1, 3, 5, -2, 9, -8, 6, 4}));
    Assert.assertArrayEquals(new int[]{2, 4}, f(new int[]{1, -3, 5, -2, 9, -8, -6, 4}));
    Assert.assertArrayEquals(new int[]{2, 4}, f(new int[]{1, -3, 5, -2, 9, -8, 6, 1}));
    Assert.assertArrayEquals(new int[]{2, 7}, f(new int[]{1, -3, 5, -2, 9, -8, 6, 4}));
    Assert.assertArrayEquals(new int[]{1, 8}, f(new int[]{0, 1, 3, 5, -2, 9, -8, 6, 4}));
    Assert.assertArrayEquals(new int[]{0, 7}, f(new int[]{1, 3, 5, -2, 9, -8, 6, 4, 0}));
  }
}
