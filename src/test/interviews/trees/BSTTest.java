package interviews.trees;

import junit.framework.Assert;
import interviews.sorts.Sorts;

import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BSTTest {

  @Test(expected = NullPointerException.class)
  public void test_add() {
    BST<Integer> bst = new BST<Integer>(1, Sorts.getComparatorOfIntegers());
    bst.add(null);
  }

  @Test
  public void test_max() {
    BST<Integer> bst = new BST<Integer>(10, Sorts.getComparatorOfIntegers());
    bst.add(5);
    bst.add(3);
    bst.add(8);
    bst.add(2);
    bst.add(4);
    bst.add(6);
    bst.add(9);
    bst.add(14);
    bst.add(11);
    bst.add(16);
    Assert.assertEquals(new Integer(16), bst.max());
  }

  @Test
  public void test_min() {
    BST<Integer> bst = new BST<Integer>(10, Sorts.getComparatorOfIntegers());
    bst.add(5);
    bst.add(3);
    bst.add(8);
    bst.add(2);
    bst.add(4);
    bst.add(6);
    bst.add(9);
    bst.add(14);
    bst.add(11);
    bst.add(16);
    Assert.assertEquals(new Integer(2), bst.min());
  }

  @Test
  public void test_remove() {
    BST<Integer> bst = new BST<Integer>(10, Sorts.getComparatorOfIntegers());
    bst.add(5);
    bst.add(3);
    bst.add(8);
    bst.add(2);
    bst.add(4);
    bst.add(6);
    bst.add(9);
    bst.add(14);
    bst.add(11);
    bst.add(16);
    Assert.assertEquals("10 5 14 3 8 11 16 2 4 6 9", bst.toString());
    Assert.assertEquals(true, bst.remove(5));
    Assert.assertEquals("10 6 14 3 8 11 16 2 4 9", bst.toString());
    Assert.assertEquals(true, bst.remove(10));  // remove root
    Assert.assertEquals("11 6 14 3 8 16 2 4 9", bst.toString());
    Assert.assertEquals(false, bst.remove(10));
  }

  @Test
  public void test_toString() {
    BST<Integer> bst = new BST<Integer>(10, Sorts.getComparatorOfIntegers());
    bst.add(5);
    bst.add(3);
    bst.add(8);
    bst.add(2);
    bst.add(4);
    bst.add(6);
    bst.add(9);
    bst.add(14);
    bst.add(11);
    bst.add(16);
    Assert.assertEquals("10 5 14 3 8 11 16 2 4 6 9", bst.toString());
  }
}
