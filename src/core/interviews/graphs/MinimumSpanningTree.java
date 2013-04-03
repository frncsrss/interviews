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
   */
  public void kruskal() {
    edges.clear();

    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    for(Edge edge: g.edges()) {  // sort them by ascending weight
      pq.add(edge);
    }

    UnionFind uf = new QuickUnionPathCompression(g.V);
    while(!pq.isEmpty() && edges.size() < g.V - 1) {  // a mst has V - 1 edges
      Edge edge = pq.poll();
      if(!uf.connected(edge.v, edge.w)) {
        uf.union(edge.v, edge.w);
        edges.add(edge);
      }
    }
  }
}
