package interviews.matrices;

import static interviews.matrices.LargestSubmatrixBelowBudget.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LargestSubmatrixBelowBudgetTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{1, 1}},
        f(new int[][]{
            new int[]{3, 2, 7, 4, 6},
            new int[]{1, 5, 8, 9, 3},
            new int[]{7, 2, 6, 1, 5},
            new int[]{8, 3, 4, 2, 7},
        }, 11));
    Assert.assertArrayEquals(
        new int[][]{new int[]{2, 1}, new int[]{3, 3}},
        f(new int[][]{
            new int[]{3, 2, 7, 4, 6},
            new int[]{1, 5, 8, 9, 3},
            new int[]{7, 2, 6, 1, 5},
            new int[]{8, 3, 4, 2, 2},
        }, 19));
    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{3, 4}},
        f(new int[][]{
            new int[]{3, 2, 7, 4, 6},
            new int[]{1, 5, 8, 9, 3},
            new int[]{7, 2, 6, 1, 5},
            new int[]{8, 3, 4, 2, 2},
        }, 100));
  }
}
