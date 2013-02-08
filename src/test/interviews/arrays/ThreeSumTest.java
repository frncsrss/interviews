package interviews.arrays;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.ThreeSum.count;
import static interviews.arrays.ThreeSum.find;
import static interviews.arrays.ThreeSum.findAll;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ThreeSumTest {
  @Test
  public void test_find() {
    Assert.assertEquals(
        Arrays.asList(-7, 2, 5), find(Arrays.asList(-7, 1, 5, 2, -4, 3, 0)));
    Assert.assertArrayEquals(
        new int[]{-7, 2, 5}, find(new int[]{-7, 1, 5, 2, -4, 3, 0}));
  }

  @Test
  public void test_findAll() {
    final int[] input = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
    List<int[]> triples = findAll(input);
    Assert.assertArrayEquals(new int[]{-40, 0, 40}, triples.get(0));
    Assert.assertArrayEquals(new int[]{-40, 10, 30}, triples.get(1));
    Assert.assertArrayEquals(new int[]{-20, -10, 30}, triples.get(2));
    Assert.assertArrayEquals(new int[]{-10, 0, 10}, triples.get(3));
  }

  @Test
  public void test_findAllWithDuplicates() {
    final int[] input = new int[]{30, -40, -40, -20, -10, 40, 0, 10, 5, 0};
    List<int[]> triples = findAll(input);
    Assert.assertArrayEquals(new int[]{-40, 0, 40}, triples.get(0));
    Assert.assertArrayEquals(new int[]{-40, 0, 40}, triples.get(1));
    Assert.assertArrayEquals(new int[]{-40, 10, 30}, triples.get(2));
    Assert.assertArrayEquals(new int[]{-40, 0, 40}, triples.get(3));
    Assert.assertArrayEquals(new int[]{-40, 0, 40}, triples.get(4));
    Assert.assertArrayEquals(new int[]{-40, 10, 30}, triples.get(5));
    Assert.assertArrayEquals(new int[]{-20, -10, 30}, triples.get(6));
    Assert.assertArrayEquals(new int[]{-10, 0, 10}, triples.get(7));
    Assert.assertArrayEquals(new int[]{-10, 0, 10}, triples.get(8));
  }

  @Test
  public void test_count() {
    Assert.assertEquals(4, count(new int[]{30, -40, -20, -10, 40, 0, 10, 5}));
    Assert.assertEquals(6, count(new int[]{30, -40, -40, -20, -10, 40, 0, 10, 5}));
    Assert.assertEquals(9, count(new int[]{30, -40, -40, -20, -10, 40, 0, 10, 5, 0}));
  }
}
