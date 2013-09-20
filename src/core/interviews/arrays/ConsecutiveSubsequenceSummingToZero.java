package interviews.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Print all continuous subsequences of an array that sum to 0.
 * @author Francois Rousseau
 */
public class ConsecutiveSubsequenceSummingToZero {
  /**
   * O(n^2 x k) time, O(n) space
   */
  public static void f(int[] arr) {
    final int n = arr.length;
    int[] c = new int[n];  // current column of the "matrix"

    c[0] = arr[0];
    if(c[0] == 0) {
      print(arr, 0, 0);
    }
    for(int j = 1; j < n; j++) {     // column of the "matrix", end of the interval
      for(int i = 0; i <= j; i++) {  // row of the "matrix", start of the interval
        c[i] = c[i] + arr[j];
        if(c[i] == 0) {
          print(arr, i, j);
        }
      }
    }
  }

  /**
   * O(n x k) time, O(n) space
   */
  public static void f2(int[] arr) {
    final int n = arr.length;
    // map of <partial sums, list of indices>
    Map<Integer, List<Integer>> sums = new HashMap<Integer, List<Integer>>();
    int sum = 0;

    // insert an artificial -1 for 0 to force the printing the first time we encounter 0
    List<Integer> indices = new ArrayList<Integer>();
    indices.add(-1);
    sums.put(0, indices);

    for(int i = 0; i < n; i++) {
      sum += arr[i];
      if(sums.containsKey(sum)) {    // the sum has already been seen
        for(int j: sums.get(sum)) {  // print all the combinations of indices
          print(arr, j + 1, i);
        }
      } else {
        sums.put(sum, new ArrayList<Integer>());
      }
      sums.get(sum).add(i);
    }
  }

  /**
   * O(k) time, O(1) space. Assuming average length of a consecutive subsequence is k.
   */
  private static void print(int[] arr, int i, int j) {
    for(int k = i; k <= j; k++) {
      System.out.print(arr[k] + " ");
    }
    System.out.println();
  }
}
