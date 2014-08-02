package interviews.queues;

import java.util.Comparator;

/**
 * Stack with a pointer to the maximum value.
 *
 * @author Francois Rousseau
 */
public class MaximumValueStack<E> {
  private final Comparator<E> comparator;
  private LinkedListNode<E> head;
  private LinkedListNode<E> max;

  public MaximumValueStack(Comparator<E> comparator) {
    this.comparator = comparator;
  }

  public E max() {
    return max == null ? null : max.getValue();
  }

  public E pop() {
    if(head == null) {
      return null;
    }
    E value = head.getValue();
    if(comparator.compare(value, max.getValue()) == 0) {  // the head is the current max
      max = max.next();
    }
    head = head.next();
    return value;
  }

  public MaximumValueStack<E> push(E e) {
    if(head == null) {
      head = new LinkedListNode<E>(e);
      max = new LinkedListNode<E>(e);
    } else {
      LinkedListNode<E> node = new LinkedListNode<E>(e);
      node.setNext(head);
      head = node;
      if(comparator.compare(e, max.getValue()) >= 0) {
        node = new LinkedListNode<E>(e);
        node.setNext(max);
        max = node;
      }
    }
    return this;
  }

  @Override
  public String toString() {
    if(head == null) {
      return "";
    }
    return head.toString();
  }
}