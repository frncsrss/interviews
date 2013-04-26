package interviews.trees;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class HuffmanTest {
  @Test
  public void test() throws IOException {
    String encode = "ABRACADABRA!";
    String decode = "0110111010001010011011101011";

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);

    System.setIn(new ByteArrayInputStream(encode.getBytes()));
    Huffman.encode();
    Assert.assertEquals(decode, baos.toString());
    baos.reset();

    System.setIn(new ByteArrayInputStream(decode.getBytes()));
    Huffman.decode();
    Assert.assertEquals(encode, baos.toString());
  }
}
