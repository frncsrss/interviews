package interviews.strings;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.LongestComposition.f;
import static interviews.strings.LongestComposition.numberOfWords;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LongestCompositionTest {
  @Test
  public void test_f() {
    Assert.assertEquals(
        "dogwalker",
        f(Arrays.asList("banana", "spli", "dog", "walk", "walker", "dogwalker", "bananasplit")));
    Assert.assertEquals(
        "bananasplit",
        f(Arrays.asList("banana", "split", "dog", "walk", "walker", "dogwalker", "bananasplit")));
  }

  @Test
  public void test_numberOfWords() {
    Assert.assertEquals(
        2,
        numberOfWords(
            Arrays.asList("bananasplit", "dogwalker", "banana", "walker", "spli", "walk", "dog"),
            "dogwalker",
            0));
    Assert.assertEquals(
        0,
        numberOfWords(
            Arrays.asList("bananasplit", "dogwalker", "banana", "walker", "spli", "walk", "dog"),
            "bananasplit",
            0));
    Assert.assertEquals(
        2,
        numberOfWords(
            Arrays.asList("bananasplit", "dogwalker", "banana", "walker", "split", "walk", "dog"),
            "bananasplit",
            0));
  }
}
