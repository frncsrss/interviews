package interviews.matrices;

import static interviews.matrices.Islands.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class IslandsTest {
  @Test
  public void test() {
    Assert.assertEquals(0, f(new int[][]{new int[]{0}}));
    Assert.assertEquals(1, f(new int[][]{new int[]{0, 1}, new int[]{0, 1}}));
    Assert.assertEquals(2, f(new int[][]{new int[]{0, 1}, new int[]{1, 0}}));
    Assert.assertEquals(7,
        f(new int[][]{
            new int[]{0, 0, 1, 0, 1, 1},
            new int[]{0, 1, 1, 0, 1, 1},
            new int[]{0, 0, 0, 0, 0, 0},
            new int[]{1, 0, 1, 0, 1, 0},
            new int[]{1, 1, 1, 0, 1, 0},
            new int[]{0, 0, 0, 0, 1, 0},
            new int[]{1, 0, 0, 1, 1, 0},
            new int[]{0, 1, 0, 1, 0, 0},
            new int[]{1, 1, 1, 0, 0, 0},
            new int[]{0, 1, 0, 0, 1, 1},
        }));
  }
}
