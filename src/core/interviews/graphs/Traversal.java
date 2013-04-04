package interviews.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Graph traversals.
 * @author Francois Rousseau
 */
public class Traversal {
  protected Graph graph;
  protected int source;
  protected int[] parent;
  protected boolean[] visited;

  public Traversal(Graph graph) {
    this.graph = graph;
    this.parent = new int[graph.V];
    this.visited = new boolean[graph.V];
    this.source = -1;
  }
  
  /**
   * Perform a breadth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void bfs(int v) {
    reset(parent);   // clear the parent table from previous traversals
    reset(visited);  // clear the visited table from previous traversals
    source = v;      // set the source
    bfsHelper(v);
  }
 
  /**
   * Perform a depth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void dfs(int v) {
    reset(parent);   // clear the parent table from previous traversals
    reset(visited);  // clear the visited table from previous traversals
    source = v;      // set the source
    dfsHelper(v);
  }

  /**
   * Is there a path between the current source and the given vertex?
   */
  public boolean hasPathTo(int v) {
    return visited[v];
  }

  /**
   * Parent of the given vertex.
   * Depend on the traversal used.
   */
  public int parent(int v) {
    return parent[v];
  }

  /**
   * Path from the current source to the given vertex.
   * Depend on the traversal used.
   */
  public Iterable<Integer> pathTo(int v) {
    if(!hasPathTo(v) || source == -1) {
      return null;
    }
    Stack<Integer> path = new Stack<Integer>();
    for(int x = v; x != source; x = parent[x]) {
      path.push(x);
    }
    path.push(source);
    return path;
  }

  /**
   * Return the topological order of the graph (should be directed).
   */
  public Iterable<Integer> topological() {
    reset(parent);   // clear the parent table from previous traversals
    reset(visited);  // clear the visited table from previous traversals
    source = -1;     // set the source
    // better than java.util.Stack that relies on a Vector!
    Deque<Integer> stack = new ArrayDeque<Integer>();
    for(int v = 0; v < graph.V; v++) {
      if(!visited[v]) {  // not already visited
        dfs(v, stack);
      }
    }
    return stack;
  }


  /**
   * Internal routine that performs a breadth-first search traversal of the graph.
   * Use a FIFO queue.
   */
  private void bfsHelper(int v) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(v);
    visited[v] = true;  // mark vertex as visited
    while(!queue.isEmpty()) {
      int current = queue.poll();
      for(int w: graph.adjV(current)) {
        if(!visited[w]) {  // not already visited
          parent[w] = current;  // store the parent (current) of edge.v
          queue.add(w);
          visited[w] = true;
        }
      }
    }
  }

  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue).
   */
  private void dfsHelper(int v) {
    visited[v] = true;  // mark vertex as visited
    for(int w: graph.adjV(v)) {
      if(!visited[w]) {  // not already visited
        parent[w] = v;  // store the parent (current) of edge.v
        dfsHelper(w);
      }
    }
  }

  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue) and stack the elements in DFS postorder.
   */
  private void dfs(int v, Deque<Integer> stack) {
    visited[v] = true;  // mark vertex as visited
    for(int w: graph.adjV(v)) {
      if(!visited[w]) {  // not already visited
        parent[w] = v;  // store the parent (current) of edge.v
        dfs(w, stack);
      }
    }
    stack.push(v);
  }


  /**
   * Set all the values of an array to -1.
   */
  public static void reset(int[] arr) {
    Arrays.fill(arr, -1);
  }

  /**
   * Set all the values of an array to -1.
   */
  public static void reset(boolean[] arr) {
    Arrays.fill(arr, false);
  }
}
