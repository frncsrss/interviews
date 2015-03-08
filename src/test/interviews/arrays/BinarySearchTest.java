package interviews.arrays;

import static interviews.arrays.BinarySearch.f;
import static interviews.arrays.BinarySearch.f2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BinarySearchTest {
  @Test
  public void test_f() {
    Assert.assertEquals(4,
        f(new int[]{6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97}, 33));
    Assert.assertEquals(5,
        -f(new int[]{6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97}, 34) - 1);
    Assert.assertEquals(0,
        -f(new int[]{6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97}, 1) - 1);
    Assert.assertEquals(1, -f(new int[] {1, 3}, 2) - 1);
    Assert.assertEquals(2, -f(new int[] {1, 1}, 2) - 1);
    Assert.assertEquals(1, f(new int[] {1, 1, 2, 3}, 1));
    Assert.assertEquals(2, f(new int[] {1, 1, 2, 3}, 2));
  }

  @Test
  public void test_f2() {
    Assert.assertEquals(4,
        f2(new int[]{6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97}, 33));
    Assert.assertEquals(8,
        f2(new int[]{93, 95, 96, 97, 6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84}, 33));
    Assert.assertEquals(13,
        f2(new int[]{51, 53, 64, 72, 84, 93, 95, 96, 97, 6, 13, 14, 25, 33, 43}, 33));
    Assert.assertEquals(1, -f2(new int[] {1, 3}, 2) - 1);
    Assert.assertEquals(2, -f2(new int[] {1, 1}, 2) - 1);
    Assert.assertEquals(1, f2(new int[] {1, 1, 2, 3}, 1));
    Assert.assertEquals(2, f2(new int[] {1, 1, 2, 3}, 2));
  }
}
