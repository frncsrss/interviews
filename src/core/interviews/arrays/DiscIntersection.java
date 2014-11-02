package interviews.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of n integers, we draw n discs in a 2D plane such that the i-th disc is centered
 * on (0,i) and has a radius of radius[i].
 *
 * We say that the j-th disc and k-th disc intersect if j ­ k and j-th and k-th discs have at least
 * one common point.
 *
 * Write a function that, given an array describing N discs as explained above, returns the number
 * of pairs of intersecting discs.
 *
 * For example, given n=6 and radius = {1, 5, 2, 1, 4, 0}
 * there are 11 pairs of intersecting discs:
 * 0 and 1,
 * 0 and 2,
 * 0 and 4,
 * 1 and 2,
 * 1 and 3,
 * 1 and 4,
 * 1 and 5,
 * 2 and 3,
 * 2 and 4,
 * 3 and 4,
 * 4 and 5.
 * so the function should return 11.
 *
 * @author Francois Rousseau
 */
public class DiscIntersection {

  /**
   * Time complexity:  O(n^2)
   * Space complexity: O(1)
   */
  public static int f1(int[] radius) {
    int count = 0;
    for (int i = 0; i < radius.length; i++) {
      for (int j = i + 1; j < radius.length; j++) {
        if (i + radius[i] >= j - radius[j]) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * Time complexity:  O(nlogn)
   * Space complexity: O(n)
   */
  public static int f2(int[] radius) {
    final int n = radius.length;

    // transform the array of n radius into an array of n intervals
    Interval[] intervals = new Interval[n];
    for(int i = 0; i < n; i++) {
      intervals[i] = new Interval(i - radius[i], i + radius[i]);
    }
    // sort the intervals in ascending lower bound then ascending upper bound
    Arrays.sort(intervals, new Comparator<Interval>() {  // O(nlogn)
      @Override
      public int compare(Interval i1, Interval i2) {
        if(i1.lo > i2.lo) {
          return 1;
        } else if(i1.lo < i2.lo) {
          return -1;
        }
        return new Integer(i1.hi).compareTo(i2.hi);
      }
    });

    int count = 0;
    for(int i = 0; i < n - 1; i++) {  // O(nlogn)
      // binary search of intervals[i].hi in intervals[i+1...n-1], O(logn)
      final int value = intervals[i].hi;
      int lo = i + 1;
      int hi = n - 1;
      while(lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if(intervals[mid].lo > value) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }

      count += hi - i;
    }
    return count;
  }

  private static class Interval {
    final int lo, hi;

    public Interval(int lo, int hi) {
      this.lo = lo;
      this.hi = hi;
    }
  }

  /**
   * Time complexity:  O(nlogn)
   * Space complexity: O(n)
   */
  public static int f3(int[] radius) {
    final int n = radius.length;

    // transform the array of n radius into an array of 2n boundaries
    Endpoint[] boundaries = new Endpoint[2 * n];
    for(int i = 0; i < n; i++) {
      boundaries[i] = new Endpoint(Endpoint.Type.START, i - radius[i]);
      boundaries[i + n] = new Endpoint(Endpoint.Type.END, i + radius[i]);
    }
    // sort the boundaries
    Arrays.sort(boundaries);

    int count = 0;
    int start = 0;
    for(int i = 0; i < 2 * n; i++) {
      if(Endpoint.Type.START.equals(boundaries[i].type)) {
        start++;
      } else {
        start--;
        count += start;
      }
    }
    return count;
  }

  private static class Endpoint implements Comparable<Endpoint> {
    public static enum Type {START, END};

    private final Type type;  // start or end boundary
    private final int v;

    public Endpoint(Type type, int value) {
      this.type = type;
      this.v = value;
    }

    @Override
    public int compareTo(Endpoint that) {
      if(this.v < that.v) return -1;
      if(this.v > that.v) return +1;
      // switch sign if exclusive ending range endpoint
      if(Type.START.equals(this.type) && Type.END.equals(that.type)) return -1;
      if(Type.END.equals(this.type) && Type.START.equals(that.type)) return +1;
      return 0;
    }
  }
}
