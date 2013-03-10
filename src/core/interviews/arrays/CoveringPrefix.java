package interviews.arrays;

/**
 * Find the first covering prefix of a given array.
 * The first covering prefix of an array is the smallest index from which all
 * the elements have already been seen.
 * @author Francois Rousseau
 */
public class CoveringPrefix {
  public static int f(int A[]) {
    final int N = A.length;
    final int[] B = new int[N];

    int count=0;
    for(int i = 0; i < N; i++) {
      if(B[A[i]] == 0) {
        count++;
      }
      B[A[i]] = 1;
    }
    if(count == N) {
      return N - 1;
    }

    for(int i = 0; i < N; i++) {
      if(B[A[i]] == 1) {
        count--;
      }
      B[A[i]] = 2;
      if(count == 0) {
        return i;
      }
    }
    return N;
  }
}
