package interviews.trees;

import java.util.Comparator;

/**
 * Binary Tree.
 * @author Francois Rousseau
 */
public class BT<E> {

  /**
   * Check is a given tree (through its root node) is a valid BST or not.
   */
  public static <E> boolean isBST(Node<E> node, Comparator<E> comparator, E min, E max) {
    if(node == null) {
      return true;
    }
    if(comparator.compare(node.e, min) < 0 || comparator.compare(node.e, max) > 0) {
      return false;
    }
    return isBST(node.left, comparator, min, node.e) && isBST(node.right, comparator, node.e, max);
  }

  /**
   * Check is a given tree (through its root node) is a valid BST or not using in-order traversal.
   */
  public static <E> boolean isBST(Node<E> node, Comparator<E> comparator) {
    return isBST(node, comparator, new Node<E>(null));
  }

  public static <E> String serialize(Node<E> root) {
    StringBuilder builder = new StringBuilder();
    serialize(root, builder);
    return builder.toString();
  }

  public static Node<Integer> deserialize(String s) {
    return deserialize(s.toCharArray(), new int[]{-1});  // -1 to eat the non-existent (
  }


  private static <E> boolean isBST(Node<E> node, Comparator<E> comparator, Node<E> prev) {
    if(node == null) {
      return true;
    }
    if(!isBST(node.left, comparator, prev)) {    // visit left node
      return false;
    }
    // compare current value with previous one
    if(prev.e != null && comparator.compare(node.e, prev.e) <= 0) {
      return false;
    }
    prev.e = node.e;  // update previous value with current one
    return isBST(node.right, comparator, prev);  // visit right node
  }

  private static <E> void serialize(Node<E> node, StringBuilder builder) {
    if(node == null) {
      return;
    }
    builder.append(node.e);
    if(node.left == null && node.right == null) {
      return;
    }
    builder.append('(');
    serialize(node.left, builder);
    builder.append(')');
    builder.append('(');
    serialize(node.right, builder);
    builder.append(')');
  }

  private static Node<Integer> deserialize(char[] arr, int[] i) {  // int[] to pass it like a reference
    i[0]++;  // eat up (
    if(arr[i[0]] == ')') {
      i[0]++;  // eat up )
      return null;
    }
    StringBuilder builder = new StringBuilder();
    while(i[0] < arr.length && arr[i[0]] != '(' && arr[i[0]] != ')') {
      builder.append(arr[i[0]]);
      i[0]++;
    }
    Node<Integer> node = new Node<Integer>(Integer.parseInt(builder.toString()));
    if(i[0] == arr.length) {  // single root
    } else if(arr[i[0]] == ')') {  // leaf
      node.left = null;
      node.right = null;
    } else {
      node.left = deserialize(arr, i);
      node.right = deserialize(arr, i);
    }
    i[0]++;  // eat up )
    return node;
  }


  private static class Node<E> {
    private E e;
    private Node<E> left;
    private Node<E> right;

    public Node(E e) {
      this.e = e;
    }

    @Override
    public String toString() {
      return e == null ? null : e.toString();
    }
  }
}
