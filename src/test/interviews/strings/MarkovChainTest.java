package interviews.strings;

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
    int bu = 0, gr = 0, fi = 0;
    for(int i = 0; i < 1000000; i++) {
      String next = mc.nextWord("the");
      if(next.equals("best")) {
        b++;
      } else if(next.equals("worst")) {
        w++;
      } else if(next.equals("butcher")) {
        bu++;
      } else if(next.equals("grocer")) {
        gr++;
      } else if(next.equals("fisherman")) {
        fi++;
      }
    }
    Assert.assertEquals(199967, b);
    Assert.assertEquals(200403, w);
    Assert.assertEquals(200144, bu);
    Assert.assertEquals(199547, gr);
    Assert.assertEquals(199939, fi);
  }
}
