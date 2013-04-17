package interviews.strings;

import interviews.strings.Substring.TYPE;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Substring.getPrefixTable1;
import static interviews.strings.Substring.getPrefixTable2;
import static interviews.strings.Substring.strstr;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SubstringTest {
  @Test
  public void test_strstrBruteForce() {
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", TYPE.BRUTE_FORCE));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", TYPE.BRUTE_FORCE));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", TYPE.BRUTE_FORCE));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", TYPE.BRUTE_FORCE));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", TYPE.BRUTE_FORCE));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", TYPE.BRUTE_FORCE));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", TYPE.BRUTE_FORCE));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", TYPE.BRUTE_FORCE));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", TYPE.BRUTE_FORCE));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", TYPE.BRUTE_FORCE));
  }

  @Test
  public void test_strstrKMP1() {
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", TYPE.KMP1));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", TYPE.KMP1));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", TYPE.KMP1));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", TYPE.KMP1));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", TYPE.KMP1));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", TYPE.KMP1));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", TYPE.KMP1));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", TYPE.KMP1));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", TYPE.KMP1));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", TYPE.KMP1));
  }

  @Test
  public void test_prefixTable() {
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 0, 1, 0, 1, 2, 3, 4, 2, 3, 4},
        getPrefixTable1("atcacatcatca".toCharArray()));
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 1, 2, 3, 4, 0, 1},
        getPrefixTable1("abababca".toCharArray()));
    Assert.assertArrayEquals(
        new int[]{-1, 0, 0, 0, 1, 0, 1, 0, 1, 2, 3, 4},
        getPrefixTable1("abracadabra".toCharArray()));
  }

  @Test
  public void test_strstrKMP2() {
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", TYPE.KMP2));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", TYPE.KMP2));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", TYPE.KMP2));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", TYPE.KMP2));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", TYPE.KMP2));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", TYPE.KMP2));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", TYPE.KMP2));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", TYPE.KMP2));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", TYPE.KMP2));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", TYPE.KMP2));
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
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", TYPE.KMP3));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", TYPE.KMP3));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", TYPE.KMP3));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", TYPE.KMP3));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", TYPE.KMP3));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", TYPE.KMP3));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", TYPE.KMP3));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", TYPE.KMP3));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", TYPE.KMP3));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", TYPE.KMP3));
  }
}
