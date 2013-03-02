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

  @Test(expected = NullPointerException.class)
  public void test_add_exception() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    bst.insert(null);
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
  public void test_max() {
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
    Assert.assertEquals(new Integer(16), bst.max());
  }

  @Test
  public void test_min() {
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
    Assert.assertEquals(new Integer(2), bst.min());
  }

  @Test
  public void test_remove() {
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
    Assert.assertEquals("10 5 14 3 8 11 16 2 4 6 9", bst.toString());
    Assert.assertEquals(true, bst.remove(5));
    Assert.assertEquals("10 6 14 3 8 11 16 2 4 9", bst.toString());
    Assert.assertEquals(true, bst.remove(10));  // remove root
    Assert.assertEquals("11 6 14 3 8 16 2 4 9", bst.toString());
    Assert.assertEquals(false, bst.remove(10));
    Assert.assertEquals(true, bst.remove(3));
    Assert.assertEquals(true, bst.remove(8));
    Assert.assertEquals(true, bst.remove(2));
    Assert.assertEquals(true, bst.remove(4));
    Assert.assertEquals(true, bst.remove(6));
    Assert.assertEquals(true, bst.remove(9));
    Assert.assertEquals(true, bst.remove(14));
    Assert.assertEquals(true, bst.remove(11));
    Assert.assertEquals(true, bst.remove(16));
    Assert.assertEquals(false, bst.remove(16));
    bst.insert(5);
    Assert.assertEquals(true, bst.remove(5));
  }

  @Test
  public void test_traversalInOrderRecursive() {
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
    Assert.assertEquals(Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 14, 16), bst.traversalInOrderRecursive());
    Assert.assertEquals(Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 14, 16), bst.traversalInOrderRecursive());
  }

  @Test
  public void test_traversalInOrderNonRecursive() {
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
    Assert.assertEquals(Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 14, 16), bst.traversalInOrderNonRecursive());
    Assert.assertEquals(Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 14, 16), bst.traversalInOrderNonRecursive());
  }

  @Test
  public void test_toString() {
    BST<Integer> bst = new BST<Integer>(Sorts.getComparatorOfIntegers());
    Assert.assertEquals("", bst.toString());
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
    Assert.assertEquals("10 5 14 3 8 11 16 2 4 6 9", bst.toString());
  }
}
