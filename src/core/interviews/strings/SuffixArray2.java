package interviews.strings;

/**
 * Suffix array of a string.
 * @author Francois Rousseau
 */
public class SuffixArray2 {
  private final String s;
  private final int[] suffixes;
  private final int N;

  /**
   * Let n = length(s).
   * Time complexity:  O(n)
   * Space complexity: O(n)
   */
  public SuffixArray2(String s) {
    this.s = s;
    N = s.length();
    suffixes = new int[N];
    for(int i = 0; i < N; i++) {
      suffixes[i] = i;
    }
    sort();
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
    return suffixes[i];
  }

  /**
   * ith sorted suffix.
   */
  public String select(int i) {
    return s.substring(suffixes[i]);
  }

  /**
   * Length of longest common prefix of suffixes[i] and suffixes[i+1].
   */
  public int lcp(int i) {
    return lcp(i, i + 1);
  }

  /**
   * Length of longest common prefix of suffixes[i] and suffixes[j].
   */
  public int lcp(int i, int j) {
    return lcp(s, suffixes[i], suffixes[j]);
  }


  /**
   * Overwrite String.toCharAt so that it returns -1 as last character (like \0 in C).
   */
  private int charAt(int i, int d) {
    if (i + d < N) return s.charAt(i + d);
    return -1;
  }

  /**
   * Internal MSD subroutine that recursively sort a subarray (range lo and hi).
   */
  private void msd(int[] a, int R, int[] aux, int lo, int hi, int d) {
    if (hi <= lo) return;

    // key-indexed counting for the dth digit
    int[] count = new int[R + 2];
    for(int i = lo; i <= hi; i++) {
      count[charAt(a[i], d) + 2]++;
    }
    for(int r = 0; r < R+1; r++) {
      count[r + 1] += count[r];
    }
    for(int i = lo; i <= hi; i++) {
      aux[count[charAt(a[i], d) + 1]++] = a[i];
    }
    for(int i = lo; i <= hi; i++) {
      a[i] = aux[i - lo];
    }

    // sort R subarrays recursively
    for(int r = 0; r < R; r++) {
      msd(a, R, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }
  }

  /**
   * Sort the suffix array using most-significant-digit radix sort in O(n) time and O(n) space.
   */
  private void sort() {
    int[] aux = new int[N];
    msd(suffixes, 256, aux, 0, N - 1, 0);
  }


  /**
   * Length of longest common prefix between a and b.
   */
  private static int lcp(String s, int i, int j) {
    int k = 0;
    int length = s.length() - Math.max(i, j);
    while(s.charAt(i + k) == s.charAt(j + k)) {
      k++;
      if(k == length) {
        break;
      }
    }
    return k;
  }
}
