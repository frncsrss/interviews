package interviews.strings;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Returns the longest string consisting of a composition of the other strings
 * in the list.
 * @author Francois Rousseau
 */
public class LongestComposition {
  public static String f(List<String> list) {
    Collections.sort(list, new Comparator<String>() {
      public int compare(String s1, String s2) {
        return new Integer(s2.length()).compareTo(s1.length());
      }
    });
    for(String s: list) {
      if(numberOfWords(list, s, 0) > 0) {
        return s;
      }
    }
    return null;
  }
  
  public static int numberOfWords(List<String> list, String s, int start) {
    for(int i = start + 1; i <= s.length(); i++) {
      final String current = s.substring(start, i);
      if(s.equals(current) || !list.contains(current)) {
        continue;
      }
      if(i == s.length()) {
        return 1;
      }
      final int res = numberOfWords(list, s, i);
      if(res > 0) {
        return res + 1;
      }
    }
    return 0;
  }
}
