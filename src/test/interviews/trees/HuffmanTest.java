package interviews.trees;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class HuffmanTest {
  @Test
  public void test() {
    Huffman h = new Huffman();
    Assert.assertEquals("ABRACADABRA!", h.decode(h.encode("ABRACADABRA!")));
  }
}
