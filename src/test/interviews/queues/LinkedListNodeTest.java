package interviews.queues;

import interviews.sorts.Sorts;

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

  @Test
  public void test_insertIntoCyclingSortedLinkedList() {
    LinkedListNode<Integer> node = new LinkedListNode<Integer>(1);
    node.setNext(node);
    Assert.assertEquals("1->1*", node.toString());
    node.insert(2, Sorts.getComparatorOfIntegers());
    Assert.assertEquals("1->2->1*", node.toString());
    node.insert(5, Sorts.getComparatorOfIntegers());
    Assert.assertEquals("1->2->5->1*", node.toString());
    node.insert(5, Sorts.getComparatorOfIntegers());
    Assert.assertEquals("1->2->5->5->1*", node.toString());
    node.insert(8, Sorts.getComparatorOfIntegers());
    Assert.assertEquals("1->2->5->5->8->1*", node.toString());
    node.insert(0, Sorts.getComparatorOfIntegers());
    Assert.assertEquals("1->2->5->5->8->0->1*", node.toString());
    node.insert(10, Sorts.getComparatorOfIntegers());
    Assert.assertEquals("1->2->5->5->8->10->0->1*", node.toString());
  }
}
