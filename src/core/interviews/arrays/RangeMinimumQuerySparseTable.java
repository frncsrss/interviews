package interviews.arrays;

/**
 * Given a fixed array A of n integers, design a way to handle a lot of queries asking for the
 * minimum element inside a range. The array does not change between queries.
 * This implementation uses log2-based intervals. Pre-processing in O(nlogn) in time and space.
 * Query time in O(1) in time and O(nlogn) in space.
 * @author Francois Rousseau
 */
public class RangeMinimumQuerySparseTable {
  protected int[] A;
  protected int[][] M;

  public RangeMinimumQuerySparseTable(int[] A) {
    this.A = A;
    this.M = process(A);
  }

  public int query(int i, int j) {
    if(i < 0 || i >= A.length || j < 0 || j >= A.length) {
      throw new IndexOutOfBoundsException();
    }
    if(i > j) {  // swap i and j
      i = i^j;
      j = i^j;
      i = i^j;
    } else if(i == j) {
      return A[i];
    }
    final int k = log2(j - i);  // k = E(log2(j - i)) <= log2(j - i)
    // the minimum for the interval [i, j] corresponds to the minimum between the
    // minimum of [i, i+2^k] and the minimum of [j-2^k, j]
    // since 2^k < j-i < 2^(k+1), the intervals are overlapping
    return Math.min(M[i][k], M[j - (1<<k)][k]);
  }

  private static int[][] process(int[] A) {
    // index ranges from 0 to n-1
    final int n = A.length;
    
    // i ranges from 0 to n-2 (n-1 values)
    // j ranges from 1 to n-1, i.e. k ranges from 0 to log(n-1) (log2(n-1) + 1 values)
    final int[][] M = new int[n-1][log2(n-1)+1];

    // initialize M for the intervals with length 1 (i to i+1)
    for (int i = 0; i < n-1; i++) {
        M[i][0] = Math.min(A[i], A[i+1]);
    }

    // compute values from smaller to bigger intervals
    for (int k = 1; 1 << k <= n-1; k++) {  // k = E(log2(j - i))
      for (int i = 0; i + (1 << k) <= n-1; i++) {
        // the minimum for the interval [i, i+2^k] corresponds to the minimum between the
        // minimum of [i, i+2^(k-1)] and the minimum of [i+2^k-2^(k-1), i+2^k]
        // note that i+2^k-2^(k-1) == i+2^(k-1)
        M[i][k] = Math.min(M[i][k - 1], M[i + (1 << (k - 1))][k - 1]);
      }
    }
    return M;
  }

   private static int log2(int n) {
     if(n <= 0) throw new IllegalArgumentException();
     return 31 - Integer.numberOfLeadingZeros(n);
   }
}
