package interviews.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array A of N integers, we draw N discs in a 2D plane such that the
 * i-th disc is centered on (0,i) and has a radius of A[i].
 * We say that the j-th disc and k-th disc intersect if j ­ k and j-th and k-th
 * discs have at least one common point.
 * 
 * Write a function that, given an array A describing N discs as explained above,
 * returns the number of pairs of intersecting discs.
 * 
 * For example, given N=6 and:
 * A[0] = 1  A[1] = 5  A[2] = 2 
 * A[3] = 1  A[4] = 4  A[5] = 0  
 * intersecting discs appear in eleven pairs of elements:
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
 * @author Francois Rousseau
 */
public class DiscIntersection {
  public static int f(int[] A) {
    return f1(A);
  }
  
  public static int f1(int[] A) {
    int count = 0, N=A.length;
    List<Interval> list = new ArrayList<Interval>();
    for(int i = 0; i < N; i++) {
      list.add(new Interval(i-A[i], i+A[i]));
    }
    Collections.sort(list, new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        if(i1.min > i2.min) {
          return 1;
        } else if(i1.min < i2.min) {
          return -1;
        }
        return (new Integer(i2.max).compareTo(i1.max));
      }
    });

    // no need to process the last disc.
    for(int i = 0; i < N-1; i++) {
      // early pruning.
      if(list.get(i+1).min > list.get(i).max) {
        continue;
      }

      // binary search in the subarray at the right of the index.
      int a = i+1;
      int b = N-1;
      int c = (a+b)/2;
      while(a < b) {
        if(list.get(c).min > list.get(i).max) {
          b = c-1;
        } else {
          a = c+1;
        }
        c = (a+b)/2;
      }
      if(list.get(c).min > list.get(i).max) {
        c--;
      }

      count += c-i;
      if(count > 10000000) {
        return -1;
      }
    }
    return count;
  }

  public static int f2(int[] A) {
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = i+1; j < A.length; j++) {
        if (i + A[i] >= j - A[j]) {
          count++;
        }
      }
    }
    return count;
  }

  public static int f3(int[] A) {
    int N = A.length;
    List<Boundary> list = new ArrayList<Boundary>();
    for(int i = 0; i < N; i++) {
      list.add(new Boundary(i-A[i], false));
      list.add(new Boundary(i+A[i], true));
    }
    Collections.sort(list, new Comparator<Boundary>() {
      @Override
      public int compare(Boundary b1, Boundary b2) {
        return (new Integer(b1.value).compareTo(b2.value));
      }
    });
    int count = 0, ret = 0;
    for(int i = 0; i < 2*N; i++) {
      if(!list.get(i).isEnd) {
        count++;
      } else {
        count--;
        ret += count;
      }
    }
    return ret;
  }
}

class Interval {
  int min, max;
  public Interval(int min, int max) {
    this.min = min;
    this.max = max;
  }
  public String toString() {
    return "("+min+", "+max+")";
  }
}

class Boundary {
  int value;
  boolean isEnd;
  public Boundary(int value, boolean isEnd) {
    this.value = value;
    this.isEnd = isEnd;
  }
}