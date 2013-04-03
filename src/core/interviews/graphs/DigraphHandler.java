package interviews.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Digraph operations.
 * @author Francois Rousseau
 */
public class DigraphHandler extends GraphHandler {

  public DigraphHandler(Graph graph) {
    super(graph);
  }

  /**
   * Return the topological order of the graph.
   */
  public Iterable<Integer> topological() {
    reset(parent);   // clear the parent table from previous traversals
    reset(visited);  // clear the visited table from previous traversals
    source = -1;     // set the source
    Deque<Integer> stack = new ArrayDeque<Integer>();  // better than java.util.Stack that relies on a Vector!
    for(int v = 0; v < graph.V; v++) {
      if(!visited[v]) {  // not already visited
        dfs(v, stack);
      }
    }
    return stack;
  }


  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue) and stack the elements in DFS postorder.
   */
  private void dfs(int v, Deque<Integer> stack) {
    visited[v] = true;  // mark vertex as visited
    for(int w: graph.adjacents(v)) {
      if(!visited[w]) {  // not already visited
        parent[w] = v;  // store the parent (current) of edge.v
        dfs(w, stack);
      }
    }
    stack.push(v);
  }
}
