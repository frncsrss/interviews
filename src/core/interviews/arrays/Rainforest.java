package interviews.arrays;

import java.util.Stack;

/**
 * Given an island represented as an array of integer heights, return the amount of rain it can
 * contain.
 *
 * For instance, given the island below, the amount of rain is 21 (number of X).
 *        _       _   _
 *       | |X X X| |X| |
 *      _| |X X X|     |_   _
 *    _|   |X X X|       |X| |_         _
 *  _|     |X X|               |X X X X| |
 * |         |X|                 |X X X| |
 * [1 2 3 5 1 0 2 5 4 5 3 2 3 2 1 0 0 0 2]
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
    for(int i = 1; i < heights.length - 1; i++) {  // no need to check the extreme values
      int left = max(heights, 0, i - 1);
      int right = max(heights, i + 1, heights.length - 1);
      if(left > heights[i] && right > heights[i]) {
        rain += Math.min(left, right) - heights[i];
      }
    }
    return rain;
  }

  /**
   * Find the maximum element in arr[lo...hi] in O(hi - lo) time.
   */
  private static int max(int[] arr, int lo, int hi) {
    int max = Integer.MIN_VALUE;
    while(lo <= hi) {
      max = Math.max(max, arr[lo]);
      lo++;
    }
    return max;
  }

  /**
   * Let n = length(heights).
   * Time complexity:  O(n), elements are visited at most twice
   * Space complexity: O(n), elements are pushed and popped at most once each
   */
  public static int stack(int[] heights) {
    int rain = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for(int i = 0; i < heights.length; i++) {
      while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
        int pop = stack.pop();
        if(stack.isEmpty()) {
          break;
        }
        int height = Math.min(heights[stack.peek()], heights[i]) - heights[pop];
        rain += (i - stack.peek() - 1) * height;
      }
      stack.push(i);
    }
    return rain;
  }
}
