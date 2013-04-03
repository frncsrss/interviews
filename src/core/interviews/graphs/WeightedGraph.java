package interviews.graphs;

/**
 * Weighted graph representation.
 * @author Francois Rousseau
 */
public class WeightedGraph extends Graph {

  public WeightedGraph(int V) {
    super(V);
  }

  /**
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(int v, int w, double weight) {
    boolean ret = addEdge(new Edge(v, w, weight));
    if(ret) {
      E++;  // we only want to increment it once for undirected edge
    }
    return ret;
  }
}
