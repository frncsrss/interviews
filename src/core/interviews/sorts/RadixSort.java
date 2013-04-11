package interviews.sorts;

import interviews.arrays.Swap;

/**
 * Radix sort.
 * @author Francois Rousseau
 */
public class RadixSort {

  /**
   * Least-significant-digit-first radix sort.
   * Assume an array of fixed-length strings.
   * Run in O(W x N) time with O(N + R) space. Stable sort.
   * @param R radix (size of the alphabet)
   */
  public static void lsd(String[] a, int R) {
    int N = a.length;
    int W = a[0].length();
    String[] aux = new String[N];

    // do key-indexed counting for each digit from right to left
    for (int d = W - 1; d >= 0; d--) {
      int[] count = new int[R + 1];
      for (int i = 0; i < N; i++) {
        count[a[i].charAt(d) + 1]++;
      }
      for (int r = 0; r < R; r++) {
        count[r + 1] += count[r];
      }
      for (int i = 0; i < N; i++) {
        aux[count[a[i].charAt(d)]++] = a[i];
      }
      for (int i = 0; i < N; i++) {
        a[i] = aux[i];
      }
    }
  }

  /**
   * Most-significant-digit-first radix sort.
   * Run in O(W x N) time with O(N + DR) space. Stable sort.
   * @param R radix (size of the alphabet)
   */
  public static void msd(String[] a, int R) {
    String[] aux = new String[a.length]; 
    msd(a, R, aux, 0, a.length - 1, 0);
    a = aux;
  }

  /**
   * 3-way radix quicksort.
   * Run in O(W x NlogN) time with O(log N + W) space.
   * ~ 2N ln N character compares on average for random strings
   * compared to ~ 2N ln N string compares on average for random strings.
   * @param R radix (size of the alphabet)
   */
  public static void threeWayQuicksort(String[] a, int R) {
    threeWayQuicksort(a, R, 0, a.length - 1, 0);
  }


  /**
   * Overwrite String.toCharAt so that it returns -1 as last character (like \0 in C).
   */
  private static int charAt(String s, int d) {
   if (d < s.length()) return s.charAt(d);
   return -1;
  }

  /**
   * Internal MSD subroutine that recursively sort a subarray (range lo and hi).
   */
  private static void msd(String[] a, int R, String[] aux, int lo, int hi, int d) {
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
   * Internal 3-way radix quicksort subroutine that recursively sort a subarray (range lo and hi).
   */
  private static void threeWayQuicksort(String[] a, int R, int lo, int hi, int d) {
    if (hi <= lo) return;
    int lt = lo, gt = hi;
    int v = charAt(a[lo], d);  // pivot character (not string)
    int i = lo + 1;
    while (i <= gt) {
      int t = charAt(a[i], d);
      if (t < v) Swap.f(a, lt++, i++);
      else if (t > v) Swap.f(a, i, gt--);
      else i++;
    }
    threeWayQuicksort(a, R, lo, lt - 1, d);
    if (v >= 0) threeWayQuicksort(a, R, lt, gt, d + 1);
    threeWayQuicksort(a, R, gt + 1, hi, d);
  }
}
