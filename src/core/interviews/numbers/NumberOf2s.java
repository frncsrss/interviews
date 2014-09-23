package interviews.numbers;

/**
 * Given an integer n, returns the number of 2s that appear in all the numbers from 0 to n
 * (inclusive).
 *
 * @author Francois Rousseau
 */
public class NumberOf2s {
  public static int f(int n) {
    int count = 0;
    int mod = 1;
    while(n >= mod) {
      count += n / (mod * 10) * mod;
      int digit = n / mod % 10;  // current digit
      if(digit == 2) {           // we add part of the mod (what is at the right of the digit)
        count += n % mod + 1;
      } else if(digit > 2) {     // we add the full mod
        count += mod;
      }
      mod *= 10;
    }
    return count;
  }
}
