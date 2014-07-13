package interviews.strings;

/**
 * Perform ROT13 on a string (replace a character by the one 13 letters after in the alphabet).
 *
 * @author Francois Rousseau
 */
public class ROT13 {
  public static String f(String s) {
    StringBuffer sb = new StringBuffer();
    for(char c : s.toCharArray()) {
      if(c >= 'A' && c <= 'Z') {  // uppercase
        sb.append((char)((c - 'A' + 13) % 26 + 'A'));
      } else if(c >= 'a'  && c <= 'z') {  // lowercase
        sb.append((char)((c - 'a' + 13) % 26 + 'a'));
      } else {
        throw new IllegalArgumentException(Character.toString(c));
      }
    }
    return sb.toString();
  }
}
