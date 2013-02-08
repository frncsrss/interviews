package interviews.queues;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FIFO class.
 * @author Francois Rousseau
 */
public class FIFO<E> {
  private LinkedListNode<E> head;
  private LinkedListNode<E> tail;
  private int size;
  private Lock lock;

  public FIFO() {
    head = tail = null;
    size = 0;
    lock = new ReentrantLock();
  }
  
  public FIFO<E> add(Collection<E> collection) throws InterruptedException {
    for(E e : collection) {
      add(e);
    }
    return this;
  }

  public FIFO<E> add(E e) throws InterruptedException {
    lock.lock();
    if(tail == null) {
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
    return size == 0;
  }
  
  public E remove() throws InterruptedException {
    lock.lock();
    if(head == null) {
      lock.unlock();
      return null;
    }
    E e = head.getValue();
    head = head.next();
    if(head == null) {
      tail = null;
    }
    size--;
    lock.unlock();
    return e;
  }
  
  public int size() {
    return size;
  }

  public String toString() {
    if(head == null) {
      return "";
    }
    return head.toString();
  }
}

class FIFOModifier<E> extends Thread {
  private FIFO<E> fifo;
  private final E e;

  public FIFOModifier(FIFO<E> fifo, E e) {
    this.fifo = fifo;
    this.e = e;
  }

  public void run() {
    try {
      Thread.sleep(Math.round(1 + Math.random()*2));
      if(Math.random() <= 0.5) {
        System.out.println(e+" adding "+fifo);
        fifo.add(e);
        System.out.println(e+" added "+fifo);
      } else {
        System.out.println(e+ " removing "+fifo);
        fifo.remove();
        System.out.println(e+ " removed "+fifo);
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
