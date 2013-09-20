package interviews.arrays;

/**
 * Print all continuous subsequences of an array that sum to 0.
 * @author Francois Rousseau
 */
public class ConsecutiveSubsequenceSummingToZero {
  /**
   * O(n^2 x k) time, O(n) space
   */
  public static void f(int[] arr) {
    final int n = arr.length;
    int[] c = new int[n];  // current column of the "matrix"

    c[0] = arr[0];
    checkAndPrint(c[0], arr, 0, 0);
    for(int j = 1; j < n; j++) {     // column of the "matrix", end of the interval
      for(int i = 0; i <= j; i++) {  // row of the "matrix", start of the interval
        c[i] = c[i] + arr[j];
        checkAndPrint(c[i], arr, i, j);
      }
    }
  }

  /**
   * O(k) time, O(1) space. Assuming average length of a consecutive subsequence is k.
   */
  private static void checkAndPrint(int n, int[] arr, int i, int j) {
    if(n == 0) {
      for(int k = i; k <= j; k++) {
        System.out.print(arr[k] + " ");
      }
      System.out.println();
    }
  }
}
