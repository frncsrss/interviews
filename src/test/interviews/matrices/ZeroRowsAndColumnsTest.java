package interviews.matrices;

import static interviews.matrices.ZeroRowsAndColumns.f;
import static interviews.matrices.ZeroRowsAndColumns.f2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ZeroRowsAndColumnsTest {
  @Test
  public void test_f() {
    Assert.assertArrayEquals(new int[][]{new int[]{0}}, f(new int[][]{new int[]{0}}));
    Assert.assertArrayEquals(new int[][]{new int[]{1}}, f(new int[][]{new int[]{1}}));
    Assert.assertArrayEquals(new int[][]{new int[]{2}}, f(new int[][]{new int[]{2}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{1, 2}, new int[]{3, 4}},
        f(new int[][]{new int[]{1, 2}, new int[]{3, 4}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{3, 0}},
        f(new int[][]{new int[]{1, 0}, new int[]{3, 4}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{0, 4}},
        f(new int[][]{new int[]{0, 1}, new int[]{3, 4}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{0, 0}},
        f(new int[][]{new int[]{0, 1}, new int[]{3, 0}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{0, 0}},
        f(new int[][]{new int[]{1, 2}, new int[]{0, 0}}));

    Assert.assertArrayEquals(
        new int[][]{
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0},
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0}
        },
        f(new int[][]{
            new int[]{1, 2, 0, 3, 4, 0}, new int[]{5, 6, 7, 0, 8, 9},
            new int[]{1, 2, 0, 3, 4, 5}, new int[]{6, 0, 7, 8, 9, 1}
        }));

    Assert.assertArrayEquals(
        new int[][]{
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{5, 0, 0, 3, 8, 9},
            new int[]{1, 0, 0, 3, 4, 5}, new int[]{0, 0, 0, 0, 0, 0}
        },
        f(new int[][]{
            new int[]{1, 2, 0, 3, 4, 2}, new int[]{5, 6, 7, 3, 8, 9},
            new int[]{1, 2, 7, 3, 4, 5}, new int[]{6, 0, 7, 8, 9, 1}
        }));

    Assert.assertArrayEquals(
        new int[][]{
            new int[]{1, 2, 0, 3, 4, 2}, new int[]{5, 6, 0, 3, 8, 9},
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{6, 2, 0, 8, 9, 1}
        },
        f(new int[][]{
            new int[]{1, 2, 1, 3, 4, 2}, new int[]{5, 6, 7, 3, 8, 9},
            new int[]{1, 2, 0, 3, 4, 5}, new int[]{6, 2, 7, 8, 9, 1}
        }));

    Assert.assertArrayEquals(
        new int[][]{
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 6, 7, 3, 8, 9},
            new int[]{0, 2, 7, 3, 4, 5}, new int[]{0, 2, 7, 8, 9, 1}
        },
        f(new int[][]{
            new int[]{0, 2, 1, 3, 4, 2}, new int[]{5, 6, 7, 3, 8, 9},
            new int[]{1, 2, 7, 3, 4, 5}, new int[]{6, 2, 7, 8, 9, 1}
        }));
  }

  @Test
  public void test_f2() {
    Assert.assertArrayEquals(new int[][]{new int[]{0}}, f2(new int[][]{new int[]{0}}));
    Assert.assertArrayEquals(new int[][]{new int[]{1}}, f2(new int[][]{new int[]{1}}));
    Assert.assertArrayEquals(new int[][]{new int[]{2}}, f2(new int[][]{new int[]{2}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{1, 2}, new int[]{3, 4}},
        f2(new int[][]{new int[]{1, 2}, new int[]{3, 4}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{3, 0}},
        f2(new int[][]{new int[]{1, 0}, new int[]{3, 4}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{0, 4}},
        f2(new int[][]{new int[]{0, 1}, new int[]{3, 4}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{0, 0}},
        f2(new int[][]{new int[]{0, 1}, new int[]{3, 0}}));

    Assert.assertArrayEquals(
        new int[][]{new int[]{0, 0}, new int[]{0, 0}},
        f2(new int[][]{new int[]{1, 2}, new int[]{0, 0}}));

    Assert.assertArrayEquals(
        new int[][]{
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0},
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0}
        },
        f2(new int[][]{
            new int[]{1, 2, 0, 3, 4, 0}, new int[]{5, 6, 7, 0, 8, 9},
            new int[]{1, 2, 0, 3, 4, 5}, new int[]{6, 0, 7, 8, 9, 1}
        }));

    Assert.assertArrayEquals(
        new int[][]{
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{5, 0, 0, 3, 8, 9},
            new int[]{1, 0, 0, 3, 4, 5}, new int[]{0, 0, 0, 0, 0, 0}
        },
        f2(new int[][]{
            new int[]{1, 2, 0, 3, 4, 2}, new int[]{5, 6, 7, 3, 8, 9},
            new int[]{1, 2, 7, 3, 4, 5}, new int[]{6, 0, 7, 8, 9, 1}
        }));

    Assert.assertArrayEquals(
        new int[][]{
            new int[]{1, 2, 0, 3, 4, 2}, new int[]{5, 6, 0, 3, 8, 9},
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{6, 2, 0, 8, 9, 1}
        },
        f2(new int[][]{
            new int[]{1, 2, 1, 3, 4, 2}, new int[]{5, 6, 7, 3, 8, 9},
            new int[]{1, 2, 0, 3, 4, 5}, new int[]{6, 2, 7, 8, 9, 1}
        }));

    Assert.assertArrayEquals(
        new int[][]{
            new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 6, 7, 3, 8, 9},
            new int[]{0, 2, 7, 3, 4, 5}, new int[]{0, 2, 7, 8, 9, 1}
        },
        f2(new int[][]{
            new int[]{0, 2, 1, 3, 4, 2}, new int[]{5, 6, 7, 3, 8, 9},
            new int[]{1, 2, 7, 3, 4, 5}, new int[]{6, 2, 7, 8, 9, 1}
        }));
  }
}
