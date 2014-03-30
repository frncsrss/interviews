package interviews.arrays;

import static interviews.arrays.MatrixDiagonals.f;
import static interviews.arrays.MatrixDiagonals.f2;

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
  public void test_f() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    f(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
    Assert.assertEquals("1 \n2 4 \n3 5 7 \n6 8 \n9 \n", baos.toString());
  }

  @Test
  public void test_f2() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    f2(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}});
    Assert.assertEquals("1 \n2 5 \n3 6 \n4 7 \n8 \n", baos.toString());
    baos = new ByteArrayOutputStream();
    ps = new PrintStream(baos);
    System.setOut(ps);
    f2(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}});
    Assert.assertEquals("1 \n2 5 \n3 6 9 \n4 7 10 \n8 11 \n12 \n", baos.toString());
  }
}
