package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ReversedBinaryTest {
  @Test
  public void test_reverse() {
    Assert.assertEquals(11, ReversedBinary.reverse(13));
    Assert.assertEquals(61, ReversedBinary.reverse(47));
    Assert.assertEquals(1,  ReversedBinary.reverse(64));
    Assert.assertEquals(65, ReversedBinary.reverse(65));
  }

  @Test
  public void test_reverse2() {
    Assert.assertEquals(11, ReversedBinary.reverse2(13));
    Assert.assertEquals(61, ReversedBinary.reverse2(47));
    Assert.assertEquals(1,  ReversedBinary.reverse2(64));
    Assert.assertEquals(65, ReversedBinary.reverse2(65));
  }
}
