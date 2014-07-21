package interviews.numbers;

import static interviews.numbers.ClosestFibonacciNumber.f;
import static interviews.numbers.ClosestFibonacciNumber.f2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ClosestFibonacciNumberTest {
  @Test
  public void test_f() {
    Assert.assertEquals(0, f(1));
    Assert.assertEquals(0, f(13));
    Assert.assertEquals(2, f(15));
    Assert.assertEquals(2, f(19));
    Assert.assertEquals(167960, f(1000000));
  }

  @Test
  public void test_f2() {
    Assert.assertEquals(0, f2(1));
    Assert.assertEquals(0, f2(13));
    Assert.assertEquals(2, f2(15));
    Assert.assertEquals(2, f2(19));
    Assert.assertEquals(167960, f2(1000000));
  }
}
