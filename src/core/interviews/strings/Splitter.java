package interviews.strings;

import interviews.trees.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Split a string with missing whitespace if possible. Highlight EXLs (words not in dictionary).
 * A dictionary of valid words is given as input.
 *
 * @author Francois Rousseau
 */
public class Splitter {
  public static String f(String s, Trie dict) {
    final List<String> result = new ArrayList<String>();
    if(f(s, dict, 0, result)) {  // there is a possible split
      Collections.reverse(result);  // because of the recursion
      final StringBuffer buffer = new StringBuffer();
      for (Iterator<String> iterator = result.iterator(); iterator.hasNext();) {
        buffer.append(iterator.next()+ " ");
      }
      buffer.deleteCharAt(buffer.length()-1);  // remove the last whitespace
      return buffer.toString();
    }
    return null;
  }

  private static boolean f(String s, Trie dict, int start, List<String> result) {
    if(start == s.length()) {
      return true;
    }

    final StringBuffer exl = new StringBuffer();
    for(int i = start + 1; i <= s.length(); i++) {
      final String current = s.substring(start, i);
      if(!dict.contains(current)) {  // potentially an EXL
        if(current.length() > 1) {
          exl.append(current.substring(0, current.length()-1));
        }
        else {
          exl.append(current);
        }
        start++;
        continue;
      } else if(!dict.isValid(current)) {  // not a valid word, we continue
        continue;
      }

      // we have a current valid word, we try to split the rest of the string
      if(f(s, dict, i, result)) {  // the rest of the string can be split
        result.add(current);  // we add the current valid word
        if(exl.length() > 0) {  // we add the possible EXLs preceding the word
          result.add(exl.toString().toUpperCase());
        }
        return true;
      }
    }
    if(exl.length() > 0) {  // the substring [start, end] is an EXL
      result.add(exl.toString().toUpperCase());
      return true;
    }
    return false;  // no valid nor EXL words found
  }
}
