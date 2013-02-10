package interviews.trees;

import interviews.lib.Pair;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * TrieNode.
 * @author Francois Rousseau
 */
public class TrieNode {
  private char value;
  private int frequency;
  private boolean isValid;
  private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>(10);
  private TrieNode mostFrequentChild;

  /**
   * Empty public constructor used for the root.
   */
  public TrieNode() {}
  
  /**
   * Private non-empty public constructor used internally for the children.
   */
  private TrieNode(char value) {
    this.value = value;
  }

  /**
   * Return the value in the current child node.
   */
  protected char getValue() {
    return value;
  }

  /**
   * Return the values of the current node's children.
   */
  protected Collection<TrieNode> getChildrenValues() {
    return children.values();
  }

  /**
   *  Add the ith index of the given array to the current node.
   */
  protected void add(char[] arr, int i) {
    if (i == arr.length) {
      isValid = true;
      return;
    }
    final char first = arr[i];
    TrieNode child = getChild(first);
    if (child == null) {
      child = setChild(first);
    } 
    incrementFrequency(child);
    child.add(arr, i+1);
  }

  /**
   * Clear the children. Use by the root to remove the entire trie.
   */
  protected void clearChildren() {
    children.clear();
  }

  /**
   * Check whether a given string is in the trie.
   * Valid or not, depending on the argument isValid.
   */
  protected boolean contains(String s, boolean isValid) {
    if (s == null) {
      return false;
    }
    return contains(s.toCharArray(), 0, isValid);
  }
  
  /**
   * Check whether a given array of characters is in the trie.
   * Valid or not, depending on the argument isValid.
   */
  protected boolean contains(char[] arr, int i, boolean isValid) {
    if (i == arr.length) {
      return isValid ? this.isValid : true;
    }
    TrieNode child = getChild(arr[i]);
    if (child == null) {
      return false;
    }
    return child.contains(arr, i+1, isValid);
  }

  /**
   *  Return the frequency of the leaf corresponding to the given array.
   *  Recursion on the index i until the end of the array.
   *  @return frequency
   */
  protected int frequency(char[] arr, int i) {
    if (i == arr.length) {
      return frequency;
    }
    TrieNode child = getChild(arr[i]);
    if (child == null) {
      return 0;
    } 
    return child.frequency(arr, i+1);
  }

  /**
   *  Appends to a StringBuffer the longest prefix in the trie for a given String.
   *  @return boolean value indicating if the prefix is a valid word or not.
   */
  protected boolean longestPrefix(char[] arr, int i, StringBuffer buffer) {
    if (i == arr.length) {
      return isValid;
    }
    TrieNode child = getChild(arr[i]);
    if (child == null) {
      return isValid;
    }
    if (child.longestPrefix(arr, i+1, buffer)) {
      buffer.append(child.value);
      return true;
    }
    return isValid;
  }
  
  /**
   *  Returns the most frequent suffix to append to the given string.
   * @param force a boolean indicating if we want to auto-complete
   * even if the string is already a valid prefix.
   * @return the auto-completed suffix, null if there is none
   */
  protected String completion(String s, boolean force) {
    TrieNode current = this;
    for(int i=0; i < s.length(); i++) {  // loop until you get the last child
      TrieNode child = current.getChild(s.charAt(i));
      if(child == null) {  // the string we want to complete is not even in the trie
        return null;
      }
      current = child;
    }
    if((current.isValid && !force) || current.mostFrequentChild == null) {
      return null;
    }
    StringBuffer buffer = new StringBuffer();
    current.mostFrequentChild.completion(buffer);
    return buffer.toString();
  }
  
  /**
   * Fill a StringBuffer with the most frequent suffix. Ends with a valid one is reached.
   */
  private void completion(StringBuffer buffer) {
    buffer.append(value);
    if(isValid) {
      return;
    }
    mostFrequentChild.completion(buffer);
  }

  /**
   *  Remove the given array of characters from the trie.
   *  @return Pair<Boolean, TrieNode> the boolean indicating if it was remove and the TrieNode
   *  the node to remove because there is no child.
   */
  protected Pair<Boolean, TrieNode> remove(char[] arr, int i) {
    if (i == arr.length) {  // we reached the end of the array
      if(isValid) {  // if it is a valid word, we remove its validity
        isValid = false;
        if(!children.isEmpty()) {  // if there is no child, we tell the parent to remove the node
          return new Pair<Boolean, TrieNode>(true, this);
        } else {  // otherwise we don't
          return new Pair<Boolean, TrieNode>(true, null);
        }
      } else {
        return new Pair<Boolean, TrieNode>(false, this);
      }
    }
    TrieNode child = getChild(arr[i]);
    if (child == null) {
      return new Pair<Boolean, TrieNode>(false, this);
    }
    Pair<Boolean, TrieNode> pair = child.remove(arr, i+1);
    if(pair.first() && pair.second() == null) {
      removeChild(arr[i]);
      if(!children.isEmpty()) {
        return new Pair<Boolean, TrieNode>(true, this);
      } else {
        return new Pair<Boolean, TrieNode>(true, null);
      }
    }
    return new Pair<Boolean, TrieNode>(pair.first(), this);
  }

  
  private TrieNode getChild(char key) {
    return children.get(key);
  }

  private TrieNode removeChild(char key) {
    return children.remove(key);
  }
  
  private TrieNode setChild(char key) {
    setChild(key, new TrieNode(key));
    return getChild(key);
  }

  private void setChild(char key, TrieNode node) {
    children.put(key, node);
  }

  private void incrementFrequency(TrieNode child) {
    child.frequency++;
    if(mostFrequentChild == null || mostFrequentChild.frequency < child.frequency) {
      mostFrequentChild = child;
    }
  }
}
