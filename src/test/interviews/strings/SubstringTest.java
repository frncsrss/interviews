package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Substring.getPrefixTable;
import static interviews.strings.Substring.getPrefixTable2;
import static interviews.strings.Substring.strstrBruteForce;
import static interviews.strings.Substring.strstrKMP;
import static interviews.strings.Substring.strstrKMP2;
import static interviews.strings.Substring.strstrKMP3;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SubstringTest {
  @Test
  public void test_strstrBruteForce() {
    Assert.assertEquals(4,  strstrBruteForce("ababaaab", "aaa"));
    Assert.assertEquals(5,  strstrBruteForce("ababaaab", "aab"));
    Assert.assertEquals(-1, strstrBruteForce("ababaaab", "aac"));
    Assert.assertEquals(-1, strstrBruteForce("ababaaab", "aaaa"));
    Assert.assertEquals(14, strstrBruteForce("abacadabrabracabracadabrabrabracad", "abracadabra"));
    Assert.assertEquals(8,  strstrBruteForce("abacadabrabracabracadabrabrabracad", "rab"));
    Assert.assertEquals(-1, strstrBruteForce("abacadabrabracabracadabrabrabracad", "bcara"));
    Assert.assertEquals(23, strstrBruteForce("abacadabrabracabracadabrabrabracad", "rabrabracad"));
    Assert.assertEquals(0,  strstrBruteForce("abacadabrabracabracadabrabrabracad", "abacad"));
    Assert.assertEquals(13, strstrBruteForce("abra abracad abracadabra", "abracadabra"));
  }

  @Test
  public void test_strstrKMP() {
    Assert.assertEquals(4,  strstrKMP("ababaaab", "aaa"));
    Assert.assertEquals(5,  strstrKMP("ababaaab", "aab"));
    Assert.assertEquals(-1, strstrKMP("ababaaab", "aac"));
    Assert.assertEquals(-1, strstrKMP("ababaaab", "aaaa"));
    Assert.assertEquals(14, strstrKMP("abacadabrabracabracadabrabrabracad", "abracadabra"));
    Assert.assertEquals(8,  strstrKMP("abacadabrabracabracadabrabrabracad", "rab"));
    Assert.assertEquals(-1, strstrKMP("abacadabrabracabracadabrabrabracad", "bcara"));
    Assert.assertEquals(23, strstrKMP("abacadabrabracabracadabrabrabracad", "rabrabracad"));
    Assert.assertEquals(0,  strstrKMP("abacadabrabracabracadabrabrabracad", "abacad"));
    Assert.assertEquals(13, strstrKMP("abra abracad abracadabra", "abracadabra"));
  }

  @Test
  public void test_prefixTable() {
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 0, 1, 0, 1, 2, 3, 4, 2, 3, 4}, getPrefixTable("atcacatcatca".toCharArray()));
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 1, 2, 3, 4, 0, 1}, getPrefixTable("abababca".toCharArray()));
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 0, 1, 0, 1, 0, 1, 2, 3, 4}, getPrefixTable("abracadabra".toCharArray()));
  }

  @Test
  public void test_strstrKMP2() {
    Assert.assertEquals(4,  strstrKMP2("ababaaab", "aaa"));
    Assert.assertEquals(5,  strstrKMP2("ababaaab", "aab"));
    Assert.assertEquals(-1, strstrKMP2("ababaaab", "aac"));
    Assert.assertEquals(-1, strstrKMP2("ababaaab", "aaaa"));
    Assert.assertEquals(14, strstrKMP2("abacadabrabracabracadabrabrabracad", "abracadabra"));
    Assert.assertEquals(8,  strstrKMP2("abacadabrabracabracadabrabrabracad", "rab"));
    Assert.assertEquals(-1, strstrKMP2("abacadabrabracabracadabrabrabracad", "bcara"));
    Assert.assertEquals(23, strstrKMP2("abacadabrabracabracadabrabrabracad", "rabrabracad"));
    Assert.assertEquals(0,  strstrKMP2("abacadabrabracabracadabrabrabracad", "abacad"));
    Assert.assertEquals(13, strstrKMP2("abra abracad abracadabra", "abracadabra"));
  }

  @Test
  public void test_prefixTable2() {
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 0, 1, 0, 1, 2, 3, 4, 2, 3}, getPrefixTable2("atcacatcatca".toCharArray()));
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 1, 2, 3, 4, 0}, getPrefixTable2("abababca".toCharArray()));
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 0, 1, 0, 1, 0, 1, 2, 3}, getPrefixTable2("abracadabra".toCharArray()));
  }

  @Test
  public void test_strstrKMP3() {
    Assert.assertEquals(4,  strstrKMP3("ababaaab", "aaa"));
    Assert.assertEquals(5,  strstrKMP3("ababaaab", "aab"));
    Assert.assertEquals(-1, strstrKMP3("ababaaab", "aac"));
    Assert.assertEquals(-1, strstrKMP3("ababaaab", "aaaa"));
    Assert.assertEquals(14, strstrKMP3("abacadabrabracabracadabrabrabracad", "abracadabra"));
    Assert.assertEquals(8,  strstrKMP3("abacadabrabracabracadabrabrabracad", "rab"));
    Assert.assertEquals(-1, strstrKMP3("abacadabrabracabracadabrabrabracad", "bcara"));
    Assert.assertEquals(23, strstrKMP3("abacadabrabracabracadabrabrabracad", "rabrabracad"));
    Assert.assertEquals(0,  strstrKMP3("abacadabrabracabracadabrabrabracad", "abacad"));
    Assert.assertEquals(13, strstrKMP3("abra abracad abracadabra", "abracadabra"));
  }
}
