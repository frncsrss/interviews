package interviews.strings;

import static interviews.strings.LongestPalindromicSubstring.bruteForce;
import static interviews.strings.LongestPalindromicSubstring.centerExpansion;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LongestPalindromicSubstringTest {
  @Test
  public void test_bruteForce() {
    Assert.assertEquals("aba", bruteForce("caba"));
    Assert.assertEquals("aba", bruteForce("abacdfgdcaba"));
    Assert.assertEquals("aba", bruteForce("abacdfgdcaba"));
    Assert.assertEquals("aabbccbbaa", bruteForce("aabbccbbaa"));
    Assert.assertEquals("aabbccbbaa", bruteForce("aabbcbbaadeaabbccbbaa"));
    Assert.assertEquals("aabbddbbaa", bruteForce("aabbddbbaadeaabbccbbaa"));
  }

  @Test
  public void test_centerExpansion() {
    Assert.assertEquals("aba", centerExpansion("caba"));
    Assert.assertEquals("aba", centerExpansion("abacdfgdcaba"));
    Assert.assertEquals("aba", centerExpansion("abacdfgdcaba"));
    Assert.assertEquals("aabbccbbaa", centerExpansion("aabbccbbaa"));
    Assert.assertEquals("aabbccbbaa", centerExpansion("aabbcbbaadeaabbccbbaa"));
    Assert.assertEquals("aabbddbbaa", centerExpansion("aabbddbbaadeaabbccbbaa"));
  }
}
