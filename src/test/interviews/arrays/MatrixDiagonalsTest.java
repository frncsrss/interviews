package interviews.arrays;

import static interviews.arrays.MatrixDiagonals.f;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MatrixDiagonalsTest {
  @Test
  public void test() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    f(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
    Assert.assertEquals("1 \n2 4 \n3 5 7 \n6 8 \n9 \n", baos.toString());
  }
}
