package interviews.arrays;

import java.util.List;

/**
 * Circular permutation of a list/array.
 * @author Francois Rousseau
 */
public class Rotation {
  public static <E> List<E> reversalAlgorithm1(List<E> list, int d) {
    final int n = list.size();
    d = d % n;  // permutation is done modulo n
    if(n == 0 || d == 0) {
      return list;  // for testing purposes
    }
    reverse(list, 0, n - 1);
    reverse(list, 0, d - 1);
    reverse(list, d, n - 1);
    return list;  // for testing purposes
  }

  public static <E> E[] reversalAlgorithm1(E[] arr, int d) {
    final int n = arr.length;
    d = d % n;  // permutation is done modulo n
    if(n == 0 || d == 0) {
      return arr;  // for testing purposes
    }
    reverse(arr, 0, n - 1);
    reverse(arr, 0, d - 1);
    reverse(arr, d, n - 1);
    return arr;  // for testing purposes
  }

  public static <E> List<E> reversalAlgorithm2(List<E> list, int d) {
    final int n = list.size();
    d = d % n;  // permutation is done modulo n
    if(n == 0 || d == 0) {
      return list;  // for testing purposes
    }
    reverse(list, n - d, n - 1);
    reverse(list, 0, n - d - 1);
    reverse(list, 0, n - 1);
    return list;  // for testing purposes
  }

  public static <E> E[] reversalAlgorithm2(E[] arr, int d) {
    final int n = arr.length;
    d = d % n;  // permutation is done modulo n
    if(n == 0 || d == 0) {
      return arr;  // for testing purposes
    }
    reverse(arr, n - d, n - 1);
    reverse(arr, 0, n - d - 1);
    reverse(arr, 0, n - 1);
    return arr;  // for testing purposes
  }

  public static int[] blockSwap(int[] arr, int d) {
    final int n = arr.length;
    d = d % n;  // permutation is done modulo n
    if(n == 0 || d == 0) {
      return arr;  // for testing purposes
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
    return arr;  // for testing purposes    
  }


  private static <E> void reverse(List<E> list, int start, int end) {
    final int middle = (start + end) >>> 1;
    for(int i = start; i < middle + 1; i++) {
      Swap.f(list, i, start + end - i);
    }
  }

  private static <E> void reverse(E[] arr, int start, int end) {
    while(start < end) {
      Swap.f(arr, start++, end--);
    }
  }
}
