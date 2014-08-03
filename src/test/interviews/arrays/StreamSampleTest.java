package interviews.arrays;

import static interviews.arrays.StreamSample.f;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class StreamSampleTest {
  @Test
  public void test_randomness() {
    int[] stream = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    int[] count = new int[stream.length];
    int N = 5;  // => probability of being in a sample is 5/20 = 1/4
    int T = 1000000;
    for(int i = 0; i < T; i++) {
      int[] sample = f(stream, N);
      for(int element : sample) {
        count[element]++;
      }
    }
    float p = N * 1.0f / stream.length;
    float T_1 = 1.0f / T;
    for(int c : count) {
      Assert.assertEquals(p, c * T_1, 0.01);
    }
  }

  @Test
  public void test_algorithm() {
    Assert.assertArrayEquals(new int[]{0}, f(new int[]{0}, 1));
    Assert.assertArrayEquals(new int[]{0, 1}, f(new int[]{0, 1}, 2));
    Assert.assertArrayEquals(new int[]{0}, f(new int[]{0, 1}, 1, new Random(1234)));
    Assert.assertArrayEquals(new int[]{1}, f(new int[]{0, 1}, 1, new Random(12345)));
  }
}
