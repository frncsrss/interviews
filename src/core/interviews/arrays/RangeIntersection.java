package interviews.arrays;

import java.util.Arrays;

/**
 * Given a list of ranges, with a start and an end, return the range that has the most
 * intersections with other ranges. In case of ties, return the one with lowest starting endpoint
 * then lowest ending endpoint.
 *
 * All ranges are inclusive. Therefore, [a, b] and [b, c] intersect.
 *
 * @author Francois Rousseau
 */
public class RangeIntersection {
  /**
   * Let n = length(ranges).
   * Time complexity:  O(nlogn)
   * Space complexity: O(n)
   */
  public static int[] f(int[][] ranges) {
    final int n = ranges.length;

    // expand the n ranges in 2*n endpoints and sort them by values
    Endpoint[] endpoints = new Endpoint[2 * n];
    for(int i = 0; i < n; i++) {
      endpoints[i] = new Endpoint(Endpoint.Type.START, i, ranges[i][0]);
      endpoints[i + n] = new Endpoint(Endpoint.Type.END, i, ranges[i][1]);
    }
    Arrays.sort(endpoints);

    // compute the number of intersections for each range
    int[] intersections = new int[n];
    int s = 0;
    int t = 0;
    for(Endpoint endpoint : endpoints) {
      if(Endpoint.Type.START.equals(endpoint.type)) {
        s++;
        intersections[endpoint.i] = -(t + 1);
      } else {
        t++;
        intersections[endpoint.i] += s;
      }
    }

    // find the range with the most intersections. ties
    int max = Integer.MIN_VALUE;
    int max_index = -1;
    for(int i = 0; i < intersections.length; i++) {
      if(max < intersections[i]
         || max == intersections[i] && ranges[i][0] < ranges[max_index][0]
         || max == intersections[i] && ranges[i][0] == ranges[max_index][0]
            && ranges[i][1] < ranges[max_index][1]) {
        max = intersections[i];
        max_index = i;
      }
    }

    return ranges[max_index];
  }

  private static class Endpoint implements Comparable<Endpoint> {
    public static enum Type {
      START("s"), END("e");
      private final String symbol;
      private Type(String symbol) {
        this.symbol = symbol;
      }
    };

    private final Type type;  // start or end endpoint
    private final int i;      // range index
    private final int v;      // value

    public Endpoint(Type type, int i, int v) {
      this.type = type;
      this.i = i;
      this.v = v;
    }

    @Override
    public int compareTo(Endpoint o) {
      if(this.v < o.v) return -1;
      if(this.v > o.v) return +1;
      // switch sign if exclusive ending range endpoint
      if(Type.START.equals(this.type) && Type.END.equals(o.type)) return -1;
      if(Type.END.equals(this.type) && Type.START.equals(o.type)) return +1;
      return 0;
    }

    @Override
    public String toString() {
      return String.format("%s%s(%d)", v, type.symbol, i);
    }
  }
}
