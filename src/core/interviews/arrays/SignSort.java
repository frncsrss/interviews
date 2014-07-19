package interviews.arrays;

/**
 * Given an array of unsorted negative and positive integers, sort the array so that negative numbers
 * stand at the front and positive at the back. Note that this should be a stable sort.
 *
 * For example, given A = [1, -2, 4, -3, -2, 5] return [-2, -3, -2, 1, 4, 5].
 *
 * @author Francois Rousseau
 */
public class SignSort {
  /**
   * In-place stable sign sort. Return the arr for ease of testing.
   *
   * Let n = length(arr).
   * Time complexity:  O(n^2)
   * Space complexity: O(1)
   */
  public static int[] f(int [] arr) {
    if(arr == null || arr.length < 2) {
      return arr;
    }

    int positive = 0;
    for(int i = 0; i < arr.length; i++) {    // partition routine of quicksort
      if(arr[i] < 0) {
        swap(arr, i, positive++);
        for(int j = i; j > positive; j--) {  // bubbling down the newly swapped positive number
          swap(arr, j, j - 1);
        }
      }
    }

    return arr;
  }

  private static void swap(int[] arr, int i, int j) {
    if(i == j) {
      return;
    }
    arr[i] ^= arr[j];
    arr[j] ^= arr[i];
    arr[i] ^= arr[j];
  }
}
