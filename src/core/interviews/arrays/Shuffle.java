package interviews.arrays;

import java.util.List;
import java.util.Random;

/**
 * Shuffle uniformly a list/array in place.
 *
 * @author Francois Rousseau
 */
public class Shuffle {
  public static long seed = -1;

  public static void f(List<Integer> list) {
    final int n = list.size();
    Random rnd = seed == -1 ? new Random() : new Random(seed);
    for(int i = 0; i < n; i++) {
      int j = rnd.nextInt(n - i) + i;  // we pick a random index between i and n-1
      Swap.f(list, i, j);
    }
  }

  public static void f(int[] arr) {
    final int n = arr.length;
    Random rnd = seed == -1 ? new Random() : new Random(seed);
    for(int i = 0; i < n; i++) {
      int j = rnd.nextInt(n - i) + i;  // we pick a random index between i and n-1
      Swap.f(arr, i, j);
    }
  }
}
