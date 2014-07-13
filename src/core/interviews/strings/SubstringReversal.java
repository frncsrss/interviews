package interviews.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a String s. The string can have up to 2500 characters.
 *
 * You have to reverse exactly one substring of s. Formally, you have to choose two 0-based indices
 * {x,y} such that x <= y, and then you have to reverse the order of the letters with indices x
 * through y, inclusive. That is, S[x]S[x+1]...S[y] becomes S[y]...S[x+1]S[x].
 *
 * For example, if s="abcdefg", you can choose the indices {2,5} to obtain "abfedcg", the indices
 * {0,1} to obtain "bacdefg", or the indices {3,3} to obtain "abcdefg". (In the last example, only
 * one letter was selected, so the string did not change.)
 *
 * Your goal is to produce the lexicographically smallest string possible. Return a int[] containing
 * two elements: the optimal indices x and y. If there are multiple optimal choices, find the one
 * with the smallest x. If there are still multiple optimal choices, find the one with the smallest
 * y.
 *
 * @author Francois Rousseau
 */
public class SubstringReversal {

  public static int[] f(String s) {
    char[] arr = s.toCharArray();

    int first = 0;  // first element lesser than its predecessor
    while(first < arr.length - 1 && arr[first] <= arr[first + 1]) {
      first++;
    }

    if(first == arr.length - 1) {  // increasing all along, e.g., aabbcc
      return new int[] {0, 0};
    }
    first++;

    // find minimum character in arr[first...end] - there may be multiple matches stored in indices
    char min = 'z';
    List<Integer> indices = new ArrayList<Integer>();
    for(int i = first; i < arr.length; i++) {
      if(arr[i] < min) {
        indices.clear();
        min = arr[i];
      }
      if(arr[i] == min) {
        indices.add(i);
      }
    }

    int x = 0;

    // find the position of min in arr[0...first - 1], which is sorted in increasing order
    // because multiple characters in a sequence could match min and we want binary search to return
    // us the last index, we look for min + 1.
    x = Arrays.binarySearch(arr, 0, first, (char)(min + 1));
    if (x < 0) {  // x is not in arr[0...first - 1] but the method still gives us its position
      x = -x - 1;
    }

    // find the best y among all the potential indices.
    outer: {
      for(int i = 1; i < arr.length; i++) {
        List<Integer> retained_indices = new ArrayList<Integer>();
        char current_min = 'z';
        for(int potential_y : indices) {
          if(potential_y - i < x) {  // we hit up to x for this y so we choose it
            indices.clear();
            indices.add(potential_y);
            break outer;
          }
          if(arr[potential_y - i] < current_min) {
            retained_indices.clear();
            current_min = arr[potential_y - i];
          }
          if(arr[potential_y - i] == current_min) {
            retained_indices.add(potential_y);
          }
        }
        indices = retained_indices;
        if(indices.size() == 1) {  // no need to go further, only one y remaining
          break;
        }
      }
    }  // at that point indices contains only one element
    int y = indices.get(0);

    return new int[] {x, y};
  }
}
