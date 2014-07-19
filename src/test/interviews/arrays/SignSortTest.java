package interviews.arrays;

import static interviews.arrays.SignSort.f;
import static interviews.arrays.SignSort.f2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SignSortTest {
  @Test
  public void test_f() {
    Assert.assertArrayEquals(new int[]{-2, -3, -2, 1, 4, 5}, f(new int[]{1, -2, 4, -3, -2, 5}));
    Assert.assertArrayEquals(new int[]{1, 2, 4, 3, 2, 5}, f(new int[]{1, 2, 4, 3, 2, 5}));
    Assert.assertArrayEquals(new int[]{-1, -2, -4, -3, -2, -5}, f(new int[]{-1, -2, -4, -3, -2, -5}));
    Assert.assertArrayEquals(new int[]{-1, -2, -4, 3, 2, 5}, f(new int[]{-1, -2, -4, 3, 2, 5}));
    Assert.assertArrayEquals(new int[]{-1, -2, -4, -1, 3, 2, 5}, f(new int[]{-1, -2, -4, 3, 2, 5, -1}));
    Assert.assertArrayEquals(new int[]{-1, -2, -3, -4, 1, 2, 3, 4, 5, 6, 7},
        f(new int[]{1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4}));
  }

  @Test
  public void test_f2() {
    Assert.assertArrayEquals(new int[]{-1, -2, 1, 2}, f2(new int[]{-1, 1, -2, 2}));
    Assert.assertArrayEquals(new int[]{-2, 1, 2}, f2(new int[]{1, -2, 2}));
    Assert.assertArrayEquals(new int[]{-2, 1}, f2(new int[]{1, -2}));
    Assert.assertArrayEquals(new int[]{-1, 1}, f2(new int[]{-1, 1}));
    Assert.assertArrayEquals(new int[]{-1, -2, -3, 1, 2, 3}, f2(new int[]{-1, 1, -2, 2, -3, 3}));
    Assert.assertArrayEquals(new int[]{-1, -2, -3, -4, 1, 2, 3, 4, 5, 6, 7},
        f2(new int[]{1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4}));
  }
}
