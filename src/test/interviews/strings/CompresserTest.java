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
    Assert.assertEquals("a2b1c5a3", Compresser.f("aabcccccaaa"));
    Assert.assertEquals("abc", Compresser.f("abc"));
    Assert.assertEquals("aabbcc", Compresser.f("aabbcc"));
  }
}
