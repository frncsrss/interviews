package interviews.trees;

/**
 * Binary Tree.
 * @author Francois Rousseau
 */
public class BT<E> {
  public static <E> String serialize(Node<E> root) {
    StringBuilder builder = new StringBuilder();
    serialize(root, builder);
    return builder.toString();
  }

  private static <E> void serialize(Node<E> node, StringBuilder builder) {
    if(node == null) {
      return;
    }
    builder.append(node.value);
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

  public static Node<Integer> deserialize(String s) {
    return deserialize(s.toCharArray(), new int[]{-1});  // -1 to eat the non-existent (
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
    Node<Integer> node = new Node<Integer>();
    node.value = Integer.parseInt(builder.toString());
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
    private E value;
    private Node<E> left;
    private Node<E> right;
  }
}
