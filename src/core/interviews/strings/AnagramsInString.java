package interviews.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings a and b, find whether any anagram of string a is a sub-string of string b.
 *
 * For example, given: a = xyz, b = xyazyfdgzyxksldfm then there is a match at index 8.
 *
 * @author Francois Rousseau
 */
public class AnagramsInString {
  /**
   * Let n = length(b) and m = length(a).
   * Time complexity:  O(nm)
   * Space complexity: O(n + m)
   */
  public static int f(String a, String b) {
    if (a == null || b == null || a.length() > b.length()) {
      return -1;
    }

    final int m = a.length();
    final int n = b.length();
    final char[] chars = b.toCharArray();
    final Map<Character, Integer> counts_a = counts(a);

    for(int i = 0; i <= n - m;) {
      // new copy each time we enter the loop (first character or for a character of b not in a)
      int ret = find(chars, i, m, new HashMap<Character, Integer>(counts_a));
      if(ret < 0) {
        i = -ret;
      } else {
        return ret;
      }
    }
    return -1;
  }

  private static Map<Character, Integer> counts(String s) {
    Map<Character, Integer> counts = new HashMap<Character, Integer>();
    for(char c : s.toCharArray()) {
      if(!counts.containsKey(c)) {
        counts.put(c, 1);
      } else {
        counts.put(c, counts.get(c) + 1);
      }
    }
    return counts;
  }

  private static int find(char[] chars, int i, int m, Map<Character, Integer> counts) {
    int j = i;
    while(j - i < m) {
      char c = chars[j];
      if(!counts.containsKey(c)) {  // character of b not in a, we can just move on to (j+1)th in b
        i = j + 1;
        return -i;
      } else if(counts.get(c) == 0) {  // character of b in a but with a zero count
        while(chars[i] != c) {
          counts.put(chars[i], counts.get(chars[i]) + 1);
          i++;
        }
        i++;
      }
      counts.put(c, counts.get(c) - 1);
      j++;
    }
    return i;
  }
}
