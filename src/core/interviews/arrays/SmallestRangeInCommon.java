package interviews.arrays;

import java.util.PriorityQueue;

/**
 * You have k arrays of sorted integers. Find the smallest range that includes at least one number
 * from each of the k arrays.
 *
 * For example:
 *   array 1: [4, 10, 15, 24, 26]
 *   array 2: [0, 9, 12, 20]
 *   array 3: [5, 18, 22, 30]
 * The smallest range here would be [20, 24] as it contains 24 from array 1, 20 from array 2
 * and 22 from array 3.
 *
 * @author Francois Rousseau
 */
public class SmallestRangeInCommon {
  /**
   * Let n be the total number of elements.
   * Time complexity:  O(nlogk)
   * Space complexity: O(k)
   */
  public static int[] f(int[][] arrays) {
    final int k = arrays.length;

    PriorityQueue<Node> pq = new PriorityQueue<Node>();

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < k; i++) {
      min = Math.min(min, arrays[i][0]);
      max = Math.max(max, arrays[i][0]);
      pq.add(new Node(arrays[i][0], i, 0));
    }

    int best_min = min;
    int best_max = max;
    int best = max - min;

    while(!pq.isEmpty()) {
      Node node = pq.poll();  // current minimum
      if(node.j < arrays[node.i].length - 1) {  // if there is a next element in the array
        pq.add(new Node(arrays[node.i][node.j + 1], node.i, node.j + 1));
        min = pq.peek().v;
        max = Math.max(max, arrays[node.i][node.j + 1]);
        if(max - min < best) { // strictly less. if ties, first range will be returned.
          best_min = min;
          best_max = max;
          best = max - min;
        }
      } else {  // we can stop as the range is bound to increase from now
        break;
      }
    }

    return new int[]{best_min, best_max};
  }

  private static class Node implements Comparable<Node> {
    final int v;  // value
    final int i;  // which array
    final int j;  // where in array

    public Node(int v, int i, int j) {
      this.v = v;
      this.i = i;
      this.j = j;
    }

    @Override
    public int compareTo(Node o) {
      if(o.v < this.v) return +1;
      if(o.v > this.v) return -1;
      return 0;
    }

    @Override
    public String toString() {
      return Integer.toString(v);
    }
  }
}
