package interviews.queues;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LinkedListStackTest {
  @Test
  public void test() {
    LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
    Assert.assertEquals(true, stack.isEmpty());
    Assert.assertEquals(null, stack.pop());
    stack.push(1);
    Assert.assertEquals(new Integer(1), stack.pop());
    stack.push(1);
    stack.push(2);
    Assert.assertEquals(new Integer(2), stack.pop());
    Assert.assertEquals(new Integer(1), stack.pop());
  }

}
