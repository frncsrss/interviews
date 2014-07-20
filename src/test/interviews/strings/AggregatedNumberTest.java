package interviews.strings;

import static interviews.strings.AggregatedNumber.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class AggregatedNumberTest {
  @Test
  public void test() {
    Assert.assertEquals(true,  f("112358"));
    Assert.assertEquals(true,  f("122436"));
    Assert.assertEquals(true,  f("1299111210"));
    Assert.assertEquals(true,  f("112112224"));
    Assert.assertEquals(false, f("113"));
    Assert.assertEquals(true,  f("1121325"));
    Assert.assertEquals(false, f("1121326"));
    Assert.assertEquals(true,  f("123411235"));
    Assert.assertEquals(true,  f("1125126"));
  }
}
