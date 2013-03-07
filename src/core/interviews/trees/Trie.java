package interviews.trees;

import interviews.lib.Pair;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Trie.
 * @author Francois Rousseau
 */
public class Trie {
  private Node root;

  /**
   * Public constructor that initializes the root. No character stored in the root.
   */
  public Trie() {
    root = new Node();
  }

  /**
   * Inserts a given string inside the trie.
   */
  public void add(String s) {
    if (s == null) {
      return;
    }
    add(root, s.toCharArray(), 0);
  }

  /**
   * Delete every element inside the trie.
   */
  public void clear() {
    root.clearChildren();
  }

  /**
   * Checks if the trie contains a given string.
   * Return true even if the string is not a valid word.
   */
  public boolean contains(String s) {
    return contains(s, false);
  }

  /**
   * Checks if a given string is a valid word.
   * By valid, we mean once inserted as a string
   * and not only as a substring in the trie.
   */
  public boolean isValid(String s) {
    return contains(s, true);
  }

  /**
   * Returns the frequency of a given string in the trie.
   * Valid or not.
   */
  public int frequency(String s) {
    if (s == null) {
      return 0;
    }
    return frequency(root, s.toCharArray(), 0);
  }

  /**
   * Returns the longest valid prefix in the trie for a given string.
   */
  public String longestPrefix(String s) {
    if(s == null) {
      return null;
    }
    StringBuffer buffer = new StringBuffer();
    if(longestPrefix(root, s.toCharArray(), 0, buffer)) {
      return buffer.reverse().toString();
    }
    return null;
  }

  /**
   * Returns the most frequent suffix to append to the given string.
   * Returns null if none exists or if the given string is already a valid prefix.
   */
  public String completion(String s) {
    return completion(root, s, false);
  }

  /**
   * Returns the most frequent suffix to append to the given string.
   * Returns null if none exists.
   */
  public String completionForced(String s) {
    return completion(root, s, true);
  }

  /**
   * Remove the given string from the trie.
   * @return boolean indicating if the operation was done or not.
   */
  public boolean remove(String s) {
    if(s == null) {
      return false;
    }
    return remove(root, s.toCharArray(), 0).first();
  }

