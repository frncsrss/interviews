package interviews.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * TrieMap.
 * @author Francois Rousseau
 */
public class TrieMap<Value> {
  private Node root = new Node();

  /**
   * Does the trie contains the key?
   */
  public boolean contains(String key) {
    return get(key) != null;
  }

  /**
   * Return the value associated with the key in the trie.
   */
  @SuppressWarnings("unchecked")
  public Value get(String key) { 
    Node x = get(root, key.toCharArray(), 0);
    if (x == null) return null;
    return (Value) x.value;
  }

  /**
   * Return the longest valid prefix in the trie for a given string.
   */
  public String longestPrefix(String s) {
    if(s == null) return null;
    int length = longestPrefix(root, s.toCharArray(), 0, 0);
    return s.substring(0, length);
  }

  /**
   * Put a value for a given string inside the trie.
   */
  public void put(String key, Value val) {
    root = put(root, key.toCharArray(), val, 0);
  }


  /**
   * Return the node corresponding to the array of characters.
   * Null if none exists.
   */
  private Node get(Node node, char[] arr, int i) {
    if(node == null)    return null;
    if(i == arr.length) return node;
    return get(node.get(arr[i]), arr, i + 1);
  }

  /**
   * Return the length of the longest valid word prefixing the given array of characters.
   */
  private int longestPrefix(Node node, char[] arr, int i, int length) {
    if(node == null)    return length;  // return the length of the longest valid word seen so far
    if(node.value != null) length = i;  // update the length of the longest valid word seen so far
    if(i == arr.length) return length;  // return the length of the longest valid word seen so far
    return longestPrefix(node.get(arr[i]), arr, i + 1, length);
  }

  /**
   * Create child node for the ith character of the array.
   */
  private Node put(Node node, char[] key, Value value, int i) { 
    if (node == null) node = new Node();
    if (i == key.length) {
      node.value = value;
      return node;
    }
    char c = key[i];
    node.put(c, put(node.get(c), key, value, i + 1));
    return node;
  }

  /**
   * Private inner class for an internal Trie node.
   */
  private static class Node {
    private Object value;
    private Map<Character, Node> children = new HashMap<Character, Node>();

    private Node get(char key) {
      return children.get(key);
    }

    private void put(char key, Node node) {
      children.put(key, node);
    }
  }
}
