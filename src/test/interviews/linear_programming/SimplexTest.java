package interviews.linear_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SimplexTest {
  @Test
  public void test() {
    double[][] A =
        new double[][]{
            new double[]{5, 15}, new double[]{4, 4}, new double[]{35, 20}};
    double[] b = new double[] {480, 160, 1190};
    double[] c = new double[] {13, 23};
    Simplex s = new Simplex(A, b, c);
    s.solve();
    Assert.assertEquals(800, s.max(), 0.1d);
  }
}
