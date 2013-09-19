package interviews.arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RangeMinimumQuerySegmentTreesTest {
  protected static RangeMinimumQuerySegmentTrees obj;

  @BeforeClass
  public static void setUp() {
    int[] A = {0, 4, 2, 10, 8, 3, 2, 3, 1, 8, -1};
    //         0  1  2  3   4  5  6  7  8  9  10
    obj = new RangeMinimumQuerySegmentTrees(A);
  }

  @Test
  public void test() {
    Assert.assertEquals(0, obj.query(0, 0));
    Assert.assertEquals(0, obj.query(0, 1));
    Assert.assertEquals(0, obj.query(0, 2));
    Assert.assertEquals(0, obj.query(0, 3));
    Assert.assertEquals(0, obj.query(0, 4));
    Assert.assertEquals(0, obj.query(0, 5));
    Assert.assertEquals(0, obj.query(0, 6));
    Assert.assertEquals(0, obj.query(0, 7));
    Assert.assertEquals(0, obj.query(0, 8));
    Assert.assertEquals(0, obj.query(0, 9));
    Assert.assertEquals(-1, obj.query(0, 10));

    Assert.assertEquals(0, obj.query(1, 0));
    Assert.assertEquals(4, obj.query(1, 1));
    Assert.assertEquals(2, obj.query(1, 2));
    Assert.assertEquals(2, obj.query(1, 3));
    Assert.assertEquals(2, obj.query(1, 4));
    Assert.assertEquals(2, obj.query(1, 5));
    Assert.assertEquals(2, obj.query(1, 6));
    Assert.assertEquals(2, obj.query(1, 7));
    Assert.assertEquals(1, obj.query(1, 8));
    Assert.assertEquals(1, obj.query(1, 9));
    Assert.assertEquals(-1, obj.query(1, 10));

    Assert.assertEquals(0, obj.query(2, 0));
    Assert.assertEquals(2, obj.query(2, 1));
    Assert.assertEquals(2, obj.query(2, 2));
    Assert.assertEquals(2, obj.query(2, 3));
    Assert.assertEquals(2, obj.query(2, 4));
    Assert.assertEquals(2, obj.query(2, 5));
    Assert.assertEquals(2, obj.query(2, 6));
    Assert.assertEquals(2, obj.query(2, 7));
    Assert.assertEquals(1, obj.query(2, 8));
    Assert.assertEquals(1, obj.query(2, 9));
    Assert.assertEquals(-1, obj.query(2, 10));

    Assert.assertEquals(0, obj.query(3, 0));
    Assert.assertEquals(2, obj.query(3, 1));
    Assert.assertEquals(2, obj.query(3, 2));
    Assert.assertEquals(10, obj.query(3, 3));
    Assert.assertEquals(8, obj.query(3, 4));
    Assert.assertEquals(3, obj.query(3, 5));
    Assert.assertEquals(2, obj.query(3, 6));
    Assert.assertEquals(2, obj.query(3, 7));
    Assert.assertEquals(1, obj.query(3, 8));
    Assert.assertEquals(1, obj.query(3, 9));
    Assert.assertEquals(-1, obj.query(3, 10));

    Assert.assertEquals(0, obj.query(4, 0));
    Assert.assertEquals(2, obj.query(4, 1));
    Assert.assertEquals(2, obj.query(4, 2));
    Assert.assertEquals(8, obj.query(4, 3));
    Assert.assertEquals(8, obj.query(4, 4));
    Assert.assertEquals(3, obj.query(4, 5));
    Assert.assertEquals(2, obj.query(4, 6));
    Assert.assertEquals(2, obj.query(4, 7));
    Assert.assertEquals(1, obj.query(4, 8));
    Assert.assertEquals(1, obj.query(4, 9));
    Assert.assertEquals(-1, obj.query(4, 10));

    Assert.assertEquals(0, obj.query(5, 0));
    Assert.assertEquals(2, obj.query(5, 1));
    Assert.assertEquals(2, obj.query(5, 2));
    Assert.assertEquals(3, obj.query(5, 3));
    Assert.assertEquals(3, obj.query(5, 4));
    Assert.assertEquals(3, obj.query(5, 5));
    Assert.assertEquals(2, obj.query(5, 6));
    Assert.assertEquals(2, obj.query(5, 7));
    Assert.assertEquals(1, obj.query(5, 8));
    Assert.assertEquals(1, obj.query(5, 9));
    Assert.assertEquals(-1, obj.query(5, 10));

    Assert.assertEquals(0, obj.query(6, 0));
    Assert.assertEquals(2, obj.query(6, 1));
    Assert.assertEquals(2, obj.query(6, 2));
    Assert.assertEquals(2, obj.query(6, 3));
    Assert.assertEquals(2, obj.query(6, 4));
    Assert.assertEquals(2, obj.query(6, 5));
    Assert.assertEquals(2, obj.query(6, 6));
    Assert.assertEquals(2, obj.query(6, 7));
    Assert.assertEquals(1, obj.query(6, 8));
    Assert.assertEquals(1, obj.query(6, 9));
    Assert.assertEquals(-1, obj.query(6, 10));

    Assert.assertEquals(0, obj.query(7, 0));
    Assert.assertEquals(2, obj.query(7, 1));
    Assert.assertEquals(2, obj.query(7, 2));
    Assert.assertEquals(2, obj.query(7, 3));
    Assert.assertEquals(2, obj.query(7, 4));
    Assert.assertEquals(2, obj.query(7, 5));
    Assert.assertEquals(2, obj.query(7, 6));
    Assert.assertEquals(3, obj.query(7, 7));
    Assert.assertEquals(1, obj.query(7, 8));
    Assert.assertEquals(1, obj.query(7, 9));
    Assert.assertEquals(-1, obj.query(7, 10));

    Assert.assertEquals(0, obj.query(8, 0));
    Assert.assertEquals(1, obj.query(8, 1));
    Assert.assertEquals(1, obj.query(8, 2));
    Assert.assertEquals(1, obj.query(8, 3));
    Assert.assertEquals(1, obj.query(8, 4));
    Assert.assertEquals(1, obj.query(8, 5));
    Assert.assertEquals(1, obj.query(8, 6));
    Assert.assertEquals(1, obj.query(8, 7));
    Assert.assertEquals(1, obj.query(8, 8));
    Assert.assertEquals(1, obj.query(8, 9));
    Assert.assertEquals(-1, obj.query(8, 10));

    Assert.assertEquals(0, obj.query(9, 0));
    Assert.assertEquals(1, obj.query(9, 1));
    Assert.assertEquals(1, obj.query(9, 2));
    Assert.assertEquals(1, obj.query(9, 3));
    Assert.assertEquals(1, obj.query(9, 4));
    Assert.assertEquals(1, obj.query(9, 5));
    Assert.assertEquals(1, obj.query(9, 6));
    Assert.assertEquals(1, obj.query(9, 7));
    Assert.assertEquals(1, obj.query(9, 8));
    Assert.assertEquals(8, obj.query(9, 9));
    Assert.assertEquals(-1, obj.query(9, 10));

    Assert.assertEquals(-1, obj.query(10, 0));
    Assert.assertEquals(-1, obj.query(10, 1));
    Assert.assertEquals(-1, obj.query(10, 2));
    Assert.assertEquals(-1, obj.query(10, 3));
    Assert.assertEquals(-1, obj.query(10, 4));
    Assert.assertEquals(-1, obj.query(10, 5));
    Assert.assertEquals(-1, obj.query(10, 6));
    Assert.assertEquals(-1, obj.query(10, 7));
    Assert.assertEquals(-1, obj.query(10, 8));
    Assert.assertEquals(-1, obj.query(10, 9));
    Assert.assertEquals(-1, obj.query(10, 10));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void test_exception1() {
    obj.query(-1, 10);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void test_exception2() {
    obj.query(2, 11);
  }
}