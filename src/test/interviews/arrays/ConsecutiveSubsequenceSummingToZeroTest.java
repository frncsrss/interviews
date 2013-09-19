package interviews.arrays;

import static interviews.arrays.ConsecutiveSubsequenceSummingToZero.f;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ConsecutiveSubsequenceSummingToZeroTest {
  @Test
  public void test() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    f(new int[] {0, -1, -3, 4, 5, 4, 0, -4, 1, 1, 2, 0, -1, -2});
    Assert.assertEquals("0 \n"
        + "0 -1 -3 4 \n"
        + "-1 -3 4 \n"
        + "0 \n"
        + "4 0 -4 \n"
        + "0 -4 1 1 2 \n"
        + "-4 1 1 2 \n"
        + "0 -4 1 1 2 0 \n"
        + "-4 1 1 2 0 \n"
        + "0 \n"
        + "1 2 0 -1 -2 \n", baos.toString());
  }
}
