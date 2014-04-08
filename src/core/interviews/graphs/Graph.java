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
  protected double[] degree;

  @SuppressWarnings("unchecked")
  public Graph(int V) {
    this.V = V;
    this.adjacencyLists = new List[V];
    for (int v = 0; v < V; v++) {
      adjacencyLists[v] = new ArrayList<Edge>();
    }
    this.edges = new HashSet<Edge>(V);
    this.degree = new double[V];
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
   */
  public boolean addEdge(Edge e) {
    if(!edges.add(e)) {
      return false;
    }
    adjacencyLists[e.v].add(e);
    adjacencyLists[e.w].add(e);
    E++;
    degree[e.v] += e.weight;
    degree[e.w] += e.weight;
    return true;
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
   * Does the graph contains the edge?
   */
  public boolean contains(Edge e) {
    return edges.contains(e);
  }

  /**
   * Does the graph contains the edge?
   */
  public boolean containsEdge(int v, int w) {
    for(Edge edge: adjacencyLists[v]) {
      if(edge.other(v) == w) {
        return true;
      }
    }
    return false;
  }

  /**
   * Degree of v.
   */
  public double degree(int v) {
    return degree[v];
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
   * Remove the edge if inside the graph.
   */
  public boolean removeEdge(Edge e) {
    if(!edges.contains(e)) {
      return false;
    }
    edges.remove(e);
    adjacencyLists[e.v].remove(e);
    adjacencyLists[e.w].remove(e);
    E--;
    degree[e.v] -= e.weight;
    degree[e.w] -= e.weight;
    return true;
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
}
