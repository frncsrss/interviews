package interviews.strings;

/**
 * Longest common substrings between two strings.
 * @author Francois Rousseau
 */
public class LongestCommonSubstring {
  public static String f(String str1, String str2) {
    if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
      return "";
    }

    // ignore case
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    StringBuilder builder = new StringBuilder();
    final int[][] num = new int[str1.length()][str2.length()];
    int bestSoFar = 0;
    int lastSubsBegin = 0;

    for (int i = 0; i < str1.length(); i++) {
      for (int j = 0; j < str2.length(); j++) {
        if (str1.charAt(i) != str2.charAt(j)) {
          continue;
        }

        if (i == 0 || j == 0) {
           num[i][j] = 1;
        } else {
           num[i][j] = 1 + num[i - 1][j - 1];
        }

        if (num[i][j] > bestSoFar) {
          bestSoFar = num[i][j];
          // generate substring from str1 => i
          final int thisSubsBegin = i - num[i][j] + 1;
          if (lastSubsBegin == thisSubsBegin) {
             //if the current LCS is the same as the last time this block ran
             builder.append(str1.charAt(i));
          } else {
             //this block resets the string builder if a different LCS is found
             lastSubsBegin = thisSubsBegin;
             builder = new StringBuilder();
             builder.append(str1.substring(thisSubsBegin, i + 1));
          }
        }
      }
    }
    return builder.toString();
  }
}
