package interviews.arrays;

import interviews.lib.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2-sum. Find pairs of elements of an array summing to a given value.
 *
 * @author Francois Rousseau
 */
public class TwoSum {
  public static List<Pair<Integer, Integer>> findAll(int[] array, int sum) {
    return findAll(array, sum, false);
  }

  public static List<Pair<Integer, Integer>> findAll(int[] array, int sum, boolean unique) {
    Collections.shuffle(java.util.Arrays.asList(array));  // shuffling to prevent quicksort edge cases.
    Arrays.sort(array);  // quicksort O(n*log(n))
    int lower = 0;
    int higher = array.length-1;
    List<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer,Integer>>();
    while(lower < higher) {
      final int s = array[lower] + array[higher];
      if(s == sum) {
        int nb_start = 1;
        int nb_end = 1;
        while(lower < higher && array[lower] == array[lower+1]) {
          nb_start++;
          lower++;
        }
        while(lower < higher && array[higher] == array[higher-1]) {
          nb_end++;
          higher--;
        }
        if(unique) {
          pairs.add(new Pair<Integer, Integer>(array[lower], array[higher]));
        } else {
          int nb_total = nb_start*nb_end;
          while(nb_total-- > 0) {
            pairs.add(new Pair<Integer, Integer>(array[lower], array[higher]));
          }
        }
        lower++;
        higher--;
      } else if(s < sum) {
        lower++;
      } else {
        higher--;
      }
    }
    return pairs;
  }
}