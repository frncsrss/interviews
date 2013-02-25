package interviews.arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Heap.
 * @author Francois Rousseau
 */
public abstract class Heap<E> implements Iterable<E> {

  private List<E> heap;
  protected Comparator<E> comparator;
  
  public Heap(Comparator<E> comparator) {
    this.comparator = comparator;
    heapify(null);
  }
  
	public Heap(Collection<E> collection, Comparator<E> comparator) {
	  this.comparator = comparator;
	  heapify(collection);
	}

	/**
	 * Inserts the specified element into this heap.
	 */
	public boolean add(E e) throws NullPointerException {
	  if(e == null) {
	    throw new NullPointerException();
	  }
	  heap.add(e);  // we add the element at the end of the array
	  bubbleUp(size()-1);  // we "bubble it up" until it reaches its position in the heap
	  return true;
	}

	 /**
   * Removes all of the elements from this heap.
   */
	public void clear() {
	  heap.clear();
	}

	/**
	 * Returns the comparator used to order the elements in this heap.
	 */
	public Comparator<E> comparator() {
	  return comparator;
	}

	/**
	 * Returns true if this heap contains the specified element.
	 */
	public boolean contains(E e) {
	  return contains(e, 0);
	}

	/**
	 * Retrieves, but does not remove, the head of this heap.
	 * @throws: NoSuchElementException if the heap is empty.
	 */
	public E element() {
	  if(isEmpty()) {
	    throw new NoSuchElementException();
	  }
	  return get(0);
	}

  /**
	 * Is the heap empty?
	 */
  public boolean isEmpty() {
    return heap.size() == 0;
  }
  
  /**
   * Returns an iterator over the elements in this heap.
   */
  @Override
  public Iterator<E> iterator() {
    return heap.iterator();
  }

	/**
	 * Inserts the specified element into this heap.
	 */
  public boolean offer(E e) throws NullPointerException {
    return add(e);
  }

  /**
   * Retrieves, but does not remove, the head of this heap.
   * or returns null if this heap is empty.
   */
  public E peek() {
    try {
      return element();
    } catch(NoSuchElementException e) {
      return null;
    }
  }

	/**
	 * Retrieves and removes the head of this heap, or returns null if this heap is empty.
	 */
  public E poll() {
    try {
      return remove();
    } catch(NoSuchElementException e) {
      return null;
    }
  }

	/**
   * Retrieves and remove the head of this heap.
   * @throws: NoSuchElementException if the heap is empty.
	 */
  public E remove() throws NoSuchElementException {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    swap(0, size()-1);  // we swap the element to remove with the element at the end of the array
    final E head = heap.remove(size()-1);  // the head is now at the end
    if(size() > 0) {  // if the heap is not empty
      bubbleDown(0);  // we bubble down the element previously at the end
    }
    return head;
  }

	/**
	 * Removes a single instance of the specified element from this heap, if it is present.
	 */
  public boolean remove(E e) {
    return remove(e, 0);
  }

	/**
	 * Returns the number of elements in this collection.
	 */
  public int size() {
    return heap.size();
  }
  
	/**
	 * Returns an array containing all of the elements in this heap.
	 */
  public Object[] toArray() {
    return heap.toArray();
  }
  
	/**
	 * Returns an array containing all of the elements in this heap.
	 * The runtime type of the returned array is that of the specified array.
	 */
  public <T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException {
    return heap.toArray(a);
  }
  
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    int power = 1;
    for (E e : heap) {
      buffer.append(e + " ");
      power++;
      if((power & (power-1)) == 0) {  // power of 2;
        buffer.deleteCharAt(buffer.length() - 1).append("\n");
      }
    }
    return buffer.deleteCharAt(buffer.length() - 1).toString();
  }

  //////////////////
  // Private methods
  //////////////////
  
	abstract protected int bubbleUp(int index);

	abstract protected int bubbleDown(int index);

  private boolean contains(E e, int index) {
    if(comparator.compare(e, get(index)) == 0) {
      return true;
    }
    try {
      if(contains(e, left(index))) {
        return true;
      }
      try {
        if(contains(e, right(index))) {
          return true;
        }
      } catch(NoSuchElementException exc) {
      }
    } catch(NoSuchElementException exc) {
    }
    return false;
  }

  protected E get(int index) {
    return heap.get(index);
  }
  
	protected int left(int index) throws NoSuchElementException {
	  if(2*index + 1 > size()-1) {  // if its a node without left child
	    throw new NoSuchElementException();
	  }
	  return 2*index + 1;
	}

	private void heapify(Collection<E> collection) {
    heap = new ArrayList<E>();
	  if(collection == null || collection.isEmpty()) {
	    return;
	  }
    for(E e: collection) {
      heap.add(e);
    }
    for(int i=(size()-1)/2; i>=0; i--) {
      bubbleDown(i);
    }  // doing that instead of this.add(e) in the previous loop guarantees a construction in O(n) instead of O(nlogn)
  }
  
  protected int parent(int index) throws NoSuchElementException {
    if(index == 0) {  // the root has no parent
      throw new NoSuchElementException();
    }
    return (int)((index - 1) / 2);  // there is a formula for the rest of the indices
  }

  private boolean remove(E e, int index) {
    if(comparator.compare(e, get(index)) == 0) {
      heap.remove(index);
      heapify(heap);  // much easier
      return true;
    }
    try {
      if(remove(e, left(index))) {
        return true;
      }
      try {
        if(remove(e, right(index))) {
          return true;
        }
      } catch(NoSuchElementException exc) {}
    } catch(NoSuchElementException exc) {}
    return false;    
  }
  
  protected int right(int index) throws NoSuchElementException {
    if(2*index + 2 > size()-1) {  // if its a node without right child
      throw new NoSuchElementException();
    }
    return 2*index + 2;
  }
  
  protected void swap(int from, int with) {
    Collections.swap(heap, from, with);   
  }
}
