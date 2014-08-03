package interviews.arrays;

import java.util.Random;

/**
 * Given a stream of elements, maintain at any point a random sample of size N.
 *
 * @author Francois Rousseau
 */
public class StreamSample {
  /**
   * At any point (ith element, i > N), the probability of an element belonging to the sample is
   * N/i.
   *
   * Therefore, for any new element, we add it in the sample with probability N/i. If so, we remove
   * randomly any of the N elements present in the sample (probability of 1/N). Why? Because the
   * probability of an element already present in the sample to stay in the element is indeed still
   * N/i (= N / (i - 1) x [1 - N/i + N / i x (1 - 1 / N)]
   *
   * This technique is known as reservoir sampling.
   *
   * Let i = length(stream).
   * Time complexity:  O(i)
   * Space complexity: O(N)
   */
  public static int[] f(int[] stream, int N) {
    return f(stream, N, new Random());
  }

  public static int[] f(int[] stream, int N, Random r) {
    assert stream.length >= N;
    int[] sample = new int[N];

    int i = 0;  // number of elements seen so far
    for(int element : stream) {
      i++;
      if(i <= N) {  // the first N elements are part of the sample for sure
        sample[i - 1] = element;  // 0-indexed array
        continue;
      }
      int p = r.nextInt(i);
      if(p >= N) {  // probability of discarding the element = 1 - N/i
        continue;
      }
      p = r.nextInt(N);  // we replace the element at index p in the sample by the new element
      sample[p] = element;
    }

    return sample;
  }
}
