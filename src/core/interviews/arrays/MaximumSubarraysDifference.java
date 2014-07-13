package interviews.arrays;

/**
 * Given an array of integers, return the two subarrays with maximum difference in terms of sum.
 *
 * @author Francois Rousseau
 */
public class MaximumSubarraysDifference {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(n)
   */
  public static int[][] f(int[] arr) {
    // we will be using arrays of size 3 to store value, start and end indexes
    int[][] leftMax = new int[arr.length][3];  // maximum in arr[0...i]
    int[][] leftMin = new int[arr.length][3];  // minimum in arr[0...i]
    leftMax[0] = new int[]{arr[0], 0, 0};
    leftMin[0] = new int[]{arr[0], 0, 0};
    int currentMax = leftMax[0][0];
    int currentMin = -leftMin[0][0];  // basically max of -arr but leftMin do store the min
    for(int i = 1; i < arr.length; i++) {
      currentMax += arr[i];
      if(currentMax > 0) {
        if(currentMax > leftMax[i - 1][0]) {
          leftMax[i] = new int[]{currentMax, leftMax[i - 1][1], i};
        } else {
          leftMax[i] = leftMax[i - 1];
        }
      } else {
        leftMax[i] = leftMax[i - 1];
        currentMax = 0;
      }

      currentMin += -arr[i];
      if(currentMin > 0) {
        if(currentMin > -leftMin[i - 1][0]) {
          leftMin[i] = new int[]{-currentMin, leftMin[i - 1][1], i};
        } else {
          leftMin[i] = leftMin[i - 1];
        }
      } else {
        leftMin[i] = new int[]{arr[i], i, i};
        currentMin = 0;
      }
    }

    int len = arr.length - 1;
    int[][] rightMax = new int[arr.length][3];  // maximum in arr[i+1...n-1]
    int[][] rightMin = new int[arr.length][3];  // minimum in arr[i+1...n-1]
    rightMax[len] = new int[]{arr[len], len, len};
    rightMin[len] = new int[]{arr[len], len, len};
    currentMax = rightMax[len][0];
    currentMin = -rightMin[len][0];
    for(int i = len - 1; i >= 0; i--) {
      currentMax += arr[i];
      if(currentMax > 0) {
        if(currentMax > rightMax[i + 1][0]) {
          rightMax[i] = new int[]{currentMax, i, rightMax[i + 1][2]};
        } else {
          rightMax[i] = rightMax[i + 1];
        }
      } else {
        rightMax[i] = rightMax[i + 1];
        currentMax = 0;
      }

      currentMin += -arr[i];
      if(currentMin > 0) {
        if(currentMin > -rightMin[i + 1][0]) {
          rightMin[i] = new int[]{-currentMin, i, rightMin[i + 1][2]};
        } else {
          rightMin[i] = leftMin[i + 1];
        }
      } else {
        rightMin[i] = new int[]{arr[i], i, i};
        currentMin = 0;
      }
    }

    int max_diff = Integer.MIN_VALUE, max_start = -1, max_end = -1, min_start = -1, min_end = -1;
    for(int i = 0; i <= len; i++) {
      int diff1 = Math.abs(leftMax[i][0] - rightMin[i][0]);
      int diff2 = Math.abs(leftMin[i][0] - rightMax[i][0]);
      if(diff1 > diff2 && diff1 > max_diff) {
        max_diff = diff1;
        min_start = rightMin[i][1];
        min_end = rightMin[i][2];
        max_start = leftMax[i][1];
        max_end = leftMax[i][2];
      } else if(diff2 >= diff1 && diff2 > max_diff) {
        max_diff = diff2;
        min_start = leftMin[i][1];
        min_end = leftMin[i][2];
        max_start = rightMax[i][1];
        max_end = rightMax[i][2];
      }
    }

    // handle special case when only positive/negative integers
    if(min_end == max_start) {
      max_diff -= Math.abs(arr[max_start]);
      if(max_end - max_start > 1) {
        max_start++;
      } else {
        min_end--;
      }
    } else if(max_end == min_start) {
      max_diff -= Math.abs(arr[max_end]);
      if(max_end - max_start > 1) {
        max_end--;
      } else {
        min_start++;
      }
    }

    return new int[][]{new int[]{min_start, min_end}, new int[]{max_start, max_end}};
  }
}
