package interviews.numbers;

import static interviews.numbers.ClosestFibonacciNumber.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ClosestFibonacciNumberTest {
  @Test
  public void test() {
    Assert.assertEquals(0, f(1));
    Assert.assertEquals(0, f(13));
    Assert.assertEquals(2, f(15));
    Assert.assertEquals(2, f(19));
    Assert.assertEquals(167960, f(1000000));
  }
}
