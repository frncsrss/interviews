package interviews.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Shortest path.
 * @author Francois Rousseau
 */
public class ShortestPath {
  private Graph g;
  private double[] distTo;
  private int[] parent;
  private int source;

  public ShortestPath(Graph g) {
    this.g = g;
    this.distTo = new double[g.V];
    this.parent = new int[g.V];
  }

  /**
   * Apply Dijkstra's algorithm. Assume a positively weighted digraph.
   * Lazy implementation (keep in the priority queue nodes with distances that have been overridden).
   * Run in O(ElogE).
   */
  public void dijkstra(int source) {
    Arrays.fill(distTo, Double.POSITIVE_INFINITY);  // reset the distance table
    Arrays.fill(parent, -1);                        // reset the parent table
    this.distTo[source] = 0;
    this.parent[source] = source;
    this.source = source;

    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    pq.add(new Node(source, 0));
    while(!pq.isEmpty()) {
      Node n = pq.poll();
      if(n.dist > distTo[n.v]) {  // obsolete node since we found better meanwhile
        continue;
      }
      for(Edge e: g.adjE(n.v)) {
        relax(e, pq);
      }
    }
  }

  /**
   * Distance between the current source and the given vertex.
   * Double.POSITIVE_INFINITY is no path.
   */
  public double distTo(int v) {
    return distTo[v];
  }

  /**
   * Path from the current source to the given vertex.
   * Null if no path.
   */
  public Iterable<Integer> pathTo(int v) {
    // better than java.util.Stack that relies on a Vector!
    Deque<Integer> path = new ArrayDeque<Integer>();
    for(int x = v; x != source; x = parent[x]) {
      if(x == -1) {
        return null;
      }
      path.push(x);
    }
    path.push(source);
    return path;
  }


  /**
   * Internal subroutine that relaxes an edge and insert it in the priority queue if necessary.
   */
  private void relax(Edge e, PriorityQueue<Node> pq) {
    if(distTo[e.w] > distTo[e.v] + e.weight) {
      distTo[e.w] = distTo[e.v] + e.weight;
      parent[e.w] = e.v;
      pq.add(new Node(e.w, distTo[e.w]));
    }
  }

  /**
   * Internal class that holds a pair <vertex, distance> to be inserted in the priority queue.
   */
  private static class Node implements Comparable<Node> {
    private int v;
    private double dist;

    public Node(int v, double dist) {
      this.v = v;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node that) {
      if(this.dist < that.dist) return -1;
      if(this.dist > that.dist) return +1;
      return 0;
    }
  }
}
