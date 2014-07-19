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

  /**
   * In-place stable sign sort. Return the arr for ease of testing.
   *
   * The key idea is given an array of the form N1P1N2P2 with Ni being a block of negative integers
   * and Pi a block of positive integers and the reverse block-operation B --> B' then:
   * N1P1N2P2 --> N1P1'N2'P2 --> N1(P1'N2')'P2 == N1N2P1P2, which is stable
   * 
   * N1 and P2 can be of size 0. If P1 is empty then there are no positive elements. If N2 is empty
   * then we are done. Otherwise, we continue with N1 = N1N2 and P1 = P1P2.
   *
   * Let n = length(arr).
   * Time complexity:  O(n^2)
   * Space complexity: O(1)
   */
  public static int[] f2(int [] arr) {
    if(arr == null || arr.length < 2) {
      return arr;
    }

    final int n = arr.length;

    int p1 = 0;
    while(true) {
      while(p1 < n && arr[p1] < 0) {
        p1++;
      }  // p1, index of first positive

      if(p1 == n) {  // only negative elements
        return arr;
      }

      int n2 = p1 + 1;
      while(n2 < n && arr[n2] > 0) {
        n2++;
      }  // n2, index of second negative

      if(n2 == n) {  // no second negative block remaining
        return arr;
      }

      int p2 = n2 + 1;
      while(p2 < n && arr[p2] < 0) {
        p2++;
      }  // n2, index of second positive

      reverse(arr, p1, n2 - 1);
      reverse(arr, n2, p2 - 1);
      reverse(arr, p1, p2 - 1);
    }
  }

  /**
   * Reverse the array between the inclusive indices lo and hi.
   */
  private static void reverse(int[] arr, int lo, int hi) {
    int mid = lo + hi >>> 1;
      for(int i = lo; i <= mid; i++) {
        swap(arr, i, hi + lo - i);
      }
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
