package interviews.queues;

/**
 * LnikedListStack class (LIFO).
 *
 * @author Francois Rousseau
 */
public class LinkedListStack<E> {
  private LinkedListNode<E> first;

  public boolean isEmpty() {
    return first == null;
  }

  public void push(E e) {
    LinkedListNode<E> node = new LinkedListNode<E>(e);
    node.setNext(first);
    first = node;
  }

  public E pop() {
    if(isEmpty()) {
      return null;
    }
    E e = first.getValue();
    first = first.next();
    return e;
  }
}
