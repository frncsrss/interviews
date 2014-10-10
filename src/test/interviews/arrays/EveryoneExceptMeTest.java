package interviews.arrays;

import static interviews.arrays.EveryoneExceptMe.f;
import static interviews.arrays.EveryoneExceptMe.f_division;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class EveryoneExceptMeTest {
  @Test
  public void test_f() {
    Assert.assertArrayEquals(
        new int[]{240, 144, 360, 180, 120, 720}, f(new int[]{3, 5, 2, 4, 6, 1}));
  }

  @Test
  public void test_f_division() {
    Assert.assertArrayEquals(
        new int[]{240, 144, 360, 180, 120, 720}, f_division(new int[]{3, 5, 2, 4, 6, 1}));
  }
}
