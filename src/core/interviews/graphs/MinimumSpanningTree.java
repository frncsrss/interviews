package interviews.graphs;

import interviews.sets.QuickUnionPathCompression;
import interviews.sets.UnionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Minimum spanning tree.
 * @author Francois Rousseau
 */
public class MinimumSpanningTree {
  private WeightedGraph g;
  private List<Edge> edges;

  public MinimumSpanningTree(WeightedGraph g) {
    this.g = g;
    this.edges = new ArrayList<Edge>(g.V - 1);
  }

  /**
   * Return all the edges from this minimum spanning tree.
   */
  public Iterable<Edge> edges() {
    return edges;
  }

  /**
   * Apply Kruskal's algorithm.
   * O(ElogE) to sort the edges by ascending weights.
   * O(ElogE) to find the first V - 1 edges with minimum weights not already connected.
   * Use constant union-find structure.
   */
  public void kruskal() {
    edges.clear();

    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    for(Edge e: g.edges()) {  // sort them by ascending weight
      pq.add(e);
    }

    UnionFind uf = new QuickUnionPathCompression(g.V);
    while(!pq.isEmpty() && edges.size() < g.V - 1) {  // a mst has V - 1 edges
      Edge e = pq.poll();
      if(!uf.connected(e.v, e.w)) {
        uf.union(e.v, e.w);
        edges.add(e);
      }
    }
  }

  /**
   * Apply Prim's algorithm.
   * Maintain a priority queue (min-oriented) of candidate edges.
   * Lazy implementation (keep in the priority queue edges with both endpoints that are already in
   * the minimum spanning tree).
   */
  public void prim(int v) {
    edges.clear();

    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

    boolean[] visited = new boolean[g.V];  // is the vertex in the mst
    visit(0, visited, pq);
    while(!pq.isEmpty() && edges.size() < g.V - 1) {  // a mst has V - 1 edges
      Edge e = pq.poll();
      if(visited[e.v] && visited[e.w]) {  // both endpoints are already in the mst
        continue;
      }
      edges.add(e);
      if(!visited[e.v]) visit(e.v, visited, pq);
      if(!visited[e.w]) visit(e.w, visited, pq);
    }
  }


  private void visit(int v, boolean[] visited, PriorityQueue<Edge> pq) {
    visited[v] = true;
    for(Edge e: g.adjE(v)) {
      if(!visited[e.other(v)]) {
        pq.add(e);
      }
    }
  }
}
