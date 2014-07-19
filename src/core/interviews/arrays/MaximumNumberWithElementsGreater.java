package interviews.arrays;


/**
 * Given an unsorted array of integers of size n, return the maximum possible m such that the array
 * consists at least m values greater than or equals to m. Array can contain duplicate values.
 *
 * Example:
 *   [1, 2, 3, 4] --> 2
 *   [900, 2, 901, 3, 1000] --> 3
 *
 * @author Francois Rousseau
 */
public class MaximumNumberWithElementsGreater {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int f(int[] arr) {
    int n = arr.length;  // number of elements
    int lo = 0;
    int hi = arr.length - 1;
    while(lo < hi) {
      int p = partition(arr, lo, hi);  // we have (n - p) elements >= arr[p]
      if(n - p >= arr[p]) {  // at least arr[p] elements >= arr[p]
        lo = p + 1;
      } else {
        hi = p - 1;
      }
    }
    return n - lo;
  }

  private static int partition(int[] arr, int lo, int hi) {
    int pivot = hi;
    int first_high = lo;
    for(int i = lo; i < hi; i++) {
      if(arr[i] < arr[pivot]) {
        swap(arr, i, first_high);
        first_high++;
      }
    }
    swap(arr, first_high, pivot);
    return first_high;
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
