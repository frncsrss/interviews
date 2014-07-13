package interviews.queues;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LinkedListQueue class (FIFO).
 *
 * @author Francois Rousseau
 */
public class LinkedListQueue<E> {
  private LinkedListNode<E> head;
  private LinkedListNode<E> tail;
  private int size;
  private final Lock lock;

  public LinkedListQueue() {
    head = tail = null;
    size = 0;
    lock = new ReentrantLock();
  }

  public LinkedListQueue<E> add(Collection<E> collection) throws InterruptedException {
    for(E e : collection) {
      add(e);
    }
    return this;
  }

  public LinkedListQueue<E> add(E e) throws InterruptedException {
    lock.lock();
    if(isEmpty()) {
      head = tail = new LinkedListNode<E>(e);
    } else {
      tail.setNext(new LinkedListNode<E>(e));
      tail = tail.next();
    }
    size++;
    lock.unlock();
    return this;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public E dequeue() throws InterruptedException {
    lock.lock();
    if(isEmpty()) {
      lock.unlock();
      return null;
    }
    E e = head.getValue();
    head = head.next();
    if(isEmpty()) {
      tail = null;
    }
    size--;
    lock.unlock();
    return e;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    if(head == null) {
      return "";
    }
    return head.toString();
  }
}

class LinkedListQueueModifier<E> extends Thread {
  private final LinkedListQueue<E> fifo;
  private final E e;

  public LinkedListQueueModifier(LinkedListQueue<E> fifo, E e) {
    this.fifo = fifo;
    this.e = e;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(Math.round(1 + Math.random()*2));
      if(Math.random() <= 0.5) {
        System.out.println(e+" adding "+fifo);
        fifo.add(e);
        System.out.println(e+" added "+fifo);
      } else {
        System.out.println(e+ " removing "+fifo);
        fifo.dequeue();
        System.out.println(e+ " removed "+fifo);
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
