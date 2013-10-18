package interviews.trees;

import interviews.sorts.Sorts;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BTTest {

  @Test
  public void test_isBST1_true() {
    final String s = "5(3()(4))(7)";
    Assert.assertEquals(true, BT.isBST(
        BT.deserialize(s), Sorts.getComparatorOfIntegers(), Integer.MIN_VALUE, Integer.MAX_VALUE));
  }

  @Test
  public void test_isBST1_false() {
    final String s = "4(3()(5))(7)";
    Assert.assertEquals(false, BT.isBST(
        BT.deserialize(s), Sorts.getComparatorOfIntegers(), Integer.MIN_VALUE, Integer.MAX_VALUE));
  }

  @Test
  public void test_isBST2_true() {
    final String s = "5(3()(4))(7)";
    Assert.assertEquals(true, BT.isBST(BT.deserialize(s), Sorts.getComparatorOfIntegers()));
  }

  @Test
  public void test_isBST2_false() {
    final String s = "4(3()(5))(7)";
    Assert.assertEquals(false, BT.isBST(BT.deserialize(s), Sorts.getComparatorOfIntegers()));
  }

  @Test
  public void test_serialize_me() {
    final String s = "10(8)(7(6)(3()(4)))";
    Assert.assertEquals(s, BT.serialize(BT.deserialize(s)));
  }

  @Test
  public void test_serialize_interviewer() {
    final String s = "10(8)(7(6()(5()(9)))(3()(4)))";
    Assert.assertEquals(s, BT.serialize(BT.deserialize(s)));
  }

  @Test
  public void test_serialize_extreme() {
    Assert.assertEquals("10", BT.serialize(BT.deserialize("10")));
    Assert.assertEquals("10()(7)", BT.serialize(BT.deserialize("10()(7)")));
  }
}
