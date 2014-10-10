package interviews.arrays;

/**
 * New array where A[i] = product (j­i) A[j]
 *
 * @author Francois Rousseau
 */
public class EveryoneExceptMe {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(n)
   */
  public static int[] f(int[] arr) {
    int[] products = new int[arr.length];
    products[0] = 1;
    int product = 1;
    for(int i = 1; i <= arr.length - 1; i++) {
      product *= arr[i - 1];
      products[i] = product;
    }
    product = arr[arr.length - 1];
    for(int i = arr.length - 2; i >= 0; i--) {
      product *= arr[i + 1];
      products[i] *= product;
    }
    return products;
  }

  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int[] f_division(int[] arr) {
    int product = 1;
    for(int i = 0; i < arr.length; i++) {
      product *= arr[i];
    }
    for(int i = 0; i < arr.length; i++) {
      arr[i] = product / arr[i];
    }
    return arr;  // for ease of testing
  }
}
