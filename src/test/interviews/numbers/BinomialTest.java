package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BinomialTest {
  @Test
  public void test_f_n2() {
    Assert.assertEquals(1, Binomial.f_n2(8, 0));
    Assert.assertEquals(8, Binomial.f_n2(8, 1));
    Assert.assertEquals(28, Binomial.f_n2(8, 2));
    Assert.assertEquals(56, Binomial.f_n2(8, 3));
    Assert.assertEquals(70, Binomial.f_n2(8, 4));
    Assert.assertEquals(56, Binomial.f_n2(8, 5));
    Assert.assertEquals(28, Binomial.f_n2(8, 6));
    Assert.assertEquals(8, Binomial.f_n2(8, 7));
    Assert.assertEquals(1, Binomial.f_n2(8, 8));
    Assert.assertEquals(0, Binomial.f_n2(8, 10));
    Assert.assertEquals(364, Binomial.f_n2(14, 3));
    Assert.assertEquals(161700, Binomial.f_n2(100, 3));
    Assert.assertEquals(86493225, Binomial.f_n2(30, 12));
    Assert.assertEquals(121399651100L, Binomial.f_n2(50, 12));
    Assert.assertEquals(1399358844975L, Binomial.f_n2(60, 12));
  }

  @Test
  public void test_f_nk() {
    Assert.assertEquals(1, Binomial.f_nk(8, 0));
    Assert.assertEquals(8, Binomial.f_nk(8, 1));
    Assert.assertEquals(28, Binomial.f_nk(8, 2));
    Assert.assertEquals(56, Binomial.f_nk(8, 3));
    Assert.assertEquals(70, Binomial.f_nk(8, 4));
    Assert.assertEquals(56, Binomial.f_nk(8, 5));
    Assert.assertEquals(28, Binomial.f_nk(8, 6));
    Assert.assertEquals(8, Binomial.f_nk(8, 7));
    Assert.assertEquals(1, Binomial.f_nk(8, 8));
    Assert.assertEquals(0, Binomial.f_nk(8, 10));
    Assert.assertEquals(364, Binomial.f_nk(14, 3));
    Assert.assertEquals(161700, Binomial.f_nk(100, 3));
    Assert.assertEquals(86493225, Binomial.f_nk(30, 12));
    Assert.assertEquals(121399651100L, Binomial.f_nk(50, 12));
    Assert.assertEquals(1399358844975L, Binomial.f_nk(60, 12));
  }

  @Test
  public void test_f_k() {
    Assert.assertEquals(1, Binomial.f_k(8, 0));
    Assert.assertEquals(8, Binomial.f_k(8, 1));
    Assert.assertEquals(28, Binomial.f_k(8, 2));
    Assert.assertEquals(56, Binomial.f_k(8, 3));
    Assert.assertEquals(70, Binomial.f_k(8, 4));
    Assert.assertEquals(56, Binomial.f_k(8, 5));
    Assert.assertEquals(28, Binomial.f_k(8, 6));
    Assert.assertEquals(8, Binomial.f_k(8, 7));
    Assert.assertEquals(1, Binomial.f_k(8, 8));
    Assert.assertEquals(0, Binomial.f_k(8, 10));
    Assert.assertEquals(364, Binomial.f_k(14, 3));
    Assert.assertEquals(161700, Binomial.f_k(100, 3));
    Assert.assertEquals(86493225, Binomial.f_k(30, 12));
    Assert.assertEquals(121399651100L, Binomial.f_k(50, 12));
    Assert.assertEquals(1399358844975L, Binomial.f_k(60, 12));
  }
}
