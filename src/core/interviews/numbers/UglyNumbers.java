package interviews.numbers;

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
   * Space complexity: O(k)
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
}
