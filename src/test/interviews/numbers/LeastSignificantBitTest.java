package interviews.numbers;

import static interviews.numbers.LeastSignificantBit.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LeastSignificantBitTest {
  @Test
  public void test() {
    Assert.assertEquals(1, f(11));
    Assert.assertEquals(4, f(20));
    Assert.assertEquals(8, f(136));
    Assert.assertEquals(Integer.parseInt("10", 2), f(Integer.parseInt("100000010", 2)));
    Assert.assertEquals(Integer.parseInt("10000000", 2), f(Integer.parseInt("10000000", 2)));
  }
}
