package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class VerbalizerTest {
  @Test
  public void test_toString() {
     Assert.assertEquals(
         Verbalizer.toString(1234), "One Thousand, Two Hundred Thirty Four");
     Assert.assertEquals(
         Verbalizer.toString(-1234), "Minus One Thousand, Two Hundred Thirty Four");
     Assert.assertEquals(
         Verbalizer.toString(0), "Zero");
     Assert.assertEquals(
         Verbalizer.toString(1), "One");
     Assert.assertEquals(
         Verbalizer.toString(21), "Twenty One");
     Assert.assertEquals(
         Verbalizer.toString(321), "Three Hundred Twenty One");
     Assert.assertEquals(
         Verbalizer.toString(4321), "Four Thousand, Three Hundred Twenty One");
     Assert.assertEquals(
         Verbalizer.toString(54321), "Fifty Four Thousand, Three Hundred Twenty One");
     Assert.assertEquals(
         Verbalizer.toString(654321), "Six Hundred Fifty Four Thousand, Three Hundred Twenty One");
     Assert.assertEquals(
         Verbalizer.toString(7654321), "Seven Million, Six Hundred Fifty Four Thousand, Three Hundred Twenty One");
     Assert.assertEquals(
         Verbalizer.toString(10), "Ten");     
     Assert.assertEquals(
         Verbalizer.toString(11), "Eleven");     
     Assert.assertEquals(
         Verbalizer.toString(12), "Twelve");     
     Assert.assertEquals(
         Verbalizer.toString(2011), "Two Thousand, Eleven");
  }
}
