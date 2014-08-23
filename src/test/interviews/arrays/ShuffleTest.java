package interviews.arrays;

import static interviews.arrays.Shuffle.f;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ShuffleTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(
        new int[]{9, 0, 6, 1, 3, 2, 4, 7, 5, 8},
        f(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new Random(1234)));
  }

  @Test
  public void test_uniform() {
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    counts.put(Arrays.hashCode(new int[]{1, 2, 3}), 0);
    counts.put(Arrays.hashCode(new int[]{1, 3, 2}), 0);
    counts.put(Arrays.hashCode(new int[]{2, 1, 3}), 0);
    counts.put(Arrays.hashCode(new int[]{2, 3, 1}), 0);
    counts.put(Arrays.hashCode(new int[]{3, 1, 2}), 0);
    counts.put(Arrays.hashCode(new int[]{3, 2, 1}), 0);

    final int T = 1000000;
    int[] arr = new int[]{1, 2, 3};

    for(int i = 0; i < T; i++) {
      f(arr);
      counts.put(Arrays.hashCode(arr), counts.get(Arrays.hashCode(arr)) + 1);
    }

    double precision = T / 6 * 5.f / 100;

    Assert.assertEquals(counts.get(Arrays.hashCode(new int[]{1, 2, 3})) * 6.f, T, precision);
    Assert.assertEquals(counts.get(Arrays.hashCode(new int[]{1, 3, 2})) * 6.f, T, precision);
    Assert.assertEquals(counts.get(Arrays.hashCode(new int[]{2, 1, 3})) * 6.f, T, precision);
    Assert.assertEquals(counts.get(Arrays.hashCode(new int[]{2, 3, 1})) * 6.f, T, precision);
    Assert.assertEquals(counts.get(Arrays.hashCode(new int[]{3, 1, 2})) * 6.f, T, precision);
    Assert.assertEquals(counts.get(Arrays.hashCode(new int[]{3, 2, 1})) * 6.f, T, precision);
  }
}
