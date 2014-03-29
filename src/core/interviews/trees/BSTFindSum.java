package interviews.trees;

import java.util.Stack;

/**
 * Given a BST of integers and a target value s, return two nodes summing to s.
 *
 * @author Francois Rousseau
 */
public class BSTFindSum {
  private Node root;

  public BSTFindSum() {}
  public BSTFindSum(int[] vs) {
    for(int v : vs) {
      insert(v);
    }
  }

  public void insert(int v) {
    root = insert(root, v);
  }

  /**
   * Let n be the number of nodes and h the height of the bst.
   * Time complexity:  O(n)
   * Space complexity: O(h)
   */
  public int[] sum(int s) {
    return sum(root, s);
  }

  private Node insert(Node node, int v) {
    if(node == null) {
      return new Node(v);
    }
    if(v > node.v) {
      node.right = insert(node.right, v);
    } else if(v < node.v) {
      node.left = insert(node.left, v);
    }  // we ignore duplicates
    return node;
  }

  private void addLeft(Node node, Stack<Node> ll) {
    Node curr = node;
    while(curr != null) {
      ll.add(curr);
      curr = curr.left;
    }
  }

  private void addRight(Node node, Stack<Node> ll) {
    Node curr = node;
    while(curr != null) {
      ll.add(curr);
      curr = curr.right;
    }
  }

  private int[] sum(Node node, int s) {
    if(node == null) {
      return null;
    }
    if(s < node.v) {  // speed-up
      return sum(node.left, s);
    }
    if(node.v * 2 < s && node.right == null) {  // no solution, you need at least one right element
      return null;
    }
    if(node.v * 2 > s && node.left == null) {  // no solution, you need at least one left element
      return null;
    }

    Stack<Node> right = new Stack<Node>();  // size of at most h
    addRight(node, right);
    if(s > right.peek().v * 2) {  // no solution, target is greater than twice the largest element
      return null;
    }

    Stack<Node> left = new Stack<Node>();  // size of at most h
    addLeft(node, left);

    while(!right.isEmpty() && !left.isEmpty()) {
      int sum = left.peek().v + right.peek().v;
      if(sum < s) {
        addLeft(left.pop().right, left);
      } else if(sum > s) {
        addRight(right.pop().left, right);
      } else {  // sum == s
        return new int[] {left.peek().v, right.peek().v};
      }
    }

    return null;
  }


  private class Node {
    private final int v;
    private Node left;
    private Node right;

    protected Node(int v) {
      this.v = v;
    }
  }
}
