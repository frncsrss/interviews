package interviews.strings;

import interviews.sorts.RadixSort;

/**
 * Find the longest repeated substring in a string.
 * O(D x N x log N) with D length of the lrs and N the length of the string.
 * @author Francois Rousseau
 */
public class LongestRepeatedSubstring {
  public static String f(String s) {
    int N = s.length();

    // array of suffixes - linear time and space in Java
    String[] suffixes = new String[N];
    for (int i = 0; i < N; i++) {
      suffixes[i] = s.substring(i, N);
    }

    // sort suffixes using 3-way radix quicksort
    RadixSort.threeWayQuicksort(suffixes, 256);

    // compute length of longest common prefix between consecutive suffixes
    String lrs = "";
    for (int i = 0; i < N - 1; i++) {
      int len = lcp(suffixes[i], suffixes[i + 1]);
      if (len > lrs.length()) {
        lrs = suffixes[i].substring(0, len);
      }
    }
    return lrs;
  }

  /**
   * Length of the longest common prefix between two Strings.
   */
  private static int lcp(String a, String b) {
    int i = 0;
    int length = Math.min(a.length(), b.length());
    while(a.charAt(i) == b.charAt(i)) {
      i++;
      if(i == length) {
        break;
      }
    }
    return i;
  }
}
