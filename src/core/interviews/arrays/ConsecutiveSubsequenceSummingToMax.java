package interviews.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Return the longest subsequence of a list with the maximum sum in O(n) time.
 * @author Francois Rousseau
 */
public class MaximumConsecutiveSubsequence {
  public static List<Integer> f(List<Integer> list) {
    int i = 0;
    int max = Integer.MIN_VALUE;
    for(; i < list.size(); i++) {  // we loop until we find a positive value
      final int e = list.get(i);
      if(e > 0) {
        break;
      }
      if(e > max) {
        max = e;
      }
    }
    if(i == list.size()) {  // there were only negative numbers
      return Arrays.asList(max);  // the maximum sum is obtained with the highest value only
    }

    int current_sum = list.get(i);  // first positive value
    List<Integer> current_list = new ArrayList<Integer>();
    current_list.add(current_sum);
    int best_sum = current_sum;
    List<Integer> best_list = new ArrayList<Integer>(current_list);
    for(i++; i < list.size(); i++) {
      final int e = list.get(i);
      current_sum += e;
      // when the current sum becomes negative, there is no need to take it into account anymore
      // we flush and move on
      if(current_sum <= 0) {
        current_sum = 0;
        current_list.clear();
        continue;
      }
      current_list.add(e);
      // we only update the best sum if the current sum is greater than it
      if(current_sum > best_sum) {
        best_sum = current_sum;
        best_list = new ArrayList<Integer>(current_list);
      }
    }
    return best_list;
  }

  public static List<Integer> f(int[] arr) {
    int i = 0;
    int max = Integer.MIN_VALUE;
    for(; i < arr.length; i++) {  // we loop until we find a positive value
      final int e = arr[i];
      if(e > 0) {
        break;
      }
      if(e > max) {
        max = e;
      }
    }
    if(i == arr.length) {  // there were only negative numbers
      return Arrays.asList(max);  // the maximum sum is obtained with the highest value only
    }

    int current_sum = arr[i];  // first positive value
    List<Integer> current_list = new ArrayList<Integer>();
    current_list.add(current_sum);
    int best_sum = current_sum;
    List<Integer> best_list = new ArrayList<Integer>(current_list);
    for(i++; i < arr.length; i++) {
      final int e = arr[i];
      current_sum += e;
      // when the current sum becomes negative, there is no need to take it into account anymore
      // we flush and move on
      if(current_sum <= 0) {
        current_sum = 0;
        current_list.clear();
        continue;
      }
      current_list.add(e);
      // we only update the best sum if the current sum is greater than it
      if(current_sum > best_sum) {
        best_sum = current_sum;
        best_list = new ArrayList<Integer>(current_list);
      }
    }
    return best_list;
  }
}
