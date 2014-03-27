package interviews.arrays;

import static interviews.arrays.MaximumSubarraysDifference.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaximumSubarraysDifferenceTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(new int[][]{new int[]{0, 0}, new int[]{1, 2}},
        f(new int[]{-2, 1, 2}));
    Assert.assertArrayEquals(new int[][]{new int[]{1, 5}, new int[]{6, 7}},
        f(new int[]{2, -1, -2, 1, -1, -4, 2, 8}));
    Assert.assertArrayEquals(new int[][]{new int[]{1, 1}, new int[]{2, 2}}, f(new int[]{4, -1, 7}));
    Assert.assertArrayEquals(new int[][]{new int[]{0, 0}, new int[]{1, 7}},
        f(new int[]{2, 1, 2, 1, 1, 4, 2, 8}));
    Assert.assertArrayEquals(new int[][]{new int[]{7, 7}, new int[]{0, 6}},
        f(new int[]{8, 1, 2, 1, 1, 4, 2, 1}));
    Assert.assertArrayEquals(new int[][]{new int[]{1, 7}, new int[]{0, 0}},
        f(new int[]{-2, -1, -2, -1, -1, -4, -2, -8}));
    Assert.assertArrayEquals(new int[][]{new int[]{0, 6}, new int[]{7, 7}},
        f(new int[]{-8, -1, -2, -1, -1, -4, -2, -1}));
  }
}
