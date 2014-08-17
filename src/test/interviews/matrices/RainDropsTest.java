package interviews.matrices;

import static interviews.matrices.RainDrops.f;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RainDropsTest {
  @Test
  public void test() {
    List<int[]> actual = f(new int[][]{
        new int[]{1, 9, 2, 9, 6},
        new int[]{3, 5, 7, 6, 3},
        new int[]{4, 6, 7, 6, 3},
        new int[]{6, 6, 6, 8, 3},
        new int[]{8, 3, 6, 6, 2},
        new int[]{5, 5, 4, 1, 2},
    });

    Assert.assertArrayEquals(new int[]{0, 3}, actual.get(0));
    Assert.assertArrayEquals(new int[]{0, 4}, actual.get(1));
    Assert.assertArrayEquals(new int[]{1, 2}, actual.get(2));
    Assert.assertArrayEquals(new int[]{2, 2}, actual.get(3));
    Assert.assertArrayEquals(new int[]{4, 0}, actual.get(4));
    Assert.assertArrayEquals(new int[]{5, 0}, actual.get(5));
  }
}
