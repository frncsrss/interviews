package interviews.numbers;

/**
 * Roman numerals to integer converter.
 * @author Francois Rousseau
 */
public class RomanNumeralToInteger {
  /**
   * Does not complain if 3 is written iiv or 15 vvv for example.
   */
  public static int f(String s) {
    if(s == null || s.isEmpty()) {
      throw new IllegalArgumentException();
    }

    int[] arr = new int[s.length()];
    for(int i = 0; i < s.length(); i++) {
      arr[i] = letterToInt(s.charAt(i));
    }

    int n = 0;
    int acc = arr[0];
    for(int i = 1; i < arr.length; i++) {
      if(arr[i - 1] == arr[i]) {
        acc += arr[i];
      } else if(arr[i - 1] < arr[i]) {
        acc = arr[i] - acc;
      } else {
        n += acc;
        acc = arr[i];
      }
    }
    n += acc;
    return n;
  }

  private static int letterToInt(char c) {
    switch(c) {
      case 'i':
      case 'I': return 1;
      case 'v':
      case 'V': return 5;
      case 'x':
      case 'X': return 10;
      case 'l':
      case 'L': return 50;
      case 'c':
      case 'C': return 100;
      case 'd':
      case 'D': return 500;
      case 'm':
      case 'M': return 1000;
      default: throw new NumberFormatException();
    }
  }
}