  /**
   * BFS traversal of the trie.
   * @return String
   */
  public String toString() {
    final Queue<Node> queue = new LinkedList<Node>();
    for (Node child : root.getChildrenValues()) {
      if (child != null) {
        queue.add(child);
      }
    }
    final StringBuffer buffer = new StringBuffer();
    
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      buffer.append(current.value);
      for (Node child : current.getChildrenValues()) {
        if (child != null) {
          queue.add(child);
        }
      }
    }
    return buffer.toString();
  }

  /**
   * Add the ith index of the given array to the current node.
   */
  private void add(Node node, char[] arr, int i) {
    if (i == arr.length) {
      node.isValid = true;
      return;
    }
    final char first = arr[i];
    Node child = node.getChild(first);
    if (child == null) {
      child = node.setChild(first);
    } 
    node.incrementFrequency(child);
    add(child, arr, i+1);
  }

  /**
   * Check whether a given string is in the trie.
   * Valid or not, depending on the argument isValid.
   */
  private boolean contains(String s, boolean isValid) {
    if (s == null) {
      return false;
    }
    return contains(root, s.toCharArray(), 0, isValid);
  }

  /**
   * Check whether a given array of characters is in the trie.
   * Valid or not, depending on the argument isValid.
   */
  private boolean contains(Node node, char[] arr, int i, boolean isValid) {
    if (i == arr.length) {
      return isValid ? node.isValid : true;
    }
    Node child = node.getChild(arr[i]);
    if (child == null) {
      return false;
    }
    return contains(child, arr, i+1, isValid);
  }

  /**
   * Return the frequency of the leaf corresponding to the given array.
   * Recursion on the index i until the end of the array.
   * @return frequency
   */
  private int frequency(Node node, char[] arr, int i) {
    if (i == arr.length) {
      return node.frequency;
    }
    Node child = node.getChild(arr[i]);
    if (child == null) {
      return 0;
    } 
    return frequency(child, arr, i+1);
  }
  
  /**
   * Appends to a StringBuffer the longest prefix in the trie for a given String.
   * @return boolean value indicating if the prefix is a valid word or not.
   */
  protected boolean longestPrefix(Node node, char[] arr, int i, StringBuffer buffer) {
    if (i == arr.length) {
      return node.isValid;
    }
    Node child = node.getChild(arr[i]);
    if (child == null) {
      return node.isValid;
    }
    if (longestPrefix(child, arr, i+1, buffer)) {
      buffer.append(child.value);
      return true;
    }
    return node.isValid;
  }

  /**
   * Returns the most frequent suffix to append to the given string.
   * @param force a boolean indicating if we want to auto-complete
   * even if the string is already a valid prefix.
   * @return the auto-completed suffix, null if there is none
   */
  protected String completion(Node node, String s, boolean force) {
    for(int i = 0; i < s.length(); i++) {  // loop until you get the last child
      Node child = node.getChild(s.charAt(i));
      if(child == null) {  // the string we want to complete is not even in the trie
        return null;
      }
      node = child;
    }
    if((node.isValid && !force) || node.mostFrequentChild == null) {
      return null;
    }
    StringBuffer buffer = new StringBuffer();
    completion(node.mostFrequentChild, buffer);
    return buffer.toString();
  }
  
  /**
   * Fill a StringBuffer with the most frequent suffix. Ends with a valid one is reached.
   */
  private void completion(Node node, StringBuffer buffer) {
    buffer.append(node.value);
    if(node.isValid) {
      return;
    }
    completion(node.mostFrequentChild, buffer);
  }

  /**
   * Remove the given array of characters from the trie.
   * @return Pair<Boolean, TrieNode> the boolean indicating if it was remove and the TrieNode
   * the node to remove because there is no child.
   */
  private Pair<Boolean, Node> remove(Node node, char[] arr, int i) {
    if (i == arr.length) {  // we reached the end of the array
      if(node.isValid) {  // if it is a valid word, we remove its validity
        node.isValid = false;
        if(!node.children.isEmpty()) {  // if there is no child, we tell the parent to remove the node
          return new Pair<Boolean, Node>(true, node);
        } else {  // otherwise we don't
          return new Pair<Boolean, Node>(true, null);
        }
      } else {
        return new Pair<Boolean, Node>(false, node);
      }
    }
    Node child = node.getChild(arr[i]);
    if (child == null) {
      return new Pair<Boolean, Node>(false, node);
    }
    Pair<Boolean, Node> pair = remove(child, arr, i+1);
    if(pair.first() && pair.second() == null) {
      node.removeChild(arr[i]);
      if(!node.children.isEmpty()) {
        return new Pair<Boolean, Node>(true, node);
      } else {
        return new Pair<Boolean, Node>(true, null);
      }
    }
    return new Pair<Boolean, Node>(pair.first(), node);
  }

  /**
   * Private inner class for an internal Trie node.
   */
  private class Node {
    private char value;
    private int frequency;
    private boolean isValid;
    private Map<Character, Node> children = new HashMap<Character, Node>(10);
    private Node mostFrequentChild;

    /**
     * Private empty constructor used for the root.
     */
    private Node() {}
    
    /**
     * Private non-empty public constructor used internally for the children.
     */
    private Node(char value) {
      this.value = value;
    }

    private void clearChildren() {
      children.clear();
    }

    private void incrementFrequency(Node child) {
      child.frequency++;
      if(mostFrequentChild == null || mostFrequentChild.frequency < child.frequency) {
        mostFrequentChild = child;
      }
    }

    private Node getChild(char key) {
      return children.get(key);
    }

    private Collection<Node> getChildrenValues() {
      return children.values();
    }

    private Node removeChild(char key) {
      return children.remove(key);
    }
    
    private Node setChild(char key) {
      setChild(key, new Node(key));
      return getChild(key);
    }

    private void setChild(char key, Node node) {
      children.put(key, node);
    }
  }
}