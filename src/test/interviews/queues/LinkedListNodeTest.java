package interviews.queues;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LinkedListNodeTest {
  @Test
  public void test_toString() {
    LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1);
    LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2);
    node1.setNext(node2);
    LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3);
    node2.setNext(node3);
    LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4);
    node3.setNext(node4);
    LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(5);
    node4.setNext(node5);
    Assert.assertEquals("1->2->3->4->5", node1.toString());
  }

  @Test
  public void test_toStringInReverseOrderWithRecursion() {
    LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1);
    LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2);
    node1.setNext(node2);
    LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3);
    node2.setNext(node3);
    LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4);
    node3.setNext(node4);
    LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(5);
    node4.setNext(node5);
    Assert.assertEquals("54321", node1.toStringInReverseOrderWithRecursion());

    node1.setNext(null);
    Assert.assertEquals("1", node1.toStringInReverseOrderWithRecursion());
  }

  @Test
  public void test_toStringInReverseOrderWithoutRecursion() {
    LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1);
    LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2);
    node1.setNext(node2);
    LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3);
    node2.setNext(node3);
    LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4);
    node3.setNext(node4);
    LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(5);
    node4.setNext(node5);
    Assert.assertEquals("54321", node1.toStringInReverseOrderWithoutRecursion());

    node1.setNext(null);
    Assert.assertEquals("1", node1.toStringInReverseOrderWithoutRecursion());
  }
}
