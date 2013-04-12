package interviews.strings;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ReverseWordsTest {
  @Test
  public void test_input1()  {
    String input = "3\n"
        + "this is a test\nfoobar\nall your base\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    ReverseWords.main(null);
    Assert.assertEquals(
        "Case #1: test a is this\nCase #2: foobar\nCase #3: base your all\n", baos.toString());
  }
}
