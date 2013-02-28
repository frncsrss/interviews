package interviews.arrays;

import static interviews.arrays.DutchNationalFlag.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class DutchNationalFlagTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(
        new int[]{0, 0, 1, 1, 2, 2}, f(new int[]{0, 1, 2, 2, 1, 0}));
    Assert.assertArrayEquals(
        new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2}, f(new int[]{0, 1, 2, 1, 2, 0, 0, 2, 1}));
    Assert.assertArrayEquals(
        new int[]{0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, f(new int[]{0, 1, 2, 0, 1, 2, 2, 0, 0, 2, 1, 1}));
    Assert.assertArrayEquals(
        new int[]{0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, f(new int[]{0, 1, 2, 1, 2, 2, 0, 0, 2, 1, 1}));
  }
}
