package interviews.arrays;

import static interviews.arrays.RangeIntersection.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RangeIntersectionTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(new int[]{1, 6}, f(new int[][]{new int[]{1, 6}}));
    Assert.assertArrayEquals(new int[]{1, 6},
        f(new int[][]{new int[]{1, 6}, new int[]{2, 3}, new int[]{4, 11}}));
    Assert.assertArrayEquals(new int[]{1, 10},
        f(new int[][]{new int[]{1, 10}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4},
            new int[]{4, 5}, new int[]{5, 6}, new int[]{6, 7}, new int[]{7, 8}, new int[]{8, 9},
            new int[]{9, 10}}));
    Assert.assertArrayEquals(new int[]{1, 10},
        f(new int[][]{new int[]{1, 10}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4},
            new int[]{4, 5}, new int[]{5, 6}, new int[]{6, 7}, new int[]{7, 8}, new int[]{8, 9},
            new int[]{9, 10}}));
    Assert.assertArrayEquals(new int[]{5, 10},  // tie, 5 < 7
        f(new int[][]{new int[]{5, 10}, new int[]{7, 15}, new int[]{12, 13}, new int[]{3, 5},
            new int[]{4, 5}, new int[]{5, 6}, new int[]{10, 11}, new int[]{13, 15},
            new int[]{13, 20}}));
    Assert.assertArrayEquals(new int[]{7, 15},
        f(new int[][]{new int[]{5, 10}, new int[]{7, 15}, new int[]{12, 13}, new int[]{3, 5},
            new int[]{4, 5}, new int[]{5, 6}, new int[]{10, 11}, new int[]{13, 15},
            new int[]{13, 20}, new int[]{11, 50}}));
  }
}
