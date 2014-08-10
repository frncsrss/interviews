package interviews.matrices;

/**
 * Given a matrix A, modify it in place such that A[i][j] = sum_{0 <= k,l <= i,j}{A[k][l]}.
 *
 * @author Francois Rousseau
 */
public class SquaredSum {
  /**
   * Let A be a n by m matrix.
   * Time complexity:  O(nm)
   * Space complexity: O(1)
   */
  public static int[][] f(int[][] A) {
    final int n = A.length;
    final int m = A[0].length;

    for(int j = 1; j < m; j++) {
      A[0][j] += A[0][j - 1];
    }

    for(int i = 1; i < n; i++) {
      A[i][0] += A[i - 1][0];
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j < m; j++) {
        A[i][j] += A[i][j - 1] + A[i - 1][j] - A[i - 1][j - 1];
      }
    }

    return A;
  }
}
