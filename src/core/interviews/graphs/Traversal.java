package interviews.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph traversals.
 * @author Francois Rousseau
 */
public class Traversal {
  private Graph g;
  private int source;
  private int[] parent;
  private boolean[] visited;

  public Traversal(Graph g) {
    this.g = g;
    this.parent = new int[g.V];
    this.visited = new boolean[g.V];
    this.source = -1;
  }

  /**
   * Perform a breadth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void bfs(int v) {
    Arrays.fill(parent, -1);      // clear the parent  table from previous traversals
    Arrays.fill(visited, false);  // clear the visited table from previous traversals
    source = v;                   // set the source
    bfsHelper(v);
  }

  /**
   * Perform a depth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void dfs(int v) {
    Arrays.fill(parent, -1);      // clear the parent  table from previous traversals
    Arrays.fill(visited, false);  // clear the visited table from previous traversals
    source = v;                   // set the source
    dfsHelper(v);
  }

  /**
   * Perform a depth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void dfs(Iterable<Integer> vs) {
    Arrays.fill(parent, -1);      // clear the parent  table from previous traversals
    Arrays.fill(visited, false);  // clear the visited table from previous traversals
    source = -1;                  // not just one source
    for(int v: vs) {
      dfsHelper(v);
    }
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
    // better than java.util.Stack that relies on a Vector!
    Deque<Integer> path = new ArrayDeque<Integer>();
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
    Arrays.fill(parent, -1);      // clear the parent  table from previous traversals
    Arrays.fill(visited, false);  // clear the visited table from previous traversals
    source = -1;     // set the source
    // better than java.util.Stack that relies on a Vector!
    Deque<Integer> stack = new ArrayDeque<Integer>();
    for(int v = 0; v < g.V; v++) {
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
    visited[v] = true;                // mark vertex as visited
    while(!queue.isEmpty()) {
      int current = queue.poll();
      for(int w: g.adjV(current)) {
        if(!visited[w]) {             // not already visited
          parent[w] = current;        // store the parent (current) of edge.v
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
    visited[v] = true;        // mark vertex as visited
    for(int w: g.adjV(v)) {
      if(!visited[w]) {       // not already visited
        parent[w] = v;        // store the parent (current) of edge.v
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
    for(int w: g.adjV(v)) {
      if(!visited[w]) {  // not already visited
        parent[w] = v;  // store the parent (current) of edge.v
        dfs(w, stack);
      }
    }
    stack.push(v);
  }
}
