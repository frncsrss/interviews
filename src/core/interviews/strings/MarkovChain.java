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
      current.addWord(word);
    }
    if(!map.containsKey(word)) {
      current = new Node();
      map.put(word, current);
    } else {
      current = map.get(word);
    }
  }

  public String nextWord(String word) {
    if(!map.containsKey(word)) {  // could be improved with a source node pointing to all the nodes
      throw new NoSuchElementException();
    }
    return map.get(word).nextWord();
  }

  private static class Node {
    private final Map<String, Integer> map = new HashMap<String, Integer>();
    private int count = 0;  // total number of calls to addWord
    private boolean hasChanged = true;  // do we need to re-compute the cumulative frequencies
    private String[] words;  // same as map.keySet(), in sync with the cumulative frequencies
    private int[] cumulativeFrequencies;

    public void addWord(String word) {
      if(map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
      count++;
      hasChanged = true;
    }

    public String nextWord() {
      if(map.size() == 0) {
        throw new NoSuchElementException();
      }
      if(map.size() == 1) {
        return map.keySet().iterator().next();
      }
      if(hasChanged) {
        updateFrequencies();
        hasChanged = false;
      }
      return which(r.nextInt(count));
    }

    /**
     * Recompute the words and cumulativeFrequencies arrays. Needed whenever a word was upserted.
     */
    private void updateFrequencies() {
      words = new String[map.size()];
      // one cumulative frequency per word. the first cumulative frequency will be 0 and the next
      // the previous one + the frequency of the previous word
      // for example if the frequencies are 7 5 11 then the array will look like 0 7 12
      cumulativeFrequencies = new int[map.size()];
      int i = 0;
      for(String s : map.keySet()) {
        words[i] = s;
        if(i == 0) {
          cumulativeFrequencies[0] = 0;
        } else {
          cumulativeFrequencies[i] = map.get(words[i-1]) + cumulativeFrequencies[i - 1];
        }
        i++;
      }
    }

    /**
     * Binary search in cumulativeFrequencies to find the range where p falls in.
     */
    private String which(int p) {
      int lo = 0;
      int hi = cumulativeFrequencies.length - 1;
      while(lo < hi) {
        int mid = lo + hi >>> 1;
        if(cumulativeFrequencies[mid] < p) {
          lo = mid + 1;
        } else if(cumulativeFrequencies[mid] > p) {
          hi = mid - 1;
        } else {
          return words[mid];
        }
      }
      return words[lo];
    }
  }
}
