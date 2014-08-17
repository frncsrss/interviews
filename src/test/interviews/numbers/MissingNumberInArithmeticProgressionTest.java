package interviews.numbers;

import static interviews.numbers.MissingNumberInArithmeticProgression.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MissingNumberInArithmeticProgressionTest {
  @Test
  public void test()  {
    Assert.assertEquals(21, f(new int[]{1, 11, 31, 41, 51}));
    Assert.assertEquals( 3, f(new int[]{1, 5, 7, 9, 11}));
    Assert.assertEquals( 5, f(new int[]{1, 3, 7}));
    Assert.assertEquals( 3, f(new int[]{1, 5, 7}));
    Assert.assertEquals(41, f(new int[]{1, 11, 21, 31, 51}));
    Assert.assertEquals( 1, f(new int[]{-1, 0, 2}));
    Assert.assertEquals(12, f(new int[]{0, 4, 8, 16}));
    Assert.assertEquals( 5, f(new int[]{9, 7, 3, 1}));
  }
}
