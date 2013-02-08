package interviews.strings;

import interviews.trees.Trie;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Splitter.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SplitterTest {
  @Test
  public void test_split() {
    Trie dict = new Trie();
    dict.add("is");
    dict.add("awesome");
    dict.add("!");
    String s = "thisisawesome!";
    Assert.assertEquals("TH is is awesome !", f(s, dict));
    dict.add("this");
    Assert.assertEquals("this is awesome !", f(s, dict));
    dict.add("we");
    dict.add("some");
    Assert.assertEquals("this is awesome !", f(s, dict));
    dict.add("a");
    Assert.assertEquals("this is a we some !", f(s, dict));
  }

  @Test
  public void test_remove() {
    Trie dict = new Trie();
    dict.add("this");
    dict.add("is");
    dict.add("awesome");
    dict.add("!");
    String s = "thisisawesome!";
    Assert.assertEquals("this is awesome !", f(s, dict));
    dict.remove("this");
    Assert.assertEquals("TH is is awesome !", f(s, dict));
  }

  @Test
  public void test_exl() {
    Trie dict = new Trie();
    dict.add("look");
    dict.add("just");
    dict.add("like");
    dict.add("her");
    dict.add("brother");
    String s = "jesslooksjustlikeherbrothertim";
    Assert.assertEquals("JESS look S just like her brother TIM", f(s, dict));
  }

  @Test
  public void test_interview() {
    Trie dict = new Trie();
    dict.add("looked");
    dict.add("just");
    dict.add("like");
    dict.add("her");
    dict.add("brother");
    String s = "jesslookedjustlikeherbrothertim";
    Assert.assertEquals("JESS looked just like her brother TIM", f(s, dict));
  }
}
