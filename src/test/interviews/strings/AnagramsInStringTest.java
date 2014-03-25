package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class AnagramsInStringTest {
  @Test
  public void test() {
    Assert.assertEquals(-1, AnagramsInString.f("xyz",   "afdgksldfm"));
    Assert.assertEquals(0,  AnagramsInString.f("xyz",   "xyzafdgzyxksldfm"));
    Assert.assertEquals(0,  AnagramsInString.f("xyz",   "yxzafdgzyxksldfm"));
    Assert.assertEquals(4,  AnagramsInString.f("xyz",   "afdgzyxksldfm"));
    Assert.assertEquals(8,  AnagramsInString.f("xyz",   "xyazyfdgzyxksldfm"));
    Assert.assertEquals(4,  AnagramsInString.f("abbc",  "xybabacbaskf"));
    Assert.assertEquals(6,  AnagramsInString.f("abbcd", "xybabdacdbbaskf"));
    Assert.assertEquals(2,  AnagramsInString.f("abbcd", "xyabbcd"));
    Assert.assertEquals(-1, AnagramsInString.f("abbcd", "xyabbc"));
  }
}
