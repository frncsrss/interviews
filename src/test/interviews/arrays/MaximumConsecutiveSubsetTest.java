package interviews.arrays;

import static interviews.arrays.MaximumConsecutiveSubset.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaximumConsecutiveSubsetTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(new int[]{1, 5}, f(new int[]{5, 1, 9, 3, 8, 20, 4, 10, 2, 11, 3}));
  }
}
