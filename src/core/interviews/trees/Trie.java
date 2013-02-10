package interviews.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Trie.
 * @author Francois Rousseau
 */
public class Trie {
  private TrieNode root;

  /**
   * Public constructor that initializes the root. No character stored in the root.
   */
  public Trie() {
    root = new TrieNode();
  }

  /**
   *  Inserts a given string inside the trie.
   */
  public void add(String s) {
    if (s == null) {
      return;
    }
    root.add(s.toCharArray(), 0);
  }

  /**
   *  Delete every element inside the trie.
   */
  public void clear() {
    root.clearChildren();
  }

  /**
   *  Checks if the trie contains a given string.
   *  Return true even if the string is not a valid word.
   */
  public boolean contains(String s) {
    return root.contains(s, false);
  }

  /**
   *  Checks if a given string is a valid word.
   *  By valid, we mean once inserted as a string
   *  and not only as a substring in the trie.
   */
  public boolean isValid(String s) {
    return root.contains(s, true);
  }

  /**
   *  Returns the frequency of a given string in the trie.
   *  Valid or not.
   */
  public int frequency(String s) {
    if (s == null) {
      return 0;
    }
    return root.frequency(s.toCharArray(), 0);
  }

  /**
   *  Returns the longest valid prefix in the trie for a given string.
   */
  public String longestPrefix(String s) {
    if(s == null) {
      return null;
    }
    StringBuffer buffer = new StringBuffer();
    if(root.longestPrefix(s.toCharArray(), 0, buffer)) {
      return buffer.reverse().toString();
    }
    return null;
  }

  /**
   *  Returns the most frequent suffix to append to the given string.
   *  Returns null if none exists or if the given string is already a valid prefix.
   */
  public String completion(String s) {
    return root.completion(s, false);
  }

  /**
   *  Returns the most frequent suffix to append to the given string.
   *  Returns null if none exists.
   */
  public String completionForced(String s) {
    return root.completion(s, true);
  }

  /**
   *  Remove the given string from the trie.
   *  @return boolean indicating if the operation was done or not.
   */
  public boolean remove(String s) {
    if(s == null) {
      return false;
    }
    return root.remove(s.toCharArray(), 0).first();
  }

  /**
   *  BFS traversal of the trie.
   *  @return String
   */
  public String toString() {
    final Queue<TrieNode> queue = new LinkedList<TrieNode>();
    for (TrieNode child : root.getChildrenValues()) {
      if (child != null) {
        queue.add(child);
      }
    }
    final StringBuffer buffer = new StringBuffer();
    
    while (!queue.isEmpty()) {
      TrieNode current = queue.poll();
      buffer.append(current.getValue());
      for (TrieNode child : current.getChildrenValues()) {
        if (child != null) {
          queue.add(child);
        }
      }
    }
    return buffer.toString();
  }

}