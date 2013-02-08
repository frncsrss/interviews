package interviews.strings;

import java.math.BigInteger;

import interviews.lib.PrimeNumber;

/**
 * Are all the characters in String b appearing in String a?
 * @author Francois Rousseau
 */
public class Subsequence {
  public static boolean f(String a, String b, int method) {
    switch(method) {
      case 0:
        return isSubSequenceWithPrimeNumbers(a, b);
      case 1:
        return isSubSequenceWithBitManipulation(a, b);
      case 2:
        return isSubSequenceWithCounterArray(a, b);
      default:
        return false;
    }
  }
  
  private static boolean isSubSequenceWithPrimeNumbers(String a, String b) {
    BigInteger number = new BigInteger("1");
    char[] arr = a.toLowerCase().toCharArray();
    for(char c:arr) {
      number =
          number.multiply(
              new BigInteger(Integer.toString(PrimeNumber.get(c - 97))));
    }

    arr = b.toLowerCase().toCharArray();
    for(char c:arr) {
      if(!number.divideAndRemainder(
          new BigInteger(
              Integer.toString(
                  PrimeNumber.get(c - 97))))[1].equals(BigInteger.ZERO)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isSubSequenceWithBitManipulation(String a, String b) {
    int number_a = 0;
    int number_b = 0;
    char[] arr = a.toLowerCase().toCharArray();
    for(char c:arr) {
      number_a |= 1 << (c - 97);  // assuming ASCII (less than 32)
    }

    arr = b.toLowerCase().toCharArray();
    for(char c:arr) {
      number_b |= 1 << (c - 97);
    }
    return ((number_a ^ number_b) & number_b) == 0;
  }

  private static boolean isSubSequenceWithCounterArray(String a, String b) {
    final boolean[] counter = new boolean[26];  // assuming ASCII
    char[] arr = a.toLowerCase().toCharArray();
    for(char c:arr) {
      counter[c - 97] = true; 
    }

    arr = b.toLowerCase().toCharArray();
    for(char c:arr) {
      if(!counter[c - 97]) {
        return false;
      }
    }
    return true;
  }

}
