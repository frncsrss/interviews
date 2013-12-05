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

    int b = 0;
    int w = 0;
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
  }
}
