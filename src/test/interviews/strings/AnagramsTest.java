package interviews.strings;

import static interviews.strings.Anagrams.f;
import interviews.strings.Anagrams.Method;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class AnagramsTest {
  @Test
  public void test_sort() {
    Assert.assertEquals(null,  f(null, Method.SORT));
    Assert.assertEquals(null,  f(new String[]{}, Method.SORT));
    Assert.assertEquals("[[none], [kile, like], [man], [car, arc]]",
        f(new String[]{"man", "car", "kile", "arc", "none", "like"}, Method.SORT).toString());
    Assert.assertEquals("[[dog, god], [cat, tac, act]]",
        f(new String[]{"cat", "dog", "tac", "god", "act"}, Method.SORT).toString());
  }

  @Test
  public void test_prime() {
    Assert.assertEquals(null,  f(null, Method.PRIME));
    Assert.assertEquals(null,  f(new String[]{}, Method.PRIME));
    Assert.assertEquals("[[none], [kile, like], [man], [car, arc]]",
        f(new String[]{"man", "car", "kile", "arc", "none", "like"}, Method.PRIME).toString());
    Assert.assertEquals("[[dog, god], [cat, tac, act]]",
        f(new String[]{"cat", "dog", "tac", "god", "act"}, Method.PRIME).toString());
  }
}
