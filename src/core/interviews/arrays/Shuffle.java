package interviews.arrays;

import java.util.Random;

/**
 * Shuffle uniformly a list/array in place.
 *
 * @author Francois Rousseau
 */
public class Shuffle {
  public static int[] f(int[] arr) {
    return f(arr, new Random());
  }

  /**
   * Known as FisherÐYates shuffle or Knuth shuffle.
   *
   * Each of the n! permutations as equal chance of happening.
   */
  public static int[] f(int[] arr, Random rnd) {
    final int n = arr.length;
    for(int i = n - 1; i >= 0; i--) {
      int j = rnd.nextInt(i + 1);  // we pick a random index between 0 and i
      Swap.f(arr, i, j);
    }
    return arr;  // for ease of testing
  }

  public static String[] f(String[] arr) {
    final int n = arr.length;
    Random rnd = new Random();
    for(int i = n - 1; i >= 0; i--) {
      int j = rnd.nextInt(i + 1);  // we pick a random index between 0 and i
      Swap.f(arr, i, j);
    }
    return arr;  // for ease of testing
  }
}
