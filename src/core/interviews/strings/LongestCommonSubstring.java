package interviews.strings;

/**
 * Longest common substring between two strings.
 * @author Francois Rousseau
 */
public class LongestCommonSubstring {
  /**
   * Using dynamic programming.
   *
   * Let n = length(str1) and m = length(str2).
   * Time complexity:  O(nm)
   * Space complexity: O(nm)
   */
  public static String f1(String str1, String str2) {
    if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
      return "";
    }

    // ignore case
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    StringBuilder builder = new StringBuilder();
    int[][] num = new int[str1.length()][str2.length()];
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
          int thisSubsBegin = i - num[i][j] + 1;
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

  /**
   * Using suffix array.
   *
   * Let n = length(str1) and m = length(str2).
   * Time complexity:  O(nlogn + mlogm)
   * Space complexity: O(n + m) for Java 6, O(n^2 + m^2) for Java 7
   */
  public static String f2(String str1, String str2) {
    if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
      return "";
    }

    // ignore case
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    final int N1 = str1.length();

    SuffixArray sa = new SuffixArray(str1 + "\0" + str2);
    final int N = sa.length();

    String substring = "";  // longest common substring
    for (int i = 0; i < N - 1; i++) {
      // adjacent suffixes both from second text string
      if (sa.index(i) >= N1 && sa.index(i + 1) >= N1) {
        continue;
      }

      // adjacent suffixes both from first text string
      if (sa.index(i) < N1 && sa.index(i + 1) < N1) {
        continue;
      }

      // longest common substring between adjacent suffixes
      int length = sa.lcp(i);
      // check if it is longer than current longest common substring
      if (length > substring.length()) {
        substring = sa.select(i).substring(0, length);
      }
    }
    return substring;
  }
}
