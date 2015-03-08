package interviews.arrays;

/**
 * Binary search in a sorted array.
 *
 * @author Francois Rousseau
 */
public class BinarySearch {
  /**
   * Binary search in a sorted array in increasing order.
   *
   * Let n = length(arr).
   * Time complexity:  O(logn)
   * Space complexity: O(1)
   */
  public static int f(int[] arr, int x) {
    int lo = 0;
    int hi = arr.length - 1;
    while(lo <= hi) {
      int mid = lo + hi >>> 1;  // prevent possible overflow
      if(arr[mid] < x) {
        lo = mid + 1;
      } else if(arr[mid] > x) {
        hi = mid - 1;
      } else {
        return mid;  // key found
      }
    }
    return -lo - 1;  // key not found (-1 to avoid the 0 ambiguity)
  }
}
