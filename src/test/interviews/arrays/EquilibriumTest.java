package interviews.arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.Equilibrium.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class EquilibriumTest {
  @Test
  public void test_equi_good() {
    int[] arr = {-7, 1, 5, 2, -4, 3, 0};
    Assert.assertEquals(3, f(arr));
  }

  @Test
  public void test_equi_fail() {
    int[] arr = {-8, 1, 5, 2, -4, 3, 0};
    Assert.assertEquals(-1, f(arr));
  }

  @Test
  public void test_first() {
    int[] arr = {10, 1, 5, 2, -4, -4, 0};
    Assert.assertEquals(0, f(arr));
  }

  @Test
  public void test_penultimate() {
    int[] arr = {10, 1, 5, 2, -4, 17, 14};
    Assert.assertEquals(5, f(arr));
  }

  @Test
  public void test_last() {
    int[] arr = {10, 1, 5, 2, -4, -14, 9};
    Assert.assertEquals(6, f(arr));
  }

  @Test
  public void test_empty() {
    int[] arr = {};
    Assert.assertEquals(-1, f(arr));
  }

  @Test
  public void test_one() {
    int[] arr = {1};
    Assert.assertEquals(0, f(arr));
  }

  @Test
  public void test_large() {
    int[] arr = new int[5];
    arr[0] = Integer.MAX_VALUE;
    arr[1] = 10;
    arr[2] = 0;
    arr[3] = 9;
    arr[4] = Integer.MIN_VALUE;
    Assert.assertEquals(-1, f(arr));
  }


}
