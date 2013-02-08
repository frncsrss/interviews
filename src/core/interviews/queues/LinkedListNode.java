package interviews.queues;

/**
 * LinkedListNode class.
 * @author Francois Rousseau
 */
public class LinkedListNode<E> {
  private E e;
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

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    LinkedListNode<E> current = this;
    builder.append(current.getValue());
    while(current.hasNext()) {
      builder.append("->" + current.next().getValue());
      current = current.next();
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
}
