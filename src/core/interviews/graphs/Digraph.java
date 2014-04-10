package interviews.graphs;

/**
 * Directed graph representation.
 * @author Francois Rousseau
 */
public class Digraph extends Graph {
  private final double[] indegree;
  private final double[] outdegree;

  public Digraph(int V) {
    super(V);
    this.indegree = new double[V];
    this.outdegree = new double[V];
  }

  @Override
  public boolean addEdge(int v, int w) {
    return addEdge(new DirectedEdge(v, w));
  }

  @Override
  public boolean addEdge(int v, int w, double weight) {
    return addEdge(new DirectedEdge(v, w, weight));
  }

  /**
   * Add a directed edge between vertex v and vertex w.
   */
  @Override
  public boolean addEdge(Edge e) {
    if(!(e instanceof DirectedEdge)) {
      throw new IllegalArgumentException("The edge must be an instance of DirectedEdge");
    }
    if(adjacencyListsVertices[e.v].contains(e.w)) {
      return false;
    }
    adjacencyListsEdges[e.v].add(e);
    adjacencyListsVertices[e.v].add(e.w);
    edges.add(e);
    degree[e.v] += e.weight;
    degree[e.w] += e.weight;
    outdegree[e.v] += e.weight;
    indegree[e.w] += e.weight;
    return true;
  }

  /**
   * Indegree of v.
   */
  public double indegree(int v) {
    return indegree[v];
  }

  /**
   * Outdegree of v.
   */
  public double outdegree(int v) {
    return outdegree[v];
  }

  @Override
  public boolean removeEdge(Edge e) {
    if(!(e instanceof DirectedEdge)) {
      throw new IllegalArgumentException("The edge must be an instance of DirectedEdge");
    }
    if(!adjacencyListsVertices[e.v].contains(e.w)) {
      return false;
    }
    adjacencyListsEdges[e.v].remove(e);
    adjacencyListsVertices[e.v].remove(e.w);
    edges.remove(e);
    degree[e.v] -= e.weight;
    degree[e.w] -= e.weight;
    outdegree[e.v] -= e.weight;
    indegree[e.w] -= e.weight;
    return true;
  }

  /**
   * Return a reverse digraph.
   */
  public Digraph reverse() {
    Digraph reverse = new Digraph(V);
    for(int v = 0; v < V; v++) {
      for(int w: adjV(v)) {
        reverse.addEdge(w, v);
      }
    }
    return reverse;
  }
}
