package interviews.graphs;

/**
 * Edge.
 * @author Francois Rousseau
 */
public class Edge implements Comparable<Edge> {
  public final int v;
  public final int w;
  public final double weight;

  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public Edge(int v, int w) {
    this(v, w, -1);
  }

  @Override
  public int compareTo(Edge that) {
    if(this.weight < that.weight) return -1;
    if(this.weight > that.weight) return +1;
    return 0;
  }

  @Override
  public boolean equals(Object that) {
    if(this == that) {
      return true;
    }
    if(this.getClass() != that.getClass()) {
      return false;
    }
    Edge edge = (Edge) that;
    if(edge.weight != this.weight) {
      return false;
    }
    if((edge.v == this.v && edge.w == this.w)
       || (edge.v == this.w && edge.w == this.v)) {
      return true;
    }
    return false;
  }

  /**
   * Return one endpoint.
   */
  public int either() {
    return v;
  }

  /**
   * Return the other endpoint from v.
   */
  public int other(int v) {
    if(this.v == v) return w;
    return this.v;
  }

  @Override
  public String toString() {
    if(weight > 0) {
      return v + "->" + w + "(" + weight + ")";
    }
    return v + "->" + w;
  }
}
