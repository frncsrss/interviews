package interviews.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Graph operations.
 * @author Francois Rousseau
 */
public class GraphHandler {
  protected Graph graph;
  protected int source;
  protected int[] parent;
  protected boolean[] visited;

  public GraphHandler(Graph graph) {
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
   * Set all the values of an array to -1.
   */
  public static void reset(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      arr[i] = -1;
    }
  }

  /**
   * Set all the values of an array to -1.
   */
  public static void reset(boolean[] arr) {
    for(int i = 0; i < arr.length; i++) {
      arr[i] = false;
    }
  }
}
