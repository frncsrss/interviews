package interviews.strings;

/**
 * Compress string with multiple same consecutive characters.
 * @author Francois Rousseau
 */
public class Compresser {
  public static String f(String s) {
    final StringBuffer buffer = new StringBuffer();
    final char[] arr = s.toCharArray();
    int count = 1;
    for(int i = 0; i < s.length(); i++) {
      while(i < s.length()-1
            && arr[i] == arr[i+1]) {
        count++;
        i++;
      }
      buffer.append(arr[i]);
      buffer.append(count);
      count = 1;
    }
    if(buffer.length() >= s.length()) {
      return s;
    }
    return buffer.toString();
  }
}
