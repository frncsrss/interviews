package interviews.sets;

import java.util.Arrays;

/**
 * Quick Union (one of the implementations of Union Find).
 * With weighting. Usually called union-by-size.
 * Find in O(log(N)) time, Union in O(log(N)) time. O(N) in space.
 * @author Francois Rousseau
 */
public class QuickUnion extends UnionFind {
  protected int[] size;  // sz[i] = number of objects in subtree rooted at i

  public QuickUnion(final int N) {
    super(N);
    this.size = new int[N];
    Arrays.fill(size, 1);
  }

  @Override
  public int find(int p) {
    while(p != id[p]) {
      p = id[p];
    }
    return p;
  }

  @Override
  public void union(int p, int q) {
    if(connected(p, q)) {
      return;
    }
    final int i = find(p);  // root of p
    final int j = find(q);  // root of q
    if(size[i] < size[j]) {
      id[i] = j;  // root of q becomes root of p
      size[j] += size[i];
    } else {
      id[j] = i;  // root of p becomes root of q
      size[i] += size[j];      
    }
    count--;
  }
}
