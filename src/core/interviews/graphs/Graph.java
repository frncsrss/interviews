package interviews.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Graph representation.
 * @author Francois Rousseau
 */
public class Graph<V> {
  protected int E;
  protected Map<V, Set<Edge<V>>> adjacencyLists;
  protected Set<Edge<V>> edges;
  protected Set<V> vertices;

  public Graph() {
    this.adjacencyLists = new HashMap<V, Set<Edge<V>>>();
    this.edges = new HashSet<Edge<V>>();
    this.vertices = new HashSet<V>();
  }

  /**
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(V v, V w) {
    vertices.add(v);
    vertices.add(w);
    boolean ret = false;
    ret |= addEdge(new Edge<V>(v, w));
    ret |= addEdge(new Edge<V>(w, v));
    if(ret) {
      E++;  // we only want to increment it once for undirected edge
    }
    return ret;
  }

  /**
   * Adjacent vertices of v.
   */
  public Iterable<V> adjacents(V v) {
    List<V> adjacents = new ArrayList<V>();
    for(Edge<V> edge: adjacencyLists.get(v)) {
      adjacents.add(edge.w);
    }
    return adjacents;
  }

  /**
   * Number of edges.
   */
  public int E() {
    return E;
  }

  /**
   * Return all the edges from this graph.
   */
  public Iterable<Edge<V>> edges() {
    return edges;
  }

  /**
   * String representation by adjacency lists.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for(V v: vertices()) {
      builder.append(v + " -> [");
      for(V w: adjacents(v)) {
        builder.append(w + ", ");
      }
      builder.delete(builder.length() - 2, builder.length());
      builder.append("]\n");
    }
    return builder.toString();
  }

  /**
   * Number of vertices.
   */
  public int V() {
    return vertices.size();
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
  protected boolean addEdge(Edge<V> edge) {
    if(!adjacencyLists.containsKey(edge.v)) {
      adjacencyLists.put(edge.v, new HashSet<Edge<V>>());
    }
    edges.add(edge);
    return adjacencyLists.get(edge.v).add(edge);
  }
}
