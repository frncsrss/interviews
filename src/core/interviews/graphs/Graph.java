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
  protected final List<Edge>[] adjacencyListsEdges;
  protected final Set<Integer>[] adjacencyListsVertices;
  protected final Set<Edge> edges;
  protected final double[] degree;

  @SuppressWarnings("unchecked")
  public Graph(int V) {
    this.V = V;
    this.adjacencyListsEdges = new List[V];
    this.adjacencyListsVertices = new Set[V];
    for (int v = 0; v < V; v++) {
      adjacencyListsEdges[v] = new ArrayList<Edge>();
      adjacencyListsVertices[v] = new HashSet<Integer>();
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
  protected boolean addEdge(Edge e) {
    if(adjacencyListsVertices[e.v].contains(e.w)) {
      return false;
    }
    adjacencyListsEdges[e.v].add(e);
    adjacencyListsVertices[e.v].add(e.w);
    adjacencyListsEdges[e.w].add(e);
    adjacencyListsVertices[e.w].add(e.v);
    edges.add(e);
    degree[e.v] += e.weight;
    degree[e.w] += e.weight;
    return true;
  }

  /**
   * Adjacent edges of v.
   */
  public Iterable<Edge> adjE(int v) {
    return adjacencyListsEdges[v];
  }

  /**
   * Adjacent vertices of v.
   */
  public Iterable<Integer> adjV(int v) {
    return adjacencyListsVertices[v];
  }

  /**
   * Does the graph contains the edge?
   */
  public boolean contains(Edge e) {
    return containsEdge(e.v, e.w);
  }

  /**
   * Does the graph contains the edge?
   */
  public boolean containsEdge(int v, int w) {
    return adjacencyListsVertices[v].contains(w);
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
    return edges.size();
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
    if(!adjacencyListsVertices[e.v].contains(e.w)) {
      return false;
    }
    edges.remove(e);
    adjacencyListsEdges[e.v].remove(e);
    adjacencyListsVertices[e.v].remove(e.w);
    adjacencyListsEdges[e.w].remove(e);
    adjacencyListsVertices[e.w].remove(e.v);
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
