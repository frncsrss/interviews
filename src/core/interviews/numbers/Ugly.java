package interviews.numbers;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Numbers of the form 2^i * 3^j * 5^k * 7^l where i,j,k,l >=0 are integers are called ugly numbers.
 *
 * Generate the first k ugly numbers (in increasing order).
 *
 * @author Francois Rousseau
 */
public class Ugly {
  private static final long[] COEFFICIENTS = new long[]{2, 3, 5, 7};

  /**
   * Time complexity:  O(klogk)
   * Space complexity: O(k)  // not counting the returned array
   */
  public static long[] f(int k) {
    long[] numbers = new long[k];
    SortedSet<Long> set = new TreeSet<Long>();
    set.add(1L);  // all exponents to 0
    while(k > 0) {
      long head = set.first();
      set.remove(head);
      numbers[numbers.length - k] = head;
      k--;
      for(long coefficient : COEFFICIENTS) {
        set.add(coefficient * head);
      }
    }
    return numbers;
  }

  /**
   * Time complexity:  O(k)
   * Space complexity: O(1)  // not counting the returned array,
   *                         // assuming COEFFICIENTS.length constant
   */
  public static long[] f2(int k) {
    long[] numbers = new long[k];
    numbers[0] = 1;

    final int n = COEFFICIENTS.length;
    long[] next_multiples = Arrays.copyOf(COEFFICIENTS, n);
    int[] indices = new int[n];

    for(int i = 1; i < k; i++) {
      numbers[i] = min(next_multiples);
      for(int j = 0; j < n; j++) {
        if(next_multiples[j] == numbers[i]) {
          indices[j]++;
          next_multiples[j] = numbers[indices[j]] * COEFFICIENTS[j];
        }
      }
    }

    return numbers;
  }

  private static long min(long[] arr) {
    long min = Long.MAX_VALUE;
    for(long i : arr) {
      min = Math.min(min, i);
    }
    return min;
  }
}
