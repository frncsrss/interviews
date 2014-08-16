package interviews.matrices;

/**
 * Given a matrix A, rotate it by 90û left/right. In-place if square matrix.
 *
 * @author Francois Rousseau
 */
public class Rotation {
  /**
   * Let A be a n by m matrix.
   * Time complexity:  O(nm)
   * Space complexity: O(1)  // without counting the returned array
   */
  public static int[][] left(int[][] A) {
    final int n = A.length;
    final int m = A[0].length;

    int[][] B = new int[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        B[i][j] = A[j][m - 1 - i];
      }
    }

    return B;
  }

  /**
   * Let A be a n by m matrix.
   * Time complexity:  O(nm)
   * Space complexity: O(1)  // without counting the returned array
   */
  public static int[][] right(int[][] A) {
    final int n = A.length;
    final int m = A[0].length;

    int[][] B = new int[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        B[i][j] = A[n - 1 - j][i];
      }
    }

    return B;
  }
}
