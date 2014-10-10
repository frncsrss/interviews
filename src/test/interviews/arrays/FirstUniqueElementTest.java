package interviews.arrays;

import static interviews.arrays.FirstUniqueElement.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class FirstUniqueElementTest {
  @Test
  public void test() {
    Assert.assertEquals(1, f(new int[]{1}));
    Assert.assertEquals(1, f(new int[]{1, 2}));
    Assert.assertEquals(2, f(new int[]{1, 2, 1}));
    Assert.assertEquals(1, f(new int[]{1, 2, 2}));
    Assert.assertEquals(3, f(new int[]{1, 2, 2, 1, 3}));
    Assert.assertEquals(4, f(new int[]{1, 2, 2, 4, 1, 3}));
    Assert.assertEquals(6, f(new int[]{1, 2, 2, 4, 1, 3, 4, 3, 5, 6, 7, 7, 5}));
  }
}
