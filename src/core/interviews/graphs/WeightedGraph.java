package interviews.graphs;

/**
 * Weighted graph representation.
 * @author Francois Rousseau
 */
public class WeightedGraph<V> extends Graph<V> {

  public WeightedGraph() {
    super();
  }

  /**
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(V v, V w, double weight) {
    vertices.add(v);
    vertices.add(w);
    boolean ret = false;
    ret |= addEdge(new Edge<V>(v, w, weight));
    ret |= addEdge(new Edge<V>(v, w, weight));
    if(ret) {
      E++;  // we only want to increment it once for undirected edge
    }
    return ret;
  }
}
