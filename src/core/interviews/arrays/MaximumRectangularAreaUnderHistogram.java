package interviews.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Find the maximum rectangular area under a given histogram.
 * The histogram is considered as a succession of bars (vertical rectangle) of width 1. Hence, we
 * only need to store the heights of each bar and the histogram as an array of integers.
 *
 * @author Francois Rousseau
 */
public class MaximumRectangularAreaUnderHistogram {
  /**
   * 1. For each bar, we want the biggest rectangle containing this bar. So that we can find the
   *    biggest of all. For each bar, we will thus compute the maximum width possible and multiply
   *    it at the end by the height of the bar. The maximum width is the left maximum width + 1 +
   *    the right maximum width.
   * 2. We do it in two passes: from left-to-right to compute the left maximum width and then from
   *    right-to-left for the right maximum width.
   * 3. For each pass, we keep on a stack all the indexes of bars that are shorter than the current
   *    one.
   */
  public static int f(int[] hist) {
    if(hist == null) {
      throw new IllegalArgumentException();
    }
    if(hist.length == 0) {
      return 0;
    }

    Stack<Integer> stack;  // will contain indexes of bars shorter than the current one
    int[] width = new int[hist.length];  // maximum width for each bar
    Arrays.fill(width, 1);  // all intervals should at least be 1 unit wide (the bar itself)

    // left-to-right pass
    stack = new Stack<Integer>();  // left stack
    for(int i = 0; i < hist.length; i++) {
      // pop all the bars (their indexes) until one is shorter in height than the current one
      while(!stack.isEmpty() && hist[i] <= hist[stack.peek()]){
        stack.pop();
      }

      if(stack.isEmpty()) {  // all bars to the left are higher than height[i]
        width[i] += i;
      } else {               // bar at index stack.peek() is the closest shorter bar
        width[i] += i - stack.peek() - 1;
      }

      stack.push(i);        // push current index
    }

    // right-to-left pass
    stack = new Stack<Integer>();  // right stack
    for (int i = hist.length - 1; i >=0; i--) {
      // pop all the bars (their indexes) until one is shorter in height than the current one
      while(!stack.isEmpty() && hist[i] <= hist[stack.peek()]){
        stack.pop();
      }

      if(stack.isEmpty()) {  // all bars to the right are higher than height[i]
        width[i] += hist.length - 1 - i;
      } else {               // bar at index stack.peek() is the closest shorter bar
        width[i] += stack.peek() - i - 1;
      }

      stack.push(i);        // push current index
    }

    // We have the maximum width for each bar so the area of the biggest rectangle containing a bar
    // is just the product of this width and its height. And we take the maximum of all.
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < hist.length; i++){
      // find the maximum value of all rectangle areas
      max = Math.max(max, width[i] * hist[i]);
    }

    return max;
  }
}
