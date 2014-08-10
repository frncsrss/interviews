package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MinCutTest {
  @Test
  public void test() {
    MinCut mc = new MinCut(GraphTest.setUp());
    Assert.assertEquals(1, mc.f(0, 2));
    Assert.assertEquals(2, mc.f(0, 4));
    Assert.assertEquals(2, mc.f(3, 4));
    Assert.assertEquals(1, mc.f(7, 8));
    Assert.assertEquals(2, mc.f(9, 12));
    Assert.assertEquals(2, mc.f(10, 11));
  }
}
