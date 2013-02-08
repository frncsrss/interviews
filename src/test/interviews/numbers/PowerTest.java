package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

import static interviews.numbers.Power.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class PowerTest {
  @Test
  public void test() {
    Assert.assertEquals(1, f(2, 0));
    Assert.assertEquals(2, f(2, 1));
    Assert.assertEquals(4, f(2, 2));
    Assert.assertEquals(8, f(2, 3));
    Assert.assertEquals(16, f(2, 4));
    Assert.assertEquals(32, f(2, 5));
    Assert.assertEquals(243, f(3, 5));
    Assert.assertEquals(1000000, f(10, 6));
  }

  @Test
  public void test_a_negative() {
    Assert.assertEquals(1, f(-2, 0));
    Assert.assertEquals(-2, f(-2, 1));
    Assert.assertEquals(4, f(-2, 2));
    Assert.assertEquals(-8, f(-2, 3));
    Assert.assertEquals(16, f(-2, 4));
    Assert.assertEquals(-32, f(-2, 5));
    Assert.assertEquals(-243, f(-3, 5));
    Assert.assertEquals(1000000, f(-10, 6));
  }
}
