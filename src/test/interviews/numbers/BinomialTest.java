package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

import static interviews.numbers.Binomial.binomial;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BinomialTest {
  @Test
  public void test() {
    Assert.assertEquals(1, binomial(8, 0));
    Assert.assertEquals(8, binomial(8, 1));
    Assert.assertEquals(28, binomial(8, 2));
    Assert.assertEquals(56, binomial(8, 3));
    Assert.assertEquals(70, binomial(8, 4));
    Assert.assertEquals(56, binomial(8, 5));
    Assert.assertEquals(28, binomial(8, 6));
    Assert.assertEquals(8, binomial(8, 7));
    Assert.assertEquals(1, binomial(8, 8));
    Assert.assertEquals(0, binomial(8, 10));
    Assert.assertEquals(364, binomial(14, 3));
    Assert.assertEquals(161700, binomial(100, 3));
    Assert.assertEquals(86493225, binomial(30, 12));
    Assert.assertEquals(121399651100L, binomial(50, 12));
    Assert.assertEquals(1399358844975L, binomial(60, 12));
  }
}
