package interviews.arrays;

import static interviews.arrays.MaximumRectangularAreaUnderHistogram.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaximumRectangularAreaUnderHistogramTest {
  @Test(expected = IllegalArgumentException.class)
  public void test_null() {
    f(null);
  }

  @Test
  public void test() {
    Assert.assertEquals(0, f(new int[]{}));
    Assert.assertEquals(4, f(new int[]{4}));
    Assert.assertEquals(6, f(new int[]{5, 3, 1}));
    Assert.assertEquals(5, f(new int[]{3, 1, 2, 4, 1}));
    Assert.assertEquals(9, f(new int[]{1, 2, 3, 4, 5}));
    Assert.assertEquals(12, f(new int[]{1, 2, 3, 4, 5, 6}));
  }
}
