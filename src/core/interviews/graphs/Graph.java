package interviews.graphs;

import java.util.HashMap;
import java.util.Map;

public class Graph<Vertex> {
  
  protected int V;
  protected int E;
  protected boolean directed;
  protected Map<Vertex, Edge<Vertex>> adjancencyLists;
  protected Map<Vertex, Integer> degree;
  protected enum STATE {UNIDISCOVERED, DISCOVERED, PROCESSED};

  public Graph(boolean directed) {
    this.directed = directed;
    this.adjancencyLists = new HashMap<Vertex, Edge<Vertex>>();
    this.degree = new HashMap<Vertex, Integer>();
  }

  public boolean addEdge(Vertex x, Vertex y) {
    return addEdge(x, y, directed);
  }

  public int E() {
    return E;
  }

  public int V() {
    return adjancencyLists.size();
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

  protected static class Edge<Vertex> {
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
