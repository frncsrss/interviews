package interviews.arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.EveryoneExceptMe.*;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class EveryoneExceptMeTest {
  @Test
  public void test_f1() {
    Assert.assertEquals(
        Arrays.asList(240, 144, 360, 180, 120, 720), f1(Arrays.asList(3, 5, 2, 4, 6, 1)));
  }

  @Test
  public void test_f2() {
    Assert.assertArrayEquals(
        new int[]{240, 144, 360, 180, 120, 720}, f2(new int[]{3, 5, 2, 4, 6, 1}));
  }

  @Test
  public void test_f3() {
    int[] arr = {3, 5, 2, 4, 6, 1};
    int[] expecteds = {240, 144, 360, 180, 120, 720};
    f3(arr);
    Assert.assertArrayEquals(expecteds, arr);
  }
}
