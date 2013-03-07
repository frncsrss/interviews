package interviews.strings;

/**
 * Are the parentheses ok?
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
      if(count < 0) {
        return false;
      }
    }
    return (count==0) ? true : false;
  }
}
