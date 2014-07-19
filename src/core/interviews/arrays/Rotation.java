package interviews.arrays;

/**
 * In-place rotation (shift) of a circular array by an offset of d.
 *
 * Example: f([7, 1, 5, 2, 4, 3, 0], 3) = [4, 3, 0, 7, 1, 5, 2]
 * 
 * The array is returned for testing purposes.
 *
 * @author Francois Rousseau
 */
public class Rotation {
  public static int[] reversalAlgorithm1(int[] arr, int d) {
    final int n = arr.length;
    d = d % n;  // permutation is done modulo n
    if(n == 0 || d == 0) {
      return arr;
    }
    reverse(arr, 0, n - 1);
    reverse(arr, 0, d - 1);
    reverse(arr, d, n - 1);
    return arr;
  }

  public static int[] reversalAlgorithm2(int[] arr, int d) {
    final int n = arr.length;
    d = d % n;  // permutation is done modulo n
    if(n == 0 || d == 0) {
      return arr;
    }
    reverse(arr, n - d, n - 1);
    reverse(arr, 0, n - d - 1);
    reverse(arr, 0, n - 1);
    return arr;
  }

  public static int[] blockSwap(int[] arr, int d) {
    final int n = arr.length;
    d = d % n;  // permutation is done modulo n
    if(n == 0 || d == 0) {
      return arr;
    }
    int i = d;
    int j = n-d;
    while(i != j) {
      if(i > j) {  // B is shorter
        Swap.f(arr, d - i, d, j);
        i -= j;
      } else { // A is shorter
        Swap.f(arr, d - i, d + j - i, i);
        j -= i;
      }
    }
    // Finally, block swap A and B
    Swap.f(arr, d - i, d, i);
    return arr;
  }

  private static void reverse(int[] arr, int start, int end) {
    while(start < end) {
      Swap.f(arr, start++, end--);
    }
  }
}
