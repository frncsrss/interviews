package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class CompresserTest {
  @Test
  public void test() {
    Assert.assertEquals("2a1b5c3a", Compresser.f("aabcccccaaa"));
    Assert.assertEquals("abc", Compresser.f("abc"));
    Assert.assertEquals("abcc", Compresser.f("abcc"));
    Assert.assertEquals("aabbcc", Compresser.f("aabbcc"));
  }
}
