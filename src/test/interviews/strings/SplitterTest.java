package interviews.strings;

import static interviews.strings.Splitter.f;
import interviews.trees.Trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SplitterTest {
  @Test
  public void test_exl_empty_dict() {
    Trie dict = new Trie();
    Assert.assertEquals("EXL", f("exl", dict));
  }

  @Test
  public void test_exl_dict_with_longer_word_with_matching_prefix() {
    Trie dict = new Trie();
    dict.add("is");
    Assert.assertEquals("I", f("i", dict));
  }

  @Test
  public void test_exl_split() {
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
    Assert.assertEquals("this is awesome !", f(s, dict));
  }

  @Test
  public void test_exl_remove() {
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
  public void test_exl_interview() {
    Trie dict = new Trie();
    dict.add("looked");
    dict.add("just");
    dict.add("like");
    dict.add("her");
    dict.add("brother");
    String s = "jesslookedjustlikeherbrothertim";
    Assert.assertEquals("JESS looked just like her brother TIM", f(s, dict));
  }

  @Test
  public void test_exl_first_match_not_optimal() {
    Trie dict = new Trie();
    dict.add("is");
    dict.add("island");
    Assert.assertEquals("island", f("island", dict));
    dict.add("slow");
    Assert.assertEquals("I slow", f("islow", dict));
  }

  @Test
  public void test_exl_equality_exl() {
    Trie dict = new Trie();
    dict.add("is");
    dict.add("so");
    Assert.assertEquals("is O", f("iso", dict));
  }
}
