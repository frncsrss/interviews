package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class FibonacciTest {
  @Test
  public void test_f1() {
    Assert.assertEquals(0, Fibonacci.f1(0));
    Assert.assertEquals(1, Fibonacci.f1(1));
    Assert.assertEquals(1, Fibonacci.f1(2));
    Assert.assertEquals(2, Fibonacci.f1(3));
    Assert.assertEquals(3, Fibonacci.f1(4));
    Assert.assertEquals(5, Fibonacci.f1(5));
    Assert.assertEquals(55, Fibonacci.f1(10));
    Assert.assertEquals(28657, Fibonacci.f1(23));
    Assert.assertEquals(514229, Fibonacci.f1(29));
    Assert.assertEquals(433494437, Fibonacci.f1(43));
  }

  @Test
  public void test_f2() {
    Assert.assertEquals(0, Fibonacci.f2(0));
    Assert.assertEquals(1, Fibonacci.f2(1));
    Assert.assertEquals(1, Fibonacci.f2(2));
    Assert.assertEquals(2, Fibonacci.f2(3));
    Assert.assertEquals(3, Fibonacci.f2(4));
    Assert.assertEquals(5, Fibonacci.f2(5));
    Assert.assertEquals(55, Fibonacci.f2(10));
    Assert.assertEquals(28657, Fibonacci.f2(23));
    Assert.assertEquals(514229, Fibonacci.f2(29));
    Assert.assertEquals(433494437, Fibonacci.f2(43));
  }

  @Test
  public void test_f3() {
    Assert.assertEquals(0, Fibonacci.f3(0));
    Assert.assertEquals(1, Fibonacci.f3(1));
    Assert.assertEquals(1, Fibonacci.f3(2));
    Assert.assertEquals(2, Fibonacci.f3(3));
    Assert.assertEquals(3, Fibonacci.f3(4));
    Assert.assertEquals(5, Fibonacci.f3(5));
    Assert.assertEquals(55, Fibonacci.f3(10));
    Assert.assertEquals(28657, Fibonacci.f3(23));
    Assert.assertEquals(514229, Fibonacci.f3(29));
    Assert.assertEquals(433494437, Fibonacci.f3(43));
  }
}
