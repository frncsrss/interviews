package interviews.graphs;

/**
 * Directed graph representation.
 * @author Francois Rousseau
 */
public class Digraph extends Graph {

  public Digraph(int V) {
    super(V);
  }

  /**
   * Return a reverse digraph.
   */
  public Digraph reverse() {
    Digraph reverse = new Digraph(V);
    for(int v = 0; v < V; v++) {
      for(int w: adjV(v)) {
        reverse.addEdge(w, v);
      }
    }
    return reverse;
  }

  
  /**
   * Add a (directed) edge between vertex v and vertex w.
   * Create the vertices if not already present in the graph.
   */
  @Override
  protected boolean addEdgeInternal(Edge edge) {
    edges.add(edge);
    return adjacencyLists[edge.v].add(edge);
  }

}
