package interviews.numbers;

import java.util.PriorityQueue;

/**
 * Returns the first unique k integers of the form a^3 + b^3 where a and b are integers.
 *
 * Note: 1729 can be written as 9^3 + 10^3 and as 1^3 + 12^3, but should only be returned once.
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
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    // We start at (0, 0).
    pq.add(new Node(0, 0));
    // We make sure we only consider the first unique k integers.
    while(k > 0) {
      Node node = pq.poll();
      // We consider next (a, b + 1).
      pq.add(new Node(node.a, node.b + 1));
      // In parallel, we also start considering (a + 1, b), incrementing a to a + 1 only once and
      // as soon as possible, i. e. a = b - 1.
      if(node.a == node.b - 1) {
        pq.add(new Node(node.a + 1, node.b));
      }
      // Add to the returned array if not already present, e.g., 1729 can be written as 9^3 + 10^3
      // and as 1^3 + 12^3. Note that we still want to continue the search from (1, 12).
      if (k == numbers.length || numbers[numbers.length - k - 1] < node.v) {
        numbers[numbers.length - k] = node.v;
        k--;
      }
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

    @Override
    public String toString() {
      return v +  " = " + a + "^3 + " + b + "^3";
    }
  }
}
