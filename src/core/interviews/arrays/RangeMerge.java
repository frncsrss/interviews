package interviews.arrays;

import java.util.ArrayList;
import java.util.Arrays;
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

  public static List<int[]> f(int[][] ranges) {
    Arrays.sort(ranges, COMPARATOR_START_VALUE);
    List<int[]> merged = new ArrayList<int[]>();
    int[] current = ranges[0];
    for(int i = 1; i < ranges.length; i++) {
      if(current[1] >= ranges[i][0]) {
        current[1] = Math.max(current[1], ranges[i][1]);
      } else {
        merged.add(current);
        current = ranges[i];
      }
    }
    merged.add(current);
    return merged;
  }
}
