package interviews.strings;

import interviews.trees.Trie;

/**
 * Split a string with missing whitespace if possible. Highlight EXLs (words not in dictionary).
 * A dictionary of valid words is given as input.
 *
 * @author Francois Rousseau
 */
public class Splitter {
  public static String f(String s, Trie dict) {
    if(s == null || s.isEmpty()) {
      return s;
    }

    final StringBuffer exl = new StringBuffer();
    int start = 0;
    for(int i = start + 1; i <= s.length(); i++) {
      final String prefix = s.substring(start, i);
      if(!dict.contains(prefix)) {  // potentially an EXL
        if(prefix.length() > 1) {   // don't mark the last character as EXLs if more than one character
          exl.append(prefix.substring(0, prefix.length() - 1));
        } else {
          exl.append(prefix);
        }
        start++;
        continue;
      } else if(!dict.isValid(prefix)) {  // a valid prefix but not a valid word, we continue
        continue;
      }

      // we have a current valid word, we split the rest of the string
      String suffix = s.substring(i);
      String splitSuffix = f(suffix, dict);
      String ret;
      if(exl.length() > 0) {  // we add the possible EXLs preceding the word
        ret = exl.toString().toUpperCase() + " " + prefix;
      } else {
        ret = prefix;
      }
      if(!splitSuffix.isEmpty()) {
        ret += " " + splitSuffix;
      }
      return ret;
    }

    return s.toUpperCase();
  }
}
