package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SuffixArrayTest {
  @Test
  public void test() {
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
