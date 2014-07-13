package interviews.numbers;

/**
 * Various Fibonacci sequence implementations.
 *
 * @author Francois Rousseau
 */
public class Fibonacci {
  /**
   * Top-down recursion based on the mathematical recurrence relation.
   * Quite inefficient as the same value gets computed multiple times.
   */
  public static long f1(int n) {
    if(n == 0) {
      return 0;
    }
    if(n == 1) {
      return 1;
    }
    return f1(n-1) + f1(n-2);
  }

  /**
   * Top-down dynamic programming.
   * Uses an array to store the values already computed.
   */
  public static long f2(int n) {
    final long[] arr = new long[n + 2];
    arr[0] = 0;
    arr[1] = 1;
    return f2(n, arr);
  }

  private static long f2(int n, final long[] arr) {
    if(n > 1 && arr[n] == 0) {
      arr[n] = f2(n-1, arr) + f2(n-2, arr);
    }
    return arr[n];
  }

  /**
   * Bottom-up dynamic programming.
   * The most effective version as it only stores the previous two values.
   */
  public static long f3(int n) {
    if(n == 0) {
      return 0;
    }
    if(n == 1) {
      return 1;
    }
    long back1 = 1, back2 = 0;
    long current;
    for(int i = 2; i < n; i++) {
      current = back1 + back2;
      back2 = back1;
      back1 = current;
    }
    return back1 + back2;
  }
}
