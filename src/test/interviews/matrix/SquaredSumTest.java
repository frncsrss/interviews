package interviews.matrix;

import static interviews.matrix.SquaredSum.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SquaredSumTest {
  @Test
  public void test_f() {
    Assert.assertArrayEquals(
        new int[][]{new int[]{1, 3, 6, 10}, new int[]{6, 14, 24, 36}, new int[]{15, 33, 54, 78}},
        f(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}}));
  }
}
