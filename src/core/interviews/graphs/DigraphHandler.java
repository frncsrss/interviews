package interviews.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class DigraphHandler<V> extends GraphHandler<V> {

  public DigraphHandler(Graph<V> graph) {
    super(graph);
  }

  /**
   * Compute the connected components in linear time in number of edges/vertices.
   * Use the Kosaraju-Sharir algorithm.
   * Run first a DFS on the reverse graph to get a topological order of the vertices and then run a
   * DFS on the original graph using this order.
   */
  @Override
  public void cc() {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    source = null;    // set the source
    count = 0;
    DigraphHandler<V> reverseHandler = new DigraphHandler<V>(((Digraph<V>) graph).reverse());
    for(V v: reverseHandler.topological()) {
      if(!visited.containsKey(v)) {
        dfsHelper(v);
        count++;
      }
    }
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
        dfsHelper(v, stack);
      }
    }
    return stack;
  }


  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue) and stack the elements in DFS postorder.
   */
  private void dfsHelper(V v, Deque<V> stack) {
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
