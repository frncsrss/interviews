package interviews.strings;

/**
 * Compress string with multiple same consecutive characters, referred as run-length encoding.
 * @author Francois Rousseau
 */
public class Compresser {
  /**
   * Returns the compress string unless it is smaller than the original string.
   */
  public static String f(String s) {
    final StringBuffer buffer = new StringBuffer();
    final char[] arr = s.toCharArray();
    int count = 1;
    for(int i = 0; i < s.length(); i++) {
      while(i < s.length() - 1 && arr[i] == arr[i + 1]) {
        count++;
        i++;
      }
      buffer.append(count);
      buffer.append(arr[i]);
      count = 1;
    }
    if(buffer.length() >= s.length()) {
      return s;
    }
    return buffer.toString();
  }
}
