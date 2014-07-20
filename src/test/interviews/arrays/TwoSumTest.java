package interviews.arrays;

import static interviews.arrays.TwoSum.findAll;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class TwoSumTest {
  @Test
  public void test_basic() {
    Assert.assertArrayEquals(
        new int[][]{new int[]{1, 9}, new int[]{2, 8}, new int[]{3, 7}, new int[]{4, 6}},
        findAll(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10).toArray());
  }
  @Test
  public void test_duplicatesBoth() {
    Assert.assertArrayEquals(
        new int[][]{new int[]{1,9}, new int[]{1,9}, new int[]{1,9}, new int[]{1,9}, new int[]{1,9},
            new int[]{1,9}, new int[]{2,8}, new int[]{3,7}, new int[]{4,6}},
            findAll(new int[]{1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9}, 10).toArray());
  }
  @Test
  public void test_duplicatesLeft() {
    Assert.assertArrayEquals(
        new int[][]{new int[]{1,9}, new int[]{1,9}, new int[]{1,9}, new int[]{2,8}, new int[]{3,7},
            new int[]{4,6}},
            findAll(new int[]{1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10).toArray());
    Assert.assertArrayEquals(
        new int[][]{new int[]{1,9}, new int[]{2,8}, new int[]{2,8}, new int[]{3,7}, new int[]{3,7},
            new int[]{4,6}},
            findAll(new int[]{1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9}, 10).toArray());
  }
  @Test
  public void test_duplicatesRight() {
    Assert.assertArrayEquals(
        new int[][]{new int[]{1,9}, new int[]{1,9}, new int[]{1,9}, new int[]{2,8}, new int[]{3,7},
            new int[]{4,6}},
            findAll(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9}, 10).toArray());
  }
  @Test
  public void test_duplicatesUnique() {
    Assert.assertArrayEquals(
        new int[][]{new int[]{1,9}, new int[]{2,8}, new int[]{3,7}, new int[]{4,6}},
        findAll(new int[]{1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9}, 10, true).toArray());
  }
  @Test
  public void test_same() {
    Assert.assertArrayEquals(
        new int[][]{new int[]{1,1}, new int[]{1,1}, new int[]{1,1}, new int[]{1,1}, new int[]{1,1}},
        findAll(new int[]{1, 1, 1, 1, 1}, 2).toArray());
  }
  @Test
  public void test_null() {
    Assert.assertArrayEquals(new int[][]{}, findAll(new int[]{}, 10).toArray());
  }
}
