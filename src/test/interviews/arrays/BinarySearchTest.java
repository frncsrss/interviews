package interviews.arrays;

import static interviews.arrays.BinarySearch.f;

import org.junit.Assert;
import org.junit.Test;

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

  @Test
  public void test2() {
    Assert.assertEquals(1, -f(new int[] {1, 3}, 2) - 1);
    Assert.assertEquals(2, -f(new int[] {1, 1}, 2) - 1);
    Assert.assertEquals(1, f(new int[] {1, 1, 2, 3}, 1));
    Assert.assertEquals(2, f(new int[] {1, 1, 2, 3}, 2));
  }
}
