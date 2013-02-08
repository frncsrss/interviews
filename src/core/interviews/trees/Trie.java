package interviews.trees;

import interviews.lib.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Trie.
 * @author Francois Rousseau
 */
public class Trie {
  private char value;
  private int frequency;
  private boolean isValid;
  private Map<Character,Trie> children = new HashMap<Character, Trie>(10);
  private Trie mostFrequentChild;

  public Trie() {}

  private Trie(char value) {
    this.value = value;
  }

  /**
   *  Inserts a given string inside the trie.
   */
  public void add(char[] arr) {
    if (arr == null) {
      return;
    }
    add(arr, arr.length, 0);
  }
  public void add(String s) {
    if (s == null) {
      return;
    }
    add(s.toCharArray(), s.length(), 0);
  }
  
  /**
   *  Delete every element inside the trie.
   */
  public void clear() {
    isValid = false;
    clearChildren();
  }

  /**
   *  Checks if the trie contains a given string.
   *  Return true even if the string is not a valid word.
   */
  public boolean contains(String s) {
    return contains(s, false);
  }

  /**
   *  Checks if a given string is a valid word.
   *  By valid, we mean once inserted as a string
   *  and not only as a substring in the trie.
   */
  public boolean isValid(String s) {
    return contains(s, true);
  }

  /**
   *  Returns the frequency of a given string in the trie.
   *  Valid or not.
   */
  public int frequency(String s) {
    if (s == null) {
      return 0;
    }
    return frequency(s.toCharArray(), s.length(), 0);
  }

  /**
   *  Returns the longest valid prefix in the trie
   *  for a given string.
   */
  public String longestPrefix(String s) {
    if(s == null) {
      return null;
    }
    StringBuffer buffer = new StringBuffer();
    if(longestPrefix(s.toCharArray(), s.length(), 0, buffer)) {
      return buffer.reverse().toString();
    }
    return null;
  }

  /**
   *  Returns the most frequent suffix to append to the given string.
   *  Returns null if none exists
   *  or if the given string is already a valid prefix.
   */
  public String completion(String s) {
    return completion(s, false);
  }

  /**
   *  Returns the most frequent suffix to append to the given string.
   *  Returns null if none exists.
   */
  public String completionForced(String s) {
    return completion(s, true);
  }

  /**
   *  Remove the given string from the trie.
   */
  public boolean remove(String s) {
    if(s == null) {
      return false;
    }
    return remove(s.toCharArray(), s.length(), 0).first();
  }

  public String toString() {
    Queue<Trie> queue = new LinkedList<Trie>();
    for (Trie child : children.values()) {
      if (child != null) {
        queue.add(child);
      }
    }
    StringBuffer buffer = new StringBuffer();
    
    while (!queue.isEmpty()) {
      Trie current = queue.poll();
      buffer.append(current.value);
      for (Trie child : current.children.values()) {
        if (child != null) {
          queue.add(child);
        }
      }
    }
    return buffer.toString();
  }


  public void add(char[] arr, int n, int i) {
    if (i == n) {
      isValid = true;
      return;
    }
    char first = arr[i];
    Trie child = getChild(first);
    if (child == null) {
      child = setChild(first);
    } 
    incrementFrequency(child);
    child.add(arr, n, i+1);
  }

  private int frequency(char[] arr, int n, int i) {
    if (i == n) {
      return frequency;
    }
    Trie child = getChild(arr[i]);
    if (child == null) {
      return 0;
    } 
    return child.frequency(arr, n, i+1);
  }

  private boolean longestPrefix(char[] arr, int n, int i, StringBuffer buffer) {
    if (i == n) {
      return isValid;
    }
    Trie child = getChild(arr[i]);
    if (child == null) {
      return isValid;
    }
    if (child.longestPrefix(arr, n, i+1, buffer)) {
      buffer.append(child.value);
      return true;
    }
    return isValid;
  }
  
  private String completion(String s, boolean next) {
    Trie current = this;
    for(int i=0;i<s.length();i++) {
      Trie child = current.getChild(s.charAt(i));
      if(child == null) {
        return null;
      }
      current = child;
    }
    if((current.isValid && !next) || current.mostFrequentChild == null) {
      return null;
    }
    StringBuffer buffer = new StringBuffer();
    current.mostFrequentChild.completion(buffer);
    return buffer.toString();
  }
  
  private void completion(StringBuffer buffer) {
    buffer.append(value);
    if(isValid) {
      return;
    }
    mostFrequentChild.completion(buffer);
  }

  private boolean contains(String s, boolean isValid) {
    if (s == null) {
      return false;
    }
    return contains(s.toCharArray(), s.length(), 0, isValid);
  }
  
  private boolean contains(char[] arr, int n, int i, boolean isValid) {
    if (i == n) {
      return isValid ? this.isValid : true;
    }
    Trie child = getChild(arr[i]);
    if (child == null) {
      return false;
    }
    return child.contains(arr, n, i+1, isValid);
  }

  private Pair<Boolean, Trie> remove(char[] arr, int n, int i) {
    if (i == n) {
      if(isValid) {
        isValid = false;
        if(!children.isEmpty()) {
          return new Pair<Boolean, Trie>(true, this);
        } else {
          return new Pair<Boolean, Trie>(true, null);
        }
      } else {
        return new Pair<Boolean, Trie>(false, this);
      }
    }
    Trie child = getChild(arr[i]);
    if (child == null) {
      return new Pair<Boolean, Trie>(false, this);
    }
    Pair<Boolean, Trie> pair = child.remove(arr, n, i+1);
    if(pair.first() && pair.second() == null) {
      removeChild(arr[i]);
      if(!children.isEmpty()) {
        return new Pair<Boolean, Trie>(true, this);
      } else {
        return new Pair<Boolean, Trie>(true, null);
      }
    }
    return new Pair<Boolean, Trie>(pair.first(), this);
  }


  private Trie getChild(char key) {
    return children.get(key);
  }

  private void clearChildren() {
    children.clear();
  }

  private Trie removeChild(char key) {
    return children.remove(key);
  }
  
  private Trie setChild(char key) {
    setChild(key, new Trie(key));
    return getChild(key);
  }

  private void setChild(char key, Trie trie) {
    children.put(key, trie);
  }

  private void incrementFrequency(Trie child) {
    child.frequency++;
    if(mostFrequentChild == null || mostFrequentChild.frequency < child.frequency) {
      mostFrequentChild = child;
    }
  }
}