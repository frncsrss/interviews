package interviews.graphs;

/**
 * Compute the connected components in linear time in number of edges/vertices.
 * 
 * For directed graphs, use the Kosaraju-Sharir's algorithm.
 * Run first a DFS on the reverse graph to get a topological order of the vertices and then run a
 * DFS on the original graph using this order.
 */
public class ConnectedComponent {
  protected int[] visited;
  private int count;

  public ConnectedComponent(Graph g) {
    visited = new int[g.V];
    Traversal.reset(visited);
    count = 0;
    for(int v = 0; v < g.V; v++) {
      if(visited[v] == -1) {  // not already visited
        dfs(g, v);
        count++;
      }
    }
  }

  public ConnectedComponent(Digraph g) {
    visited = new int[g.V];
    Traversal.reset(visited);
    count = 0;
    Traversal reverseTraversal = new Traversal(g.reverse());
    for(int v: reverseTraversal.topological()) {
      if(visited[v] == -1) {  // not already visited
        dfs(g, v);
        count++;
      }
    }
  }

  /**
   * Check if two vertices are in the same (strongly) connected component.
   */
  public boolean connected(int v, int w) {
    return visited[v] == visited[w];    
  }

  /**
   * Return the number of connected components.
   */
  public int count() {
    return count;
  }

  /**
   * Return the connected component id for the given vertex.
   */
  public int id(int v) {
    return visited[v];
  }


  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue).
   */
  private void dfs(Graph g, int v) {
    visited[v] = count;  // mark vertex as visited
    for(int w: g.adjV(v)) {
      if(visited[w] == -1) {  // not already visited
        dfs(g, w);
      }
    }
  }
}
