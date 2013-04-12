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
public class GooglereseTest {
  @Test
  public void test_input1()  {
    String input = "3\n"
        + "ejp mysljylc kd kxveddknmc re jsicpdrysi\n"
        + "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd\n"
        + "de kr kd eoya kw aej tysr re ujdr lkgc jv\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    Googlerese.main(null);
    Assert.assertEquals(
          "Case #1: our language is impossible to understand\n"
        + "Case #2: there are twenty six factorial possibilities\n"
        + "Case #3: so it is okay if you want to just give up\n", baos.toString());
  }
}
