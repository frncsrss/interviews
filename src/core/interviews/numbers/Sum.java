package interviews.numbers;

/**
 * Sum function without the + operator.
 *
 * @author Francois Rousseau
 */
public class Sum {
  public static int f(int a, int b) {
    while(true) {
      final int carry = a&b;
      if(carry == 0) {
        break;
      }
      a = a^b;  // the sum.
      b = carry << 1;  // the carry shifted to the left.
    }
    return a^b;
  }
}
