package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SumTest {

  @Test
  public void test() {
    Assert.assertEquals(0, Sum.f(0, 0));
    Assert.assertEquals(2, Sum.f(1, 1));
    Assert.assertEquals(3, Sum.f(1, 2));
    Assert.assertEquals(37, Sum.f(22, 15));
    Assert.assertEquals(57, Sum.f(22, 35));
    Assert.assertEquals(1111111110, Sum.f(123456789, 987654321));
  }
}
