package interviews.numbers;

/**
 * Power function in O(logb). Exponentiation by squaring.
 * @author Francois Rousseau
 */
public class Power {
  public static long f(int a, int b) {
    if(b == 0) {
      return 1;
    }
    if (b == 1) {
      return a;
    }
    if(b%2 == 0) {
      return f(a*a, b >> 1);
    }
    return a*f(a*a, b >> 1);
  }
}
