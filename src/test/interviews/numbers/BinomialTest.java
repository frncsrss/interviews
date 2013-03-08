package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BinomialTest {
  @Test
  public void test() {
    Assert.assertEquals(1, Binomial.f(8, 0));
    Assert.assertEquals(8, Binomial.f(8, 1));
    Assert.assertEquals(28, Binomial.f(8, 2));
    Assert.assertEquals(56, Binomial.f(8, 3));
    Assert.assertEquals(70, Binomial.f(8, 4));
    Assert.assertEquals(56, Binomial.f(8, 5));
    Assert.assertEquals(28, Binomial.f(8, 6));
    Assert.assertEquals(8, Binomial.f(8, 7));
    Assert.assertEquals(1, Binomial.f(8, 8));
    Assert.assertEquals(0, Binomial.f(8, 10));
    Assert.assertEquals(364, Binomial.f(14, 3));
    Assert.assertEquals(161700, Binomial.f(100, 3));
    Assert.assertEquals(86493225, Binomial.f(30, 12));
    Assert.assertEquals(121399651100L, Binomial.f(50, 12));
    Assert.assertEquals(1399358844975L, Binomial.f(60, 12));
  }
}
