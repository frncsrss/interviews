package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

import static interviews.numbers.BitCount.*;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BitCountTest {
  @Test
  public void test_f1() {
    for(int i = 0; i < 100000000; i++) {
      Assert.assertEquals(Integer.bitCount(i), f1(i));
    }
  }

  @Test
  public void test_f2() {
    for(int i = 0; i < 100000000; i++) {
      Assert.assertEquals(Integer.bitCount(i), f2(i));
    }
  }

  @Test
  public void test_f3() {
    for(int i = 0; i < 100000000; i++) {
      Assert.assertEquals(Integer.bitCount(i), f3(i));
    }
  }
}
