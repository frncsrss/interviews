package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LongestCommonSubstringTest {
  @Test
  public void test_main1() {
    Assert.assertEquals(
        " peter go",
        LongestCommonSubstring.f("Please, peter go swimming!", "IÕm peter goliswi"));
  }
}
