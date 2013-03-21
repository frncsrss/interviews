package interviews.arrays;

/**
 * Given a fixed array A of n integers, design a way to handle a lot of queries asking for the
 * minimum element inside a range. The array does not change between queries.
 * This implementation uses segment trees. Pre-processing in O(n) in time.
 * Query time in O(logn) in time.
 * @author Francois Rousseau
 */
public class RangeMinimumQuerySegmentTrees {
  protected int[] A;
  protected int[] M;

  public RangeMinimumQuerySegmentTrees(int[] A) {
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
    return query(i, j, 0, A.length-1, 1);
  }

  private int query(int i, int j, int a, int b, int node) {
    if(i > b || j < a) {
      return -1000;
    }
    if(a >= i && b <= j) {
      return M[node];
    }
    final int min1 = query(i, j, a, (a+b)/2, 2*node);
    final int min2 = query(i, j, (a+b)/2 + 1, b, 2*node + 1);
    if(min1 == -1000) {
      return min2;
    }
    if(min2 == -1000) {
      return min1;
    }
    return Math.min(min1, min2);
  }

  private static int[] process(int[] A) {
    int[] M = new int[2 * (1 << log2(A.length) + 1)];
    process(A, M, 0, A.length-1, 1);
    return M;
  }

  private static void process(int[] A, int[] M, int a, int b, int node) {
    if(a == b) {
      M[node] = A[a];
    } else {
      process(A, M, a, (a+b)/2, 2*node);
      process(A, M, (a+b)/2 + 1, b, 2*node + 1);
      M[node] = Math.min(M[2*node], M[2*node + 1]);
    }
  }

  private static int log2(int n) {
    if(n <= 0) throw new IllegalArgumentException();
    return 31 - Integer.numberOfLeadingZeros(n);
  }
}
