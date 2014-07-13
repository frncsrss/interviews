package interviews.trees;

import static interviews.trees.MaximumDiameter.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaximumDiameterTest {
  @Test
  public void test() {
    Assert.assertEquals(2, f(new int[]{3}));
    Assert.assertEquals(4, f(new int[]{2, 2}));
    Assert.assertEquals(5, f(new int[]{4, 1, 2, 4}));
    Assert.assertEquals(21, f(new int[]{4, 2, 1, 3, 2, 5, 7, 2, 4, 5, 2, 3, 1, 13, 6}));
    Assert.assertEquals(23, f(new int[]{4, 2, 1, 3, 2, 5, 7, 2, 4, 5, 2, 3, 1, 13, 6, 1, 1}));
    Assert.assertEquals(7, f(new int[]{1, 1, 1, 1, 1, 2, 2}));
  }
}
