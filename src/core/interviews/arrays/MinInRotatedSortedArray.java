package interviews.arrays;

import java.util.NoSuchElementException;

/**
 * Find the min element in an rotated sorted array of elements.
 *
 * @author Francois Rousseau
 */
public class MinInRotatedSortedArray {
  /**
   * O(n) time.
   * @return
   */
  public static int f(int[] arr) {
    if(arr == null || arr.length == 0) {
      throw new NoSuchElementException();
    }
    for(int i = 0; i < arr.length - 1; i++) {
      if(arr[i + 1] < arr[i]) {
        return arr[i + 1];
      }
    }
    return arr[0];
  }

  /**
   * O(logn) time.
   * @return
   */
  public static int f2(int[] arr) {
    if(arr == null || arr.length == 0) {
      throw new NoSuchElementException();
    }
    int lo = 0;
    int hi = arr.length - 1;
    while(arr[lo] >= arr[hi] && lo < hi) {
      int mid = lo + hi >>> 1;
    if(arr[mid] >= arr[hi]) {
      lo = mid + 1;
    } else {
      hi = mid;
    }
    }
    return arr[lo];
  }
}
