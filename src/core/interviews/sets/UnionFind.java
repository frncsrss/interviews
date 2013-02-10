package interviews.sets;

/**
 * Union find.
 * @author Francois Rousseau
 */
public abstract class UnionFind {
  protected int[] id;  // id[i] = parent of i
  protected int count;  // number of components

  /**
   * Return the number of disjoint sets.
   * @return count
   */
  public int count() {
      return count;
  }

  /**
   * Return component identifier for component containing p.
   * @return id
   */
  public abstract int find(int p);

  /**
   * Are objects p and q in the same set?
   * @return boolean
   */
  public abstract boolean connected(int p, int q);

  /**
   * Replace sets containing p and q with their union.
   */
  public abstract void union(int p, int q);

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for(int i=0; i<id.length; i++) {
      builder.append(id[i] + " ");
    }
    return builder.toString();
  }
}
