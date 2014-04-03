package interviews.numbers;

import static interviews.numbers.NextIncrementalDigitSequence.f;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class NextIncrementalDigitSequenceTest {
  @Test
  public void test() {
    Assert.assertEquals(1,     f(-1));
    Assert.assertEquals(1,     f(0));
    Assert.assertEquals(6,     f(5));
    Assert.assertEquals(12,    f(9));
    Assert.assertEquals(567,   f(510));
    Assert.assertEquals(789,   f(788));
    Assert.assertEquals(1234,  f(987));
    Assert.assertEquals(1234,  f(810));
    Assert.assertEquals(3678,  f(3599));
    Assert.assertEquals(3456,  f(3123));
    Assert.assertEquals(4567,  f(3790));
    Assert.assertEquals(4569,  f(4568));
    Assert.assertEquals(4578,  f(4569));
    Assert.assertEquals(5678,  f(4789));
    Assert.assertEquals(12345, f(6790));
    Assert.assertEquals(12345679,  f(12345678));
    Assert.assertEquals(12345689,  f(12345679));
    Assert.assertEquals(123456789, f(123456788));
  }

  @Test(expected = NoSuchElementException.class)
  public void test_too_big() {
    f(123456789);
  }

  @Test(expected = NoSuchElementException.class)
  public void test_too_big2() {
    f(1000000000);
  }
}
