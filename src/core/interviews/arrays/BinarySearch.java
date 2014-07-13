package interviews.arrays;

/**
 * Binary search in a sorted array.
 *
 * @author Francois Rousseau
 */
public class BinarySearch {
  public static int f(int[] arr, int i) {
    int lo = 0;
    int hi = arr.length - 1;
    while(lo <= hi) {
      int mid = lo + hi >>> 1;  // prevent possible overflow
      if(arr[mid] < i) {
        lo = mid + 1;
      } else if(arr[mid] > i) {
        hi = mid - 1;
      } else {
        return mid;  // key found
      }
    }
    return -lo - 1;  // key not found (-1 to avoid the 0 ambiguity)
  }
}
