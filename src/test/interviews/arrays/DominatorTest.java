package interviews.arrays;

import static interviews.arrays.Dominator.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class DominatorTest {
  @Test
  public void test() {
    Assert.assertEquals(7, f(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
    Assert.assertEquals(6, f(new int[] {3, 4, 3, 2, 3, -1, 3, 6}));
    Assert.assertEquals(7, f(new int[] {2, 4, -1, 6, 3, 3, 3, 3}));
    Assert.assertEquals(7, f(new int[] {3, 4, 3, 2, 3, -1, 6, 3}));
    Assert.assertEquals(6, f(new int[] {3, 4, 3, 3, -1, 6, 3, 8}));
    Assert.assertEquals(-1,f(new int[] {}));
    Assert.assertEquals(0, f(new int[] {3}));
    Assert.assertEquals(2, f(new int[] {Integer.MAX_VALUE, 3, Integer.MAX_VALUE}));
  }
}
