package interviews.strings;

import static interviews.strings.Substring.TYPE.*;

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
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", BRUTE_FORCE));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", BRUTE_FORCE));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", BRUTE_FORCE));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", BRUTE_FORCE));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", BRUTE_FORCE));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", BRUTE_FORCE));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", BRUTE_FORCE));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", BRUTE_FORCE));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", BRUTE_FORCE));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", BRUTE_FORCE));
  }

  @Test
  public void test_strstrKMP1() {
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", KNUTH_MORRIS_PRATT_1));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", KNUTH_MORRIS_PRATT_1));
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
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", KNUTH_MORRIS_PRATT_2));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", KNUTH_MORRIS_PRATT_2));
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
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", KNUTH_MORRIS_PRATT_3));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", KNUTH_MORRIS_PRATT_3));
  }

  @Test
  public void test_strstrBM() {
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", BOYER_MOORE));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", BOYER_MOORE));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", BOYER_MOORE));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", BOYER_MOORE));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", BOYER_MOORE));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", BOYER_MOORE));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", BOYER_MOORE));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", BOYER_MOORE));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", BOYER_MOORE));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", BOYER_MOORE));
  }

  @Test
  public void test_strstrRK() {
    Assert.assertEquals(4,  strstr("ababaaab", "aaa", RABIN_KARP));
    Assert.assertEquals(5,  strstr("ababaaab", "aab", RABIN_KARP));
    Assert.assertEquals(-1, strstr("ababaaab", "aac", RABIN_KARP));
    Assert.assertEquals(-1, strstr("ababaaab", "aaaa", RABIN_KARP));
    Assert.assertEquals(14, strstr("abacadabrabracabracadabrabrabracad", "abracadabra", RABIN_KARP));
    Assert.assertEquals(8,  strstr("abacadabrabracabracadabrabrabracad", "rab", RABIN_KARP));
    Assert.assertEquals(-1, strstr("abacadabrabracabracadabrabrabracad", "bcara", RABIN_KARP));
    Assert.assertEquals(23, strstr("abacadabrabracabracadabrabrabracad", "rabrabracad", RABIN_KARP));
    Assert.assertEquals(0,  strstr("abacadabrabracabracadabrabrabracad", "abacad", RABIN_KARP));
    Assert.assertEquals(13, strstr("abra abracad abracadabra", "abracadabra", RABIN_KARP));
  }
}
