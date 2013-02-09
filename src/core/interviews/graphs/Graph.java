package interviews.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph<V> {
  
  protected int numberOfVertices;
  protected int numberOfEdges;
  protected boolean directed;
  protected Map<V, Edge<V>> adjancencyLists;
  protected Map<V, Integer> degree;
  protected enum STATE {UNIDISCOVERED, DISCOVERED, PROCESSED};
  protected Map<V, V> parent;

  public Graph(boolean directed) {
    this.directed = directed;
    this.adjancencyLists = new HashMap<V, Edge<V>>();
    this.degree = new HashMap<V, Integer>();
    this.parent = new HashMap<V, V>();
  }

  public int getNumberOfEdges() {
    return numberOfEdges;
  }

  public boolean addEdge(V x, V y) {
    return addEdge(x, y, directed);
  }

  private boolean addEdge(V x, V y, boolean directed) {
    if(!adjancencyLists.containsKey(x)) {
      adjancencyLists.put(x, new Edge<V>(y));
      if(directed) {
        numberOfEdges++;  // we only want to increment it once for undirected edge
      } else {
        addEdge(y, x, true);  // trick to add an undirected edge as a directed edge twice
      }
      return true;
    }

    // otherwise we go through the adjancencyList
    Edge<V> currentEdge = adjancencyLists.get(x);
    while(currentEdge.hasNext()) {
      if(currentEdge.y.equals(y)) {  // the edge <x, y> is already in the adjacency list
        return false;
      }
      currentEdge = currentEdge.getNext();
    }
    currentEdge.setNext(new Edge<V>(y));
    if(directed) {
      numberOfEdges++;  // we only want to increment it once for undirected edge
    } else {
      addEdge(y, x, true);  // trick to add an undirected edge as a directed edge twice          
    }
    return true;
  }

  public V getParent(V v) {
    return parent.get(v);
  }
  
  public void bfs(V v) {
    parent.clear();  // clear the parent table from previous traversals
    final LinkedList<V> queue = new LinkedList<V>();
    queue.add(v);
    final Set<V> visited = new HashSet<V>();
    visited.add(v);

    while(!queue.isEmpty()) {
      V current = queue.poll();
      processVertexEarly(current);

      Edge<V> edge = adjancencyLists.get(current);
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

  public void dfs(V v) {
    parent.clear();  // clear the parent table from previous traversals
    final Set<V> visited = new HashSet<V>();
    visited.add(v);
    dfs(v, visited);
  }

  private void dfs(V v, Set<V> visited) {
    processVertexEarly(v);

    Edge<V> edge = adjancencyLists.get(v);
    while(edge != null) {
      if(!visited.contains(edge.y)) {
        parent.put(edge.y, v);
        visited.add(edge.y);
        dfs(edge.y, visited);
      }
      edge = edge.next;
    }

    processVertexLate(v);
  }

  private void processVertexEarly(V v) {}
  private void processVertexLate(V v) {}
}

class Edge<V> {
  protected V y;
  protected Edge<V> next;

  public Edge(V y) {
    this.y = y;
  }

  public V getY() {
    return y;
  }

  public boolean hasNext() {
    return next != null;
  }
  
  public Edge<V> getNext() {
    return next;
  }

  public void setNext(Edge<V> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "Edge to " + y + " pointing to " + next;
  }
}