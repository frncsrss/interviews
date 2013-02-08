package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

import static interviews.numbers.Sum.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SumTest {

  @Test
  public void test() {
    Assert.assertEquals(0, f(0, 0));
    Assert.assertEquals(2, f(1, 1));
    Assert.assertEquals(3, f(1, 2));
    Assert.assertEquals(37, f(22, 15));
    Assert.assertEquals(57, f(22, 35));
    Assert.assertEquals(1111111110, f(123456789, 987654321));
  }
}
