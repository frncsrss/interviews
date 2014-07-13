package interviews.strings;

/**
 * Replace and resize a substring in a string.
 * For example, replace whitespaces with %20.
 *
 * @author Francois Rousseau
 */
public class Replacer {
  public static String escapeWhitespace(String s) {
    final char[] str = s.toCharArray();
    int count = countSpace(str);
    if(count == 0) {
      return s;
    }
    final char[] arr = new char[s.length()+2*count];
    for(int i = 0; i < s.length(); i++) {
      arr[i] = str[i];
    }
    return escapeWhitespace(arr, s.length());
  }

  private static String escapeWhitespace(char[] str, int length) {
    int index = str.length-1;
    for(int i = length-1; i >= 0; i--) {
      if(str[i] != ' ') {
        str[index--] = str[i];
      } else {
        str[index--] = '0';
        str[index--] = '2';
        str[index--] = '%';
      }
    }
    return new String(str);
  }

  private static int countSpace(char[] str) {
    int count = 0;
    for(int i = 0; i < str.length; i++) {
      if(str[i] == ' ') {
        count++;
      }
    }
    return count;
  }
}
