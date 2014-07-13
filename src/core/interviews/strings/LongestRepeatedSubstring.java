package interviews.strings;

/**
 * Find the longest repeated substring in a string.
 *
 * @author Francois Rousseau
 */
public class LongestRepeatedSubstring {
  /**
   * O(D x N x log N) time with D length of the lrs and N the length of the string.
   */
  public static String f(String s) {
    int N = s.length();

    SuffixArray sa = new SuffixArray(s);

    // compute length of longest common prefix between consecutive suffixes
    String lrs = "";
    for (int i = 0; i < N - 1; i++) {
      int len = sa.lcp(i);
      if (len > lrs.length()) {
        lrs = sa.select(i).substring(0, len);
      }
    }
    return lrs;
  }
}
