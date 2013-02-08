package interviews.strings;

/**
 * Check if a string is a substring of another.
 * @author Francois Rousseau
 */
public class Substring {
  /**
   * Check if a string is a substring of another in O(n*m).
   * @return the index of first match if it exists.
   */
  public static int strstrBruteForce(String s, String p) {
    return strstrBruteForce(s.toCharArray(), p.toCharArray());
  }

  /**
   * Check if a string is a substring of another in O(n*m).
   * @return the index of first match if it exists.
   */
  public static int strstrBruteForce(char[] s, char[] p) {
    for(int i=0; i<s.length - p.length + 1; i++) {  // up to n-m times
      int k = i;
      int j = 0;
      while(s[k++] == p[j++]) {  // up to m times
        if(j == p.length) {
          return i;
        }
      }
    }  // overall up to n*m times
    return -1;
  }

  /**
   * Check if a string is a substring of another in O(n + m).
   * Rely on the Knutt-Morris-Pratt algorithm.
   * @return the index of first match if it exists.
   */
  public static int strstrKMP(String s, String p) {
    return strstrKMP(s.toCharArray(), p.toCharArray());
  }

  /**
   * Check if a string is a substring of another in O(n + m).
   * Rely on the Knutt-Morris-Pratt algorithm.
   * @return the index of first match if it exists.
   */
  public static int strstrKMP(char[] s, char[] p) {
    final int[] t = getPrefixTable(p);
    int i = 0;  // position in text
    int j = 0;  // position in pattern

    while(i < s.length) {  // iterate over the entire text - O(n)
      while (j >= 0 && p[j] != s[i]) {
        j = t[j];
      }
      // at this point either j==0 (back to the beginning) or p[j] == s[i]
      i++;
      j++;
      if (j == p.length) {  // we got what we wanted
        return i - p.length;
      }
    }
    return -1;
  }

  /**
   * Returns for each position the longest prefix matching a suffix in the
   * substring before that position.
   * @return the prefix table.
   */
  public static int[] getPrefixTable(char[] p) {
    final int[] t = new int[p.length + 1];
    int i = 0;  // position in pattern
    int j = -1; // length of the current prefix

    // set the first element to -1
    t[i] = j;

    while(i < p.length) {  // iterate over the entire pattern - O(m)
      while(j >= 0  && p[j] != p[i]) {
        j = t[j];  // rollback to the longest prefix for the prefix
      }
      // at this point either j==0 or p[j] == p[i]
      i++;
      j++;
      t[i] = j;
    }
    return t;
  }
}
