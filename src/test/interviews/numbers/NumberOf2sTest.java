package interviews.numbers;

import static interviews.numbers.NumberOf2s.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class NumberOf2sTest {
  @Test
  public void test() {
    Assert.assertEquals(9,     f(25));
    Assert.assertEquals(13,    f(29));
    Assert.assertEquals(13,    f(30));
    Assert.assertEquals(14,    f(32));
    Assert.assertEquals(27,    f(123));
    Assert.assertEquals(174,   f(333));
    Assert.assertEquals(34507, f(61523));
  }
}
