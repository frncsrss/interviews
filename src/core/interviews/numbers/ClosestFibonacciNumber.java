package interviews.numbers;

/**
 * Find the smallest number of steps needed to change a given integer into a Fibonacci number.
 *
 * @author Francois Rousseau
 */
public class ClosestFibonacciNumber {
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
}
