package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LongestRepeatedSubstringTest {
  @Test
  public void test() {
    Assert.assertEquals("acaag", LongestRepeatedSubstring.f("aacaagtttacaagc"));
  }
}
