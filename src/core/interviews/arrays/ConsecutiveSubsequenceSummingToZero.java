package interviews.arrays;

/**
 * Print all continuous subsequences of an array that sum to 0.
 * @author Francois Rousseau
 */
public class ConsecutiveSubsequenceSummingToZero {
  public static void f(int[] arr) {
    final int n = arr.length;
    int[][] m = new int[n][n];  // we will only fill the top half of the matrix

    m[0][0] = arr[0];
    checkAndPrint(m[0][0], arr, 0, 0);
    for(int j = 1; j < n; j++) {     // column of m, end of the interval
      for(int i = 0; i <= j; i++) {  // row of m, start of the interval
        m[i][j] = m[i][j - 1] + arr[j];
        checkAndPrint(m[i][j], arr, i, j);
      }
    }
  }

  private static void checkAndPrint(int n, int[] arr, int i, int j) {
    if(n == 0) {
      for(int k = i; k <= j; k++) {
        System.out.print(arr[k] + " ");
      }
      System.out.println();
    }
  }
}
