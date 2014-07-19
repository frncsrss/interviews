package interviews.arrays;

import static interviews.arrays.MaximumNumberWithElementsGreater.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaximumNumberWithElementsGreaterTest {
  @Test
  public void test() {
    Assert.assertEquals(2, f(new int[]{1, 2, 3, 4}));
    Assert.assertEquals(3, f(new int[]{900, 2, 901, 3, 1000}));
    Assert.assertEquals(1, f(new int[]{1}));
    Assert.assertEquals(1, f(new int[]{1, 1}));
    Assert.assertEquals(1, f(new int[]{1, 1, 1, 1}));
    Assert.assertEquals(4, f(new int[]{900, 2, 901, 3, 1000, 500}));
    Assert.assertEquals(1, f(new int[]{-1, 2, -3, 0}));
    Assert.assertEquals(0, f(new int[]{-1, -2, -3, 0}));
  }
}
