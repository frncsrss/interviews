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
  protected Set<V> vertices;
  private Map<V, Edge<V>> adjancencyLists;

  public Graph() {
    this.vertices = new HashSet<V>();
    this.adjancencyLists = new HashMap<V, Edge<V>>();
  }

  /**
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(V v, V w) {
    vertices.add(v);
    vertices.add(w);
    boolean ret = false;
    ret |= addEdgeHelper(v, w);
    ret |= addEdgeHelper(w, v);
    if(ret) {
      E++;  // we only want to increment it once for undirected edge
    }
    return ret;
  }

  /**
   * Adjancent vertices of v.
   */
  public Iterable<V> adjancents(V v) {
    List<V> adjancents = new ArrayList<V>();
    Edge<V> current = adjancencyLists.get(v);
    while(current != null) {
      adjancents.add(current.v);
      current = current.next;
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
  protected boolean addEdgeHelper(V v, V w) {
    if(!adjancencyLists.containsKey(v)) {
      adjancencyLists.put(v, new Edge<V>(w));
    } else {
      Edge<V> currentEdge = adjancencyLists.get(v);
      while(currentEdge.hasNext()) {
        if(currentEdge.v.equals(w)) {  // the edge <v, w> is already in the adjacency list
          return false;
        }
        currentEdge = currentEdge.next;
      }
      currentEdge.next = new Edge<V>(w);
    }
    return true;
  }

  /**
   * Internal class representing an edge inside a linked-list.
   */
  private static class Edge<V> {
    private final V v;
    private Edge<V> next;

    public Edge(V v) {
      this.v = v;
    }

    public boolean hasNext() {
      return next != null;
    }

    @Override
    public String toString() {
      return "Edge to " + v + " pointing to " + next;
    }
  }
}
