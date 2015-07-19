package interviews.strings;

import interviews.trees.Trie;

/**
 * Split a string with missing whitespace if possible. Highlight EXLs (words not in dictionary).
 * A dictionary of valid words is given as input.
 *
 * @author Francois Rousseau
 */
public class Splitter {
  private static final String SEPARATOR = " ";

  public static String f(String s, Trie dict) {
    return f(s, dict, 0, 1).s;
  }

  /**
   * Do we put a whitespace after the word s[start, end) or do we include another character,
   * i.e. do we break or do we continue?
   */
  private static Result f(String s, Trie dict, int start, int end) {
    if(end > s.length()) {
      String current = s.substring(start);
      return new Result(current.toUpperCase(), current.length(), true);
    }

    String current = s.substring(start, end);

    // what if we put a whitespace after the current word
    Result withBreak = f(s, dict, end, end + 1);
    if(!dict.contains(current)) {  // if the current word is not a valid prefix, let's bail out
      withBreak.prependWithEXL(current.toUpperCase());
      return withBreak;
    } else if (dict.isValid(current)) {
      withBreak.prependWithWord(current);
    } else {
      withBreak.prependWithEXL(current.toUpperCase());
    }

    // what if we consider another character in the current word
    Result withContinue = f(s, dict, start, end + 1);

    // we favor continuation over break (e.g., 'awesome' over 'a we some')
    return Result.min(withContinue, withBreak);
  }

  private static class Result {
    private String s;
    private int exl;
    private boolean startsWithEXL;

    public Result(String s, int exl, boolean startsWithEXL) {
      this.s = s;
      this.exl = exl;
      this.startsWithEXL = startsWithEXL;
    }

    public void prependWithEXL(String s) {
      if(this.s.isEmpty()) {
        this.s = s;
      } else if(startsWithEXL) {
        this.s = s + this.s;
      } else {
        this.s = s + SEPARATOR + this.s;
      }
      this.exl += s.length();
      this.startsWithEXL = true;
    }

    public void prependWithWord(String s) {
      if(this.s.isEmpty()) {
        this.s = s;
      } else {
        this.s = s + SEPARATOR + this.s;
      }
      this.startsWithEXL = false;
    }

    public static Result min(Result r1, Result r2) {
      return r1.exl <= r2.exl ? r1 : r2;
    }
  }
}
