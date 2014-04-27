package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SuffixArrayTest {
  @Test
  public void test_index() {
    SuffixArray sa = new SuffixArray("babaaaabcbabaaaaa0");
    Assert.assertEquals(17, sa.index(0));
    Assert.assertEquals(16, sa.index(1));
    Assert.assertEquals(15, sa.index(2));
    Assert.assertEquals(14, sa.index(3));
    Assert.assertEquals(13, sa.index(4));
    Assert.assertEquals(12, sa.index(5));
    Assert.assertEquals(3, sa.index(6));
    Assert.assertEquals(4, sa.index(7));
    Assert.assertEquals(5, sa.index(8));
    Assert.assertEquals(10, sa.index(9));
    Assert.assertEquals(1, sa.index(10));
    Assert.assertEquals(6, sa.index(11));
    Assert.assertEquals(11, sa.index(12));
    Assert.assertEquals(2, sa.index(13));
    Assert.assertEquals(9, sa.index(14));
    Assert.assertEquals(0, sa.index(15));
    Assert.assertEquals(7, sa.index(16));
    Assert.assertEquals(8, sa.index(17));
  }

  @Test
  public void test_select() {
    SuffixArray sa = new SuffixArray("babaaaabcbabaaaaa0");
    Assert.assertEquals("0", sa.select(0));
    Assert.assertEquals("a0", sa.select(1));
    Assert.assertEquals("aa0", sa.select(2));
    Assert.assertEquals("aaa0", sa.select(3));
    Assert.assertEquals("aaaa0", sa.select(4));
    Assert.assertEquals("aaaaa0", sa.select(5));
    Assert.assertEquals("aaaabcbabaaaaa0", sa.select(6));
    Assert.assertEquals("aaabcbabaaaaa0", sa.select(7));
    Assert.assertEquals("aabcbabaaaaa0", sa.select(8));
    Assert.assertEquals("abaaaaa0", sa.select(9));
    Assert.assertEquals("abaaaabcbabaaaaa0", sa.select(10));
    Assert.assertEquals("abcbabaaaaa0", sa.select(11));
    Assert.assertEquals("baaaaa0", sa.select(12));
    Assert.assertEquals("baaaabcbabaaaaa0", sa.select(13));
    Assert.assertEquals("babaaaaa0", sa.select(14));
    Assert.assertEquals("babaaaabcbabaaaaa0", sa.select(15));
    Assert.assertEquals("bcbabaaaaa0", sa.select(16));
    Assert.assertEquals("cbabaaaaa0", sa.select(17));
  }
}
