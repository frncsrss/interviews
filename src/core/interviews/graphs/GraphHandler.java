package interviews.graphs;

import interviews.graphs.Graph.Edge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphHandler<Vertex> {
  protected Graph<Vertex> graph;
  protected Vertex source;
  protected Map<Vertex, Vertex> parent;
  protected Set<Vertex> visited;

  public GraphHandler(Graph<Vertex> graph) {
    this.graph = graph;
    this.parent = new HashMap<Vertex, Vertex>();
    this.visited = new HashSet<Vertex>();
  }
  
  public void bfs(Vertex v) {
    parent.clear();  // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    this.source = v;  // set the source
    bfs(v, new LinkedList<Vertex>());
  }

  public void dfs(Vertex v) {
    parent.clear();   // clear the parent table from previous traversals
    visited.clear();  // clear the visited set from previous traversals
    this.source = v;  // set the source
    dfs(v, visited);
  }

  public boolean hasPathTo(Vertex v) {
    return visited.contains(v);
  }

  public Vertex parent(Vertex v) {
    return parent.get(v);
  }

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


  private void bfs(Vertex v, Queue<Vertex> queue) {
    queue.add(v);
    visited.add(v);  // mark vertex as visited
    while(!queue.isEmpty()) {
      Vertex current = queue.poll();
      Edge<Vertex> edge = graph.adjancencyLists.get(current);
      while(edge != null) {
        if(!visited.contains(edge.y)) {  // not already visited
          queue.add(edge.y);
          parent.put(edge.y, current);  // store the parent (current) of edge.y
          visited.add(edge.y);
        }
        edge = edge.next;
      }
    }
  }

  private void dfs(Vertex v, Set<Vertex> visited) {
    visited.add(v);  // mark vertex as visited
    Edge<Vertex> edge = graph.adjancencyLists.get(v);
    while(edge != null) {
      if(!visited.contains(edge.y)) {  // not already visited
        parent.put(edge.y, v);  // store the parent (v) of edge.y
        dfs(edge.y, visited);
      }
      edge = edge.next;
    }
  }

}
