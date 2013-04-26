package interviews.trees;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Huffman encoding (prefix-free).
 * @author Francois Rousseau
 */
public class Huffman {
  private static Node root;  // root of the trie
  private static Map<Character, String> st;  // symbol table

  /**
   * Decode the input String using the current trie.
   * @throws IOException 
   */
  public static void decode() throws IOException {
    Scanner stdin = new Scanner(System.in);
    PrintWriter stdout = new PrintWriter(System.out);

    // read the input
    String s = stdin.next();
    char[] input = s.toCharArray();

    int i = 0;
    while(i < input.length) {
      Node x = root;
      while(!x.isLeaf()) {
        if(input[i++] == '0') {
          x = x.left;
        }
        else {
          x = x.right;
        }
      }
      stdout.write(x.ch);
    }
    stdout.flush();
  }

  /**
   * Encode the input String using Huffman algorithm.
   * Overwriting previous trie and symbol table.
   * @throws IOException 
   */
  public static void encode() throws IOException {
    Scanner stdin = new Scanner(System.in);
    PrintWriter stdout = new PrintWriter(System.out);

    // read the input
    String s = stdin.next();
    char[] input = s.toCharArray();

    // tabulate frequency counts
    Map<Character, Integer> freq = new HashMap<Character, Integer>();
    for(char c: input) {
      if(!freq.containsKey(c)) {
        freq.put(c, 1);
      } else {
        freq.put(c, freq.get(c) + 1);
      }
    }

    // build Huffman trie
    root = makeTrie(freq);

    // build code table
    st = new HashMap<Character, String>();
    makeTable(st, root, "");

    // use Huffman code to encode input
    for(char c: input) {
      stdout.write(st.get(c));
    }
    stdout.flush();
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
