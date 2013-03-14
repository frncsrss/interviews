package interviews.numbers;

/**
 * Sum function without the + operator.
 * @author Francois Rousseau
 */
public class Sum {
  public static int f(int a, int b) {
    if((a&b) == 0) {  // no carry
      return a^b;
    }
    return f(a^b, (a&b) << 1);  // add the carry that corresponds to (a & b) << 1
  }
}
