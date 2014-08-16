package interviews.numbers;

import static interviews.numbers.NumberOfPrimeNumbersBelow.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class NumberOfPrimeNumbersBelowTest {
  @Test
  public void test() {
    Assert.assertEquals(25, f(100));
    Assert.assertEquals(100, f(542));
    Assert.assertEquals(1000, f(7920));
    Assert.assertEquals(10000, f(104730));
    Assert.assertEquals(100008, f(1299827));
  }
}
