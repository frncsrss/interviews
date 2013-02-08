package interviews.numbers;

/**
 * Max function without comparisons.
 * @author Francois Rousseau
 */
public class Max {  
  public static int f(int a, int b) {
    return a + (((a-b)>>31)&1)*(b-a);
  }
}
