package interviews.numbers;

/**
 * Given an integer, returns its least significant bit.
 *
 * Example:
 *   11 (1011)  --> 1 (1)
 *   20 (10100) --> 4 (100)
 *   136 (10001000) --> 8 (1000)
 *
 * @author Francois Rousseau
 */
public class LeastSignificantBit {
  public static int f(int n) {
    return (n ^ n - 1) & n;
  }
}
