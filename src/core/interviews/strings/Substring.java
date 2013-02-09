package interviews.strings;

/**
 * Returns the first index where a pattern p appears in a string s.
 * @author Francois Rousseau
 */
public class Substring {
  /**
   * Returns the first index where a pattern p appears in a string s in O(n*m).
   * @return the index of first match if it exists.
   */
  public static int strstrBruteForce(String s, String p) {
    return strstrBruteForce(s.toCharArray(), p.toCharArray());
  }

  /**
   * Returns the first index where a pattern p appears in a string s in O(n*m).
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
   * Returns the first index where a pattern p appears in a string s in O(n + m).
   * Rely on the Knutt-Morris-Pratt algorithm. Explained below.
   * @return the index of first match if it exists.
   */
  public static int strstrKMP(String s, String p) {
    return strstrKMP(s.toCharArray(), p.toCharArray());
  }

  /**
   * Returns the first index where a pattern p appears in a string s in O(n + m).
   * Rely on the Knutt-Morris-Pratt algorithm. Explained below.
   * @return the index of first match if it exists.
   */
  public static int strstrKMP(char[] s, char[] p) {
    final int[] t = getPrefixTable(p);
    int i = 0;  // position in text
    int j = 0;  // position in pattern

    while(i < s.length) {  // iterate over the entire text - O(n)
      while(j >= 0 && p[j] != s[i]) {
        j = t[j];  // instead of shifting the window by 1, we shift the window by t[j] + 1
      }
      // at this point either j==0 (back to the beginning) or p[j] == s[i]
      i++;
      j++;
      if(j == p.length) {  // we got what we wanted
        return i - p.length;
      }
    }
    return -1;
  }

  /**
   * Computes the length of the longest prefix matching a suffix for every substring of p
   * and returns a prefix table t as follows:
   * t[i] == length of the longest prefix matching a suffix in p[0..i-1]
   * with t[0] == -1 (see above).
   * 
   * @return the index of first match if it exists.
   */
  protected static int[] getPrefixTable(char[] p) {
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

  /**
   * Returns the first index where a pattern p appears in a string s in O(n + m).
   * Rely on the Knutt-Morris-Pratt algorithm. Explained below.
   * @return the index of first match if it exists.
   */
  public static int strstrKMP2(String s, String p) {
    return strstrKMP2(s.toCharArray(), p.toCharArray());
  }

  /**
   * Returns the first index where a pattern p appears in a string s in O(n + m).
   * 
   * Rely on the Knutt-Morris-Pratt algorithm. Explained below.
   * For example, consider:
   * i   0123456789
   * s = abcdab abc (i=0)
   * p = abcdabd    (j=0)
   * j   0123456
   * 
   * The first mismatch occurs at j==6.
   * Considering p[0..5], the length of the longest prefix matching a suffix is 2 ("ab").
   * Therefore, you should move i from 0 to 4 (6-2) but start j at 2 since we already know that the
   * first 2 characters are matching (this is why the complexity is O(n) and not O(n*m)).
   * i   0123456789
   * s = abcdab abc  (i=4)
   * p =     abcdabd (j=2)
   * j       0123456
   * 
   * Computing the length of the longest prefix matching a suffix for every substring of p doesn't
   * depend on s and is therefore pre-computed and stored in a prefix table t as follows:
   * t[i] == length of the longest prefix matching a suffix in p[0..i-1]
   * with t[0] == -1 to increment i if mismatch at first character (we slide by j - t[j]).
   * 
   * @return the index of first match if it exists.
   */
  public static int strstrKMP2(char[] s, char[] p) {
    final int[] t = getPrefixTable2(p);
    int i = 0;  // position in text
    int j = 0;  // position in pattern

    while(i+j < s.length) {  // iterate over the entire text - O(n)
      if(s[i+j] == p[j]) {
        if (j == p.length - 1) {  // reached the end of the pattern - we got what we wanted
          return i;
        }
        j++;  // otherwise move along to the next character
      } else {
        i += j - t[j];  // sliding in s by j - t[j]
        if(j > 0) {
          j = t[j];  // starting at t[j] in p - prevents the matching of already seen characters
        }  // for j==0, t[j] = -1 so we need j to remains equal to 0
      }
    }
    return -1;
  }

  /**
   * Computes the length of the longest prefix matching a suffix for every substring of p
   * and returns a prefix table t as follows:
   * t[i] == length of the longest prefix matching a suffix in p[0..i-1]
   * with t[0] == -1 (see above).
   * 
   * @return the index of first match if it exists.
   */
  protected static int[] getPrefixTable2(char[] p) {
    final int[] t = new int[p.length];
    t[0] = -1;  // special value for the KMP algorithm
    t[1] = 0;  // we consider only proper prefix/suffix so p[0] doesn't contain any

    int i = 2;  // position in pattern
    int len = 0; // length of the current prefix

    while(i < p.length) {  // iterate over the entire pattern - O(m)
      if(p[i-1] == p[len]) {  // we have one more match
        len++;
        t[i++] = len;  // set the length and move along to the next character
      } else if(len > 0) {  // mismatch but still smaller prefixes to try
        len = t[len];  // rollback to the second longest prefix for the prefix and try again
      } else {  // mismatch for the first character
        t[i++] = 0;  // set the length and move along to the next character
      }
    }
    return t;
  }
}
