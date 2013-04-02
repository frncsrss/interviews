package interviews.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<V> {
  private int E;
  private Set<V> vertices;
  private Map<V, Set<Edge<V>>> adjancencyLists;

  public WeightedGraph() {
    this.vertices = new HashSet<V>();
    this.adjancencyLists = new HashMap<V, Set<Edge<V>>>();
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
   * Adjacent vertices of v.
   */
  public Iterable<V> adjancents(V v) {
    List<V> adjancents = new ArrayList<V>();
    for(Edge<V> edge: adjancencyLists.get(v)) {
      adjancents.add(edge.w);
    }
    return adjancents;
  }

  /**
   * Number of edges.
   */
  public int E() {
    return E;
  }

  /**
   * Number of vertices.
   */
  public int V() {
    return vertices.size();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for(V v: vertices()) {
      builder.append(v + " -> [");
      for(V w: adjancents(v)) {
        builder.append(w + ", ");
      }
      builder.delete(builder.length() - 2, builder.length());
      builder.append("]\n");
    }
    return builder.toString();
  }

  /**
   * Return all the vertices from this graph.
   */
  public Iterable<V> vertices() {
    return vertices;
  }


  /**
   * Add a (directed) edge between vertex v and vertex w.
   * Create the vertices if not already present in the graph.
   */
  protected boolean addEdgeHelper(V v, V w, double weight) {
    if(!adjancencyLists.containsKey(v)) {
      adjancencyLists.put(v, new HashSet<Edge<V>>());
    } 
    return adjancencyLists.get(v).add(new Edge<V>(v, w, weight));
  }
}
