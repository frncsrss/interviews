package interviews.strings;

import interviews.trees.Trie;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Transformer.path;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class TransformerTest {
  @Test
  public void test() {
    Trie dict = new Trie();
    dict.add("camp");
    dict.add("damp");
    dict.add("lamp");
    dict.add("ramp");
    dict.add("limp");
    dict.add("lime");
    dict.add("limo");
    dict.add("like");
    dict.add("hike");
    dict.add("pike");
    Assert.assertEquals(
        Arrays.asList("lamp", "limp", "lime", "like"), path("damp", "like", dict));
    dict.add("lame");
    Assert.assertEquals(
        Arrays.asList("lamp", "lame", "lime", "like"), path("damp", "like", dict));
    dict.remove("lime");
    Assert.assertEquals(null, path("damp", "like", dict));
    Assert.assertEquals(null, path("damp", "damp", dict));
  }
}
