package interviews.graphs;

/**
 * Edge.
 * @author Francois Rousseau
 */
public class Edge<V> implements Comparable<Edge<V>> {
  public final V v;
  public final V w;
  public final double weight;

  public Edge(V v, V w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public Edge(V v, V w) {
    this(v, w, -1);
  }

  @Override
  public int compareTo(Edge<V> that) {
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
    Edge<?> edge = (Edge<?>) that;
    if(edge.v != this.v) {
      return false;
    }
    if(edge.w != this.w) {
      return false;
    }
    if(edge.weight != this.weight) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    if(weight > 0) {
      return v + " -> " + w + "(" + weight + ")";
    }
    return v + " -> " + w;
  }
}
