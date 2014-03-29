package interviews.arrays;

import static interviews.arrays.SignSort.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SignSortTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(new int[]{-2, -3, -2, 1, 4, 5}, f(new int[]{1, -2, 4, -3, -2, 5}));
    Assert.assertArrayEquals(new int[]{1, 2, 4, 3, 2, 5}, f(new int[]{1, 2, 4, 3, 2, 5}));
    Assert.assertArrayEquals(new int[]{-1, -2, -4, -3, -2, -5}, f(new int[]{-1, -2, -4, -3, -2, -5}));
    Assert.assertArrayEquals(new int[]{-1, -2, -4, 3, 2, 5}, f(new int[]{-1, -2, -4, 3, 2, 5}));
    Assert.assertArrayEquals(new int[]{-1, -2, -4, -1, 3, 2, 5}, f(new int[]{-1, -2, -4, 3, 2, 5, -1}));
    Assert.assertArrayEquals(new int[]{-1, -2, -3, -4, 1, 2, 3, 4, 5, 6, 7},
        f(new int[]{1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4}));
  }
}
