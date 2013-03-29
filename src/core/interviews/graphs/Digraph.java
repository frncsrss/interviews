package interviews.graphs;

public class Digraph<V> extends Graph<V> {

  /**
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  @Override
  public boolean addEdge(V v, V w) {
    vertices.add(v);
    vertices.add(w);
    boolean ret = addEdgeHelper(v, w);
    if(ret) {
      E++;  // we only want to increment it once for undirected edge
    }
    return ret;
  }
}
