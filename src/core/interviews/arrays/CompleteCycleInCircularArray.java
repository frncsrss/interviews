package interviews.arrays;

/**
 * Given a circular array of relative indices, find out if there is a complete cycle. Each cell
 * points relatively to another cell (e.g., -1 to the previous cell, 2 to the second next cell and 0
 * to the same cell). A complete cycle corresponds to visiting all the cells, only once each.
 *
 * Example:
 *   [2, 2, -1] --> true
 *   [2, 2, 0] --> false
 *   [0] --> true
 *   [1, -1] --> true
 *
 * @author Francois Rousseau
 */
public class CompleteCycleInCircularArray {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static boolean f(int[] arr) {
    final int n = arr.length;
    int index = 0;  // starting index, the value does not matter if there is indeed a complete cycle
    for(int i = 0; i < n; i++) {  // at most n steps
      // in Java, -b < a % b < b but 0 < (a % b + b) % b < b
      index = ((index + arr[index]) % n + n) % n;
      if(index == 0 && i < n - 1) {  // subcyle
        return false;
      }
    }
    return index == 0;  // are we back to the original cell after n steps
  }
}
