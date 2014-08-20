package interviews.numbers;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Returns the first k integers of the form a^3 + b^3 where a and b are integers.
 *
 * @author Francois Rousseau
 */
public class Cube {
  /**
   * Time complexity:  O(klogk)
   * Space complexity: O(k)  // not counting the returned array
   */
  public static long[] f(int k) {
    long[] numbers = new long[k];
    SortedSet<Node> set = new TreeSet<Node>();
    set.add(new Node(0, 0));
    while(k > 0) {
      Node node = set.first();
      set.remove(node);
      numbers[numbers.length - k] = node.v;
      set.add(new Node(node.a, node.b + 1));
      if(node.b - node.a == 1) {
        set.add(new Node(node.a + 1, node.b));
      }
      k--;
    }
    return numbers;
  }

  private static class Node implements Comparable<Node> {
    final int a;
    final int b;
    final long v;

    public Node(int a, int b) {
      this.a = a;
      this.b = b;
      this.v = (long) (Math.pow(a, 3) + Math.pow(b, 3));
    }

    @Override
    public int compareTo(Node that) {
      if(this.v < that.v) return -1;
      if(this.v > that.v) return +1;
      return 0;
    }
  }
}
