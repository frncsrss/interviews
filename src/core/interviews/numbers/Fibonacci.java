package interviews.numbers;

/**
 * Fibonacci sequence from recursion to dynamic programming.
 * @author Francois Rousseau
 */
public class Fibonacci {
  public static long f1(int n) {
    if(n == 0) {
      return 0;
    }
    if(n == 1) {
      return 1;
    }
    return f1(n-1) + f1(n-2);
  }
  
  public static long f2(int n) {
    final long[] arr = new long[50];
    arr[0] = 0;
    arr[1] = 1;
    return fibonacci_2(n, arr);
  }

  protected static long fibonacci_2(int n, final long[] arr) {
    if(n > 1 && arr[n] == 0) {
      arr[n] = fibonacci_2(n-1, arr) + fibonacci_2(n-2, arr);
    }
    return arr[n];
  }

  public static long f3(int n) {
    if(n == 0) {
      return 0;
    }
    if(n == 1) {
      return 1;
    }
    long back1 = 1, back2 = 0;
    long current;
    for(int i = 2;i < n; i++) {
      current = back1 + back2;
      back2 = back1;
      back1 = current;
    }
    return back1 + back2;
  }
}
