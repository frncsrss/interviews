package interviews.strings;

/**
 * Perform ROT13 on a string (replace a character by the one 13 letters after).
 * @author Francois Rousseau
 */
public class ROT13 {
  public static String f(String s) {
    StringBuffer sb = new StringBuffer();
    for(char c : s.toCharArray()) {
      if(c > 64 && c < 91) {  // uppercase
        sb.append((char)((c - 'A' + 13) % 26 + 'A'));
      } else if(c > 96 && c < 123) {  // lowercase
        sb.append((char)((c - 'a' + 13) % 26 + 'a'));
      } else {
        throw new IllegalArgumentException(Character.toString(c));
      }
    }
    return sb.toString();
  }
}
