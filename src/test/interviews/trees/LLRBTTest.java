package interviews.trees;

import interviews.sorts.Sorts;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LLRBTTest {

  @Test
  public void test() {
    LLRBT<String> llrbt = new LLRBT<String>(String.CASE_INSENSITIVE_ORDER);
    llrbt.insert("S");
    llrbt.insert("E");
    Assert.assertEquals("S E", llrbt.toString());
    llrbt.insert("A");
    Assert.assertEquals("E A S", llrbt.toString());
    llrbt.insert("R");
    Assert.assertEquals("E A S R", llrbt.toString());
    llrbt.insert("C");
    Assert.assertEquals("E C S A R", llrbt.toString());
    llrbt.insert("H");
    Assert.assertEquals("R E S C H A", llrbt.toString());
    llrbt.insert("X");
    Assert.assertEquals("R E X C H S A", llrbt.toString());
    llrbt.insert("M");
    Assert.assertEquals("R E X C M S A H", llrbt.toString());
    llrbt.insert("P");
    Assert.assertEquals("M E R C H P X A S", llrbt.toString());
    llrbt.insert("K");
    Assert.assertEquals("M E R C K P X A H S", llrbt.toString());
    llrbt.insert("L");
    Assert.assertEquals("M K R E L P X C H S A", llrbt.toString());
    llrbt.insert("D");
    Assert.assertEquals("M E R C K P X A D H L S", llrbt.toString());
  }

  @Test
  public void test_quizz() {
    LLRBT<Integer> llrbt = new LLRBT<Integer>(Sorts.getComparatorOfIntegers());
    llrbt.insert(29);
    llrbt.insert(21);
    llrbt.insert(20);
    llrbt.insert(28);
    llrbt.insert(80);
    llrbt.insert(69);
    llrbt.insert(98);
    llrbt.insert(58);
    llrbt.insert(71);
    llrbt.insert(87);
    Assert.assertEquals("29 21 80 20 28 69 98 58 71 87", llrbt.toString());
    llrbt.insert(54);
    llrbt.insert(72);
    llrbt.insert(34);
    Assert.assertEquals("69 29 80 21 54 72 98 20 28 34 58 71 87", llrbt.toString());
  }
}
