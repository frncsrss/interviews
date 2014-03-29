package interviews.trees;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BSTFindSumTest {
  @Test
  public void test() {
    BSTFindSum bst = new BSTFindSum(new int[]{10, 8, 13, 5, 9, 12, 15, 2, 7, 14, 1, 3});
    Assert.assertArrayEquals(new int[]{1, 15}, bst.sum(16));
    Assert.assertArrayEquals(new int[]{7, 14}, bst.sum(21));
    Assert.assertArrayEquals(new int[]{8, 15}, bst.sum(23));
    Assert.assertArrayEquals(new int[]{1, 10}, bst.sum(11));
    Assert.assertArrayEquals(new int[]{15, 15}, bst.sum(30));
    Assert.assertArrayEquals(new int[]{12, 14}, bst.sum(26));
    Assert.assertArrayEquals(new int[]{1, 2}, bst.sum(3));
    Assert.assertArrayEquals(new int[]{1, 3}, bst.sum(4));
    Assert.assertArrayEquals(null, bst.sum(0));
    Assert.assertArrayEquals(null, bst.sum(31));
  }
}
