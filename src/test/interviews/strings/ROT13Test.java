package interviews.strings;

import static interviews.strings.ROT13.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ROT13Test {
  @Test
  public void test() {
    Assert.assertEquals("uryyb", f("hello"));
    Assert.assertEquals("hello", f(f("hello")));
    Assert.assertEquals("UrYyB", f("HeLlO"));
    Assert.assertEquals("HELLO", f(f("HELLO")));
    Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", f(f("abcdefghijklmnopqrstuvwxyz")));
    Assert.assertEquals("nopqrstuvwxyzabcdefghijklm", f("abcdefghijklmnopqrstuvwxyz"));
  }
}
