package interviews.arrays;

import static interviews.arrays.MissingElements.f;
import static interviews.arrays.MissingElements.f2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MissingElementsTest {
  @Test
  public void test() {
    Assert.assertEquals(5, f(new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10}, 10));
    Assert.assertArrayEquals(new int[]{5, 8}, f2(new int[]{1, 2, 3, 4, 6, 7, 9, 10}, 10));
    Assert.assertArrayEquals(new int[]{3, 8}, f2(new int[]{1, 2, 5, 4, 6, 7, 9, 10}, 10));
  }
}
