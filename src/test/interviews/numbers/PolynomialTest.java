package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class PolynomialTest {
  @Test
  public void test_add() {
    Assert.assertEquals(" +5.00 x^2 +1.00 x^1 +1.00 x^0",
        Polynomial.add(
            new Polynomial(new double[]{1, 0, 2}),
            new Polynomial(new double[]{0, 1, 3})).toString());
    Assert.assertEquals("",
        Polynomial.add(
            new Polynomial(new double[]{1, 0, 2}),
            new Polynomial(new double[]{-1, 0, -2})).toString());
  }

  @Test
  public void test_multiply() {
    Assert.assertEquals(" +1.00 x^2 -1.00 x^0",
        Polynomial.multiply(
            new Polynomial(new double[]{1, 1}),
            new Polynomial(new double[]{-1, 1})).toString());
  }

  @Test
  public void test_subtract() {
    Assert.assertEquals(" -1.00 x^2 -1.00 x^1 +1.00 x^0",
        Polynomial.subtract(
            new Polynomial(new double[]{1, 0, 2}),
            new Polynomial(new double[]{0, 1, 3})).toString());
    Assert.assertEquals("",
        Polynomial.subtract(
            new Polynomial(new double[]{1, 0, 2}),
            new Polynomial(new double[]{1, 0, 2})).toString());
  }
}
