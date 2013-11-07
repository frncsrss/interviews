package interviews.strings;

/**
 * Let a=1, b=2, c=3,....z=26.
 * Given a string, find all possible codes that string can generate.
 * Give a count as well as print the strings.
 *
 * For example:
 * Input: "1123". You need to general all valid alphabet codes from this string.
 * Output List:
 * aabc //a = 1, a = 1, b = 2, c = 3
 * kbc // since k is 11, b = 2, c= 3
 * alc // a = 1, l = 12, c = 3
 * aaw // a= 1, a =1, w= 23
 * kw // k = 11, w = 23
 *
 * @author Francois Rousseau
 */
public class Coder {
  public static int f(String s) {
    if(s == null || s.isEmpty()) {
      return 0;
    }
    int[] count = new int[1];
    f(s, count, new StringBuilder(), 0, 1);
    return count[0];
  }

  private static void f(String s, int[] count, StringBuilder builder, int i, int j) {
    if(i >= s.length()) {  // we hit the last digit, print and increment counter
      System.out.println(builder);
      count[0]++;
      return;
    }
    int n = Integer.parseInt(s.substring(i, j));
    if(n < 1 || n > 26) {
      return;
    }
    builder.append((char)(n + 96));
    if(i + 1 == j) {
      f(s, count, builder, i + 1, j + 1);
    } else {  // if we were in a double digit number, we need to shift by 2
      f(s, count, builder, i + 2, i + 3);
    }
    builder.deleteCharAt(builder.length() - 1);
    // consider the current digit for a double digit number
    if(i + 1 == j                 // can't be already a double digit number
        && (n == 1 || n == 2)     // the first digit has to be a 1 or a 2
        && i < s.length() - 1) {  // can't be the last digit in the input number
      f(s, count, builder, i, i + 2);
    }
  }
}
