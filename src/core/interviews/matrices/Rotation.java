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

  /**
   * Let A be a n by n matrix.
   * Time complexity:  O(n^2)
   * Space complexity: O(1)  // in-place
   */
  public static int[][] leftSquare(int[][] A) {
    final int n = A.length;
    assert n == A[0].length;

    for(int i = 0; i < n / 2; i++) {
      for(int j = 0; j < Math.ceil(n / 2.0); j++) {
        swap(A, i, j, n - 1 - j, i);
        swap(A, i, j, n - 1 - i, n - 1 - j);
        swap(A, i, j, j, n - 1 - i);
      }
    }

    return A;  // for ease of testing
  }

  /**
   * Let A be a n by n matrix.
   * Time complexity:  O(n^2)
   * Space complexity: O(1)  // in-place
   */
  public static int[][] rightSquare(int[][] A) {
    final int n = A.length;
    assert n == A[0].length;

    for(int i = 0; i < n / 2; i++) {
      for(int j = 0; j < Math.ceil(n / 2.0); j++) {
        swap(A, i, j, j, n - 1 - i);
        swap(A, i, j, n - 1 - i, n - 1 - j);
        swap(A, i, j, n - 1 - j, i);
      }
    }

    return A;  // for ease of testing
  }

  private static void swap(int[][] A, int i1, int j1, int i2, int j2) {
    if(i1 == i2 && j1 == j2) {
      return;
    }
    A[i1][j1] ^= A[i2][j2];
    A[i2][j2] ^= A[i1][j1];
    A[i1][j1] ^= A[i2][j2];
  }
}
