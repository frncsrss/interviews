package interviews.arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.TwoSum.findAll;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class TwoSumTest {
  @Test
  public void test_basic() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Assert.assertEquals(findAll(array, 10).toString(), "[(1,9), (2,8), (3,7), (4,6)]");
  }
  @Test
  public void test_duplicatesBoth() {
    int[] array = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
    Assert.assertEquals(findAll(array, 10).toString(), "[(1,9), (1,9), (1,9), (1,9), (1,9), (1,9), (2,8), (3,7), (4,6)]");
  }
  @Test
  public void test_duplicatesLeft() {
    int[] array = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Assert.assertEquals(findAll(array, 10).toString(), "[(1,9), (1,9), (1,9), (2,8), (3,7), (4,6)]");
    int[] array2 = {1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9};
    Assert.assertEquals(findAll(array2, 10).toString(), "[(1,9), (2,8), (2,8), (3,7), (3,7), (4,6)]");
  }
  @Test
  public void test_duplicatesRight() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9};
    Assert.assertEquals(findAll(array, 10).toString(), "[(1,9), (1,9), (1,9), (2,8), (3,7), (4,6)]");
  }
  @Test
  public void test_duplicatesUnique() {
    int[] array = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9};
    Assert.assertEquals(findAll(array, 10, true).toString(), "[(1,9), (2,8), (3,7), (4,6)]");
  }
  @Test
  public void test_same() {
    int[] array = {1, 1, 1, 1, 1};
    Assert.assertEquals(findAll(array, 2).toString(), "[(1,1), (1,1), (1,1), (1,1), (1,1)]");
  }
  @Test
  public void test_null() {
    int[] array = {};
    Assert.assertEquals(findAll(array, 10).toString(), "[]");
  }
}
