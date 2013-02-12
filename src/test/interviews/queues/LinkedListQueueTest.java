package interviews.queues;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LinkedListQueueTest {
  @Test
  public void test() throws InterruptedException {
    LinkedListQueue<Integer> fifo = new LinkedListQueue<Integer>();
    Assert.assertEquals("", fifo.toString());
    Assert.assertEquals(0, fifo.size());
    Assert.assertEquals(true, fifo.isEmpty());

    fifo.add(Arrays.asList(1, 2, 3, 4, 5));
    Assert.assertEquals("1->2->3->4->5", fifo.toString());
    Assert.assertEquals(5, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    Assert.assertEquals(new Integer(1), fifo.dequeue());
    Assert.assertEquals("2->3->4->5", fifo.toString());
    Assert.assertEquals(4, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    fifo.add(6);
    Assert.assertEquals("2->3->4->5->6", fifo.toString());
    Assert.assertEquals(5, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    Assert.assertEquals(new Integer(2), fifo.dequeue());
    Assert.assertEquals(new Integer(3), fifo.dequeue());
    Assert.assertEquals(new Integer(4), fifo.dequeue());
    Assert.assertEquals("5->6", fifo.toString());
    Assert.assertEquals(2, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    Assert.assertEquals(new Integer(5), fifo.dequeue());
    Assert.assertEquals("6", fifo.toString());
    Assert.assertEquals(1, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    Assert.assertEquals(new Integer(6), fifo.dequeue());
    Assert.assertEquals("", fifo.toString());
    Assert.assertEquals(0, fifo.size());
    Assert.assertEquals(true, fifo.isEmpty());

    fifo.add(7);
    Assert.assertEquals("7", fifo.toString());
    Assert.assertEquals(1, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    fifo.add(8);
    Assert.assertEquals("7->8", fifo.toString());
    Assert.assertEquals(2, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());
  }
}
