package interviews.arrays;

/**
 * Given a matrix, print it out diagonally.
 *
 * @author Francois Rousseau
 */
public class MatrixDiagonals {
  /**
   * Let mat be a n by n matrix.
   * Time complexity:  O(n^2)
   * Space complexity: O(1)
   */
  public static void f(int[][] mat) {
    final int n = mat.length;
    for(int k = 0; k < 2* n - 1; k++) {
      for(int j = Math.min(k, n - 1), i = k - j; i <= Math.min(k, n - 1); i++, j--) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }
}
