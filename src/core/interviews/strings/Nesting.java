package interviews.strings;

/**
 * Are the parentheses ok, i.e. for each open paretheses there is a closing one?
 *
 * @author Francois Rousseau
 */
public class Nesting {
  public static boolean f(String s) {
    final char[] arr = s.toCharArray();
    int count = 0;
    for(int i = 0; i < s.length(); i++) {
      if(arr[i] == '(') {
        count++;
      } else if(arr[i] == ')') {
        count--;
      }
      if(count < 0) {  // closing parentheses before an open one
        return false;
      }
    }
    return count == 0 ? true : false;
  }
}
