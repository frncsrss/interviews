package interviews.sets;

/**
 * Quick Find (one of the implementations of Union Find).
 * Find in O(1) time, Union in O(N) time. O(N) in space.
 * @author Francois Rousseau
 */
public class QuickFind extends UnionFind {

  public QuickFind(final int N) {
    this.count = N;
    this.id = new int[N];
    for(int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  @Override
  public int find(int p) {
    return id[p];
  }

  @Override
  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  @Override
  public void union(int p, int q) {
    if(connected(p, q)) {
      return;
    }
    final int pid = id[p];  // needs to store it before it gets changed in the loop!
    for(int k = 0; k < id.length; k++) {
      if(id[k] == pid) {
        id[k] = id[q];
      }
    }
    count--;
  }
}
