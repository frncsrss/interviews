package interviews.queues;

import java.util.Comparator;

/**
 * Stack with a pointer to the maximum value.
 * @author Francois Rousseau
 */
public class MaximumValueStack<E> {
  private Comparator<E> comparator;
  private LinkedListNode<E> head;
  private LinkedListNode<E> max;

  public MaximumValueStack(Comparator<E> comparator) {
    this.comparator = comparator;
  }

  public E peek() {
    if(max == null) {
      return null;
    }
    return max.getValue();
  }

  public E pop() {
    if(head == null) {
      return null;
    }
    E value = head.getValue();
    if(comparator.compare(value, max.getValue()) == 0) {
      max = (max.hasNext()) ? max.next() : null;      
    }
    head = (head.hasNext()) ? head.next() : null;
    return value;
  }

  public MaximumValueStack<E> push(E e) {
    if(head == null) {
      head = new LinkedListNode<E>(e);
    } else {
      LinkedListNode<E> node = new LinkedListNode<E>(e);
      node.setNext(head);
      head = node;
    }
    if(max == null) {
      max = new LinkedListNode<E>(e);
    } else if(comparator.compare(e, max.getValue()) >= 0) {
      LinkedListNode<E> node = new LinkedListNode<E>(e);
      node.setNext(max);
      max = node;
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