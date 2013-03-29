package interviews.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Graph operations.
 * @author Francois Rousseau
 */
public class GraphHandler<Vertex> {
  private Graph<Vertex> graph;
  private Vertex source;
  private Map<Vertex, Vertex> parent;
  private Map<Vertex, Integer>  visited;
  private int count;

  public GraphHandler(Graph<Vertex> graph) {
    this.graph = graph;
    this.parent = new HashMap<Vertex, Vertex>();
    this.visited = new HashMap<Vertex, Integer>();
    this.source = null;
    this.count = -1;
  }
  
  /**
   * Perform a breadth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void bfs(Vertex v) {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    source = v;       // set the source
    count = (count == -1) ? 0 : visited.get(source);
    bfsHelper(v);
  }

  /**
   * Compute the connected components in linear time in number of edges/vertices.
   */
  public void cc() {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    source = null;    // set the source
    count = 0;
    for(Vertex v: graph.vertices()) {
      if(!visited.containsKey(v)) {
        dfsHelper(v);
        count++;
      }
    }
  }

  /**
   * Check if two vertices are in the same (strongly) connected component.
   */
  public boolean connected(Vertex v, Vertex w) {
    if(count == -1) {
      cc();
    }
    return visited.get(v) == visited.get(w);    
  }

  /**
   * Return the number of connected components.
   */
  public int count() {
    if(count == -1) {
      cc();
    }
    return count;
  }

  /**
   * Perform a depth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void dfs(Vertex v) {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    source = v;       // set the source
    count = (count == -1) ? 0 : visited.get(source);
    dfsHelper(v);
  }

  /**
   * Is there a path between the current source and the given vertex?
   */
  public boolean hasPathTo(Vertex v) {
    return visited.containsKey(v);
  }

  /**
   * Return the connected component id for the given vertex.
   */
  public int id(Vertex v) {
    if(count == -1) {
      cc();
    }
    return visited.get(v);
  }

  /**
   * Parent of the given vertex.
   * Depend on the traversal used.
   */
  public Vertex parent(Vertex v) {
    return parent.get(v);
  }

  /**
   * Path from the current source to the given vertex.
   * Depend on the traversal used.
   */
  public Iterable<Vertex> pathTo(Vertex v) {
    if(!hasPathTo(v) || source == null) {
      return null;
    }
    Stack<Vertex> path = new Stack<Vertex>();
    for(Vertex x = v; !x.equals(source); x = parent.get(x)) {
      path.push(x);
    }
    path.push(source);
    return path;
  }

  /**
   * Compute the connected components in linear time in number of edges/vertices.
   */
  public Iterable<Vertex> topological() {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    source = null;    // set the source
    Stack<Vertex> stack = new Stack<Vertex>();
    for(Vertex v: graph.vertices()) {
      if(!visited.containsKey(v)) {
        dfsHelper(v, stack);
      }
    }
    return stack;
  }


  /**
   * Internal routine that performs a breadth-first search traversal of the graph.
   * Use a FIFO queue.
   */
  private void bfsHelper(Vertex v) {
    Queue<Vertex> queue = new LinkedList<Vertex>();
    queue.add(v);
    visited.put(v, count);  // mark vertex as visited
    while(!queue.isEmpty()) {
      Vertex current = queue.poll();
      for(Vertex w: graph.adjancents(current)) {
        if(!visited.containsKey(w)) {  // not already visited
          parent.put(w, current);  // store the parent (current) of edge.v
          queue.add(w);
          visited.put(w, count);
        }
      }
    }
  }

  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue).
   */
  private void dfsHelper(Vertex v) {
    visited.put(v, count);  // mark vertex as visited
    for(Vertex w: graph.adjancents(v)) {
      if(!visited.containsKey(w)) {  // not already visited
        parent.put(w, v);  // store the parent (v) of edge.v
        dfsHelper(w);
      }
    }
  }

  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue) and stack the elements in DFS postorder.
   */
  private void dfsHelper(Vertex v, Stack<Vertex> stack) {
    visited.put(v, count);  // mark vertex as visited
    for(Vertex w: graph.adjancents(v)) {
      if(!visited.containsKey(w)) {  // not already visited
        parent.put(w, v);  // store the parent (v) of edge.v
        dfsHelper(w, stack);
      }
    }
    stack.push(v);
  }
}
