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
public class Graph<Vertex> {
  private int E;
  private boolean directed;
  private Set<Vertex> vertices;
  private Map<Vertex, Edge<Vertex>> adjancencyLists;

  public Graph(boolean directed) {
    this.directed = directed;
    this.vertices = new HashSet<Vertex>();
    this.adjancencyLists = new HashMap<Vertex, Edge<Vertex>>();
  }

  /**
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(Vertex v, Vertex w) {
    vertices.add(v);
    vertices.add(w);
    return addEdge(v, w, directed);
  }

  public Iterable<Vertex> adjancents(Vertex v) {
    List<Vertex> adjancents = new ArrayList<Vertex>();
    Edge<Vertex> current = adjancencyLists.get(v);
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

  /**
   * Return all the vertices from this graph.
   */
  public Iterable<Vertex> vertices() {
    return vertices;
  }


  /**
   * Add a (directed) edge between vertex v and vertex w.
   * Create the vertices if not already present in the graph.
   */
  private boolean addEdge(Vertex v, Vertex w, boolean directed) {
    if(!adjancencyLists.containsKey(v)) {
      adjancencyLists.put(v, new Edge<Vertex>(w));
      if(directed) {
        E++;  // we only want to increment it once for undirected edge
      } else {
        addEdge(w, v, true);  // trick to add an undirected edge as a directed edge twice
      }
      return true;
    }

    // otherwise we go through the adjancencyList
    Edge<Vertex> currentEdge = adjancencyLists.get(v);
    while(currentEdge.hasNext()) {
      if(currentEdge.v.equals(w)) {  // the edge <v, w> is already in the adjacency list
        return false;
      }
      currentEdge = currentEdge.next;
    }
    currentEdge.next = new Edge<Vertex>(w);
    if(directed) {
      E++;  // we only want to increment it once for undirected edge
    } else {
      addEdge(w, v, true);  // trick to add an undirected edge as a directed edge twice          
    }
    return true;
  }

  /**
   * Internal class representing an edge inside a linked-list.
   */
  private static class Edge<Vertex> {
    protected Vertex v;
    protected Edge<Vertex> next;

    public Edge(Vertex v) {
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
