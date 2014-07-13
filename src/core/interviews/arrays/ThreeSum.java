package interviews.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 3-sum. Find triples of elements of an array summing to 0.
 *
 * @author Francois Rousseau
 */
public class ThreeSum {
  public static List<Integer> find(List<Integer> list) {
    Collections.sort(list);
    for(int i = 0; i < list.size() - 3; i++) {
      int lower = i+1;
      int higher = list.size()-1;
      while(lower < higher) {
        long sum = list.get(i) + list.get(lower) + list.get(higher);
        if(sum == 0) {
          return Arrays.asList(list.get(i), list.get(lower), list.get(higher));
        } else if(sum > 0) {
          higher--;
        } else {
          lower++;
        }
      }
    }
    return null;
  }

  public static int[] find(int[] arr) {
    Arrays.sort(arr);
    for(int i = 0; i < arr.length - 3; i++) {
      int lower = i+1;
      int higher = arr.length-1;
      while(lower < higher) {
        final long sum = arr[i] + arr[lower] + arr[higher];
        if(sum == 0) {
          return new int[]{arr[i], arr[lower], arr[higher]};
        } else if(sum > 0) {
          higher--;
        } else {
          lower++;
        }
      }
    }
    return null;
  }

  public static List<int[]> findAll(int[] arr) {
    return findAll(arr, false);
  }

  public static List<int[]> findAll(int[] arr, boolean unique) {
    Arrays.sort(arr);
    List<int[]> triples = new ArrayList<int[]>();
    for(int i = 0; i < arr.length - 3; i++) {
      int lower = i+1;
      int higher = arr.length-1;
      while(lower < higher) {
        final long sum = arr[i] + arr[lower] + arr[higher];
        if(sum == 0) {
          int nb_lower = 1;
          int nb_higher = 1;
          while(lower < higher && arr[lower] == arr[lower+1]) {
            nb_lower++;
            lower++;
          }
          while(lower < higher && arr[higher] == arr[higher-1]) {
            nb_higher++;
            higher--;
          }
          if(unique) {
            triples.add(new int[]{arr[i], arr[lower], arr[higher]});
          } else {
            int nb_total = nb_lower*nb_higher;
            while(nb_total-- > 0) {
              triples.add(new int[]{arr[i], arr[lower], arr[higher]});
            }
          }
          lower++;
          higher--;
        } else if(sum > 0) {
          higher--;
        } else {
          lower++;
        }
      }
    }
    return triples;
  }

  public static int count(int[] arr) {
    return count(arr, false);
  }

  public static int count(int[] arr, boolean unique) {
    int count = 0;
    Arrays.sort(arr);
    for(int i = 0; i < arr.length - 3; i++) {
      int lower = i+1;
      int higher = arr.length-1;
      while(lower < higher) {
        final long sum = arr[i] + arr[lower] + arr[higher];
        if(sum == 0) {
          int nb_lower = 1;
          int nb_higher = 1;
          while(lower < higher && arr[lower] == arr[lower+1]) {
            nb_lower++;
            lower++;
          }
          while(lower < higher && arr[higher] == arr[higher-1]) {
            nb_higher++;
            higher--;
          }
          if(unique) {
            count++;
          } else {
            count += nb_lower*nb_higher;
          }
          lower++;
          higher--;
        } else if(sum > 0) {
          higher--;
        } else {
          lower++;
        }
      }
    }
    return count;
  }
}
