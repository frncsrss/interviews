package interviews.arrays;

import static interviews.arrays.RangeMerge.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RangeMergeTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(new int[][]{new int[]{0, 100}},
        f(new int[][]{new int[]{0, 50}, new int[]{50, 100}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, 50}, new int[]{51, 100}},
        f(new int[][]{new int[]{0, 50}, new int[]{51, 100}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, 100}},
        f(new int[][]{new int[]{0, 75}, new int[]{25, 100}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, 25}, new int[]{30, 100}},
        f(new int[][]{new int[]{0, 25}, new int[]{30, 60}, new int[]{50, 100}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, 25}, new int[]{30, 100}},
        f(new int[][]{ new int[]{50, 100}, new int[]{30, 60}, new int[]{0, 25}}).toArray());
  }
}
