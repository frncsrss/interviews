package interviews.strings;

import java.util.Arrays;

/**
 * Suffix array of a string.
 * Linear construction in time and space for Java 6.
 * @author Francois Rousseau
 */
public class SuffixArray {
  private final String[] suffixes;
  private final int N;

  public SuffixArray(String s) {
    N = s.length();
    suffixes = new String[N];
    for(int i = 0; i < N; i++) {
      suffixes[i] = s.substring(i);
    }
    Arrays.sort(suffixes);
  }

  /**
   * Size of string.
   */
  public int length() {
    return N;
  }

  /**
   * Index of ith sorted suffix.
   */
  public int index(int i) {
    return N - suffixes[i].length();
  }

  /**
   * ith sorted suffix/
   */
  public String select(int i) {
    return suffixes[i];
  }

  /**
   * Number of suffixes strictly less than query.
   */
  public int rank(String query) {
    int lo = 0, hi = N - 1;
    while (lo <= hi) {
      int mid = (lo + hi) >>> 1;
      int cmp = query.compareTo(suffixes[mid]);
      if      (cmp < 0) hi = mid - 1;
      else if (cmp > 0) lo = mid + 1;
      else return mid;
    }
    return lo;
  } 

  /**
   * Length of longest common prefix between a and b.
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

  /**
   * Longest common prefix of suffixes(i) and suffixes(i+1).
   */
  public int lcp(int i) {
      return lcp(suffixes[i], suffixes[i + 1]);
  }

  /**
   * Longest common prefix of suffixes(i) and suffixes(j).
   */
  public int lcp(int i, int j) {
      return lcp(suffixes[i], suffixes[j]);
  }
}
