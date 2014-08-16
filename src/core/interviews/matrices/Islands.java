package interviews.matrices;

/**
 * Given a matrix A of 0s (water) and 1s (land), return the total number of islands. Two pieces of
 * land are connected if they touch each other (left/up/down/right, not in diagonal). An island
 * corresponds to a set of connected lands.
 *
 * @author Francois Rousseau
 */
public class Islands {
  /**
   * Let A be a n by m matrix.
   * Time complexity:  O(nm)
   * Space complexity: O(1)
   */
  public static int f(int[][] A) {
    final int n = A.length;
    final int m = A[0].length;

    int count = 0;

    // we use (count + 1) to mark lands as visited and as a by-product with their island id.
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(A[i][j] == 1) {  // not water and not already visited
          count++;
          visit(A, n, m, i, j, count + 1);
        }
      }
    }

    // reset the land values to 1
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(A[i][j] > 1) {
          A[i][j] = 1;
        }
      }
    }

    return count;
  }

  private static void visit(int[][] A, int n, int m, int i, int j, int id) {
    A[i][j] = id;
    if(i > 0 && A[i - 1][j] == 1) visit(A, n, m, i - 1, j, id);
    if(j > 0 && A[i][j - 1] == 1) visit(A, n, m, i, j - 1, id);
    if(i < n - 1 && A[i + 1][j] == 1) visit(A, n, m, i + 1, j, id);
    if(j < m - 1 && A[i][j + 1] == 1) visit(A, n, m, i, j + 1, id);
  }
}
