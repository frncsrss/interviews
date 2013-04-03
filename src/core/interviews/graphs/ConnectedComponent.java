package interviews.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * Compute the connected components in linear time in number of edges/vertices.
 * 
 * For directed graphs, use the Kosaraju-Sharir algorithm.
 * Run first a DFS on the reverse graph to get a topological order of the vertices and then run a
 * DFS on the original graph using this order.
 */
public class ConnectedComponent<V> {
  private Map<V, Integer>  visited;
  private int count;

  public ConnectedComponent(Graph<V> g) {
    visited = new HashMap<V, Integer>();
    count = 0;
    for(V v: g.vertices()) {
      if(!visited.containsKey(v)) {
        dfs(g, v);
        count++;
      }
    }
  }

  public ConnectedComponent(Digraph<V> g) {
    visited = new HashMap<V, Integer>();
    count = 0;
    DigraphHandler<V> reverseHandler = new DigraphHandler<V>(g.reverse());
    for(V v: reverseHandler.topological()) {
      if(!visited.containsKey(v)) {
        dfs(g, v);
        count++;
      }
    }
  }

  /**
   * Check if two vertices are in the same (strongly) connected component.
   */
  public boolean connected(V v, V w) {
    return visited.get(v) == visited.get(w);    
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
  public int id(V v) {
    return visited.get(v);
  }


  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue).
   */
  private void dfs(Graph<V> g, V v) {
    visited.put(v, count);  // mark vertex as visited
    for(V w: g.adjacents(v)) {
      if(!visited.containsKey(w)) {  // not already visited
        dfs(g, w);
      }
    }
  }
}
