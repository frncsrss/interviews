package interviews.arrays;

/**
 * Given an array of integers where every element appears k > 1 times except for one that appears
 * once, find that unique element.
 * @author Francois Rousseau
 */
public class AllDuplicatesExceptOne {
  /**
   * Every element appears twice except for the one.
   *
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int f2(int[] arr) {
    int xor = 0;
    for(int i : arr) {  // XOR is commutative and associative
      xor ^= i;
    }
    return xor;
  }

  /**
   * Every element appears thrice except for the one.
   *
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int f3(int[] arr) {
    int ones = 0, twos = 0;
    for(int i : arr) {
      twos |= ones & i;
      ones ^= i;
      int not_threes = ~(ones & twos);
      ones &= not_threes;
      twos &= not_threes;
    }
    assert twos == 0;
    return ones;
  }
}
