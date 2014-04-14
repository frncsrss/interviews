package interviews.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MarkovChainTest {
  @Test
  public void test() {
    MarkovChain mc = new MarkovChain();
    mc.addWord("it");
    mc.addWord("was");
    mc.addWord("the");
    mc.addWord("best");
    mc.addWord("of");
    mc.addWord("times");
    mc.addWord("it");
    mc.addWord("was");
    mc.addWord("the");
    mc.addWord("worst");
    mc.addWord("of");
    mc.addWord("times");

    Assert.assertEquals("was", mc.nextWord("it"));
    Assert.assertEquals("of",  mc.nextWord("best"));
    Assert.assertEquals("of",  mc.nextWord("worst"));
    MarkovChain.r = new Random(1234);
    Assert.assertEquals("best",  mc.nextWord("the"));
    Assert.assertEquals("worst", mc.nextWord("the"));
    Assert.assertEquals("best",  mc.nextWord("the"));
    Assert.assertEquals("worst", mc.nextWord("the"));
    Assert.assertEquals("best",  mc.nextWord("the"));
    Assert.assertEquals("worst", mc.nextWord("the"));
    Assert.assertEquals("worst", mc.nextWord("the"));
    Assert.assertEquals("best",  mc.nextWord("the"));

    int b = 0, w = 0;
    for(int i = 0; i < 1000000; i++) {
      String next = mc.nextWord("the");
      if(next.equals("best")) {
        b++;
      } else if(next.equals("worst")) {
        w++;
      }
    }
    Assert.assertEquals(499648, b);
    Assert.assertEquals(500352, w);

    mc.addWord("the");
    mc.addWord("butcher");
    mc.addWord("the");
    mc.addWord("grocer");
    mc.addWord("and");
    mc.addWord("the");
    mc.addWord("fisherman");

    b = 0; w = 0;
    Map<String, Integer> counts = new HashMap<String, Integer>();
    for(int i = 0; i < 1000000; i++) {
      String next = mc.nextWord("the");
      if(counts.containsKey(next)) {
        counts.put(next, counts.get(next) + 1);
      } else {
        counts.put(next, 1);
      }
    }
    Assert.assertEquals(199967, counts.get("best").intValue());
    Assert.assertEquals(200403, counts.get("worst").intValue());
    Assert.assertEquals(200144, counts.get("butcher").intValue());
    Assert.assertEquals(199547, counts.get("grocer").intValue());
    Assert.assertEquals(199939, counts.get("fisherman").intValue());

    counts = new HashMap<String, Integer>();
    for(int i = 0; i < 1000000; i++) {
      String next = mc.nextWord("notInMarkovChain");
      if(counts.containsKey(next)) {
        counts.put(next, counts.get(next) + 1);
      } else {
        counts.put(next, 1);
      }
    }
    Assert.assertEquals( 52999, counts.get("times").intValue());
    Assert.assertEquals(261994, counts.get("the").intValue());
  }
}
