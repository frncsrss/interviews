package interviews.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * Graph representation.
 * @author Francois Rousseau
 */
public class Graph<Vertex> {
  protected int V;
  protected int E;
  protected boolean directed;
  protected Map<Vertex, Edge<Vertex>> adjancencyLists;

  public Graph(boolean directed) {
    this.directed = directed;
    this.adjancencyLists = new HashMap<Vertex, Edge<Vertex>>();
  }

  /**
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(Vertex v, Vertex w) {
    return addEdge(v, w, directed);
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
    return adjancencyLists.size();
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
      if(currentEdge.y.equals(w)) {  // the edge <x, y> is already in the adjacency list
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
  protected static class Edge<Vertex> {
    protected Vertex y;
    protected Edge<Vertex> next;

    public Edge(Vertex y) {
      this.y = y;
    }

    public boolean hasNext() {
      return next != null;
    }

    @Override
    public String toString() {
      return "Edge to " + y + " pointing to " + next;
    }
  }
}
