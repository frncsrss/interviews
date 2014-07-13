package interviews.strings;

import interviews.graphs.Digraph;
import interviews.graphs.Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Regular expression matching.
 * Base on a Nondeterministic Finite state Automaton (NFA).
 *
 * @author Francois Rousseau
 */
public class RegularExpression {
  private final char[] re;  // match transitions
  private final Digraph g;  // epsilon-transition digraph
  private final int M;      // number of states

  public RegularExpression(String regex) {
    M = regex.length();
    re = regex.toCharArray();
    g = buildEpsilonTransitionsDigraph();
  }

  /**
   * Does the regex match the input String?
   */
  public boolean match(String s) {
    return match(s.toCharArray());
  }


  /**
   * Build a digraph from the epsilon-transitions.
   */
  private Digraph buildEpsilonTransitionsDigraph() {
    Digraph g = new Digraph(M + 1);
    Deque<Integer> stack = new ArrayDeque<Integer>();
    for(int i = 0; i < M; i++) {
      int lp = i;

      // left parentheses or OR symbol
      if(re[i] == '(' || re[i] == '|') stack.push(i);

      else if(re[i] == ')') {
        int op = stack.pop();
        if(re[op] == '|') {  // the popped operation is an OR
          lp = stack.pop();
          g.addEdge(lp, op + 1);
          g.addEdge(op, i);
        }
        else {  // the popped operation was a left parenthese
          lp = op;
        }
      }

      // closure, needs 1-character lookahead
      if(i < M-1 && re[i + 1] == '*') {
        g.addEdge(lp, i + 1);
        g.addEdge(i + 1, lp);
      }

      // closure, needs 1-character lookahead
      if(i < M-1 && re[i + 1] == '+') {
        g.addEdge(i + 1, lp);
      }

      // metasymbols
      if(re[i] == '(' || re[i] == '*' || re[i] == ')' || re[i] == '+') {
        g.addEdge(i, i + 1);
      }
    }
    return g;
  }

  /**
   * Does the regex match the input array of characters?
   */
  private boolean match(char[] s) {
    List<Integer> states = new ArrayList<Integer>();
    Traversal t = new Traversal(g);

    // states reachable from start by epsilon-transitions
    t.dfs(0);
    for(int v = 0; v < g.V; v++) {
      if(t.hasPathTo(v)) {
        states.add(v);
      }
    }

    for(int i = 0; i < s.length; i++) {
      // states reachable after scanning past s[i]
      List<Integer> match = new ArrayList<Integer>();
      for(int v : states) {
        if(v == M) {
          return true;  // prefix matching
        }
        if(re[v] == s[i] || re[v] == '.')
          match.add(v+1);
      }

      // states reachable from match by epsilon-transitions
      t.dfs(match);
      states = new ArrayList<Integer>();
      for(int v = 0; v < g.V; v++) {
        if(t.hasPathTo(v)) {
          states.add(v);
        }
      }
    }

    // accept if can end in state M
    for(int v : states) {
      if(v == M) return true;
    }
    return false;
  }
}
