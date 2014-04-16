package interviews.graphs;

import interviews.arrays.UpdatableHeap;
import interviews.lib.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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

  private Node source;
  private Map<Integer, Node> nodes;
  private Set<Integer> enqueued;
  private Set<Integer> visited;
  private Set<Integer> ignoring;

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

    computeEffectiveDegree();
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

    computeEffectiveDegree();
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

  /**
   * Add the edge if it leaves the core number sequence unchanged.
   */
  public boolean addEdge(Edge e) {
    g.addEdge(e);
    int v = e.v;
    int w = e.w;
    int core_v = core[v];
    int core_w = core[w];
    if(core_v < core_w) {
      effectiveDegree[v]++;
      reset(v);
      if(bfs()) {
        return true;
      }
      effectiveDegree[v]--;
    } else if(core_v > core_w) {
      effectiveDegree[w]++;
      reset(w);
      if(bfs()) {
        return true;
      }
      effectiveDegree[w]--;
    } else {
      effectiveDegree[v]++;
      effectiveDegree[w]++;
      reset(v);
      if(bfs()) {
        return true;
      }
      reset(w);
      if(bfs()) {
        return true;
      }
      effectiveDegree[v]--;
      effectiveDegree[w]--;
    }
    g.removeEdge(e);
    return false;
  }

  /**
   * Remove the edge if it leaves the core number sequence unchanged.
   */
  public boolean removeEdge(Edge e) {
    int v = e.v;
    int w = e.w;
    if(core[v] < core[w] && core[v] < effectiveDegree[v]) {
      g.removeEdge(e);
      effectiveDegree[v]--;
      return true;
    } else if(core[v] > core[w] && core[w] < effectiveDegree[w]) {
      g.removeEdge(e);
      effectiveDegree[w]--;
      return true;
    } else if(core[v] < effectiveDegree[v] && core[w] < effectiveDegree[w]) {
      g.removeEdge(e);
      effectiveDegree[v]--;
      effectiveDegree[w]--;
      return true;
    }
    return false;
  }

  private void computeEffectiveDegree() {
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

  private void reset(int v) {
    source = new Node(v);
    nodes = new HashMap<Integer, Node>();
    nodes.put(v, source);
    enqueued = new HashSet<Integer>();
    visited = new HashSet<Integer>();
    ignoring = new HashSet<Integer>();
  }

  private boolean bfs() {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(source);
    enqueued.add(source.id);
    while(!queue.isEmpty()) {
      visit(queue);
      if(!source.couldBeInNextCore()) {
        return true;
      }
    }
    return !source.couldBeInNextCore();
  }

  private void visit(Queue<Node> queue) {
    Node v = queue.poll();
    visited.add(v.id);
    List<Node> toVisit = new ArrayList<Node>();
    for(int w : g.adjV(v.id)) {
      if(ignoring.contains(w)) {  // previously ignored
        continue;
      }
      if(core[w] < v.k) {  // not in k-shell, discard
        continue;
      }
      if(core[w] > v.k) {  // already in (k+1)-core
        v.sure++;
        continue;
      }
      if(effectiveDegree[w] < v.k + 1) {  // in k-shell but definitely not in (k+1)-core
        continue;
      }
      if(!nodes.containsKey(w)) {
        nodes.put(w, new Node(w));
      } else if(v.neighbors.contains(nodes.get(w))) {  // parent
        continue;
      }
      v.neighbors.add(nodes.get(w));
      nodes.get(w).neighbors.add(v);
      toVisit.add(nodes.get(w));
    }

    if(!v.couldBeInNextCore()) {  // v does NOT meet 3. for sure
      v.propagate();
    } else {
      for(Node w : toVisit) {
        if(!enqueued.contains(w.id)) {
          enqueued.add(w.id);
          queue.add(w);
        }
      }
    }
  }

  private class Node {
    private final int id;
    private final int k;
    private int sure = 0;
    private final List<Node> neighbors = new ArrayList<Node>();  // forward or backward

    Node(int v) {
      this.id = v;
      this.k = core[v];
    }

    private boolean couldBeInNextCore() {
      return sure + neighbors.size() > core[id];
    }

    private void propagate() {
      ignoring.add(id);
      for(Node node : neighbors) {
        node.neighbors.remove(this);
      }
      for(Node node : neighbors) {
        if(visited.contains(node.id) && !node.couldBeInNextCore()) {
          node.propagate();
        }
      }
      neighbors.clear();
    }

    @Override
    public String toString() {
      return String.format("%d %d %d\t%d+%s", id, k, effectiveDegree[id], sure, neighbors.size());
    }
  }
}
