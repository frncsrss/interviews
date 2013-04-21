package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RegularExpressionTest {
  @Test
  public void test() {
    RegularExpression re = new RegularExpression("((A*B|AC)D)");
    Assert.assertEquals( true, re.match("ACD"));
    Assert.assertEquals( true, re.match("BD"));
    Assert.assertEquals( true, re.match("ABD"));
    Assert.assertEquals( true, re.match("AABD"));
    Assert.assertEquals( true, re.match("AAABD"));
    Assert.assertEquals( true, re.match("AAAABD"));
    Assert.assertEquals(false, re.match("AC"));
    Assert.assertEquals(false, re.match("ABCD"));
  }
}
