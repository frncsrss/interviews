package interviews.strings;

import interviews.strings.Anagrams.METHOD;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class AnagramsTest {
  @Test
  public void test_sort() {
    Assert.assertEquals(null,  Anagrams.f(null, METHOD.SORT));
    Assert.assertEquals(null,  Anagrams.f(new String[]{}, METHOD.SORT));
    Assert.assertEquals("[[none], [kile, like], [man], [car, arc]]",
        Anagrams.f(new String[]{"man", "car", "kile", "arc", "none", "like"}, METHOD.SORT).toString());
    Assert.assertEquals("[[dog, god], [cat, tac, act]]",
        Anagrams.f(new String[]{"cat", "dog", "tac", "god", "act"}, METHOD.SORT).toString());
  }

  @Test
  public void test_prime() {
    Assert.assertEquals(null,  Anagrams.f(null, METHOD.PRIME));
    Assert.assertEquals(null,  Anagrams.f(new String[]{}, METHOD.PRIME));
    Assert.assertEquals("[[car, arc], [man], [none], [kile, like]]",
        Anagrams.f(new String[]{"man", "car", "kile", "arc", "none", "like"}, METHOD.PRIME).toString());
    Assert.assertEquals("[[cat, tac, act], [dog, god]]",
        Anagrams.f(new String[]{"cat", "dog", "tac", "god", "act"}, METHOD.PRIME).toString());
  }
}
