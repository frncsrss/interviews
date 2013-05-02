package interviews.linear_programming;

/**
 * Simplex algorithm.
 * @author Francois Rousseau
 */
public class Simplex {
  private double[][] t;  // simplex tableau
  private int M, N;      // M constraints, N variables

  /**
   * Create a tableau t of size M x (M + N)
   *    _______
   * m | A I b |
   * 1 | c 0 0 |
   *    -------
   *     n m 1
   */
  public Simplex(double[][] A, double[] b, double[] c) {
    M = b.length;
    N = c.length;
    t = new double[M + 1][M + N + 1];
    for(int i = 0; i < M; i++) {      // put A[][] into tableau
      for(int j = 0; j < N; j++) {
        t[i][j] = A[i][j];
      }
    }
    for(int j = N; j < M + N; j++) {  // put I[][] into tableau
      t[j - N][j] = 1.0;
    }
    for(int j = 0; j < N; j++) {      // put c[] into tableau
      t[M][j] = c[j];
    }
    for(int i = 0; i < M; i++) {      // put b[] into tableau
      t[i][M + N] = b[i];
    }
  }

  /**
   * Return maximal value.
   */
  public double max() {
    return -t[M][M + N];
  }

  /**
   * Solve the current tableau with the simplex algorithm.
   */
  public void solve() {
    while(true) {
      int c = column();  // column
      if(c == -1) {
        break;
      }

      int r = row(c);    // row
      if(r == -1) {
        break;
      }

      pivot(r, c);
    }
  }


  /**
   * Find entering column using Bland's rule.
   * Find index of first column whose objective function coefficient is positive.
   */
  private int column() {
    for(int j = 0; j < M + N; j++) {
      if(t[M][j] > 0) {
        return j;
      }
    }
    return -1;
  }

  /**
   * Find leaving row using min ratio rule.
   * Bland's rule: if a tie, choose first such row.
   */
  private int row(int c) {
    int r = -1;                   // leaving row
    for(int i = 0; i < M; i++) {
      if(t[i][c] <= 0) {          // consider only positive entries
        continue;
      } else if(r == -1) {
        r = i;
      } else if(t[i][M+N] / t[i][c] < t[r][M+N] / t[r][c]) {
        // row r has min ratio so far
        r = i;
      }
    }
    return r;
  }

  /**
   * Pivot on row r and column c.
   */
  private void pivot(int r, int c) {
    for(int i = 0; i <= M; i++) {    // scale all entries 
      for(int j = 0; j <= M+N; j++) {
        if(i != r && j != c) {       // but row r and column c
          t[i][j] -= t[r][j] * t[i][c] / t[r][c];
        }
      }
    }
    for(int i = 0; i <= M; i++) {    // zero out column c
      if(i != r) {
        t[i][c] = 0.0;
      }
    }
    for(int j = 0; j <= M+N; j++) {  // scale row r
      if(j != c) {
        t[r][j] /= t[r][c];
      }
    }
    t[r][c] = 1.0;
  }
}
