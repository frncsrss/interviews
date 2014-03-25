package interviews.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words, group together anagrams.
 *
 * For example, given: `man car kile arc none like`,
 * print:
 * man
 * car arc
 * kile like
 * none
 *
 * @author Francois Rousseau
 */
public class Anagrams {
  // prime numbers chosen based on English letter frequency. The more frequent, the lower prime number
  // http://www.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
  private static int[] PRIMES = new int[] {
    2, 41, 37, 47, 3, 67, 71, 23, 5, 101, 61, 17, 19, 13, 31, 43, 97, 29, 11, 7, 73, 83, 79, 89, 59, 53};

  public enum METHOD {
    SORT() {
      /**
       * O(mlogm) time, O(m) if bin sort.
       */
      @Override
      String getKey(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
      }
    },
    PRIME() {
      /**
       * O(m) time, but arbitrarily large words will require arbitrarily large integers.
       */
      @Override
      String getKey(String s) {
        int p = 1;
        for(char c : s.toCharArray()) {
          p *= PRIMES[c - 97];
        }
        return Integer.toString(p);  // for consistency with the other method
      }
    };
    abstract String getKey(String s);
  };

  /**
   * Let n = number of strings and m = average length of a string.
   * Time complexity:  O(nm)
   * Space complexity: O(nm)
   *
   * Uses an hashmap with keys computed using the specified method and values the list of words
   * sharing the same key, i.e. begin anagrams.
   */
  public static Collection<List<String>> f(String[] words, METHOD m) {
    if(words == null || words.length == 0) {
      return null;
    }
    Map<String, List<String>> groups = new HashMap<String, List<String>>();
    for(String word : words) {
      String key = m.getKey(word);
      if(!groups.containsKey(key)) {
        groups.put(key, new ArrayList<String>());
      }
      groups.get(key).add(word);
    }
    return groups.values();
  }
}
