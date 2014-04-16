package interviews.arrays;

/**
 * Given an island represented as an array of integer heights, return the amount of rain it can
 * contain.
 *        _       _   _
 *       | |X X X| |_| |
 *      _| |X X X|     |_   _
 *    _|   |X X _|       |_| |_
 *  _|     |_ X|               |_
 * |         |_|                 |
 * [0 1 2 4 1 0 2 4 3 4 2 1 2 1 0]
 *
 * @author Francois Rousseau
 */
public class Rainforest {
  /**
   * Let n = length(heights).
   * Time complexity:  O(n^2)
   * Space complexity: O(1)
   */
  public static int bruteforce(int[] heights) {
    int rain = 0;
    for(int i = 0; i < heights.length; i++) {
      int left = max(heights, 0, i - 1);
      int right = max(heights, i + 1, heights.length - 1);
      if(left > heights[i] && right > heights[i]) {
        rain += Math.min(left, right) - heights[i];
      }
    }
    return rain;
  }

  /**
   * Find the maximum element in heights[lo...hi] in O(hi - lo) time.
   */
  private static int max(int[] heights, int lo, int hi) {
    int max = 0;
    for(int i = lo; i <= hi; i++) {
      if(heights[i] > max) {
        max = heights[i];
      }
    }
    return max;
  }
}
