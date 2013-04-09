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
   * @param W length of a string
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
        count[r+1] += count[r];
      }
      for (int i = 0; i < N; i++) {
        aux[count[arr[i].charAt(d)]++] = arr[i];
      }
      for (int i = 0; i < N; i++) {
        arr[i] = aux[i];
      }
    }
  }
}
