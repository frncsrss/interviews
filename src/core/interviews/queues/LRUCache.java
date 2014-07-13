package interviews.queues;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache implementation.
 *
 * @author Francois Rousseau
 */
public class LRUCache<K, V> {

  private final int capacity;
  private DoubleLinkedListNode head;
  private DoubleLinkedListNode tail;
  private final Map<K, DoubleLinkedListNode> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head = null;
    this.tail = null;
    this.map = new HashMap<K, DoubleLinkedListNode>();
  }

  public V get(K key) {
    if(!map.containsKey(key)) {  // not in cache
      return null;
    }
    DoubleLinkedListNode node = map.get(key);
    if(!node.equals(head)) {     // if already head, nothing to do
      if(!node.equals(tail)) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
      } else {
        node.prev.next = null;
        tail = node.prev;
      }
      node.prev = null;
      node.next = head;
      head.prev = node;
      head = node;
    }
    return node.val;
  }

  public void put(K key, V val) {
    V v2 = get(key);
    if(val.equals(v2)) {  // already in cache with same value (get will have moved it to head)
      return;
    }
    if(v2 == null) {               // cache miss
      DoubleLinkedListNode node = new DoubleLinkedListNode(key, val);
      map.put(key, node);
      if(head == null) {           // empty cache
        head = node;
        tail = node;
      } else {
        node.next = head;
        head.prev = node;
        head = node;
      }
      if(map.size() > capacity) {  // check capacity, if over remove LRU
        map.remove(tail.key);
        if(tail.prev != null) {    // at least another element
          tail.prev.next = null;
          tail = tail.prev;
        } else {
          head = null;
          tail = null;
        }
      }
      return;
    }
    head.val = val;                // update value
  }

  private class DoubleLinkedListNode {
    public K key;
    public V val;
    public DoubleLinkedListNode prev;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(K key, V val) {
      this.key = key;
      this.val = val;
      prev = null;
      next = null;
    }
  }
}
