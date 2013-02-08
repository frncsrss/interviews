package interviews.trees;

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
public class Heap<E> implements Iterable<E> {

  public static void main(String[] args) {
    int n = 100;
    List<Integer> list = new ArrayList<Integer>(n);
    for (int i = 0; i < n; i++) {
      list.add(new Integer(i));
    }
    Comparator<Integer> comparatorInteger = new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };
    Collections.shuffle(list);    
    Heap<Integer> heap = new Heap<Integer>(list, comparatorInteger);
    System.out.println(heap);
  }

  private List<E> heap;
  private Comparator<E> comparator;
  
	public Heap(Collection<E> collection, Comparator<E> comparator) {
	  this.comparator = comparator;
	  heapify(collection);
	}
	
	/**
	 * 	Inserts the specified element into this heap.
	 */
	public boolean add(E e) throws NullPointerException {
	  if(e == null) throw new NullPointerException();
	  heap.add(e);
	  bubbleUp(size()-1);
	  return true;
	}

	 /**
   *  Removes all of the elements from this heap.
   */
	public void clear() {
	  heap.clear();
	}

	/**
	 * 	Returns the comparator used to order the elements in this heap.
	 */
	public Comparator<E> comparator() {
	  return comparator;
	}

	/**
	 * 	Returns true if this heap contains the specified element.
	 */
	public boolean contains(E e) {
	  return contains(e, 0);
	}

	/**
	 * 	Retrieves, but does not remove, the head of this heap.
	 *  @throws: NoSuchElementException if the heap is empty.
	 */
	public E element() {
	  if(size()==0) throw new NoSuchElementException();
	  return get(0);
	}

  /**
   *  Returns an iterator over the elements in this heap.
   */
  @Override
  public Iterator<E> iterator() {
    return heap.iterator();
  }

	/**
	 * 	Inserts the specified element into this heap.
	 */
  public boolean offer(E e) throws NullPointerException {
    return add(e);
  }

  /**
   *  Retrieves, but does not remove, the head of this heap.
   *  or returns null if this heap is empty.
   */
  public E peek() {
    try {
      return element();
    } catch(NoSuchElementException e) {
      return null;
    }
  }

	/**
	 * 	Retrieves and removes the head of this heap, or returns null if this heap is empty.
	 */
  public E poll() {
    try {
      return remove();
    } catch(NoSuchElementException e) {
      return null;
    }
  }

	/**
   *  Retrieves and remove the head of this heap.
   *  @throws: NoSuchElementException if the heap is empty.
	 */
  public E remove() throws NoSuchElementException {
    if(size()==0) throw new NoSuchElementException();
    swap(0, size()-1);
    E min = heap.remove(size()-1);
    if(size()>0) bubbleDown(0); // otherwise the heap is already empty
    return min;
  }

	/**
	 * 	Removes a single instance of the specified element from this heap, if it is present.
	 */
  public boolean remove(E e) {
    return remove(e, 0);
  }

	/**
	 * 	Returns the number of elements in this collection.
	 */
  public int size() {
    return heap.size();
  }
  
	/**
	 * 	Returns an array containing all of the elements in this heap.
	 */
  public Object[] toArray() {
    return heap.toArray();
  }
  
	/**
	 * 	Returns an array containing all of the elements in this heap.
	 *  The runtime type of the returned array is that of the specified array.
	 */
  public <T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException {
    return heap.toArray(a);
  }
  
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    int power = 1;
    for (E e : heap) {
      buffer.append(e+" ");
      power++;
      if((power&(power-1))==0) {  // power of 2;
        buffer.append("\n");
      }
    }
    return buffer.toString();
  }

  //////////////////
  // Private methods
  //////////////////
  
	private int bubbleUp(int index) {
	  try {
	    int indexParent = parent(index);
	    if(comparator.compare(get(index), get(indexParent)) > 0) {
	      swap(index, indexParent);
	      return bubbleUp(indexParent);
	    }	    
	  } catch(NoSuchElementException exc) {}
	  return index;
	}

	private int bubbleDown(int index) {
    try {
      int parent = index;
      int left = left(index);
      if(comparator.compare(get(parent), get(left)) < 0) {
        parent = left;
      }
      try {
        int right = right(index);
          if(comparator.compare(get(parent), get(right)) < 0) {
            parent = right;
          }
          if(parent != index) {
            swap(index, parent);
            return bubbleDown(parent);
          }
        } catch(NoSuchElementException exc) {  // we still have to mqke the swap with the left child
          if(parent != index) {
            swap(index, parent);
            return bubbleDown(parent);
          }
        }
    } catch(NoSuchElementException exc) {}  // no child
    return index;	  
	}

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

  private E get(int index) {
    return heap.get(index);
  }
  
	private int left(int index) throws NoSuchElementException {
	  if(2*index+1 > size()-1) throw new NoSuchElementException();
	  return 2*index+1;
	}

	private void heapify(Collection<E> collection) {
    heap = new ArrayList<E>();
    for(E e: collection) {
      heap.add(e);
    }
    for(int i=(size()-1)/2;i>=0;i--) {
      bubbleDown(i);
    }  // doing that instead of this.add(e) in the previous loop guarantees a construction in O(n) instead of O(nlogn)
  }
  
  private int parent(int index) throws NoSuchElementException {
    if(index==0) throw new NoSuchElementException();
    if(index==1) return 0;
    return (int)((index-1)/2);
  }

  private boolean remove(E e, int index) {
    if(comparator.compare(e, get(index)) == 0) {
      heap.remove(index);
      heapify(heap);
      return true;
    }
    try {
      if(remove(e, left(index))) return true;
      try {
        if(remove(e, right(index))) return true;
      } catch(NoSuchElementException exc) {}
    } catch(NoSuchElementException exc) {}
    return false;    
  }
  
  private int right(int index) throws NoSuchElementException {
    if(2*index+2 > size()-1) throw new NoSuchElementException();
    return 2*index+2;
  }
  
  private void swap(int from, int with) {
    Collections.swap(heap, from, with);   
  }
}
