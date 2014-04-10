package interviews.graphs;

import interviews.arrays.UpdatableHeap;
import interviews.lib.Pair;

/**
 * The k-core of a graph corresponds to the maximal subgraph whose vertices are at least of degree k
 * within the subgraph.
 *
 * @author Francois Rousseau
 */
public class KCore {
  private final Graph g;
  private final int V;
  private final int[] core;
  private final int[] effectiveDegree;  // degree of a vertex in the last core it belongs to

  public KCore(Graph g) {
    this.g = g;
    this.V = g.V;
    this.core = new int[V];
    this.effectiveDegree = new int[V];
  }

  /**
   * Core number sequence of an unweighted undirected graph. Runs in O(max(|V|, |E|)).
   */
  public void computeUnweighted() {
    int md, i, start;
    int[] bin, pos, vert;

    md = 0;                         // max degree
    for(int v = 0; v < V; v++) {    // fill the degrees (will hold the core number in the end)
      int d = (int)g.degree(v);
      core[v] = d;
      if(d > md) {
        md = d;
      }
    }

    bin = new int[md + 1];         // filled with 0
    for(int v = 0; v < V; v++) {   // number of elements in each bin
      bin[core[v]]++;
    }

    start = 0;
    for(int d = 0; d <= md; d++) {  // starting positions of each bin
      int num = bin[d];
      bin[d] = start;
      start += num;
    }

    pos = new int[V];
    vert = new int[V];
    for(int v = 0; v < V; v++) {    // starting position of bins in array vert (sort)
      pos[v] = bin[core[v]];
      vert[pos[v]] = v;
      bin[core[v]]++;
    }                               // vertices sorted by degree in vert

    for(int d = md; d > 0; d--) {   // recover starting positions of bins
      bin[d] = bin[d - 1];
    }
    bin[0] = 1;

    for(i = 0; i < V; i++) {    // loop over the vert table (always sorted by degree)
      int v = vert[i];
      for(int u : g.adjV(v)) {  // visit each edge (twice in total)
        if(core[u] > core[v]) {   // neighbor still in the remaining subgraph
          int du = core[u];
          int pu = pos[u];
          int pw = bin[du];     // pw is the id of the bin u is currently in
          int w = vert[pw];     // w is the first vertex in the same bin
          if(u != w) {          // swap u and w if u is not already the first element in the bin
            pos[u] = pw;        // swap their positions
            pos[w] = pu;
            vert[pu] = w;       // update the vert table
            vert[pw] = u;
          }
          bin[du]++;  // increase starting position of the bin (since we move u to the left bin)
          core[u]--;   // decrease the degree of u since we are removing v
        }
      }
    }  // deg[] now contains the core number of each vertex
  }

  /**
   * Core number sequence of a weighted undirected graph, aka p5-core or f-core. Runs in O(ElogV).
   */
  public void computeWeighted() {
    int k;

    UpdatableHeap<Integer> heap = new UpdatableHeap<Integer>();
    for(int v = 0; v < V; v++) {  // fill the degrees (will hold the core number in the end)
      core[v] = (int)g.degree(v);
      heap.add(v, core[v]);
    }

    k = 0;
    while(!heap.isEmpty()) {
      Pair<Integer, Integer> min = heap.poll();
      int v = min.x;
      k = Math.max(k, min.y);
      core[v] = k;
      for(Edge e : g.adjE(v)) {   // visit each edge (twice in total)
        int u = e.other(v);
        heap.decreaseKey(u, (int)e.weight);
      }
    }
  }

  /**
   * @return core number sequence.
   */
  public int[] core() {
    return core;
  }

  /**
   * @return core number of vertex v.
   */
  public int core(int v) {
    return core[v];
  }

  public void computeEffectiveDegree() {
    for(int v = 0; v < V; v++) {
      effectiveDegree[v] = effectiveDegree(v);
    }
  }

  private int effectiveDegree(int v) {
    int deg = 0;
    int k = core[v];
    for(int w : g.adjV(v)) {
      if(core[w] >= k) {
        deg++;
      }
    }
    return deg;
  }
}
