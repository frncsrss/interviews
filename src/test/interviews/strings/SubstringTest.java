package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Substring.getPrefixTable;
import static interviews.strings.Substring.strstrBruteForce;
import static interviews.strings.Substring.strstrKMP;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SubstringTest {
  @Test
  public void test_strstr() {
    Assert.assertEquals(4,  strstrBruteForce("ababaaab", "aaa"));
    Assert.assertEquals(5,  strstrBruteForce("ababaaab", "aab"));
    Assert.assertEquals(-1, strstrBruteForce("ababaaab", "aac"));
    Assert.assertEquals(-1, strstrBruteForce("ababaaab", "aaaa"));
    Assert.assertEquals(14, strstrBruteForce("abacadabrabracabracadabrabrabracad", "abracadabra"));
    Assert.assertEquals(8,  strstrBruteForce("abacadabrabracabracadabrabrabracad", "rab"));
    Assert.assertEquals(-1, strstrBruteForce("abacadabrabracabracadabrabrabracad", "bcara"));
    Assert.assertEquals(23, strstrBruteForce("abacadabrabracabracadabrabrabracad", "rabrabracad"));
    Assert.assertEquals(0,  strstrBruteForce("abacadabrabracabracadabrabrabracad", "abacad"));
  }

  @Test
  public void test_search() {
    Assert.assertEquals(4,  strstrKMP("ababaaab", "aaa"));
    Assert.assertEquals(5,  strstrKMP("ababaaab", "aab"));
    Assert.assertEquals(-1, strstrKMP("ababaaab", "aac"));
    Assert.assertEquals(-1, strstrKMP("ababaaab", "aaaa"));
    Assert.assertEquals(14, strstrKMP("abacadabrabracabracadabrabrabracad", "abracadabra"));
    Assert.assertEquals(8,  strstrKMP("abacadabrabracabracadabrabrabracad", "rab"));
    Assert.assertEquals(-1, strstrKMP("abacadabrabracabracadabrabrabracad", "bcara"));
    Assert.assertEquals(23, strstrKMP("abacadabrabracabracadabrabrabracad", "rabrabracad"));
    Assert.assertEquals(0,  strstrKMP("abacadabrabracabracadabrabrabracad", "abacad"));
  }

  @Test
  public void test_prefix() {
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 0, 1, 0, 1, 2, 3, 4, 2, 3, 4}, getPrefixTable("atcacatcatca".toCharArray()));
  }
}
