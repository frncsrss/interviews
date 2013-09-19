package interviews.arrays;

import static interviews.arrays.ConsecutiveSubsequenceSummingToMax.f;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ConsecutiveSubsequenceSummingToMaxTest {
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
    Assert.assertEquals(
        Arrays.asList(2), f(Arrays.asList(-3, 2)));
    Assert.assertEquals(
        Arrays.asList(2, 5), f(Arrays.asList(-3, 2, 5)));
    Assert.assertEquals(
        Arrays.asList(-2), f(Arrays.asList(-3, -2, -5)));
    Assert.assertEquals(
        Arrays.asList(-3), f(Arrays.asList(-3)));
    Assert.assertEquals(
        Arrays.asList(2), f(Arrays.asList(2)));
  }
}
