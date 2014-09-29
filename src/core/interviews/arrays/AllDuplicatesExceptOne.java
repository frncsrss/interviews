package interviews.arrays;


/**
 * Given an array of integers where every element appears k > 1 times except for one that appears
 * once, find that unique element.
 *
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

  /**
   * Every element appears kth time except for the one. Modify the array.
   *
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int fk(int[] arr, int k) {
    int lo = 0;
    int hi = arr.length - 1;
    while(lo < hi) {
      int p = partition(arr, lo, hi);
      if(p % k == 0) {  // the singleton is at index >= p
        lo = partition(arr, p + 1, hi, p) + 1;
        if(lo == p + 1) {
          return arr[p];
        }
      } else {  // the singleton is at index < p
        hi = p - 1;
      }
    }
    return arr[lo];
  }

  /**
   * @return an index such that all the elements in [lo, hi] strictly less than the element at
   * this index are at its left.
   */
  private static int partition(int[] arr, int lo, int hi) {
    int pivot = hi;
    int firsthigh = lo;
    for(int i = 0; i < hi; i++) {
      if(arr[i] < arr[pivot]) {
        swap(arr, i, firsthigh);
        firsthigh++;
      }
    }
    swap(arr, pivot, firsthigh);
    return firsthigh;
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /**
   * @return an index such that all the elements in [lo, hi] strictly greater than the pivot are at
   * the right of that index.
   */
  private static int partition(int[] arr, int lo, int hi, int pivot) {
    int firsthigh = lo;
    for(int i = 0; i < hi; i++) {
      if(arr[i] <= arr[pivot]) {
        swap(arr, i, firsthigh);
        firsthigh++;
      }
    }
    swap(arr, pivot, firsthigh);
    return firsthigh;
  }
}
