package interviews.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Max flow.
 * @author Francois Rousseau
 */
public class MaxFlow {
  private Graph g;
  private FlowEdge[] parent;  // last edge on source->v
  private boolean[] visited;  // true if source->v is in residual network
  private double value;

  public MaxFlow(Graph g) {
    this.g = g;
    this.parent  = new FlowEdge[g.V];
    this.visited = new boolean[g.V];
  }

  public void fordFulkerson(int source, int sink) {
    value = 0.0;
    while(hasAugmentingPath(source, sink)) {
      double bottle = Double.POSITIVE_INFINITY;
      for(int v = sink; v != source; v = parent[v].other(v)) {  // compute bottleneck capacity
        bottle = Math.min(bottle, parent[v].residualCapacityTo(v));
      }
      for(int v = sink; v != source; v = parent[v].other(v)) {  // augment flow
        parent[v].addResidualFlowTo(v, bottle); 
      }
      value += bottle;
    }
  }

  /**
   * Is v reachable from source in residual network?
   */
  public boolean inCut(int v) {
    return visited[v];
  }

  /**
   * Return max flow value.
   */
  public double value() {
    return value;
  }


  /**
   * Is there an augmenting path?
   * Use BFS internally.
   */
  private boolean hasAugmentingPath(int source, int sink) { 
    Arrays.fill(parent,  null);   // clear the parent  table from previous traversals
    Arrays.fill(visited, false);  // clear the visited table from previous traversals

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(source);
    visited[source] = true;
    while(!queue.isEmpty()) {
      int v = queue.poll();
      for(Edge e : g.adjE(v)) {
        int w = e.other(v);
        // found path from source to w in the residual network
        if(((FlowEdge) e).residualCapacityTo(w) > 0 && !visited[w]) {
          parent[w] = (FlowEdge) e;
          visited[w] = true;
          queue.add(w);
        }
      }
    }

    return visited[sink];
  }
}
