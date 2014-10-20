package interviews.arrays;

import static interviews.arrays.CoveringPrefix.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class CoveringPrefixTest {
  @Test
  public void test_good() {
    Assert.assertEquals(3, f(new int[]{2, 2, 1, 0, 1}));
    Assert.assertEquals(3, f(new int[]{2, 2, 1, 9, 1, 9, 9}));
  }

  @Test
  public void test_all() {
    Assert.assertEquals(4, f(new int[]{2, 3, 1, 0, 4}));
  }

  @Test
  public void test_empty() {
    Assert.assertEquals(-1, f(new int[]{}));
  }

  @Test
  public void test_single() {
    Assert.assertEquals(0, f(new int[]{0}));
  }

  @Test
  public void test_identity() {
    Assert.assertEquals(0, f(new int[]{1, 1, 1, 1, 1}));
  }
}
