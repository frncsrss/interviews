package interviews.arrays;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ShuffleTest {

  @Test
  public void test_arr() {
    Shuffle.seed = 1234;
    int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Shuffle.f(arr);
    Assert.assertArrayEquals(new int[]{8, 6, 9, 7, 1, 0, 3, 5, 4, 2}, arr);
  }

  @Test
  public void test_list() {
    Shuffle.seed = 1234;
    List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    Shuffle.f(list);
    Assert.assertEquals(Arrays.asList(8, 6, 9, 7, 1, 0, 3, 5, 4, 2), list);
  }
}
