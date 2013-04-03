package interviews.graphs;

import java.util.HashSet;

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
    ret |= addEdgeHelper(v, w, weight);
    ret |= addEdgeHelper(w, v, weight);
    if(ret) {
      E++;  // we only want to increment it once for undirected edge
    }
    return ret;
  }


  /**
   * Add a (directed) edge between vertex v and vertex w.
   * Create the vertices if not already present in the graph.
   */
  protected boolean addEdgeHelper(V v, V w, double weight) {
    if(!adjacencyLists.containsKey(v)) {
      adjacencyLists.put(v, new HashSet<Edge<V>>());
    } 
    return adjacencyLists.get(v).add(new Edge<V>(v, w, weight));
  }
}
