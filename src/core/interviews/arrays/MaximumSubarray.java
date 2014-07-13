package interviews.arrays;

/**
 * Given an array of integers, return the subarray with maximum sum (start and end indexes).
 * Known as the maximum subarray problem.
 *
 * @author Francois Rousseau
 */
public class MaximumSubarray {
  /**
   * Kadane's algorithm.
   *
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int[] f(int[] arr) {
    int current_sum = 0, current_start = 0;
    int best_sum = Integer.MIN_VALUE, best_start = -1, best_end = -1;
    for(int i = 0; i < arr.length; i++) {
      current_sum += arr[i];
      // we only update the best sum if the current sum is greater than it
      if(current_sum > best_sum) {
        best_sum = current_sum;
        best_start = current_start;
        best_end = i;
      }
      // when the current sum becomes negative, there is no need to take it into account anymore
      // we flush and move on
      if(current_sum <= 0) {
        current_sum = 0;
        current_start = i + 1;
      }
    }

    return new int[]{best_start, best_end};
  }
}
