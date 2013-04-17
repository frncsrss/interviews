package interviews.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Returns the first index where a pattern p appears in a string s.
 * @author Francois Rousseau
 */
public class Substring {

  public static enum TYPE {
    BRUTE_FORCE {
      public int strstr(char[] s, char[] p) {
        return strstrBruteForce(s, p);
      }
    }, KNUTH_MORRIS_PRATT_1 {
      public int strstr(char[] s, char[] p) {
        return strstrKMP1(s, p);
      }
    }, KNUTH_MORRIS_PRATT_2 {
      public int strstr(char[] s, char[] p) {
        return strstrKMP2(s, p);
      }
    }, KNUTH_MORRIS_PRATT_3 {
      public int strstr(char[] s, char[] p) {
        return strstrKMP3(s, p);
      }
    }, BOYER_MOORE {
      public int strstr(char[] s, char[] p) {
        return strstrBM(s, p);
      }
    };

    public abstract int strstr(char[] s, char[] p);
  };

  /**
   * Return the first index where a pattern p appears in a string s in O(n*m).
   */
  public static int strstr(String s, String p, TYPE type) {
    return type.strstr(s.toCharArray(), p.toCharArray());
  }


  /**
   * Return the first index where a pattern p appears in a string s in O(n*m).
   */
  private static int strstrBruteForce(char[] s, char[] p) {
    int i = 0;  // position in text
    int j = 0;  // position in pattern

    for(; i < s.length - p.length + 1; i++) {  // up to n-m+1 times
      j = 0;
      while(s[i+j] == p[j++]) {  // up to m times
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
  private static int strstrKMP1(char[] s, char[] p) {
    int[] t = getPrefixTable1(p);
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
   * Compute the length of the longest prefix matching a suffix for every substring of p
   * and returns a prefix table t as follows:
   * t[i] == length of the longest prefix matching a suffix in p[0..i-1]
   * with t[0] == -1 (see above).
   */
  protected static int[] getPrefixTable1(char[] p) {
    int[] t = new int[p.length + 1];
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
   * Return the first index where a pattern p appears in a string s in O(n + m).
   * 
   * Rely on the Knutt-Morris-Pratt algorithm. Explained below.
   * For example, consider:
   * i   0123456789
   * s = abcdab abc (i = 0)
   * p = abcdabd    (j=0)
   * j   0123456
   * 
   * The first mismatch occurs at j==6.
   * Considering p[0..5], the length of the longest prefix matching a suffix is 2 ("ab").
   * Therefore, you should move i from 0 to 4 (6-2) but start j at 2 since we already know that the
   * first 2 characters are matching (this is why the complexity is O(n) and not O(n*m)).
   * i   0123456789
   * s = abcdab abc  (i = 4)
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
  private static int strstrKMP2(char[] s, char[] p) {
    int[] t = getPrefixTable2(p);
    int i = 0;  // position in text
    int j = 0;  // position in pattern

    while(i+j < s.length) {       // iterate over the entire text - O(n)
      if(s[i+j] == p[j]) {
        if (j == p.length - 1) {  // reached the end of the pattern - we got what we wanted
          return i;
        }
        j++;            // otherwise move along to the next character
      } else {
        i += j - t[j];  // sliding in s by j - t[j]
        if(j > 0) {
          j = t[j];     // starting at t[j] in p - prevents the matching of already seen characters
        }               // for j==0, t[j] = -1 so we need j to remains equal to 0
      }
    }
    return -1;
  }

  /**
   * Compute the length of the longest prefix matching a suffix for every substring of p
   * and returns a prefix table t as follows:
   * t[i] == length of the longest prefix matching a suffix in p[0..i-1]
   * with t[0] == -1 (see above).
   */
  protected static int[] getPrefixTable2(char[] p) {
    final int[] t = new int[p.length];
    t[0] = -1;  // special value for the KMP algorithm
    t[1] = 0;   // we consider only proper prefix/suffix so p[0] doesn't contain any

    int i = 2;   // position in pattern
    int len = 0; // length of the current prefix

    while(i < p.length) {     // iterate over the entire pattern - O(m)
      if(p[i-1] == p[len]) {  // we have one more match
        len++;
        t[i++] = len;         // set the length and move along to the next character
      } else if(len > 0) {    // mismatch but still smaller prefixes to try
        len = t[len];         // rollback to the second longest prefix for the prefix and try again
      } else {                // mismatch for the first character
        t[i++] = 0;           // set the length and move along to the next character
      }
    }
    return t;
  }


  /**
   * Return the first index where a pattern p appears in a string s in O(n + m).
   * Rely on the Knutt-Morris-Pratt algorithm with Deterministic finite state automaton (DFA).
   */
  private static int strstrKMP3(char[] s, char[] p) {
    Map<Character, int[]> dfa = getDFA(p);

    int i, j; 
    for(i = 0, j = 0; i < s.length && j < p.length; i++) {
      if(dfa.containsKey(s[i])) {
        j = dfa.get(s[i])[j];
      } else {
        j = 0;
      }
    }
    if(j == p.length) return i - j; 
    else return -1; 
  }

  /**
   * Build the Deterministic finite state automaton (DFA) from the pattern p.
   *
   * Match transition: if in state j and next char c == p[j], go to j + 1.
   * Mismatch transition: if in state j and next char c != p[j],
   *   then the last j-1 characters of input are pat[1..j-1], followed by c.
   *   To compute dfa[c][j]: simulate p[1..j-1] (state X) on DFA and take transition c.
   */
  private static Map<Character, int[]> getDFA(char[] p) {
    Map<Character, int[]> dfa = new HashMap<Character, int[]>();
    for(int j = 0; j < p.length; j++) {  // initialize an empty dfa with the alphabet from p
      dfa.put(p[j], new int[p.length]);
    }
    dfa.get(p[0])[0] = 1; 
    for(int X = 0, j = 1; j < p.length; j++) { 
      for(char c: dfa.keySet()) {  // copy mismatch cases
        dfa.get(c)[j] = dfa.get(c)[X];
      }
      dfa.get(p[j])[j] = j+1;     // set match case
      X = dfa.get(p[j])[X];       // update restart state
    }
    return dfa;
  }


  /**
   * Return the first index where a pattern p appears in a string s in O(n + m).
   * Rely on the Boyer-Moore algorithm.
   */
  private static int strstrBM(char[] s, char[] p) {
    Map<Character, Integer> right = getRight(p);

    int skip; 
    for(int i = 0; i <= s.length - p.length; i += skip) {
      skip = 0;
      for(int j = p.length - 1; j >= 0; j--) {
        if(p[j] != s[i + j]) {
          if(right.containsKey(s[i + j])) {  // character in pattern
            skip = Math.max(1, j - right.get(s[i + j]));            
          } else {
            skip = Math.max(1, j + 1);
          }
          break;
        }
      }
      if(skip == 0) return i;  // match
    }
    return -1;
  }

  /**
   * Precompute index of rightmost occurrence of character c in pattern.
   */
  private static Map<Character, Integer> getRight(char[] p) {
    Map<Character, Integer> right = new HashMap<Character, Integer>();
    for(int j = 0; j < p.length; j++) { 
      right.put(p[j], j);
    }
    return right;
  }
}
