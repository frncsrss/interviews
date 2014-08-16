package interviews.matrices;

import static interviews.matrices.Rotation.left;
import static interviews.matrices.Rotation.right;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RotationTest {
  @Test
  public void test_left() {
    Assert.assertArrayEquals(new int[][]{new int[]{0}}, left(new int[][]{new int[]{0}}));
    Assert.assertArrayEquals(new int[][]{new int[]{1, 1}, new int[]{0, 0}},
        left(new int[][]{new int[]{0, 1}, new int[]{0, 1}}));
    Assert.assertArrayEquals(
        new int[][]{
            new int[]{6, 12, 18},
            new int[]{5, 11, 17},
            new int[]{4, 10, 16},
            new int[]{3, 9, 15},
            new int[]{2, 8, 14},
            new int[]{1, 7, 13},
        },
        left(new int[][]{
            new int[]{1, 2, 3, 4, 5, 6},
            new int[]{7, 8, 9, 10, 11, 12},
            new int[]{13, 14, 15, 16, 17, 18},
        }));
  }

  @Test
  public void test_right() {
    Assert.assertArrayEquals(new int[][]{new int[]{0}}, right(new int[][]{new int[]{0}}));
    Assert.assertArrayEquals(new int[][]{new int[]{0, 0}, new int[]{1, 1}},
        right(new int[][]{new int[]{0, 1}, new int[]{0, 1}}));
    Assert.assertArrayEquals(
        new int[][]{
            new int[]{13, 7, 1},
            new int[]{14, 8, 2},
            new int[]{15, 9, 3},
            new int[]{16, 10, 4},
            new int[]{17, 11, 5},
            new int[]{18, 12, 6},
        },
        right(new int[][]{
            new int[]{1, 2, 3, 4, 5, 6},
            new int[]{7, 8, 9, 10, 11, 12},
            new int[]{13, 14, 15, 16, 17, 18},
        }));
  }
}
