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
public class UglyNumbers {
  private static final int[] COEFFICIENTS = new int[]{2, 3, 5, 7};

  /**
   * Time complexity:  O(klogk)
   * Space complexity: O(k)  // not counting the returned array
   */
  public static int[] f(int k) {
    int[] numbers = new int[k];
    SortedSet<Integer> set = new TreeSet<Integer>();
    set.add(1); // all exponents to 0
    while(k > 0) {
      int head = set.first();
      set.remove(head);
      numbers[numbers.length - k] = head;
      k--;
      for(int coefficient : COEFFICIENTS) {
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
  public static int[] f2(int k) {
    int[] numbers = new int[k];
    numbers[0] = 1;

    final int n = COEFFICIENTS.length;
    int[] next_multiples = Arrays.copyOf(COEFFICIENTS, n);
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

  private static int min(int[] arr) {
    int min = Integer.MAX_VALUE;
    for(int i : arr) {
      min = Math.min(min, i);
    }
    return min;
  }
}
