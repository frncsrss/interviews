package interviews.arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.BinarySearch.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BinarySearchTest {
  @Test
  public void test() {
    final int[] input =
        new int[]{6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97};
    Assert.assertEquals(4, f(input, 33));
    Assert.assertEquals(5, -f(input, 34) - 1);
    Assert.assertEquals(0, -f(input, 1) - 1);
  }
}
