package interviews.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the first covering prefix of a given array.
 * The first covering prefix of an array is the smallest index from which all
 * the elements have already been seen.
 *
 * @author Francois Rousseau
 */
public class CoveringPrefix {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(n)
   */
  public static int f(int arr[]) {
    if(arr.length == 0) {
      return -1;
    }

    Set<Integer> seen = new HashSet<Integer>();
    int last_first = 0;
    for(int i = 0; i < arr.length; i++) {
      if(!seen.contains(arr[i])) {
        seen.add(arr[i]);
        last_first = i;
      }
    }
    return last_first;
  }
}
