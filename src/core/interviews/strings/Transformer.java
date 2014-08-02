package interviews.strings;

import interviews.trees.Trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Returns the path from one string to another if possible. The path consists of
 * valid words differing from each other with only one letter at a time.
 *
 * @author Francois Rousseau
 */
public class Transformer {
  public static List<String> path(String start, String end, Trie dict) {
    if(start.length() != end.length() || start.equals(end)) {
      return null;
    }

    final Queue<String> queue = new LinkedList<String>();
    final Set<String> visited = new HashSet<String>();
    final Map<String, String> backtrackMap = new HashMap<String, String>();

    queue.add(start);
    visited.add(start);

    while(!queue.isEmpty()) {
      String current = queue.poll();
      if(current.equals(end)) {
        LinkedList<String> path = new LinkedList<String>();
        while(!current.equals(start)) {
          path.addFirst(current);
          current = backtrackMap.get(current);
        }
        return path;
      }
      for(String s:wordsAtDistance1(current)) {
        if(dict.contains(s) && !visited.contains(s)) {
          queue.add(s);
          visited.add(s);
          backtrackMap.put(s, current);
        }
      }
    }
    return null;
  }

  private static Set<String> wordsAtDistance1(String word) {
    Set<String> words = new TreeSet<String>();
    for(int i = 0; i < word.length(); i++) {
      char[] arr = word.toCharArray();
      for(char c = 'a'; c <= 'z'; c++) {
        if(c != word.charAt(i)) {
          arr[i] = c;
          words.add(new String(arr));
        }
      }
    }
    return words;
  }
}
