package interviews.arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.CoveringPrefix.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class CoveringPrefixTest {
  @Test
  public void test_good() {
    int[] arr = {2, 2, 1, 0, 1};
    Assert.assertEquals(3, f(arr));
  }

  @Test
  public void test_all() {
    int[] arr = {2, 3, 1, 0, 4};
    Assert.assertEquals(4, f(arr));
  }

  @Test
  public void test_empty() {
    int[] arr = {};
    Assert.assertEquals(-1, f(arr));
  }

  @Test
  public void test_single() {
    int[] arr = {0};
    Assert.assertEquals(0, f(arr));
  }

  @Test
  public void test_identity() {
    int[] arr = {1, 1, 1, 1, 1};
    Assert.assertEquals(0, f(arr));
  }
}
