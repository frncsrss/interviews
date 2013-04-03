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
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  @Override
  public boolean addEdge(int v, int w) {
    boolean ret = addEdge(new Edge(v, w));
    if(ret) {
      E++;  // we only want to increment it once for undirected edge
    }
    return ret;
  }

  /**
   * Return a reverse digraph.
   */
  public Digraph reverse() {
    Digraph reverse = new Digraph(V);
    for(int v = 0; v < V; v++) {
      for(int w: adjacents(v)) {
        reverse.addEdge(w, v);
      }
    }
    return reverse;
  }
}
