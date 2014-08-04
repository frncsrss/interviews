package interviews.arrays;


/**
 * Given an array of unsorted negative and positive integers, sort the array so that negative
 * numbers stand at the front and positive at the back. Note that this should be a stable sort.
 *
 * For example, given A = [1, -2, 4, -3, -2, 5] return [-2, -3, -2, 1, 4, 5].
 *
 * @author Francois Rousseau
 */
public class SignSort {
  /**
   * In-place stable sign sort (bubblesort). Return the arr for ease of testing.
   *
   * Let n = length(arr).
   * Time complexity:  O(n^2)
   * Space complexity: O(1)
   */
  public static int[] f(int [] arr) {
    if(arr == null || arr.length < 2) {
      return arr;
    }

    for(int i = 1; i < arr.length; i++) {
      if(arr[i] < 0) {
        int j = i - 1;
        while(j >= 0 && arr[j] > 0) {  // bubbling down the negative number
          swap(arr, j, j + 1);
          j--;
        }
      }
    }

    return arr;
  }

  /**
   * In-place stable sign sort (mergesort). Return the arr for ease of testing.
   *
   * The key idea is given an array of the form N1P1N2P2 with Ni being a block of negative integers
   * and Pi a block of positive integers and the reverse block-operation B --> B' then:
   * N1P1N2P2 --> N1P1'N2'P2 --> N1(P1'N2')'P2 == N1N2P1P2, which is stable (merge operation).
   *
   * N1 and P2 can be of size 0. If P1 is empty then there are no positive elements. If N2 is empty
   * then we are done. Otherwise, we continue with N1 = N1N2 and P1 = P1P2.
   *
   * Let n = length(arr).
   * Time complexity:  O(nlogn) (T(n) = 2T(n/2) + O(n))
   * Space complexity: O(1)
   */
  public static int[] f2(int [] arr) {
    if(arr == null || arr.length < 2) {
      return arr;
    }

    f2(arr, 0, arr.length - 1);

    return arr;
  }

  /**
   * Divide and conquer arr[lo..hi].
   *
   * @return: index of the first positive element in the range [lo, hi], -1 if only negatives
   */
  private static int f2(int[] arr, int lo, int hi) {
    if(lo == hi) {
      return arr[lo] < 0 ? -1 : lo;
    }
    int mid = lo + hi >>> 1;
    int p1 = f2(arr, lo, mid);
    int p2 = f2(arr, mid + 1, hi);
    if(p1 == -1) {  // first block contains no negative numbers
      return p2;
    }
    if(p2 == -1) {  // second block contains only negative numbers
      return merge(arr, p1, hi + 1, mid);
    }
    if(p2 == mid + 1) {  // second block contains only positive numbers
      return p1;
    }
    return merge(arr, p1, p2, mid);
  }

  /**
   * In-place merge of the array arr[p1..p2[; arr[p1..mid] contains only positive elements and
   * arr[mid+1..p2[ only negative elements.
   *
   * Let n = p2 - p1 + 1.
   * Time complexity:  O(n)
   * Space complexity: O(1)
   *
   * @return: index of the first positive element in the range [p1, p2] after merging
   */
  private static int merge(int[] arr, int p1, int p2, int mid) {
    reverse(arr, p1, mid);
    reverse(arr, mid + 1, p2 - 1);
    reverse(arr, p1, p2 - 1);
    return p1 + p2 - mid - 1;  // there are (p2 - (mid + 1)) elements in arr[mid+1..p2[
  }

  /**
   * Reverse the array between the inclusive indices lo and hi.
   */
  private static void reverse(int[] arr, int lo, int hi) {
    while(lo < hi) {
      swap(arr, lo++, hi--);
    }
  }

  /**
   * Swap the array elements at indices i and j, no additional space.
   */
  private static void swap(int[] arr, int i, int j) {
    if(i == j) {
      return;
    }
    arr[i] ^= arr[j];
    arr[j] ^= arr[i];
    arr[i] ^= arr[j];
  }
}
