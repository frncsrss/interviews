package interviews.numbers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals to integer converter.
 * @author Francois Rousseau
 */
public class RomanNumeralToInteger {
  /**
   * Does not complain if 3 is written iiv or 15 vvv for example.
   * Goes from left to right (works with a stream of characters, needs an accumulator).
   */
  public static int f(String s) {
    if(s == null || s.isEmpty()) {
      throw new IllegalArgumentException();
    }
    int n = 0;
    int acc = 0;
    int prev = 0;
    for(int i = 0; i < s.length(); i++) {
      int val = letterToInt(s.charAt(i));
      if(prev == val) {
        acc += val;
      } else if(prev < val) {
        acc = val - acc;
      } else {
        n += acc;
        acc = val;
      }
      prev = val;
    }
    n += acc;
    return n;
  }

  /**
   * Does not complain if 3 is written iiv or 15 vvv for example.
   * Goes from right to left (does NOT work with a stream of characters, no need for an accumulator).
   */
  public static int f2(String s) {
    if(s == null || s.isEmpty()) {
      throw new IllegalArgumentException();
    }
    int n = 0;
    int prev = 0;
    for(int i = s.length() - 1; i >= 0; i--) {
      int val = letterToInt(s.charAt(i));
      if(val < prev) {
        n -= val;
      } else {
        n += val;
        prev = val;
      }
    }
    return n;
  }

  private static final Map<Character, Integer> letterToInt;
  static {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('i', 1);
    map.put('I', 1);
    map.put('v', 5);
    map.put('V', 5);
    map.put('x', 10);
    map.put('X', 10);
    map.put('l', 50);
    map.put('L', 50);
    map.put('c', 100);
    map.put('C', 100);
    map.put('d', 500);
    map.put('D', 500);
    map.put('m', 1000);
    map.put('M', 1000);
    letterToInt = Collections.unmodifiableMap(map);
  }

  private static int letterToInt(char c) {
    if(letterToInt.containsKey(c)) {
      return letterToInt.get(c);
    }
    throw new NumberFormatException();
  }
}
