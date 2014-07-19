package interviews.arrays;

import static interviews.arrays.CompleteCycleInCircularArray.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class CompleteCycleInCircularArrayTest {
  @Test
  public void test() {
    Assert.assertEquals(true,  f(new int[] {2, 2, -1}));
    Assert.assertEquals(false, f(new int[] {2, 2, 0}));
    Assert.assertEquals(true,  f(new int[] {1, 1, 1, 1}));
    Assert.assertEquals(true,  f(new int[] {1, -1}));
    Assert.assertEquals(true,  f(new int[] {0}));
    Assert.assertEquals(false, f(new int[] {2, 2, 1}));
    Assert.assertEquals(false, f(new int[] {1, 1, 1, -1}));
  }
}
