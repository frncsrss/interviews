package interviews.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class UpdatableHeapTest {
  @Test
  public void test() {
    UpdatableHeap<Integer> heap = new UpdatableHeap<Integer>();
    heap.add(0, 10);
    heap.add(1, 20);
    heap.add(2, 30);
    heap.add(3, 15);
    heap.add(4, 25);
    Assert.assertEquals("[0(10), 3(15), 2(30), 1(20), 4(25)]", heap.toString());
    Assert.assertEquals(true, heap.increaseKey(3, 8));
    Assert.assertEquals("[0(10), 1(20), 2(30), 3(23), 4(25)]", heap.toString());
    Assert.assertEquals(true, heap.decreaseKey(1, 12));
    Assert.assertEquals("[1(8), 0(10), 2(30), 3(23), 4(25)]", heap.toString());
  }
}
