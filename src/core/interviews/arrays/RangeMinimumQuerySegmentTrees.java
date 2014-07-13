package interviews.arrays;


/**
 * Given a fixed array A of n integers, design a way to handle a lot of queries asking for the
 * minimum element inside a range. The array does not change between queries.
 * This implementation uses segment trees. Pre-processing in O(n) in time.
 * Query time in O(logn) in time.
 * @author Francois Rousseau
 */
public class RangeMinimumQuerySegmentTrees {
  protected final int[] arr;
  protected final int[] tree;

  public RangeMinimumQuerySegmentTrees(int[] arr) {
    this.arr = arr;
    this.tree = process(arr);
  }

  public int query(int i, int j) {
    if(i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
      throw new IndexOutOfBoundsException();
    }
    if(i > j) {  // swap i and j
      i = i^j;
      j = i^j;
      i = i^j;
    } else if(i == j) {
      return arr[i];
    }
    return query(i, j, 0, arr.length - 1, 1);
  }

  /**
   * @param i: lower bound from query range
   * @param j: upper bound from query range
   * @param a: current lower bound
   * @param b: current upper bound
   * @param node: index of min value for [a, b]
   * @return
   */
  private int query(int i, int j, int a, int b, int node) {
    if(i > b || j < a) {
      return Integer.MAX_VALUE;
    }
    // if [a, b] included in [i, j]
    if(a >= i && b <= j) {
      return tree[node];
    }
    final int left = query(i, j, a, (a + b) / 2, 2 * node);
    final int right = query(i, j, (a + b) / 2 + 1, b, 2 * node + 1);
    return Math.min(left, right);
  }

  private static int[] process(int[] arr) {
    // at most, a full of tree of height E(log2(arr.length)) + 2
    int[] tree = new int[1 << log2(arr.length) + 2];
    process(arr, tree, 0, arr.length - 1, 1);
    return tree;
  }

  /**
   * Fill the tree in a recursive way, bottom-up.
   */
  private static void process(int[] arr, int[] tree, int a, int b, int node) {
    if(a == b) {  // leaf
      tree[node] = arr[a];
    } else {
      process(arr, tree, a, (a + b) / 2, 2 * node);
      process(arr, tree, (a + b) / 2 + 1, b, 2 * node + 1);
      tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }
  }

  private static int log2(int n) {
    if(n <= 0) throw new IllegalArgumentException();
    return 31 - Integer.numberOfLeadingZeros(n);
  }
}
