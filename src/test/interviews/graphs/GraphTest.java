package interviews.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class GraphTest {
  protected Graph<Integer> g;

  @Before
  public void setUp() {
    g = new Graph<Integer>(false);
    Assert.assertEquals(true, g.addEdge(1, 2));
    Assert.assertEquals(true, g.addEdge(1, 5));
    Assert.assertEquals(true, g.addEdge(1, 6));
    Assert.assertEquals(true, g.addEdge(2, 3));
    Assert.assertEquals(true, g.addEdge(2, 5));
    Assert.assertEquals(true, g.addEdge(3, 4));
    Assert.assertEquals(true, g.addEdge(4, 5));
  }
  
  @Test
  public void test_E() {
    Assert.assertEquals(7, g.E());
  }
  
  @Test
  public void test_V() {
    Assert.assertEquals(6, g.V());
  }
}
