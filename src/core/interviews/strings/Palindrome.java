package interviews.strings;

/**
 * Is this string a palindrome?
 *
 * @author Francois Rousseau
 */
public class Palindrome {

  public static boolean f(String s) {
    return f(s.toLowerCase().toCharArray());
  }

  protected static boolean f(char[] s) {
    final int n = s.length;
    for(int i = 0; i < n / 2; i++) {
      if(s[i] != s[n-1-i]) {
        return false;
      }
    }
    return true;
  }
}
