package interviews.arrays;

/**
 * Find the first covering prefix of a given array.
 * The first covering prefix of an array is the smallest index from which all
 * the elements have already been seen.
 *
 * @author Francois Rousseau
 */
public class CoveringPrefix {
  public static int f(int arr[]) {
    final int N = arr.length;
    final int[] counts = new int[N];

    int count = 0;
    for(int i = 0; i < N; i++) {
      if(counts[arr[i]] == 0) {  // only increment count if we have never encountered this element
        count++;
      }
      counts[arr[i]] = 1;
    }

    if(count == N) {  // all elements are unique
      return N - 1;
    }

    for(int i = 0; i < N; i++) {
      if(counts[arr[i]] == 1) {  // only decrement count if is the first time we see that element
        count--;
      }
      counts[arr[i]] = 2;  // prevent decrementing count the next time we see that element
      if(count == 0) {  // we have seen all the elements at least once
        return i;
      }
    }
    return N;
  }
}
