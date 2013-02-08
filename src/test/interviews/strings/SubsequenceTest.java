package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Subsequence.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SubsequenceTest {
  @Test
  public void test_f0() {
    Assert.assertEquals(true, f("ABCDEFGHLMNOPQRS", "DCGSRQPOM", 0));
    Assert.assertEquals(false, f("ABCDEFGHLMNOPQRS", "DCGSRQPOZ", 0));
  }

  @Test
  public void test_f1() {
    Assert.assertEquals(true, f("ABCDEFGHLMNOPQRS", "DCGSRQPOM", 1));
    Assert.assertEquals(false, f("ABCDEFGHLMNOPQRS", "DCGSRQPOZ", 1));
  }

  @Test
  public void test_f2() {
    Assert.assertEquals(true, f("ABCDEFGHLMNOPQRS", "DCGSRQPOM", 2));
    Assert.assertEquals(false, f("ABCDEFGHLMNOPQRS", "DCGSRQPOZ", 2));
  }
}
