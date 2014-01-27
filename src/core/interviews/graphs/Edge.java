package interviews.graphs;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Edge.
 * @author Francois Rousseau
 */
public class Edge implements Comparable<Edge> {
  public final int v, w;
  public final double weight;
  /** Cache the hash code for the edge */
  private int hash; // Default to 0

  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public Edge(int v, int w) {
    this(v, w, 1);
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
    if(edge.v == this.v && edge.w == this.w
        || edge.v == this.w && edge.w == this.v) {
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

  @Override
  public int hashCode() {
    if(hash == 0) {
      hash = new HashCodeBuilder(17, 37)
      .append(v)
      .append(w)
      .append(weight)
      .toHashCode();
    }
    return hash;
  }

  /**
   * Return the other endpoint from v.
   */
  public int other(int vertex) {
    if(vertex == v) return w;
    if(vertex == w) return v;
    throw new IllegalArgumentException("Wrong endpoint");
  }

  @Override
  public String toString() {
    return v + "->" + w + "(" + weight + ")";
  }
}
