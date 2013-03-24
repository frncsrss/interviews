package interviews.trees;

import java.util.Arrays;
import java.util.NoSuchElementException;

import interviews.sorts.Sorts;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BSTTest {

  private static BST<Integer> getBSTOfIntegers() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.insert(10);
    bst.insert(5);
    bst.insert(3);
    bst.insert(8);
    bst.insert(2);
    bst.insert(4);
    bst.insert(6);
    bst.insert(9);
    bst.insert(14);
    bst.insert(11);
    bst.insert(16);
    return bst;
  }

  @Test(expected = NullPointerException.class)
  public void test_ceiling_exception() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.ceiling(null);
  }

  @Test(expected = NullPointerException.class)
  public void test_count_exception() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.count(null, null);
  }

  @Test(expected = NullPointerException.class)
  public void test_floor_exception() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.floor(null);
  }

  @Test(expected = NullPointerException.class)
  public void test_insert_exception() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.insert(null);
  }

  @Test(expected = NullPointerException.class)
  public void test_rank_exception() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.rank(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void test_max_exception() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.max();
  }

  @Test(expected = NoSuchElementException.class)
  public void test_min_exception() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.min();
  }

  @Test
  public void test_ceiling() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(null, bst.ceiling(17));
    Assert.assertEquals(new Integer(8), bst.ceiling(7));
    Assert.assertEquals(new Integer(8), bst.ceiling(8));
    Assert.assertEquals(new Integer(2), bst.ceiling(1));
  }

  @Test
  public void test_count() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(11, bst.count(1, 17));
    Assert.assertEquals(11, bst.count(2, 16));
    Assert.assertEquals(4, bst.count(3, 7));
  }

  @Test
  public void test_delete() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals("10 5 14 3 8 11 16 2 4 6 9", bst.toString());
    bst.delete(5);
    Assert.assertEquals("10 6 14 3 8 11 16 2 4 9", bst.toString());
    bst.delete(10);  // remove root
    Assert.assertEquals("11 6 14 3 8 16 2 4 9", bst.toString());
    bst.delete(10);  // remove non-existent element
    bst.delete(3);
    bst.delete(8);
    bst.delete(2);
    bst.delete(4);
    bst.delete(6);
    bst.delete(9);
    bst.delete(14);
    bst.delete(11);
    bst.delete(16);
    bst.delete(16);
    bst.insert(5);
    bst.delete(5);
  }

  @Test
  public void test_floor() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(null, bst.floor(1));
    Assert.assertEquals(new Integer(6), bst.floor(7));
    Assert.assertEquals(new Integer(6), bst.floor(6));
    Assert.assertEquals(new Integer(16), bst.floor(17));
  }

  @Test
  public void test_insert() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(11, bst.size());
  }

  @Test
  public void test_max() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(new Integer(16), bst.max());
  }

  @Test
  public void test_min() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(new Integer(2), bst.min());
  }

  @Test
  public void test_rank() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(0, bst.rank(1));
    Assert.assertEquals(5, bst.rank(7));
    Assert.assertEquals(4, bst.rank(6));
    Assert.assertEquals(11, bst.rank(17));
  }

  @Test
  public void test_size() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(11, bst.size());
  }

  @Test
  public void test_traversalInOrderRecursive() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(
        Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 14, 16), bst.traversalInOrderRecursive());
    Assert.assertEquals(
        Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 14, 16), bst.traversalInOrderRecursive());
  }

  @Test
  public void test_traversalInOrderNonRecursive() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals(
        Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 14, 16), bst.traversalInOrderNonRecursive());
    Assert.assertEquals(
        Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 14, 16), bst.traversalInOrderNonRecursive());
  }

  @Test
  public void test_toString() {
    BST<Integer> bst = getBSTOfIntegers();
    Assert.assertEquals("10 5 14 3 8 11 16 2 4 6 9", bst.toString());
  }
}
