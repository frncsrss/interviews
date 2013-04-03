package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class GraphTest {

  public static Graph setUp() {
    Graph g = new Graph(13);
    Assert.assertEquals(true, g.addEdge(0, 1));
    Assert.assertEquals(true, g.addEdge(0, 2));
    Assert.assertEquals(true, g.addEdge(0, 5));
    Assert.assertEquals(true, g.addEdge(0, 6));
    Assert.assertEquals(true, g.addEdge(5, 3));
    Assert.assertEquals(true, g.addEdge(3, 4));
    Assert.assertEquals(true, g.addEdge(6, 4));
    Assert.assertEquals(true, g.addEdge(7, 8));
    Assert.assertEquals(true, g.addEdge(9, 10));
    Assert.assertEquals(true, g.addEdge(9, 11));
    Assert.assertEquals(true, g.addEdge(9, 12));
    Assert.assertEquals(true, g.addEdge(11, 12));
    return g;
  }

  @Test
  public void test_E() {
    Graph g = setUp();
    Assert.assertEquals(12, g.E());
  }

  @Test
  public void test_V() {
    Graph g = setUp();
    Assert.assertEquals(13, g.V);
  }
}
