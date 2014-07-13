package interviews.numbers;

/**
 * Power function implementation.
 *
 * @author Francois Rousseau
 */
public class Power {
  /**
   * Compute a^b using exponentiation by squaring. O(logb) time.
   */
  public static long f(int a, int b) {
    if(b == 0) {
      return 1;
    }
    if(b%2 == 0) {
      return f(a*a, b >> 1);
    }
    return a*f(a*a, b >> 1);
  }
}
