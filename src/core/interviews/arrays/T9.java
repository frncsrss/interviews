package interviews.arrays;

import java.util.Arrays;

/**
 * You are given a int[] frequencies with N elements. Each element of frequencies is the number of
 * times one of the letters in the alphabet appears in the text. Each element of frequencies will
 * be strictly positive (i.e. each of the N letters occurs at least once in the text).
 *
 * You are also given a int[] keySize. The number of elements of keySize is the number of keys on
 * the phone's keyboard. Each element of keySize gives the maximal number of letters on one of the
 * keys.
 *
 * Find an assignment of letters to keys that minimizes the number of keystrokes needed to type
 * the entire text (represented by frequencies). Return that minimum number of keystrokes. If there
 * is not enough room on the keys and some letters of the alphabet won't fit, return -1 instead.
 *
 * Constraints:
 *  - frequencies will contain between 1 and 50 elements, inclusive.
 *  - Each element of frequencies will be between 1 and 1,000, inclusive.
 *  - keySizes will contain between 1 and 50 elements, inclusive.
 *  - Each element of keySizes will be between 1 and 50, inclusive.
 *
 * @author Francois Rousseau
 */
public class T9 {
  /**
   * Let n = length(frequencies) and m = length(keySizes).
   * Time complexity:  O(m + nlogn)
   * Space complexity: O(1)
   */
  public static int minKeystrokes(int[] frequencies, int[] keySizes) {
    int maxNumberOfLetters = 0;
    for(int keySize : keySizes) {  // O(m)
      maxNumberOfLetters += keySize;
    }
    if(maxNumberOfLetters < frequencies.length) {  // not enough letters on the keyboard
      return -1;
    }

    Arrays.sort(frequencies);  // O(nlogn)

    int minKeystrokes = 0;  // result
    int depth = 1;  // current depth on keys
    int lastNonZeroKey = keySizes.length - 1;
    for(int i = frequencies.length - 1, key = 0; i >= 0; i--) {  // O(n)
      if(key > lastNonZeroKey) {
        key = 0;
        depth++;
      }
      minKeystrokes += frequencies[i] * depth;
      keySizes[key]--;
      if(keySizes[key] == 0) {  // swap it with the key at index lastNonZeroKey
        int tmp = keySizes[key];
        keySizes[key] = keySizes[lastNonZeroKey];
        keySizes[lastNonZeroKey] = tmp;
        lastNonZeroKey--;
      } else {
        key++;
      }
    }
    return minKeystrokes;
  }
}
