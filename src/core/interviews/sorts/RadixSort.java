package interviews.sorts;

/**
 * Radix sort.
 * @author Francois Rousseau
 */
public class RadixSort {

  /**
   * Least-significant-digit-first radix sort.
   * Assume an array of fixed-length strings.
   * Run in O(W x n). Stable sort.
   * @param R radix (size of the alphabet)
   */
  public static void lsd(String[] arr, int R) {
    int N = arr.length;
    int W = arr[0].length();
    String[] aux = new String[N];

    // do key-indexed counting for each digit from right to left
    for (int d = W-1; d >= 0; d--) {
      int[] count = new int[R + 1];
      for (int i = 0; i < N; i++) {
        count[arr[i].charAt(d) + 1]++;
      }
      for (int r = 0; r < R; r++) {
        count[r + 1] += count[r];
      }
      for (int i = 0; i < N; i++) {
        aux[count[arr[i].charAt(d)]++] = arr[i];
      }
      for (int i = 0; i < N; i++) {
        arr[i] = aux[i];
      }
    }
  }

  /**
   * Most-significant-digit-first radix sort.
   * Run in O(W x n). Stable sort.
   * @param R radix (size of the alphabet)
   */
  public static void msd(String[] arr, int R) {
    String[] aux = new String[arr.length]; 
    msd(arr, R, aux, 0, arr.length - 1, 0);
    arr = aux;
  }

  /**
   * Internal MSD subroutine that recursively sort a subarray (range lo and hi).
   */
  private static void msd(String[] a, int R, String[] aux, int lo, int hi, int d) {
    if (hi <= lo) return;

    // key-indexed counting for the dth digit
    int[] count = new int[R + 2];
    for (int i = lo; i <= hi; i++) {
      count[charAt(a[i], d) + 2]++;
    }
    for (int r = 0; r < R+1; r++) {
      count[r + 1] += count[r];     
    }
    for (int i = lo; i <= hi; i++) {
      aux[count[charAt(a[i], d) + 1]++] = a[i];
    }
    for (int i = lo; i <= hi; i++) {
      a[i] = aux[i - lo];
    }

    // sort R subarrays recursively
    for (int r = 0; r < R; r++) {
      msd(a, R, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }
  }

  /**
   * Overwrite String.toCharAt so that it returns -1 as last character (like \0 in C).
   */
  private static int charAt(String s, int d) {
   if (d < s.length()) return s.charAt(d);
   return -1;
  }
}
