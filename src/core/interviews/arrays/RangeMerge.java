package interviews.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of ranges, with a start and an end. Both start and end are >= 0 and <= 2^32-1.
 * Combine any overlapping (or touching) ranges together, and return the final merged ranges.
 * These ranges are circular. So, if you have a range from [100, 10] and another from [0, 50],
 * these 2 ranges would be combined into [100, 50].
 *
 * @author Francois Rousseau
 */
public class RangeMerge {
  private static final Comparator<int[]> COMPARATOR_START_VALUE = new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
      if(o1[0] > o2[0]) return +1;
      if(o1[0] < o2[0]) return -1;
      if(o1[1] > o2[1]) return +1;
      if(o1[1] < o2[1]) return -1;
      return 0;
    }
  };

  /**
   * Let n = length(ranges).
   * Time complexity:  O(nlogn)
   * Space complexity: O(n)
   */
  public static List<int[]> f(int[][] ranges) {

    // expand any range of the form [a, b] with b < a into [0, b] and [a, Integer.MAX_VALUE]
    List<int[]> expanded = new ArrayList<int[]>();
    for(int[] range : ranges) {
      if(range[0] <= range[1]) {
        expanded.add(range);
      } else {
        expanded.add(new int[]{0, range[1]});
        expanded.add(new int[]{range[0], Integer.MAX_VALUE});
      }
    }
    Collections.sort(expanded, COMPARATOR_START_VALUE);

    List<int[]> merged = new ArrayList<int[]>();
    int[] current = expanded.get(0);
    for(int i = 1; i < expanded.size(); i++) {
      if(current[1] >= expanded.get(i)[0] - 1) {  // merge if overlapping or touching
        current[1] = Math.max(current[1], expanded.get(i)[1]);
      } else {
        merged.add(current);
        current = expanded.get(i);
      }
    }

    // we may have to merge the current range with the first if they are touching
    if(current[1] == Integer.MAX_VALUE && !merged.isEmpty() && merged.get(0)[0] == 0) {
      merged.get(0)[0] = current[0];
    } else {
      merged.add(current);
    }
    return merged;
  }
}
