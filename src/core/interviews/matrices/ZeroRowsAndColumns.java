package interviews.matrices;

/**
 * Given a matrix A, set to 0 any cell for which there is a 0 in its row or column. The operation
 * has to be in-place.
 *
 * @author Francois Rousseau
 */
public class ZeroRowsAndColumns {
  private final static int RESERVED = 1;

  /**
   * Let A be a n by m matrix.
   * Time complexity:  O(nm)
   * Space complexity: O(1)
   */
  public static int[][] f(int[][] A) {
    final int n = A.length;
    final int m = A[0].length;

    boolean flipBack = false;

    if(A[0][0] == 0) {
      A[0][0] = RESERVED;
    } else if(A[0][0] == RESERVED) {
      A[0][0] = RESERVED + 1;
      flipBack = true;
      for(int i = 1; i < n; i++) {
        if(A[i][0] == 0) {
          flipBack = false;
        }
      }
      for(int j = 1; j < m; j++) {
        if(A[0][j] == 0) {
          flipBack = false;
        }
      }
    }

    for(int i = 0; i < n; i++) {
      int last = -1;
      for(int j = 0; j < m; j++) {
        if(A[i][j] != 0) {
          continue;
        }
        setLeftAndUp(A, i, j, last);
        A[i][j] = RESERVED;
        last = j;
      }
    }

    for(int i = n - 1; i >= 0; i--) {
      int last = m;
      for(int j = m - 1; j >= 0; j--) {
        if(!isReservedLeftAndUp(A, i, j)) {
          continue;
        }
        setRightAndDown(A, n, m, i, j, last);
        last = j;
      }
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(isReservedLeftAndUp(A, i, j)) {
          A[i][j] = 0;
        }
      }
    }

    if(flipBack) {
      A[0][0] = RESERVED;
    }

    return A;  // for ease of testing
  }

  private static void setLeftAndUp(int[][] A, int i, int j, int last) {
    for(int k = i - 1; k >= 0; k--) {
      if(isReservedLeftAndUp(A, k, j)) {
        break;
      }
      A[k][j] = 0;
    }
    for(int l = j - 1; l > last; l--) {
      A[i][l] = 0;
    }
  }

  private static void setRightAndDown(int[][] A, int n, int m, int i, int j, int last) {
    for(int k = i + 1; k < n; k++) {
      if(isReservedRightAndDown(A, n, m, k, j)) {
        break;
      }
      A[k][j] = 0;
    }
    for(int l = j + 1; l < last; l++) {
      A[i][l] = 0;
    }
  }

  private static boolean isReservedLeftAndUp(int[][] A, int i, int j) {
    if(i == 0 && j == 0) {
      return A[i][j] == RESERVED;
    }
    if(i > 0 && j == 0) {
      return A[i][j] == RESERVED && A[i - 1][j] == 0;
    }
    if(i == 0 && j > 0) {
      return A[i][j] == RESERVED && A[i][j - 1] == 0;
    }
    return A[i][j] == RESERVED && A[i - 1][j] == 0 && A[i][j - 1] == 0;
  }

  private static boolean isReservedRightAndDown(int[][] A, int n, int m, int i, int j) {
    if(i == n - 1 && j == m - 1) {
      return A[i][j] == RESERVED;
    }
    if(i < n - 1 && j == m - 1) {
      return A[i][j] == RESERVED && A[i + 1][j] == 0;
    }
    if(i == n - 1 && j < m - 1) {
      return A[i][j] == RESERVED && A[i][j + 1] == 0;
    }
    return A[i][j] == RESERVED && A[i + 1][j] == 0 && A[i][j + 1] == 0;
  }
}
