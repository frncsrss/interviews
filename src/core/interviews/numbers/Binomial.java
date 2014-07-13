package interviews.numbers;

/**
 * Various n choose k or (k..n) implementations.
 *
 * @author Francois Rousseau
 */
public class Binomial {
  /**
   * Returns (k..n) in O(n^2) time, O(n) space.
   */
  public static long f_n2(int n, int k) {
    if(k < 0 || k > n) {
      return 0;
    }
    if (k > n-k) {  // we use the symmetry property
      k = n-k;
    }
    if(k == 0) {
      return 1;
    }
    if(k == 1) {
      return n;
    }
    long[] b_n = new long[n + 1];  // hold the current line of Pascal's triangle
    b_n[0] = 1;  // (0..n) = 1
    b_n[1] = 1;  // (1..1) = 1
    for(int i = 2 ; i < n; i++) {
      b_n[i] = 1;
      b_n[i-1] = i;
      for(int j=i-2;j>1;j--) {  // we go backwards so we can overwrite without problems
        b_n[j] += b_n[j-1];  // (k..n) = (k-1..n-1) + (k..n-1)
      }
      b_n[1] = i;
    }
    for(int j = n - 1; j >= n - k; j--) {  // for the last line, we can stop once we have b_n[n-k]
      b_n[j] += b_n[j - 1];
    }
    return b_n[n-k];
  }

  /**
   * Returns (k..n) in O(nk) time, O(n) space.
   */
  public static long f_nk(int n, int k) {
    if(k < 0 || k > n) {
      return 0;
    }
    if (k > n-k) {  // we use the symmetry property
      k = n-k;
    }
    if(k == 0) {
      return 1;
    }
    if(k == 1) {
      return n;
    }
    long[] b_n = new long[n+1];  // hold the current line of Pascal's triangle
    b_n[0] = 1;  // (0..n) = 1
    b_n[1] = 1;  // (1..1) = 1
    for(int i = 2; i <= n; i++) {
      b_n[i] = 1;
      b_n[i-1] = i;
      // we go backwards so we can overwrite without problems.
      // we also know we don't need more than k values.
      // hence the O(nk) complexity.
      for(int j = i - 2, count = 0; j > 1 && count < k; j--, count++) {
        b_n[j] += b_n[j-1];  // (k..n) = (k-1..n-1) + (k..n-1)
      }
      b_n[1] = i;
    }
    return b_n[n-k];
  }

  /**
   * Returns (k..n) in O(k) time, O(1) space.
   */
  public static long f_k(int n, int k) {
    if(k < 0 || k > n) {
      return 0;
    }
    if (k > n-k) {  // we use the symmetry property
      k = n-k;
    }
    if(k == 0) {
      return 1;
    }
    if(k == 1) {
      return n;
    }
    long ret = 1;
    for(int i = 1; i <= k; i++) {
      ret *= n - k + i;  // could be n--
      ret /= i;
    }
    return ret;
  }
}
