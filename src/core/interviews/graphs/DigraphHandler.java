package interviews.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class DigraphHandler<V> extends GraphHandler<V> {

  public DigraphHandler(Graph<V> graph) {
    super(graph);
  }

  /**
   * Return the topological order of the graph.
   */
  public Iterable<V> topological() {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    source = null;    // set the source
    Deque<V> stack = new ArrayDeque<V>();  // better than java.util.Stack that relies on a Vector!
    for(V v: graph.vertices()) {
      if(!visited.containsKey(v)) {
        dfs(v, stack);
      }
    }
    return stack;
  }


  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue) and stack the elements in DFS postorder.
   */
  private void dfs(V v, Deque<V> stack) {
    visited.put(v, count);  // mark vertex as visited
    for(V w: graph.adjancents(v)) {
      if(!visited.containsKey(w)) {  // not already visited
        parent.put(w, v);  // store the parent (v) of edge.v
        dfs(w, stack);
      }
    }
    stack.push(v);
  }
}
