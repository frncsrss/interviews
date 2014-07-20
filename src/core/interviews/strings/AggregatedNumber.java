package interviews.strings;

/**
 * Find if a a given string forms an aggregated number. That is, a number which digits can be
 * divided into several parts, and the later part is the sum of the former parts.
 *
 * Example:
 *   112358 --> 1+1=2, 1+2=3, 2+3=5, 3+5=8 (Fibonacci sequence)
 *   122436 --> 12+24=36
 *   1299111210 --> 12+99=111, 99+111=210
 *   112112224 --> 112+112=224
 *
 * @author Francois Rousseau
 */
public class AggregatedNumber {
  public static boolean f(String s) {
    return f(s, 0);
  }

  private static boolean f(String s, int i) {
    // we try to sum s[i...j[ with s[j...k[
    for(int j = i + 1; j - i <= s.length() / 2; j++) {
      for(int k = j + 1; k - j <= s.length() / 2; k++) {
        String sum = Integer.toString(
            Integer.parseInt(s.substring(i, j)) + Integer.parseInt(s.substring(j, k)));
        if(k + sum.length() > s.length()) {  // the sum goes beyond the rest of the string
          break;
        }
        String next = s.substring(k, k + sum.length());
        if(k + sum.length() <= s.length() && sum.equals(next)) {
          if(k + sum.length() == s.length()) {
            return true;
          }
          boolean ret = f(s, j);  // s[i...j[ + s[j...k[ = s[k...], we start again at j
          if(ret) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
