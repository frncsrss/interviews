package interviews.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph<Vertex> {
  
  protected int V;
  protected int E;
  protected boolean directed;
  protected Map<Vertex, Edge<Vertex>> adjancencyLists;
  protected Map<Vertex, Integer> degree;
  protected enum STATE {UNIDISCOVERED, DISCOVERED, PROCESSED};
  protected Map<Vertex, Vertex> parent;

  public Graph(boolean directed) {
    this.directed = directed;
    this.adjancencyLists = new HashMap<Vertex, Edge<Vertex>>();
    this.degree = new HashMap<Vertex, Integer>();
    this.parent = new HashMap<Vertex, Vertex>();
  }

  public int E() {
    return E;
  }

  public boolean addEdge(Vertex x, Vertex y) {
    return addEdge(x, y, directed);
  }

  public Vertex getParent(Vertex v) {
    return parent.get(v);
  }
  
  public void bfs(Vertex v) {
    parent.clear();  // clear the parent table from previous traversals
    final LinkedList<Vertex> queue = new LinkedList<Vertex>();
    queue.add(v);
    final Set<Vertex> visited = new HashSet<Vertex>();
    visited.add(v);

    while(!queue.isEmpty()) {
      Vertex current = queue.poll();
      processVertexEarly(current);

      Edge<Vertex> edge = adjancencyLists.get(current);
      while(edge != null) {
        if(!visited.contains(edge.y)) {
          queue.addLast(edge.y);
          parent.put(edge.y, current);
          visited.add(edge.y);
        }
        edge = edge.next;
      }

      processVertexLate(current);
    }
  }

  public void dfs(Vertex v) {
    parent.clear();  // clear the parent table from previous traversals
    dfs(v, new HashSet<Vertex>());
  }


  private boolean addEdge(Vertex x, Vertex y, boolean directed) {
    if(!adjancencyLists.containsKey(x)) {
      adjancencyLists.put(x, new Edge<Vertex>(y));
      if(directed) {
        E++;  // we only want to increment it once for undirected edge
      } else {
        addEdge(y, x, true);  // trick to add an undirected edge as a directed edge twice
      }
      return true;
    }

    // otherwise we go through the adjancencyList
    Edge<Vertex> currentEdge = adjancencyLists.get(x);
    while(currentEdge.hasNext()) {
      if(currentEdge.y.equals(y)) {  // the edge <x, y> is already in the adjacency list
        return false;
      }
      currentEdge = currentEdge.next;
    }
    currentEdge.next = new Edge<Vertex>(y);
    if(directed) {
      E++;  // we only want to increment it once for undirected edge
    } else {
      addEdge(y, x, true);  // trick to add an undirected edge as a directed edge twice          
    }
    return true;
  }

  private void dfs(Vertex v, Set<Vertex> visited) {
    visited.add(v);  // mark vertex as visited
    processVertexEarly(v);

    Edge<Vertex> edge = adjancencyLists.get(v);
    while(edge != null) {
      if(!visited.contains(edge.y)) {  // not already visited
        parent.put(edge.y, v);  // store the parent (v) of edge.y
        dfs(edge.y, visited);
      }
      edge = edge.next;
    }

    processVertexLate(v);
  }

  private void processVertexEarly(Vertex v) {}
  private void processVertexLate(Vertex v) {}

  private static class Edge<Vertex> {
    protected Vertex y;
    protected Edge<Vertex> next;

    public Edge(Vertex y) {
      this.y = y;
    }

    public boolean hasNext() {
      return next != null;
    }

    @Override
    public String toString() {
      return "Edge to " + y + " pointing to " + next;
    }
  }
}
