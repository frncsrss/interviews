package interviews.arrays;

/**
 * Given an array of integers, write a method to find the smallest range of indices x and y such
 * that if you sort elements x through y, the entire array is sorted.
 *
 * @author Francois Rousseau
 */
public class MinimumSequenceToSort {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int[] f(int[] arr) {
    int end_left = findEndOfLeftIncreasingSubsequence(arr);
    if(end_left == arr.length - 1) {
      return null;
    }

    int end_right = findEndOfRighftDecreasingSubsequence(arr);

    int mid_min_index = end_left;
    int mid_max_index = end_right;

    for(int i = end_left; i <= end_right; i++) {
      if(arr[i] < arr[mid_min_index]) {
        mid_min_index = i;
      }
      if(arr[i] > arr[mid_max_index]) {
        mid_max_index = i;
      }
    }

    return new int[]{
        extendLeft(arr, end_left, arr[mid_min_index]),
        extendRight(arr, end_right, arr[mid_max_index])};
  }

  private static int findEndOfLeftIncreasingSubsequence(int[] arr) {
    for(int i = 0; i < arr.length - 1; i++) {
      if(arr[i] > arr[i + 1]) {
        return i;
      }
    }
    return arr.length - 1;
  }

  private static int findEndOfRighftDecreasingSubsequence(int[] arr) {
    for(int i = arr.length - 1; i > 0; i--) {
      if(arr[i] < arr[i - 1]) {
        return i;
      }
    }
    return 0;
  }

  private static int extendLeft(int[] arr, int end, int min) {
    for(int i = end - 1; i >= 0; i--) {
      if(arr[i] <= min) {
        return i + 1;
      }
    }
    return 0;
  }

  private static int extendRight(int[] arr, int start, int max) {
    for(int i = start + 1; i < arr.length; i++) {
      if(arr[i] >= max) {
        return i - 1;
      }
    }
    return arr.length - 1;
  }
}
