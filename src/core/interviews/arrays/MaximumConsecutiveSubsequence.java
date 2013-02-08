package interviews.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns the longest subsequence of a list with the maximum sum in O(n) time.
 * @author Francois Rousseau
 */
public class MaximumConsecutiveSubsequence {
  public static List<Integer> f(List<Integer> list) {
    int current_sum = list.get(0);
    List<Integer> current_list = new ArrayList<Integer>();
    current_list.add(list.get(0));
    int best_sum = current_sum;
    List<Integer> best_list = new ArrayList<Integer>(current_list);
    for(int i=1; i<list.size(); i++) {
      current_sum += list.get(i);
      if(current_sum <= 0) {
        current_sum = 0;
        current_list.clear();
        continue;
      }
      current_list.add(list.get(i));
      if(current_sum > best_sum) {
        best_sum = current_sum;
        best_list = new ArrayList<Integer>(current_list);
      }
    }
    return best_list;
  }

  public static List<Integer> f(int[] arr) {
    int current_sum = arr[0];
    List<Integer> current_list = new ArrayList<Integer>();
    current_list.add(arr[0]);
    int best_sum = current_sum;
    List<Integer> best_list = new ArrayList<Integer>(current_list);
    for(int i=1; i<arr.length; i++) {
      current_sum += arr[i];
      if(current_sum <= 0) {
        current_sum = 0;
        current_list.clear();
        continue;
      }
      current_list.add(arr[i]);
      if(current_sum > best_sum) {
        best_sum = current_sum;
        best_list = new ArrayList<Integer>(current_list);
      }
    }
    return best_list;
  }
}
