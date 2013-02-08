package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

import static interviews.numbers.Fibonacci.*;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class FibonacciTest {
  @Test
  public void test_fibonacci_1() {
    Assert.assertEquals(0, fibonacci_1(0));
    Assert.assertEquals(1, fibonacci_1(1));
    Assert.assertEquals(1, fibonacci_1(2));
    Assert.assertEquals(2, fibonacci_1(3));
    Assert.assertEquals(3, fibonacci_1(4));
    Assert.assertEquals(5, fibonacci_1(5));
    Assert.assertEquals(55, fibonacci_1(10));
    Assert.assertEquals(28657, fibonacci_1(23));
    Assert.assertEquals(514229, fibonacci_1(29));
    Assert.assertEquals(433494437, fibonacci_1(43));
  }

  @Test
  public void test_fibonacci_2() {
    Assert.assertEquals(0, fibonacci_2(0));
    Assert.assertEquals(1, fibonacci_2(1));
    Assert.assertEquals(1, fibonacci_2(2));
    Assert.assertEquals(2, fibonacci_2(3));
    Assert.assertEquals(3, fibonacci_2(4));
    Assert.assertEquals(5, fibonacci_2(5));
    Assert.assertEquals(55, fibonacci_2(10));
    Assert.assertEquals(28657, fibonacci_2(23));
    Assert.assertEquals(514229, fibonacci_2(29));
    Assert.assertEquals(433494437, fibonacci_2(43));
  }

  @Test
  public void test_fibonacci_3() {
    Assert.assertEquals(0, fibonacci_3(0));
    Assert.assertEquals(1, fibonacci_3(1));
    Assert.assertEquals(1, fibonacci_3(2));
    Assert.assertEquals(2, fibonacci_3(3));
    Assert.assertEquals(3, fibonacci_3(4));
    Assert.assertEquals(5, fibonacci_3(5));
    Assert.assertEquals(55, fibonacci_3(10));
    Assert.assertEquals(28657, fibonacci_3(23));
    Assert.assertEquals(514229, fibonacci_3(29));
    Assert.assertEquals(433494437, fibonacci_3(43));
  }
}
