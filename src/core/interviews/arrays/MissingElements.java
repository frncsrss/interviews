package interviews.arrays;

/**
 * Given an array of n-k integers between 1 and n, return the k missing elements.
 *
 * @author Francois Rousseau
 */
public class MissingElements {
  public static int f(int[] arr, int n) {
    assert arr.length == n - 1;
    long sum = 0;
    for(int i : arr) {
      sum += i;
    }
    return (int) (n * (n + 1) / 2 - sum);
  }

  public static int[] f2(int[] arr, int n) {
    assert arr.length == n - 2;
    long sum = 0;
    long sum2 = 0;
    for(int i : arr) {
      sum += i;
      sum2 += i * i;
    }
    int s = (int) (n * (n + 1) / 2 - sum);  // a + b
    int s2 = (int) (n * (n + 1) * (2 * n + 1) / 6 - sum2);  // a^2 + b^2
    int b = (int) (s / 2.0 + Math.sqrt(s2 / 2.0 - s * s /4.0));  // b > a
    int a = s - b;
    return new int[]{a, b};
  }
}
