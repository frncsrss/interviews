package interviews.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a stream of elements, find in a single pass the first unique element.
 *
 * @author Francois Rousseau
 */
public class FirstUniqueElement {
  /**
   * Use a hashmap to store as keys the elements seen so far and as values a node in a double
   * linked list for unique elements and null values otherwise. The head of the linked list is the
   * first unique element seen so far.
   *
   * Let n = length(stream).
   * Time complexity:  O(n)
   * Space complexity: O(n + u), u = # unique elements
   */
  public static int f(int[] stream) {
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;
    for(int element : stream) {  // we scan the stream only once
      if(!map.containsKey(element)) {  // first time we see the element
        Node node = new Node(element);
        if(head == null) {
          head = node;
        } else {
          tail.next = node;
          node.prev = tail;
        }
        tail = node;
        map.put(element, node);
      } else {  // duplicate element, remove from linked list if second time we see it
        Node node = map.get(element);
        if(node == null) {  // the element has already been removed from the linked list
          continue;
        }
        if(node == head && node == tail) {  // single element in the linked list
          head = null;
          tail = null;
        } else if(node == head) {  // element was the head of the linked list
          head = head.next;
          head.prev = null;
        } else if(node == tail) {  // element was the tail of the linked list
          tail = tail.prev;
          tail.next = null;
        } else {
          node.next.prev = node.prev;
          node.prev.next = node.next;
        }
        node = null;
        map.put(element, null);
      }
    }
    return head.value;
  }

  private static class Node {
    private final int value;
    private Node prev;
    private Node next;

    public Node(int value) {
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }
}
