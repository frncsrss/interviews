package interviews.queues;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaximumValueStackTest {
  @Test
  public void test() {
    MaximumValueStack<Integer> stack = new MaximumValueStack<Integer>(new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });
    stack.push(-2).push(-6).push(-4).push(-1).push(-5).push(-1);
    Assert.assertEquals("-1->-5->-1->-4->-6->-2", stack.toString());
    Assert.assertEquals(new Integer(-1), stack.peek());
    Assert.assertEquals(new Integer(-1), stack.pop());
    Assert.assertEquals("-5->-1->-4->-6->-2", stack.toString());
    Assert.assertEquals(new Integer(-1), stack.peek());
    Assert.assertEquals(new Integer(-5), stack.pop());
    Assert.assertEquals("-1->-4->-6->-2", stack.toString());
    Assert.assertEquals(new Integer(-1), stack.peek());
    Assert.assertEquals(new Integer(-1), stack.pop());
    Assert.assertEquals("-4->-6->-2", stack.toString());
    Assert.assertEquals(new Integer(-2), stack.peek());
    Assert.assertEquals(new Integer(-4), stack.pop());
    Assert.assertEquals("-6->-2", stack.toString());
    Assert.assertEquals(new Integer(-2), stack.peek());
    Assert.assertEquals(new Integer(-6), stack.pop());
    Assert.assertEquals("-2", stack.toString());
    Assert.assertEquals(new Integer(-2), stack.peek());
    Assert.assertEquals(new Integer(-2), stack.pop());
    Assert.assertEquals("", stack.toString());
  }
}
