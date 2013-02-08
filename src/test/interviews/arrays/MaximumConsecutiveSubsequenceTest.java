package interviews.arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.MaximumConsecutiveSubsequence.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaximumConsecutiveSubsequenceTest {
  @Test
  public void test() {
    Assert.assertEquals(
        Arrays.asList(5, -2, 9), f(Arrays.asList(1, -3, 5, -2, 9, -8, -6, 4)));
    Assert.assertEquals(
        Arrays.asList(4, -3, 5, -2, 9), f(Arrays.asList(4, -3, 5, -2, 9, -8, -6, 4)));
    Assert.assertEquals(
        Arrays.asList(5, -2, 9), f(Arrays.asList(1, -3, 5, -2, 9, -8, 6, 1)));
    Assert.assertEquals(
        Arrays.asList(5, -2, 9, -8, 6, 4), f(Arrays.asList(1, -3, 5, -2, 9, -8, 6, 4)));
  }
}
