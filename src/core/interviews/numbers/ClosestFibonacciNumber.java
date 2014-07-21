package interviews.numbers;

import java.util.Arrays;

/**
 * Find the smallest number of steps needed to change a given integer into a Fibonacci number.
 *
 * 1 <= n <= 1,000,000
 *
 * @author Francois Rousseau
 */
public class ClosestFibonacciNumber {
  /**
   * At most 32 steps.
   */
  public static int f(int n) {
    if(n == 0 || n == 1 || n == 2) {
      return 0;
    }
    int f_2 = 0;
    int f_1 = 1;
    while(true) {
      int f = f_1 + f_2;
      if(Math.abs(n - f) > Math.abs(n - f_1)) {
        return Math.abs(n - f_1);
      }
      f_2 = f_1;
      f_1 = f;
    }
  }

  private static final int[] NUMBERS = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
    987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229,
    832040, 1346269};

  /**
   * At most 5 steps.
   */
  public static int f2(int n) {
    if(n == 0 || n == 1 || n == 2) {
      return 0;
    }
    int index = Arrays.binarySearch(NUMBERS, n);
    if(index < 0) {
      return Math.min(Math.abs(n - NUMBERS[-index - 1]), Math.abs(n - NUMBERS[-index - 2]));
    }
    return 0;
  }

}
