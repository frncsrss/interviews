package interviews.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Graph representation.
 * @author Francois Rousseau
 */
public class Graph {
  public final int V;
  protected int E;
  protected List<Edge>[] adjacencyLists;
  protected Set<Edge> edges;

  @SuppressWarnings("unchecked")
  public Graph(int V) {
    this.V = V;
    this.adjacencyLists = (List<Edge>[]) new List[V];
    for (int v = 0; v < V; v++) {
      adjacencyLists[v] = new ArrayList<Edge>();
    }
    this.edges = new HashSet<Edge>(V);
  }

  /**
   * Add an edge between vertex v and vertex w if not already present.
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(int v, int w) {
    return addEdge(new Edge(v, w));
  }

  /**
   * Add a weighted edge between vertex v and vertex w if not already present.
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(int v, int w, double weight) {
    return addEdge(new Edge(v, w, weight));
  }

  /**
   * Add an edge between vertex v and vertex w if not already present.
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(Edge e) {
    boolean isNew = addEdgeInternal(e);
    if(isNew) {
      E++;
    }
    return isNew;
  }

  /**
   * Adjacent edges of v.
   */
  public Iterable<Edge> adjE(int v) {
    return adjacencyLists[v];
  }

  /**
   * Adjacent vertices of v.
   */
  public Iterable<Integer> adjV(int v) {
    List<Integer> adjacents = new ArrayList<Integer>();
    for(Edge edge: adjacencyLists[v]) {
      adjacents.add(edge.other(v));
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
  public Iterable<Edge> edges() {
    return edges;
  }

  /**
   * String representation by adjacency lists.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for(int v = 0; v < V; v++) {
      builder.append(v + " -> [");
      for(int w: adjV(v)) {
        builder.append(w + ", ");
      }
      builder.delete(builder.length() - 2, builder.length());
      builder.append("]\n");
    }
    return builder.toString();
  }


  /**
   * Add an edge between vertex v and vertex w.
   * Create the vertices if not already present in the graph.
   */
  protected boolean addEdgeInternal(Edge edge) {
    boolean isNew = edges.add(edge);
    if(isNew) {
      adjacencyLists[edge.v].add(edge);
      adjacencyLists[edge.w].add(edge);
    }
    return isNew;
  }
}
