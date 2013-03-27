package interviews.graphs;

import interviews.graphs.Graph.Edge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Graph operations.
 * @author Francois Rousseau
 */
public class GraphHandler<Vertex> {
  protected Graph<Vertex> graph;
  protected Vertex source;
  protected Map<Vertex, Vertex> parent;
  protected Set<Vertex> visited;

  public GraphHandler(Graph<Vertex> graph) {
    this.graph = graph;
    this.parent = new HashMap<Vertex, Vertex>();
    this.visited = new HashSet<Vertex>();
    this.source = null;
  }
  
  /**
   * Perform a breadth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void bfs(Vertex v) {
    parent.clear();  // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    this.source = v;  // set the source
    bfsHelper(v);
  }

  /**
   * Perform a depth-first search traversal of the graph from the given vertex.
   * Set the given vertex as current source for subsequent methods.
   */
  public void dfs(Vertex v) {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    this.source = v;  // set the source
    dfsHelper(v);
  }

  /**
   * Is there a path between the current source and the given vertex?
   */
  public boolean hasPathTo(Vertex v) {
    return visited.contains(v);
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
    if(!hasPathTo(v)) {
      return null;
    }
    Stack<Vertex> path = new Stack<Vertex>();
    for (Vertex x = v; !x.equals(source); x = parent.get(x)) {
      path.push(x);
    }
    path.push(source);
    return path;
  }


  /**
   * Internal routine that performs a breadth-first search traversal of the graph.
   * Use a FIFO queue.
   */
  private void bfsHelper(Vertex v) {
    Queue<Vertex> queue = new LinkedList<Vertex>();
    queue.add(v);
    visited.add(v);  // mark vertex as visited
    while(!queue.isEmpty()) {
      Vertex current = queue.poll();
      Edge<Vertex> edge = graph.adjancencyLists.get(current);
      while(edge != null) {
        if(!visited.contains(edge.y)) {  // not already visited
          parent.put(edge.y, current);  // store the parent (current) of edge.y
          queue.add(edge.y);
          visited.add(edge.y);
        }
        edge = edge.next;
      }
    }
  }

  /**
   * Internal routine that performs a depth-first search traversal of the graph.
   * Use recursion (LIFO queue).
   */
  private void dfsHelper(Vertex v) {
    visited.add(v);  // mark vertex as visited
    Edge<Vertex> edge = graph.adjancencyLists.get(v);
    while(edge != null) {
      if(!visited.contains(edge.y)) {  // not already visited
        parent.put(edge.y, v);  // store the parent (v) of edge.y
        dfsHelper(edge.y);
      }
      edge = edge.next;
    }
  }
}
