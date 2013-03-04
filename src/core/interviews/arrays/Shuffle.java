package interviews.arrays;

import java.util.List;

/**
 * Shuffle uniformly a list in place.
 * @author Francois Rousseau
 */
public class Shuffle {
  public static void f(List<Integer> list) {
    final int n = list.size();
    for(int i = 0; i < n; i++) {
      final int j = (int) (Math.random() * (n-i)) + i;  // we pick a random index between i and n-1
      Swap.f(list, i, j);
    }
  }

  public static void f(int[] arr) {
    final int n = arr.length;
    for(int i = 0; i < n; i++) {
      final int j = (int) (Math.random() * (n-i)) + i;  // we pick a random index between i and n-1
      Swap.f(arr, i, j);
    }
  }
}
