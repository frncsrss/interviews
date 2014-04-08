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

  /**
   * Add a directed edge between vertex v and vertex w.
   */
  @Override
  public boolean addEdge(Edge e) {
    if(!edges.add(e)) {
      return false;
    }
    adjacencyLists[e.v].add(e);
    E++;
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
    if(!edges.contains(e)) {
      return false;
    }
    edges.remove(e);
    adjacencyLists[e.v].remove(e);
    E--;
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
