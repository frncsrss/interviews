package interviews.arrays;

/**
 * Gustavo studies at the Byteversity (one of the best universities in Byteland). He's also very
 * keen on dancing, so he decided to enroll at a dance school. The school offers many different
 * courses, each teaching one dance. Different courses may have different costs. You are given a
 * int[] danceCost. The elements of danceCost are the costs of all courses offered at the dance
 * school. Gustavo would like to learn exactly K of those dances. He is a poor student, so his only
 * priority is to pay as little as possible for the courses. You are given the int K and the int[]
 * danceCost. Compute and return the smallest possible total cost of learning K dances.
 *
 * @author Francois Rousseau
 */
public class CostOfDancing {
  /**
   * Quickselect the kth element then sum the first k elements.
   *
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int f(int[] arr, int k) {
    k = k - 1;  // 0-index
    int lo = 0;
    int hi = arr.length - 1;
    while(lo < hi) {
      int p = partition(arr, lo, hi);
      if(k < p) {
        hi = p - 1;
      } else if(k > p) {
        lo = p + 1;
      } else {
        break;
      }
    }
    int sum = 0;
    for(int i = 0; i <= k; i++) {
      sum += arr[i];
    }
    return sum;
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
