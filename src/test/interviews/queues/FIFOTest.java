package interviews.queues;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class FIFOTest {
  @Test
  public void test_singlethreaded() throws InterruptedException {
    FIFO<Integer> fifo = new FIFO<Integer>();
    Assert.assertEquals("", fifo.toString());
    Assert.assertEquals(0, fifo.size());
    Assert.assertEquals(true, fifo.isEmpty());

    fifo.add(Arrays.asList(1, 2, 3, 4, 5));
    Assert.assertEquals("1->2->3->4->5", fifo.toString());
    Assert.assertEquals(5, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    Assert.assertEquals(new Integer(1), fifo.remove());
    Assert.assertEquals("2->3->4->5", fifo.toString());
    Assert.assertEquals(4, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    fifo.add(6);
    Assert.assertEquals("2->3->4->5->6", fifo.toString());
    Assert.assertEquals(5, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    Assert.assertEquals(new Integer(2), fifo.remove());
    Assert.assertEquals(new Integer(3), fifo.remove());
    Assert.assertEquals(new Integer(4), fifo.remove());
    Assert.assertEquals("5->6", fifo.toString());
    Assert.assertEquals(2, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    Assert.assertEquals(new Integer(5), fifo.remove());
    Assert.assertEquals("6", fifo.toString());
    Assert.assertEquals(1, fifo.size());
    Assert.assertEquals(false, fifo.isEmpty());

    Assert.assertEquals(new Integer(6), fifo.remove());
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

  @Test
  public void test_multithreaded() throws InterruptedException {
    FIFO<Integer> fifo = new FIFO<Integer>();
    for(int i=1;i<100;i++) {
      (new FIFOModifier<Integer>(fifo, i)).start();
    }
    Thread.sleep(5000);
  }
}
