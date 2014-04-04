package interviews.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of numbers, find the longest subset with consecutive numbers.
 *
 * For example, for A = [5, 1, 9, 3, 8, 20, 4, 10, 2, 11, 3], return [1, 2, 3, 4, 5]
 *
 * @author Francois Rousseau
 */
public class MaximumConsecutiveSubset {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(n)
   */
  public static int[] f(int[] arr) {
    Map<Integer, int[]> map = new HashMap<Integer, int[]>();
    int max_diff = 0;
    int[] max_range = null;

    for(int key : arr) {
      if(map.containsKey(key)) {
        continue;
      }
      int min = key, max = key;
      if(map.containsKey(key - 1) && map.containsKey(key + 1)) {  // found a merge
        min = map.get(key - 1)[0];
        max = map.get(key + 1)[1];
        map.get(key - 1)[1] = max;
        map.get(key + 1)[0] = min;
      } else if(map.containsKey(key - 1)) {  // augmenting the range from the right
        min = map.get(key - 1)[0];
        map.get(key - 1)[1] = key;
      } else if(map.containsKey(key + 1)) {  // augmenting the range from the left
        max = map.get(key + 1)[1];
        map.get(key + 1)[0] = key;
      }
      map.put(key, new int[]{min, max});

      if(max - min > max_diff) {
        max_diff = max - min;
        max_range = map.get(key);
      }
    }

    return max_range;
  }
}
