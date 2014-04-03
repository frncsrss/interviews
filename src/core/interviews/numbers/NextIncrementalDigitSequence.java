package interviews.numbers;

import java.util.NoSuchElementException;

/**
 * Given an integer, returns an integer that satisfies the following conditions:
 *  1. positive integer
 *  2. no repeated digits: 123 (valid), 122 (invalid)
 *  3. incremental digit sequence: 1234 (valid), 1243 (invalid)
 *  4. smallest one greater than the input
 *
 *  Example: 987 -> 1234, 3599 -> 3678
 *
 * @author Francois Rousseau
 */
public class NextIncrementalDigitSequence {
  private static int MAX_VALUE = first(9);  // 123456789

  /**
   * Let n be the number of digits.
   * Time complexity:  O(n)
   * Space complexity: O(n)
   */
  public static int f(int n) {
    if(n <= 0) {
      return 1;
    }
    if(n < 9) {
      return n + 1;
    }

    n++;  // we assume we want the next even if the input number meets the requirements
    char[] chars = Integer.toString(n).toCharArray();
    final int d = chars.length;

    if(d > 9) {
      throw new NoSuchElementException();
    }

    if(d == 9) {
      if(n > MAX_VALUE) {
        throw new NoSuchElementException();
      } else {
        return MAX_VALUE;
      }
    }

    int[] digits = new int[d];
    for(int i = 0; i < d; i++) {
      digits[i] = chars[i] - '0';
    }

    return f(digits, 1, d);
  }

  /**
   * @param digits: the current digits
   * @param i: the current index considered in digits
   * @param zero: the first position from which all numbers in digits can be considered as zeros
   */
  private static int f(int[] digits, int i, int zero) {
    // index 0 is a special for which we may need to return the first integer with one more digit
    if(i == 0 && digits[i] + digits.length - i - 1 > 9) {
      return first(digits.length + 1);
    }

    // the sequence must be strictly increasing, zero indicates that the number has been cleared
    if(i > 0 && digits[i] <= digits[i - 1] || i >= zero) {
      digits[i] = digits[i - 1] + 1;
    }

    // no space left for a strictly increasing sequence of digits, go back
    if(digits[i] + digits.length - i - 1 > 9) {
      digits[i - 1]++;
      return f(digits, i - 1, i);
    }

    // we were successful, return final number
    if(i == digits.length - 1) {
      return digitsToInt(digits);
    }

    // move on to the next one
    return f(digits, i + 1, zero);
  }

  private static int first(int d) {
    StringBuffer sb = new StringBuffer();
    for(int i = 1; i <= d; i++) {
      sb.append(i);
    }
    return Integer.parseInt(sb.toString());
  }

  private static int digitsToInt(int[] digits) {
    StringBuffer sb = new StringBuffer();
    for(int j = 0; j < digits.length; j++) {
      sb.append(digits[j]);
    }
    return Integer.parseInt(sb.toString());
  }
}
