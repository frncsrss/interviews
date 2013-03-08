package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class OperatorsTest {
  @Test
  public void test_apply() {
    double x = 2;
    double y = 4;
    Assert.assertEquals(6,   Operators.PLUS.apply(x, y), 0.1d);
    Assert.assertEquals(-2,  Operators.MINUS.apply(x, y), 0.1d);
    Assert.assertEquals(8,   Operators.TIMES.apply(x, y), 0.1d);
    Assert.assertEquals(0.5, Operators.DIVIDE.apply(x, y), 0.01d);
  }

  @Test
  public void test_toString() {
    Assert.assertEquals("+", Operators.PLUS.toString());
    Assert.assertEquals("-", Operators.MINUS.toString());
    Assert.assertEquals("*", Operators.TIMES.toString());
    Assert.assertEquals("/", Operators.DIVIDE.toString());
  }
}
