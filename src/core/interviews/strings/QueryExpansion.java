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
 * From an original phrase, returns the top-k expansions. Each word is mapped to a set of weighted
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
  private final Dictionary dict = new Dictionary();

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
    List<String> expansions = new ArrayList<String>();
    PriorityQueue<Node> top_k = new PriorityQueue<Node>(k);
    expansions(words, 0, new String[words.length], top_k, 1, k);
    while(!top_k.isEmpty()) {
      expansions.add(top_k.poll().string);
    }
    Collections.reverse(expansions);
    return expansions;
  }

  /**
   * Internal subroutine.
   * Use a min-oriented priority queue containing at most k expansions (the best seen so far).
   * Use DFS (recursion stack) to traverse the tree of all possible expansions.
   */
  private void expansions(
      String[] words, int index, String[] query, PriorityQueue<Node> top_k, double weight, int k) {
    String word = words[index];
    for(Node node: dict.get(word)) {
      query[index] = node.string;
      final double new_weight = weight * node.weight;
      if(top_k.size() == k) {
        Node head = top_k.peek();
        if(head.weight >= new_weight) {         // early pruning of a node or a leaf
          continue;
        } else if(index == words.length - 1) {  // leaf node in the tree
          top_k.poll();                         // remove head
        }
      }
      if(index == words.length - 1) {            // leaf node in the tree
        top_k.add(new Node(query, new_weight));  // adding leaf since the size of pq < k
        continue;
      }
      expansions(words, index + 1, query, top_k, new_weight, k);
    }
  }


  /**
   * Internal class mocking a dictionary of expansions.
   */
  private static class Dictionary {
    private final Map<String, Node[]> map = new HashMap<String, Node[]>();

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
    private final String string;
    private final double weight;

    public Node(String string, double weight) {
      this.string = string;
      this.weight = weight;
    }

    public Node(String[] query, double weight) {
      StringBuilder builder = new StringBuilder();
      for(String s : query) {
        builder.append(s + " ");
      }
      this.string = builder.deleteCharAt(builder.length() - 1).toString();
      this.weight = weight;
    }

    @Override
    public int compareTo(Node that) {
      if(this.weight < that.weight) return -1;
      if(this.weight > that.weight) return +1;
      return 0;
    }
  }
}
