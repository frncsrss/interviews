package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class AnagramsInStringTest {
  @Test
  public void test_f() {
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

  @Test
  public void test_f2() {
    Assert.assertEquals(-1, AnagramsInString.f2("xyz",   "afdgksldfm"));
    Assert.assertEquals(0,  AnagramsInString.f2("xyz",   "xyzafdgzyxksldfm"));
    Assert.assertEquals(0,  AnagramsInString.f2("xyz",   "yxzafdgzyxksldfm"));
    Assert.assertEquals(4,  AnagramsInString.f2("xyz",   "afdgzyxksldfm"));
    Assert.assertEquals(8,  AnagramsInString.f2("xyz",   "xyazyfdgzyxksldfm"));
    Assert.assertEquals(4,  AnagramsInString.f2("abbc",  "xybabacbaskf"));
    Assert.assertEquals(6,  AnagramsInString.f2("abbcd", "xybabdacdbbaskf"));
    Assert.assertEquals(2,  AnagramsInString.f2("abbcd", "xyabbcd"));
    Assert.assertEquals(-1, AnagramsInString.f2("abbcd", "xyabbc"));
  }
}
