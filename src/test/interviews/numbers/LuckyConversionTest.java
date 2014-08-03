package interviews.numbers;

import static interviews.numbers.LuckyConversion.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LuckyConversionTest {
  @Test
  public void test() {
    Assert.assertEquals(1, f("47", "74"));
    Assert.assertEquals(1, f("774", "744"));
    Assert.assertEquals(3, f("777", "444"));
    Assert.assertEquals(4, f("74777474", "44744747"));
  }
}
