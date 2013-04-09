package interviews.sorts;

/**
 * Key-Indexed Counting.
 * Sort an array a[] of N integers between 0 and R - 1:
 *   1. Count frequencies of each letter using key as index.
 *   2. Compute frequency cumulates which specify destinations.
 *   3. Access cumulates using key as index to move items.
 *   4. Copy back into original array.
 * Run in O(N + R) time and O(N + R) space. Stable sort.
 * @author Francois Rousseau
 */
public class KeyIndexedCounting {

  /**
   * Sort an array a[] of N integers between 0 and R - 1.
   * @param R radix (size of the alphabet)
   */
  public static void f(int[] arr, int R) {
    int N = arr.length;
    int[] count = new int[R + 1];

    // count frequencies of each letter using key as index
    for(int i = 0; i < N; i++) {
      count[arr[i] + 1]++;
    }

    // compute cumulated frequency that specify destinations (offsets)
    for(int r = 0; r < R; r++) {
      count[r + 1] += count[r];
    }

    int[] aux = new int[N];
    // access cumulates using key as index to move items
    for(int i = 0; i < N; i++) {
      aux[count[arr[i]]++] = arr[i];
    }

    // copy back into original array
    for (int i = 0; i < N; i++) {
      arr[i] = aux[i];
    }
  }
}
