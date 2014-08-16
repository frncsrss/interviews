package interviews.matrices;

import static interviews.matrices.Rotation.left;
import static interviews.matrices.Rotation.leftSquare;
import static interviews.matrices.Rotation.right;
import static interviews.matrices.Rotation.rightSquare;

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

  @Test
  public void test_leftSquare() {
    Assert.assertArrayEquals(new int[][]{new int[]{0}}, leftSquare(new int[][]{new int[]{0}}));
    Assert.assertArrayEquals(new int[][]{new int[]{1, 1}, new int[]{0, 0}},
        leftSquare(new int[][]{new int[]{0, 1}, new int[]{0, 1}}));
    Assert.assertArrayEquals(
        new int[][]{
            new int[]{4, 8, 12, 16},
            new int[]{3, 7, 11, 15},
            new int[]{2, 6, 10, 14},
            new int[]{1, 5, 9, 13},
        },
        leftSquare(new int[][]{
            new int[]{1, 2, 3, 4},
            new int[]{5, 6, 7, 8},
            new int[]{9, 10, 11, 12},
            new int[]{13, 14, 15, 16},
        }));
    Assert.assertArrayEquals(
        new int[][]{
            new int[]{5, 10, 15, 20, 25},
            new int[]{4, 9, 14, 19, 24},
            new int[]{3, 8, 13, 18, 23},
            new int[]{2, 7, 12, 17, 22},
            new int[]{1, 6, 11, 16, 21},
        },
        leftSquare(new int[][]{
            new int[]{1, 2, 3, 4, 5},
            new int[]{6, 7, 8, 9, 10},
            new int[]{11, 12, 13, 14, 15},
            new int[]{16, 17, 18, 19, 20},
            new int[]{21, 22, 23, 24, 25},
        }));
  }

  @Test
  public void test_rightSquare() {
    Assert.assertArrayEquals(new int[][]{new int[]{0}}, rightSquare(new int[][]{new int[]{0}}));
    Assert.assertArrayEquals(new int[][]{new int[]{0, 0}, new int[]{1, 1}},
        rightSquare(new int[][]{new int[]{0, 1}, new int[]{0, 1}}));
    Assert.assertArrayEquals(
        new int[][]{
            new int[]{13, 9, 5, 1},
            new int[]{14, 10, 6, 2},
            new int[]{15, 11, 7, 3},
            new int[]{16, 12, 8, 4},
        },
        rightSquare(new int[][]{
            new int[]{1, 2, 3, 4},
            new int[]{5, 6, 7, 8},
            new int[]{9, 10, 11, 12},
            new int[]{13, 14, 15, 16},
        }));
    Assert.assertArrayEquals(
        new int[][]{
            new int[]{21, 16, 11, 6, 1},
            new int[]{22, 17, 12, 7, 2},
            new int[]{23, 18, 13, 8, 3},
            new int[]{24, 19, 14, 9, 4},
            new int[]{25, 20, 15, 10, 5},
        },
        rightSquare(new int[][]{
            new int[]{1, 2, 3, 4, 5},
            new int[]{6, 7, 8, 9, 10},
            new int[]{11, 12, 13, 14, 15},
            new int[]{16, 17, 18, 19, 20},
            new int[]{21, 22, 23, 24, 25},
        }));
  }
}
