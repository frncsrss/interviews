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
public class GraphHandler<V> {
  protected Graph<V> graph;
  protected V source;
  protected Map<V, V> parent;
  protected Map<V, Integer>  visited;
  protected int count;

  public GraphHandler(Graph<V> graph) {
    this.graph = graph;
    this.parent = new HashMap<V, V>();
    this.visited = new HashMap<V, Integer>();
    this.source = null;
    this.count = -1;
  }
  
  /**
   * Perform a breadth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void bfs(V v) {
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
    for(V v: graph.vertices()) {
      if(!visited.containsKey(v)) {
        dfsHelper(v);
        count++;
      }
    }
  }

  /**
   * Check if two vertices are in the same (strongly) connected component.
   */
  public boolean connected(V v, V w) {
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
  public void dfs(V v) {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    source = v;       // set the source
    count = (count == -1) ? 0 : visited.get(source);
    dfsHelper(v);
  }

  /**
   * Is there a path between the current source and the given vertex?
   */
  public boolean hasPathTo(V v) {
    return visited.containsKey(v);
  }

  /**
   * Return the connected component id for the given vertex.
   */
  public int id(V v) {
    if(count == -1) {
      cc();
    }
    return visited.get(v);
  }

  /**
   * Parent of the given vertex.
   * Depend on the traversal used.
   */
  public V parent(V v) {
    return parent.get(v);
  }

  /**
   * Path from the current source to the given vertex.
   * Depend on the traversal used.
   */
  public Iterable<V> pathTo(V v) {
    if(!hasPathTo(v) || source == null) {
      return null;
    }
    Stack<V> path = new Stack<V>();
    for(V x = v; !x.equals(source); x = parent.get(x)) {
      path.push(x);
    }
    path.push(source);
    return path;
  }


  /**
   * Internal routine that performs a breadth-first search traversal of the graph.
   * Use a FIFO queue.
   */
  protected void bfsHelper(V v) {
    Queue<V> queue = new LinkedList<V>();
    queue.add(v);
    visited.put(v, count);  // mark vertex as visited
    while(!queue.isEmpty()) {
      V current = queue.poll();
      for(V w: graph.adjancents(current)) {
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
  protected void dfsHelper(V v) {
    visited.put(v, count);  // mark vertex as visited
    for(V w: graph.adjancents(v)) {
      if(!visited.containsKey(w)) {  // not already visited
        parent.put(w, v);  // store the parent (v) of edge.v
        dfsHelper(w);
      }
    }
  }
}
