package interviews.graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Min cut.
 * @author Francois Rousseau
 */
public class MinCut {
  private final Graph g;

  public MinCut(Graph g) {
    this.g = g;
  }

  /**
   * Returns the minimum number of edges to disconnect nodes source and sink.
   * It corresponds to the number of paths from source to sink with no edge in common.
   * DFS traversal from source to sink with modified stopping condition.
   */
  public int f(int source, int sink) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(source);
    Set<Integer> visited = new HashSet<Integer>();
    int count = 0;
    while(!stack.isEmpty()) {
      int head = stack.pop();
      visited.add(head);
      for(int v : g.adjV(head)) {
        if(v == sink) {
          count++;
        } else if(!visited.contains(v)) {
          stack.push(v);
        }
      }
    }
    return count;
  }
}
