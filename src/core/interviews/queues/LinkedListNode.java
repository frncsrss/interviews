package interviews.queues;

import java.util.Comparator;

/**
 * LinkedListNode class.
 * @author Francois Rousseau
 */
public class LinkedListNode<E> {
  private final E e;
  private LinkedListNode<E> next;

  public LinkedListNode(E e) {
    this.e = e;
  }

  public boolean hasNext() {
    return next != null;
  }

  public LinkedListNode<E> next() {
    return next;
  }

  public void setNext(LinkedListNode<E> e) {
    next = e;
  }

  public E getValue() {
    return e;
  }

  public void insert(E value, Comparator<E> comparator) {
    insert(value, this, comparator);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    LinkedListNode<E> current = this;
    builder.append(current.getValue());
    while(current.hasNext()) {
      builder.append("->" + current.next().getValue());
      current = current.next();
      if(current.equals(this)) {
        builder.append("*");
        break;
      }
    }
    return builder.toString();
  }

  public String toStringInReverseOrderWithRecursion() {
    StringBuilder builder = new StringBuilder();
    toStringInReverseOrderWithRecursion(builder);
    return builder.toString();
  }

  private void toStringInReverseOrderWithRecursion(StringBuilder builder) {
    if(next != null) {
      next.toStringInReverseOrderWithRecursion(builder);
    }
    builder.append(e);
  }

  public String toStringInReverseOrderWithoutRecursion() {
    if(!hasNext()) {
      return e.toString();
    }

    StringBuilder builder = new StringBuilder();
    // 1. first reverse the linked list
    LinkedListNode<E> new_head = this;
    LinkedListNode<E> current = this.next;
    LinkedListNode<E> old_head;
    new_head.next = null;
    while(current.hasNext()) {
      old_head = current.next;
      current.next = new_head;
      new_head = current;
      current = old_head;
    }
    current.next = new_head;
    new_head = current;

    System.out.println(new_head.toString());

    // 2. print and reverse it back
    builder.append(new_head.e);
    current = new_head.next;
    new_head.next = null;
    while(current.hasNext()) {
      old_head = current.next;
      current.next = new_head;
      new_head = current;
      builder.append(new_head.e);
      current = old_head;
    }
    current.next = new_head;
    new_head = current;
    builder.append(new_head.e);

    return builder.toString();
  }

  public static <E> void insert(E value, LinkedListNode<E> node, Comparator<E> comparator) {
    if(value == null || node == null) {
      return;
    }

    // look for pivot
    LinkedListNode<E> pivot = node.next;
    while(!pivot.equals(node)  // to avoid cycling indefinitely over a linked list with constant values
        && comparator.compare(pivot.e, pivot.next.e) <= 0) {  // find when the next value is smaller
      pivot = pivot.next;
    }

    // if pivot.e <= value or value <= pivot.next.e
    // for example if you want to insert 1 or 10 in ...->8->2->...
    if(comparator.compare(pivot.e, value) <= 0 || comparator.compare(pivot.next.e, value) >= 0) {
      LinkedListNode<E> newNode = new LinkedListNode<E>(value);
      newNode.next = pivot.next;
      pivot.next = newNode;
      return;
    }

    // else start from pivot.next (smallest value)
    LinkedListNode<E> prev = null;
    LinkedListNode<E> current = pivot.next;
    if(comparator.compare(node.e, value) <= 0) {  // to speed up, start from node if possible
      current = node;
    }

    while(comparator.compare(current.e, value) <= 0) {
      prev = current;
      current = current.next;
    }
    LinkedListNode<E> newNode = new LinkedListNode<E>(value);
    prev.next = newNode;
    newNode.next = current;
  }
}
