package interviews.queues;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LRUCacheTest {
  @Test
  public void test_basic() {
    LRUCache<Integer, Integer> lru = new LRUCache<Integer, Integer>(5);
    Assert.assertEquals(null, lru.get(0));
    lru.put(0, 0);
    Assert.assertEquals(new Integer(0), lru.get(0));
    lru.put(0, 1);
    Assert.assertEquals(new Integer(1), lru.get(0));
    lru.put(2, 2);
    lru.put(3, 3);
    lru.put(4, 4);
    lru.put(5, 5);
    Assert.assertEquals(new Integer(1), lru.get(0));
    lru.put(6, 6);
    Assert.assertEquals(new Integer(1), lru.get(0));
    Assert.assertEquals(null, lru.get(2));
  }

  @Test
  public void test_capacity0() {
    LRUCache<Integer, Integer> lru = new LRUCache<Integer, Integer>(0);
    Assert.assertEquals(null, lru.get(0));
    lru.put(0, 0);
    Assert.assertEquals(null, lru.get(0));
    lru.put(1, 1);
    Assert.assertEquals(null, lru.get(1));
  }

  @Test
  public void test_capacity1() {
    LRUCache<Integer, Integer> lru = new LRUCache<Integer, Integer>(1);
    Assert.assertEquals(null, lru.get(0));
    lru.put(0, 0);
    Assert.assertEquals(new Integer(0), lru.get(0));
    lru.put(1, 1);
    Assert.assertEquals(null, lru.get(0));
    Assert.assertEquals(new Integer(1), lru.get(1));
  }
}
