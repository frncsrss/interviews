package interviews.numbers;

/**
 * Given two strings a and b of the same length n that consist only of lucky digits (4 and 7).
 * What is the minimum number of operations that are needed to make string a equal to string b?
 * You can only perform operations of two types:
 *   - replace any one digit from string a by its opposite (i.e. replace 4 by 7 and 7 by 4)
 *   - swap any pair of digits in string a
 *
 * @author Francois Rousseau
 */
public class LuckyConversion {
  public static int f(String a, String b) {
    return f(a.toCharArray(), b.toCharArray());
  }

  /**
   * Let n = length(a).
   * Time complexity: O(a)
   * Space complexity: O(1)
   */
  private static int f(char[] a, char[] b) {
    assert a.length == b.length;
    int count_4_to_7 = 0;
    int count_7_to_4 = 0;
    for(int i = 0; i < a.length; i++) {
      if(a[i] == b[i]) {
        continue;
      }
      if(a[i] == '4') {
        count_4_to_7++;
      } else {
        count_7_to_4++;
      }
    }
    return Math.max(count_4_to_7, count_7_to_4);
  }
}
