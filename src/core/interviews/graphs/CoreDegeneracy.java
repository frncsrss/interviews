package interviews.graphs;

import interviews.arrays.UpdatableHeap;
import interviews.lib.Pair;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * p-core graph degeneracy.
 * @author Francois Rousseau
 */
public class CoreDegeneracy {
  private final Graph g;

  public CoreDegeneracy(Graph g) {
    this.g = g;
  }

  /**
   * k-core decomposition of an unweighted undirected graph. Runs in O(max(|V|, |E|)).
   */
  public LinkedHashMap<Integer, Set<Integer>> kcore() {
    int n, md, i, start, k;
    int[] bin, deg, pos, vert;

    n = g.V;
    deg = new int[n];
    md = 0;                         // max degree
    for(int v = 0; v < n; v++) {    // fill the degrees (will hold the core number in the end)
      int d = (int)g.degree(v);
      deg[v] = d;
      if(d > md) {
        md = d;
      }
    }

    bin = new int[md + 1];         // filled with 0
    for(int v = 0; v < n; v++) {   // number of elements in each bin
      bin[deg[v]]++;
    }

    start = 0;
    for(int d = 0; d <= md; d++) {  // starting positions of each bin
      int num = bin[d];
      bin[d] = start;
      start += num;
    }

    pos = new int[n];
    vert = new int[n];
    for(int v = 0; v < n; v++) {    // starting position of bins in array vert (sort)
      pos[v] = bin[deg[v]];
      vert[pos[v]] = v;
      bin[deg[v]]++;
    }                               // vertices sorted by degree in vert

    for(int d = md; d > 0; d--) {   // recover starting positions of bins
      bin[d] = bin[d - 1];
    }
    bin[0] = 1;

    for(i = 0; i < n; i++) {    // loop over the vert table (always sorted by degree)
      int v = vert[i];
      for(int u : g.adjV(v)) {  // visit each edge (twice in total)
        if(deg[u] > deg[v]) {   // neighbor still in the remaining subgraph
          int du = deg[u];
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
          deg[u]--;   // decrease the degree of u since we are removing v
        }
      }
    }  // deg[] now contains the core number of each vertex

    k = 0;  // will hold the graph core number (max vertex core number)
    for(int v = 0; v < n; v++) {
      if(deg[v] > k) {
        k = deg[v];
      }
    }

    LinkedHashMap<Integer, Set<Integer>> decomposition = new LinkedHashMap<Integer, Set<Integer>>();
    for(i = 0; i <= k; i++) {     // init decomposition
      decomposition.put(i, new HashSet<Integer>());
    }

    for(int v = 0; v < n; v++) {  // fill decomposition
      decomposition.get(deg[v]).add(v);
    }

    return decomposition;
  }


  /**
   * k-core decomposition of a weighted undirected graph, aka p5-core or f-core. Runs in O(ElogV).
   */
  public LinkedHashMap<Integer, Set<Integer>> fcore() {
    int n, k;
    int[] deg;

    UpdatableHeap<Integer> heap = new UpdatableHeap<Integer>();
    n = g.V;
    deg = new int[n];
    for(int v = 0; v < n; v++) {  // fill the degrees (will hold the core number in the end)
      deg[v] = (int)g.degree(v);
      heap.add(v, deg[v]);
    }

    k = 0;
    while(!heap.isEmpty()) {
      Pair<Integer, Integer> min = heap.poll();
      int v = min.x;
      k = Math.max(k, min.y);
      deg[v] = k;
      for(Edge e : g.adjE(v)) {   // visit each edge (twice in total)
        int u = e.other(v);
        heap.decreaseKey(u, (int)e.weight);
      }
    }

    LinkedHashMap<Integer, Set<Integer>> decomposition = new LinkedHashMap<Integer, Set<Integer>>();
    for(int i = 0; i <= k; i++) {  // init decomposition
      decomposition.put(i, new HashSet<Integer>());
    }

    for(int v = 0; v < n; v++) {  // fill decomposition
      decomposition.get(deg[v]).add(v);
    }

    return decomposition;
  }
}
