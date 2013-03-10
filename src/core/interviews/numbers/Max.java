package interviews.numbers;

/**
 * Max function without comparisons.
 * @author Francois Rousseau
 */
public class Max {  
  public static int f(int a, int b) {
    // (a - b) >> 31 corresponds to the leftmost bit (sign bit)
    // ((a - b) >> 31) & 1 is 0 if it is positive (a >= b), 1 if it is negative (a < b)
    return a + (((a - b) >> 31) & 1) * (b - a);
  }
}
