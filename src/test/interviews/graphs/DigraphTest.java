package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class DigraphTest {

  public static Digraph setUp() {
    Digraph g = new Digraph(13);
    Assert.assertEquals(true, g.addEdge(4,  2));
    Assert.assertEquals(true, g.addEdge(2,  3));
    Assert.assertEquals(true, g.addEdge(3,  2));
    Assert.assertEquals(true, g.addEdge(6,  0));
    Assert.assertEquals(true, g.addEdge(0,  1 ));
    Assert.assertEquals(true, g.addEdge(2,  0));
    Assert.assertEquals(true, g.addEdge(11, 12));
    Assert.assertEquals(true, g.addEdge(12, 9));
    Assert.assertEquals(true, g.addEdge(9,  10));
    Assert.assertEquals(true, g.addEdge(9,  11));
    Assert.assertEquals(true, g.addEdge(8,  9));
    Assert.assertEquals(true, g.addEdge(10, 12));
    Assert.assertEquals(true, g.addEdge(11, 4));
    Assert.assertEquals(true, g.addEdge(4,  3));
    Assert.assertEquals(true, g.addEdge(3,  5));
    Assert.assertEquals(true, g.addEdge(6,  8));
    Assert.assertEquals(true, g.addEdge(8,  6));
    Assert.assertEquals(true, g.addEdge(5,  4));
    Assert.assertEquals(true, g.addEdge(0,  5));
    Assert.assertEquals(true, g.addEdge(6,  4));
    Assert.assertEquals(true, g.addEdge(6,  9));
    Assert.assertEquals(true, g.addEdge(7,  6));
    return g;
  }

  @Test
  public void test_E() {
    Digraph g = setUp();
    Assert.assertEquals(22, g.E());
  }

  @Test
  public void test_V() {
    Digraph g = setUp();
    Assert.assertEquals(13, g.V);
  }
}
