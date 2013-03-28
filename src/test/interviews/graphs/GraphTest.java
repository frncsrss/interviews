package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class GraphTest {
  protected Graph<Integer> g;

  protected void setUpDirected() {
    g = new Graph<Integer>(true);
    Assert.assertEquals(true, g.addEdge(0, 1));
    Assert.assertEquals(true, g.addEdge(0, 5));
    Assert.assertEquals(true, g.addEdge(2, 0));
    Assert.assertEquals(true, g.addEdge(2, 3));
    Assert.assertEquals(true, g.addEdge(3, 2));
    Assert.assertEquals(true, g.addEdge(3, 5));
    Assert.assertEquals(true, g.addEdge(4, 3));
    Assert.assertEquals(true, g.addEdge(4, 2));
    Assert.assertEquals(true, g.addEdge(5, 4));
    Assert.assertEquals(true, g.addEdge(6, 0));
    Assert.assertEquals(true, g.addEdge(6, 4));
    Assert.assertEquals(true, g.addEdge(6, 8));
    Assert.assertEquals(true, g.addEdge(6, 9));
    Assert.assertEquals(true, g.addEdge(7, 6));
    Assert.assertEquals(true, g.addEdge(7, 9));
    Assert.assertEquals(true, g.addEdge(8, 6));
    Assert.assertEquals(true, g.addEdge(9, 10));
    Assert.assertEquals(true, g.addEdge(9, 11));
    Assert.assertEquals(true, g.addEdge(10, 12));
    Assert.assertEquals(true, g.addEdge(11, 4));    
    Assert.assertEquals(true, g.addEdge(11, 12));
    Assert.assertEquals(true, g.addEdge(12, 9));
  }

  protected void setUpUndirected() {
    g = new Graph<Integer>(false);
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
  }

  @Test
  public void test_E() {
    setUpDirected();
    Assert.assertEquals(22, g.E());

    setUpUndirected();
    Assert.assertEquals(12, g.E());
  }

  @Test
  public void test_V() {
    setUpDirected();
    Assert.assertEquals(13, g.V());

    setUpUndirected();
    Assert.assertEquals(13, g.V());
  }
}
