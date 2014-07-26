package interviews.numbers;

/**
 * Given an integer, returns the next integer containing the same digits.
 *
 * Example:
 *   217650  --> 250167
 *   3276510 --> 3501267
 *   12301 --> 12310
 *
 * @author Francois Rousseau
 */
public class NextNumberSameDigits {
  /**
   * Let d be the number of digits.
   * Time complexity:  O(d)
   * Space complexity: O(d)
   */
  public static int f(int n) {
    char[] digits = Integer.toString(n).toCharArray();
    // will hold the rightmost index for which the digit is less than the next one
    int ii = digits.length - 2;
    for(; ii >= 0; ii--) {
      if(digits[ii] < digits[ii + 1]) {
        break;
      }
    }

    if(ii == -1) {
      return n;
    }

    // will hold the leftmost index for which the digit is less than the one in ii
    int jj = ii;
    for(; jj < digits.length - 1; jj++) {
      if(digits[jj + 1] <= digits[ii]) {
        break;
      }
    }
    swap(digits, ii, jj);
    reverse(digits, ii + 1, digits.length - 1);
    return Integer.parseInt(new String(digits));
  }

  private static void swap(char[] arr, int i, int j) {
    if(i == j) {
      return;
    }
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  private static void reverse(char[] arr, int start, int end) {
    while(start < end) {
      swap(arr, start++, end--);
    }
  }
}
