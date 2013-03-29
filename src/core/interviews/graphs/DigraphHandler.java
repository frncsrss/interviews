package interviews.graphs;

import java.util.Stack;

public class DigraphHandler<V> extends GraphHandler<V> {

  public DigraphHandler(Graph<V> graph) {
    super(graph);
  }

  /**
   * Compute the connected components in linear time in number of edges/vertices.
   */
  @Override
  public void cc() {
    throw new UnsupportedOperationException();
  }

  /**
   * Compute the connected components in linear time in number of edges/vertices.
   */
  public Iterable<V> topological() {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    source = null;    // set the source
    Stack<V> stack = new Stack<V>();
    for(V v: graph.vertices()) {
      if(!visited.containsKey(v)) {
        dfsHelper(v, stack);
      }
    }
    return stack;
  }


  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue) and stack the elements in DFS postorder.
   */
  private void dfsHelper(V v, Stack<V> stack) {
    visited.put(v, count);  // mark vertex as visited
    for(V w: graph.adjancents(v)) {
      if(!visited.containsKey(w)) {  // not already visited
        parent.put(w, v);  // store the parent (v) of edge.v
        dfsHelper(w, stack);
      }
    }
    stack.push(v);
  }
}
