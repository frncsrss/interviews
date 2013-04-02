package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ConnectedComponentTest {
  @Test
  public void test_directed() {
    ConnectedComponent<Integer> cc = new ConnectedComponent<Integer>(DigraphTest.setUp());
    Assert.assertEquals(5, cc.count());
    Assert.assertEquals(1, cc.id(0));
    Assert.assertEquals(0, cc.id(1));
    Assert.assertEquals(1, cc.id(2));
    Assert.assertEquals(1, cc.id(3));
    Assert.assertEquals(1, cc.id(4));
    Assert.assertEquals(1, cc.id(5));
    Assert.assertEquals(3, cc.id(6));
    Assert.assertEquals(4, cc.id(7));
    Assert.assertEquals(3, cc.id(8));
    Assert.assertEquals(2, cc.id(9));
    Assert.assertEquals(2, cc.id(10));
    Assert.assertEquals(2, cc.id(11));
    Assert.assertEquals(2, cc.id(12));

    Assert.assertEquals(false, cc.connected(0, 1));
    Assert.assertEquals(false, cc.connected(0, 7));
    Assert.assertEquals(true, cc.connected(0, 2));
  }

  @Test
  public void test_undirected() {
    ConnectedComponent<Integer> cc = new ConnectedComponent<Integer>(GraphTest.setUp());
    Assert.assertEquals(3, cc.count());
    Assert.assertEquals(0, cc.id(0));
    Assert.assertEquals(0, cc.id(1));
    Assert.assertEquals(0, cc.id(2));
    Assert.assertEquals(0, cc.id(3));
    Assert.assertEquals(0, cc.id(4));
    Assert.assertEquals(0, cc.id(5));
    Assert.assertEquals(0, cc.id(6));
    Assert.assertEquals(1, cc.id(7));
    Assert.assertEquals(1, cc.id(8));
    Assert.assertEquals(2, cc.id(9));
    Assert.assertEquals(2, cc.id(10));
    Assert.assertEquals(2, cc.id(11));
    Assert.assertEquals(2, cc.id(12));

    Assert.assertEquals(true,  cc.connected(0, 1));
    Assert.assertEquals(false, cc.connected(0, 7));
  }
}
