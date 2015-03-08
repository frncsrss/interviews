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

  /**
   * Binary search in a sorted array in increasing order but rotated by some arbitrary value.
   *
   * Let n = length(arr).
   * Time complexity:  O(logn)
   * Space complexity: O(1)
   */
  public static int f2(int[] arr, int x) {
    int lo = 0;
    int hi = arr.length - 1;
    while(arr[lo] >= arr[hi] && lo < hi) {  // find the minimum element in the array
      int mid = lo + hi >>> 1;
      if(arr[mid] >= arr[hi]) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }

    int pivot = lo;  // index of the minimum element in the array
    if(x < arr[pivot]) {
      return -pivot - 1;
    }
    if(pivot > 0 && x > arr[pivot - 1]) {
      return -pivot - 2;
    }
    if(pivot == 0 && x > arr[arr.length - 1]) {
      return -arr.length - 2;
    }

    if(x <= arr[arr.length - 1]) {
      return f(arr, x, pivot, arr.length - 1);
    }
    return f(arr, x, 0, pivot - 1);
  }

  /**
   * Recursive binary search.
   */
  private static int f(int[] arr, int x, int lo, int hi) {
    if(lo > hi) {
      return -lo - 1;
    }
    int mid = lo + hi >>> 1;  // prevent possible overflow
    if(arr[mid] < x) {
      return f(arr, x, mid + 1, hi);
    } else if(arr[mid] > x) {
      return f(arr, x, lo, mid - 1);
    } else {
      return mid;  // key found
    }
  }
}
