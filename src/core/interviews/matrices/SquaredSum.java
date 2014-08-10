package interviews.matrices;

/**
 * Given a matrix A, return a matrix S such that S[i][j] = sum_{0 <= k,l <= i,j}{A[k][l]}.
 *
 * @author Francois Rousseau
 */
public class SquaredSum {
  /**
   * Let A be a n by m matrix.
   * Time complexity:  O(nm)
   * Space complexity: O(1)  // omitting the returned matrix
   */
  public static int[][] f(int[][] A) {
    final int n = A.length;
    final int m = A[0].length;
    int[][] S = new int[n][m];

    int sum = 0;
    for(int j = 0; j < m; j++) {
      sum += A[0][j];
      S[0][j] = sum;
    }

    for(int i = 1; i < n; i++) {
      sum = 0;
      for(int j = 0; j < m; j++) {
        sum += A[i][j];
        S[i][j] = sum + S[i - 1][j];
      }
    }

    return S;
  }
}
