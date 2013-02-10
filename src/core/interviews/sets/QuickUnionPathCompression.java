package interviews.sets;

/**
 * Quick Union with Path Compression (one of the implementations of Union Find).
 * With weighting and path compression.
 * Find in O(N + Mlog*(N)) time for M calls.
 * Union in O(N + Mlog*(N)) time for M calls.
 * O(N) in space.
 * @author Francois Rousseau
 */
public class QuickUnionPathCompression extends QuickUnion {

  public QuickUnionPathCompression(final int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    while(p != id[p]) {
      id[p] = id[id[p]];  // flatten the tree by 1
      p = id[p];
    }
    return p;
  }
}
