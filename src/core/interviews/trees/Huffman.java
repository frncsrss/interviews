package interviews.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Huffman encoding (prefix-free).
 * @author Francois Rousseau
 */
public class Huffman {
  private Node root;  // root of the trie
  private Map<Character, String> st;  // symbol table

  /**
   * Decode a String s with the current trie.
   */
  public String decode(String s) {
    StringBuilder builder = new StringBuilder();
    int i = 0;
    int N = s.length();
    while(i < N) { 
      Node x = root;
      while(!x.isLeaf()) {
        if(s.charAt(i++) == '0') {
          x = x.left;
        }
        else {
          x = x.right;
        }
      }
      builder.append(x.ch);
    }
    return builder.toString();
  }

  /**
   * Encode a String s, overwriting previous trie and symbol table.
   */
  public String encode(String s) {
    Map<Character, Integer> freq = new HashMap<Character, Integer>();
    for(char c: s.toCharArray()) {
      if(!freq.containsKey(c)) {
        freq.put(c, 1);
      } else {
        freq.put(c, freq.get(c) + 1);        
      }
    }
    root = makeTrie(freq);
    st = new HashMap<Character, String>();
    makeTable(st, root, "");

    StringBuilder builder = new StringBuilder();
    for(char c: s.toCharArray()) {
      builder.append(st.get(c));
    }
    return builder.toString();
  }


  /**
   * Make the symbol table from the trie.
   */
  private static void makeTable(Map<Character, String> st, Node x, String s) {
    if (!x.isLeaf()) {
      makeTable(st, x.left,  s + '0');
      makeTable(st, x.right, s + '1');
    }
    else {
      st.put(x.ch, s);
    }
  }

  /**
   * Make the trie from an table of frequency.
   * Huffman algorithm.
   */
  private static Node makeTrie(Map<Character, Integer> freq) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    for(Entry<Character, Integer> e: freq.entrySet()) {  // initialize PQ with singleton tries
      pq.add(new Node(e.getKey(), e.getValue(), null, null));
    }
    while (pq.size() > 1) { 
      Node x = pq.poll();
      Node y = pq.poll();
      Node parent = new Node(x.freq + y.freq, x, y);  // merge two smallest tries
      pq.add(parent);  // add back newly merge trie in the queue
    }
    return pq.poll();
  }

  /**
   * Internal trie node.
   */
  private static class Node implements Comparable<Node> { 
    private final char ch;           // used only for leaf nodes
    private final int freq;          // used only for compress
    private final Node left, right;

    public Node(int freq, Node left, Node right) { 
      this.ch = '\0';  // internal node
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    public Node(char ch, int freq, Node left, Node right) { 
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

    public int compareTo(Node that) {
      return this.freq - that.freq;
    }
  }
}
