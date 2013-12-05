package interviews.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Markov chain to predict the next word based on a training corpus.
 * @author Francois Rousseau
 */
public class MarkovChain {
  protected static Random r = new Random();
  private final Map<String, Node> map = new HashMap<String, Node>();
  private Node current = null;

  public void addWord(String word) {
    if(current != null) {
      current.add(word);
    }
    if(!map.containsKey(word)) {
      current = new Node();
      map.put(word, current);
    } else {
      current = map.get(word);
    }
  }

  public String nextWord(String word) {
    if(!map.containsKey(word)) {
      throw new NoSuchElementException();
    }
    Node node = map.get(word);
    String[] arr = new String[node.count];
    int j = 0;
    for(Map.Entry<String, Integer> e : node.map.entrySet()) {
      for(int k = 0; k < e.getValue(); k++) {
        arr[j++] = e.getKey();
      }
    }
    int i = r.nextInt(node.count);
    return arr[i];
  }

  private static class Node {
    private final Map<String, Integer> map = new HashMap<String, Integer>();
    private int count = 0;

    public void add(String word) {
      if(map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
      count++;
    }
  }
}
