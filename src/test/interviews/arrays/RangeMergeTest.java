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
    Assert.assertArrayEquals(new int[][]{new int[]{0, 100}},
        f(new int[][]{new int[]{0, 50}, new int[]{51, 100}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, 100}},
        f(new int[][]{new int[]{0, 75}, new int[]{25, 100}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, 25}, new int[]{30, 100}},
        f(new int[][]{new int[]{0, 25}, new int[]{30, 60}, new int[]{50, 100}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, 25}, new int[]{30, 100}},
        f(new int[][]{ new int[]{50, 100}, new int[]{30, 60}, new int[]{0, 25}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{100, 50}},
        f(new int[][]{new int[]{0, 50}, new int[]{100, 10}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, Integer.MAX_VALUE}},
        f(new int[][]{new int[]{0, 50}, new int[]{30, 10}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{100, 30}, new int[]{50, 60}},
        f(new int[][]{new int[]{0, 30}, new int[]{100, 10}, new int[]{50, 60}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{Integer.MAX_VALUE - 10, 10}},
        f(new int[][]{new int[]{Integer.MAX_VALUE - 10, Integer.MAX_VALUE}, new int[]{0, 10}}).toArray());
    Assert.assertArrayEquals(new int[][]{new int[]{0, Integer.MAX_VALUE}},
        f(new int[][]{new int[]{0, 50}, new int[]{100, 10}, new int[]{50, 60}, new int[]{60, 0}}).toArray());
  }
}
