package interviews.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MayorTest {
  @Test
  public void test_basic() {
    Mayor m = new Mayor(5, new int[][]{
        new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}, new int[]{4, 2}, new int[]{4, 3},
        new int[]{5, 1}, new int[]{5, 3}, new int[]{5, 4}});
    Assert.assertEquals(3, m.mayor());
  }

  @Test
  public void test_complete() {
    Mayor m = new Mayor(5, new int[][]{
        new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{1, 5},
        new int[]{2, 1}, new int[]{2, 3}, new int[]{2, 4}, new int[]{2, 5},
        new int[]{3, 1}, new int[]{3, 2}, new int[]{3, 4}, new int[]{3, 5},
        new int[]{4, 1}, new int[]{4, 2}, new int[]{4, 3}, new int[]{4, 5},
        new int[]{5, 1}, new int[]{5, 2}, new int[]{5, 3}, new int[]{5, 4}});
    Assert.assertEquals(-1, m.mayor());
  }

  @Test
  public void test_no_mayor() {
    Mayor m = new Mayor(5, new int[][]{
        new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 4}});
    Assert.assertEquals(-1, m.mayor());
  }
}
