package interviews.matrices;

/**
 * Given a matrix A of 0s and 1s, return the size of the largest square sub-matrix with all 1s.
 *
 * @author Francois Rousseau
 */
public class LargestSquareSubmatrixWithOnlyOnes {
  /**
   * Let A be a n by m matrix.
   * Time complexity:  O(nm)
   * Space complexity: O(nm)
   */
  public static int f(int[][] A) {
    final int n = A.length;
    final int m = A[0].length;

    // will hold the size of the largest square sub-matrix with all 1s including S[i][j]
    // where S[i][j] is the rightmost and "bottommost" cell of the sub-matrix.
    int[][] S = new int[n][m];

    // S[:][0] = A[:][0]
    for(int i = 0; i < n; i++) {
      S[i][0] = A[i][0];
    }
    // S[0][:] = A[0][:]
    for(int j = 0; j < m; j++) {
      S[0][j] = A[0][j];
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j < m; j++) {
        if(A[i][j] == 1) {
          S[i][j] = Math.min(Math.min(S[i][j - 1], S[i - 1][j]), S[i - 1][j - 1]) + 1;
        } else {
          S[i][j] = 0;
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        max = Math.max(max, S[i][j]);
      }
    }

    return max;
  }
}
