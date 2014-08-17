package interviews.arrays;

import interviews.lib.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Heap of keys with integer values. Allow in logarithmic time the update (increase or decrease) of
 * values for keys inside the heap.
 *
 * @author Francois Rousseau
 */
public class UpdatableHeap<K> {
  private final List<Node> heap;
  private final Map<K, Integer> pos;

  public UpdatableHeap() {
    heap = new ArrayList<Node>();
    pos = new HashMap<K, Integer>();
  }

  /**
   * Insert the specified element into this heap.
   */
  public boolean add(K key, int value) throws NullPointerException {
    if(key == null) {
      return false;
    }
    heap.add(new Node(key, value));  // we add the element at the end of the array
    pos.put(key, size() - 1);
    bubbleUp(size() - 1);  // we "bubble it up" until it reaches its position in the heap
    return true;
  }

  /**
   * Does the heap contains the given key?
   */
  public boolean containsKey(K key) {
    return pos.containsKey(key);
  }

  /**
   * Decrease by value the value for the key. Bubble up the key if necessary. Runs in O(logN).
   */
  public boolean decreaseKey(K key, int value) {
    if(!pos.containsKey(key)) {
      return false;
    }
    int index = pos.get(key);
    Node node = heap.get(index);
    node.v -= value;
    bubbleUp(index);
    return true;
  }

  /**
   * Increase by value the value for the key. Bubble down the key if necessary. Runs in O(logN).
   */
  public boolean increaseKey(K key, int value) {
    if(!pos.containsKey(key)) {
      return false;
    }
    int index = pos.get(key);
    Node node = heap.get(index);
    node.v += value;
    bubbleDown(index);
    return true;
  }

  /**
   * Is the heap empty?
   */
  public boolean isEmpty() {
    return heap.size() == 0;
  }

  /**
   * Return the keys.
   */
  public Set<K> keySet() {
    return pos.keySet();
  }

  /**
   * Retrieve and remove the head of this heap, or return null if this heap is empty.
   */
  public Pair<K, Integer> poll() {
    if(isEmpty()) {
      return null;
    }
    swap(0, size() - 1);  // we swap the element to remove with the element at the end of the array
    Node head = heap.remove(size() - 1);  // the head is now at the end
    pos.remove(head.k);
    if(size() > 0) {  // if the heap is not empty
      bubbleDown(0);  // we bubble down the element previously at the end
    }
    return new Pair<K, Integer>(head.k, head.v);
  }

  /**
   * Return the number of elements in this collection.
   */
  public int size() {
    return heap.size();
  }

  /**
   * Return a String representation of the array backing up the heap.
   */
  @Override
  public String toString() {
    return heap.toString();
  }

  //////////////////
  // Private methods
  //////////////////

  private int bubbleUp(int index) {
    try {
      final int parent = parent(index);
      if(get(index).compareTo(get(parent)) < 0) {
        swap(index, parent);
        return bubbleUp(parent);
      }
    } catch(NoSuchElementException exc) {}
    return index;
  }

  private int bubbleDown(int index) {
    int child = index;
    final int left = left(index);
    if(left < size()) {  // there is a left child
      if(get(child).compareTo(get(left)) > 0) {
        child = left;  // we should at least swap with the left child
      }
      final int right = left + 1;
      if(right < size() && get(child).compareTo(get(right)) > 0) {
        child = right;  // we should swap with the right child
      }
    }
    if(child != index) {  // there is one child with a bigger value
      swap(index, child);
      return bubbleDown(child);
    }
    return index;
  }

  private Node get(int index) {
    return heap.get(index);
  }

  private int left(int index) {
    return 2 * index + 1;
  }

  private int parent(int index) {
    return (index - 1) / 2;  // if index == 0 (root), return 0
  }

  private void swap(int from, int with) {
    pos.put(heap.get(from).k, with);
    pos.put(heap.get(with).k, from);
    Collections.swap(heap, from, with);
  }


  private class Node implements Comparable<Node>{
    public final K k;
    public int v;

    public Node(K k, int v) {
      this.k = k;
      this.v = v;
    }

    @Override
    public int compareTo(Node that) {
      if(this.v > that.v) return +1;
      if(this.v < that.v) return -1;
      return 0;
    }

    @Override
    public String toString() {
      return String.format("%s(%d)", k.toString(), v);
    }
  }
}
