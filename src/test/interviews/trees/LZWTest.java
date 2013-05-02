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
public class LZWTest {
  @Test
  public void test() throws IOException {
    String encode = "ABRACADABRABRABRA";
    byte[] decode = hexStringToByteArray("41425241434144818382884180");
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);

    System.setIn(new ByteArrayInputStream(encode.getBytes()));
    LZW.encode();
    Assert.assertArrayEquals(decode, baos.toByteArray());

    baos.reset();
    System.setIn(new ByteArrayInputStream(decode));
    LZW.decode();
    Assert.assertEquals(encode, baos.toString());
  }

  private static byte[] hexStringToByteArray(String hex) {
    byte[] arr = new byte[hex.length() / 2];
    for(int i = 0; i < hex.length(); i += 2) {
      arr[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                           + Character.digit(hex.charAt(i + 1), 16));
    }
    return arr;
  }
}
