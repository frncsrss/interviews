package interviews.strings;

/**
 * Find the longest palindromic substring in a string.
 *
 * @author Francois Rousseau
 */
public class LongestPalindromicSubstring {
  /**
   * Let n be the length of s.
   * Time complexity:  O(n^3)
   * Space complexity: O(1)
   */
  public static String bruteForce(String s) {
    final int n = s.length();
    int best_start = 0;
    int best_length = 1;
    for(int start = 0; start < n - 1; start++) {
      for(int end = start + 1; end < n; end++) {
        if(isPalindrome(s, start, end) && end - start + 1 > best_length) {
          best_start = start;
          best_length = end - start + 1;
        }
      }
    }
    return s.substring(best_start, best_start + best_length);
  }

  /**
   * Check whether a substring is a palindrome. O(n) time.
   */
  private static boolean isPalindrome(String s, int start, int end) {
    while(start < end) {
      if(s.charAt(start++) != s.charAt(end--)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Let n be the length of s.
   * Time complexity:  O(n^2)
   * Space complexity: O(1)
   */
  public static String centerExpansion(String s) {
    final int n = s.length();
    int best_center = 0;
    int best_radius = 1;
    boolean best_even = false;
    for(int center = 1; center < n - 1; center++) {
      int radius = expandAroundCenters(s, center, center);
      if(radius > best_radius) {
        best_center = center;
        best_radius = radius;
        best_even = false;
      }
      radius = expandAroundCenters(s, center, center + 1);
      if(radius > best_radius || !best_even && radius == best_radius) {
        best_center = center;
        best_radius = radius;
        best_even = true;
      }
    }
    if(best_even) {
      return s.substring(best_center - best_radius + 1, best_center + best_radius + 1);
    }
    return s.substring(best_center - best_radius + 1, best_center + best_radius);
  }

  /**
   * Get the length of the longest palindrome from a given pair of centers. O(n) time.
   */
  private static int expandAroundCenters(String s, int center1, int center2) {
    while(center1 >= 0 && center2 < s.length() && s.charAt(center1) == s.charAt(center2)) {
      center1--;
      center2++;
    }
    return (center2 - center1) / 2;
  }
}
