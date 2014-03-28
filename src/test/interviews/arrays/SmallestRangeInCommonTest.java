package interviews.arrays;

import static interviews.arrays.SmallestRangeInCommon.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SmallestRangeInCommonTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(new int[]{20, 24},
        f(new int[][]{new int[]{4, 10, 15, 24, 26}, new int[]{0, 9, 12, 20}, new int[]{5, 18, 22, 30}}));
    Assert.assertArrayEquals(new int[]{90, 100},
        f(new int[][]{new int[]{1, 5, 10, 20, 90}, new int[]{100}}));
  }
}
