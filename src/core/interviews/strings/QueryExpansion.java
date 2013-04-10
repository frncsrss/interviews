package interviews.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Query expansion.
 * 
 * From an original phrase, returns the top-k expansions. Each word is mapped to set of weighted
 * possible expansions. The top-k expansions correspond to the k greatest overall weights.
 * 
 * original phrase:
 *   "pictures of puppies"
 * related words:
 *   pictures -> [(pictures, 1.0), (photos, 0.8)]
 *   of -> [(of, 1.0)]
 *   puppies -> [(puppies, 1.0), (dogs, 0.6), (pets, 0.2)]
 * top k expansions:
 *   "pictures of puppies" -> 1.0
 *   "photos of puppies" -> 0.8
 *   ...
 * @author Francois Rousseau
 */
public class QueryExpansion {
  private Dictionary dict = new Dictionary();

  /**
   * Store a set of expansions for a given word.
   */
  public void put(String word, Node[] expansions) {
    dict.put(word, expansions);
  }

  /**
   * Return the top-k expansions of the original String.
   */
  public List<String> expansions(String original, int k) {
    String[] words = original.split(" ");
    List<String> list = new ArrayList<String>();
    PriorityQueue<Node> pq = new PriorityQueue<Node>(k);
    expansions(words, 0, new ArrayList<String>(), pq, 1, k);
    while(!pq.isEmpty()) {
      list.add(pq.poll().string);
    }
    Collections.reverse(list);
    return list;
  }

  /**
   * Internal subroutine.
   * Use a min-oriented priority queue containing at most k expansions (the best seen so far).
   * Use DFS (recursion stack) to traverse the tree of all possible expansions.
   */
  private void expansions(
      String[] words, int index, List<String> string, PriorityQueue<Node> pq, double weight, int k) {
    String word = words[index];
    for(Node node: dict.get(word)) {
      string.add(node.string);
      double new_weight = weight * node.weight;
      if(pq.size() >= k) {
        Node head = pq.peek();
        if(head.weight >= new_weight) {  // early pruning on a node or a leaf
          string.remove(string.size() - 1);
          continue;
        } else if(index == words.length - 1) {  // leaf node in the tree
          pq.poll();
          pq.add(new Node(string, new_weight));  // adding any leaf if the size of pq < k
          string.remove(string.size() - 1);
          continue;
        }
      }
      if(index == words.length - 1) {  // leaf node in the tree
        pq.add(new Node(string, new_weight));  // adding any leaf if the size of pq < k
        string.remove(string.size() - 1);
        continue;
      }
      expansions(words, index + 1, string, pq, new_weight, k);
      string.remove(string.size() - 1);
    }
  }
 

  /**
   * Internal class mocking a dictionary of expansions.
   */
  private static class Dictionary {
    private Map<String, Node[]> map = new HashMap<String, Node[]>();

    public void put(String word, Node[] expansions) {
      map.put(word, expansions);
    }

    public Node[] get(String word) {
      return map.get(word);
    }
  }

  /**
   * Internal class representing a node in the tree and a node in the priority queue.
   */
  protected static class Node implements Comparable<Node> {
    private String string;
    private double weight;

    public Node(String string, double weight) {
      this.string = string;
      this.weight = weight;
    }

    public Node(List<String> string, double weight) {
      StringBuilder builder = new StringBuilder();
      for(String s : string) {
          builder.append(s + " ");
      }
      this.string = builder.deleteCharAt(builder.length() - 1).toString();
      this.weight = weight;
    }

    public int compareTo(Node that) {
      if(this.weight < that.weight) return -1;
      if(this.weight > that.weight) return +1;
      return 0;
    }
  }
}
