package interviews.sets;

/**
 * Quick Union (one of the implementations of Union Find).
 * With weighting. Usually called union-by-size.
 * Find in O(log(N)) time, Union in O(log(N)) time. O(N) in space.
 * @author Francois Rousseau
 */
public class QuickUnion extends UnionFind {
  protected int[] size;  // sz[i] = number of objects in subtree rooted at i

  public QuickUnion(final int N) {
    this.count = N;
    this.id = new int[N];
    this.size = new int[N];
    for(int i = 0; i < N; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }

  @Override
  public int find(int p) {
    while (p != id[p]) {
        p = id[p];
    }
    return p;
  }

  @Override
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  @Override
  public void union(int p, int q) {
    if (connected(p, q)) {
      return;
    }
    final int i = find(p);
    final int j = find(q);
    if(size[i] < size[j]) {
      id[i] = j;  // root of p becomes root of q
      size[j] += size[i];
    } else {
      id[j] = i;  // root of p becomes root of q
      size[i] += size[j];      
    }
    count--;
  }
}
