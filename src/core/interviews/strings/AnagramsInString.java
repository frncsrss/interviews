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


  // prime numbers chosen based on English letter frequency. The more frequent, the lower prime number
  // http://www.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
  private static int[] PRIMES = new int[] {
    2, 41, 37, 47, 3, 67, 71, 23, 5, 101, 61, 17, 19, 13, 31, 43, 97, 29, 11, 7, 73, 83, 79, 89, 59, 53};

  /**
   * Let n = length(b) and m = length(a).
   * Time complexity:  O(n + m)
   * Space complexity: O(n + m)
   *
   * Inspired from Rabin-Karp algorithm for substring matching.
   */
  public static int f2(String a, String b) {
    if (a == null || b == null || a.length() > b.length()) {
      return -1;
    }

    final int m = a.length();
    final int n = b.length();
    final char[] chars = b.toCharArray();

    long golden = hash(a.toCharArray(), m);
    long h = hash(chars, m);

    if(golden == h) {
      return 0;
    }

    for(int i = m; i < n; i++) {
      h = update(h, chars, m, i);
      if(golden == h) {
        return i - m +  1;
      }
    }
    return -1;
  }

  /**
   * Compute the hash of an array s of characters (m first symbols) in linear time.
   * The hash corresponds to a product of prime numbers.
   */
  private static long hash(char[] chars, int m) {
    long h = 1;
    for(int i = 0; i < m; i++) {
      h *= PRIMES[chars[i] - 97];
    }
    return h;
  }

  /**
   * Update the hash value from s[i - M...i - 1] to s[i - M + 1...i].
   * @param h the previous hash value
   * @param chars the array of characters
   * @param m the length of the hash
   * @param i the next index to include
   * @return the new hash value
   */
  private static long update(long h, char[] chars, int m, int i) {
    return h / PRIMES[chars[i - m] - 97] * PRIMES[chars[i] - 97];
  }
}
