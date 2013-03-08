package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class PowerTest {
  @Test
  public void test() {
    Assert.assertEquals(1, Power.f(2, 0));
    Assert.assertEquals(2, Power.f(2, 1));
    Assert.assertEquals(4, Power.f(2, 2));
    Assert.assertEquals(8, Power.f(2, 3));
    Assert.assertEquals(16, Power.f(2, 4));
    Assert.assertEquals(32, Power.f(2, 5));
    Assert.assertEquals(243, Power.f(3, 5));
    Assert.assertEquals(1000000, Power.f(10, 6));
  }

  @Test
  public void test_a_negative() {
    Assert.assertEquals(1, Power.f(-2, 0));
    Assert.assertEquals(-2, Power.f(-2, 1));
    Assert.assertEquals(4, Power.f(-2, 2));
    Assert.assertEquals(-8, Power.f(-2, 3));
    Assert.assertEquals(16, Power.f(-2, 4));
    Assert.assertEquals(-32, Power.f(-2, 5));
    Assert.assertEquals(-243, Power.f(-3, 5));
    Assert.assertEquals(1000000, Power.f(-10, 6));
  }
}
