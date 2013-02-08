package interviews.arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.Dominator.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class DominatorTest {
  @Test
  public void test_good() {
    int[] arr = {3, 4, 3, 2, 3, -1, 3, 3};
    Assert.assertEquals(7, f(arr));
  }

  @Test
  public void test_good1() {
    int[] arr = {3, 4, 3, 2, 3, -1, 3, 6};
    Assert.assertEquals(6, f(arr));
  }

  @Test
  public void test_good2() {
    int[] arr = {2, 4, -1, 6, 3, 3, 3, 3};
    Assert.assertEquals(7, f(arr));
  }

  @Test
  public void test_good3() {
    int[] arr = {3, 4, 3, 2, 3, -1, 6, 3};
    Assert.assertEquals(7, f(arr));
  }

  @Test
  public void test_good4() {
    int[] arr = {3, 4, 3, 3, -1, 6, 3, 8};
    Assert.assertEquals(6, f(arr));
  }

  @Test
  public void test_fail() {
    int[] arr = {3, 1, 2, 1, 2, 1, 3};
    Assert.assertEquals(-1, f(arr));
  }

  @Test
  public void test_empty() {
    int[] arr = {};
    Assert.assertEquals(-1, f(arr));
  }

  @Test
  public void test_single() {
    int[] arr = {3};
    Assert.assertEquals(0, f(arr));
  }

  @Test
  public void test_large() {
    int[] arr = {Integer.MAX_VALUE, 3, Integer.MAX_VALUE};
    Assert.assertEquals(2, f(arr));
  }
}
