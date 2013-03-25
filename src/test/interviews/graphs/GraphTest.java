package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class GraphTest {
  @Test
  public void test_basic() {
    final Graph<Integer> g = new Graph<Integer>(false);
    Assert.assertEquals(0, g.E());
    Assert.assertEquals(true, g.addEdge(1, 2));
    Assert.assertEquals(true, g.addEdge(1, 5));
    Assert.assertEquals(true, g.addEdge(1, 6));
    Assert.assertEquals(true, g.addEdge(2, 3));
    Assert.assertEquals(true, g.addEdge(2, 5));
    Assert.assertEquals(true, g.addEdge(3, 4));
    Assert.assertEquals(true, g.addEdge(4, 5));
    Assert.assertEquals(7, g.E());
  }

  @Test
  public void test_bfs() {
    final Graph<Integer> g = new Graph<Integer>(false);
    Assert.assertEquals(true, g.addEdge(1, 2));
    Assert.assertEquals(true, g.addEdge(1, 5));
    Assert.assertEquals(true, g.addEdge(1, 6));
    Assert.assertEquals(true, g.addEdge(2, 3));
    Assert.assertEquals(true, g.addEdge(2, 5));
    Assert.assertEquals(true, g.addEdge(3, 4));
    Assert.assertEquals(true, g.addEdge(4, 5));

    g.bfs(1);
    Assert.assertEquals(null, g.getParent(1));
    Assert.assertEquals(new Integer(1), g.getParent(2));
    Assert.assertEquals(new Integer(2), g.getParent(3));
    Assert.assertEquals(new Integer(5), g.getParent(4));
    Assert.assertEquals(new Integer(1), g.getParent(5));
    Assert.assertEquals(new Integer(1), g.getParent(6));
  }

  @Test
  public void test_dfs() {
    final Graph<Integer> g = new Graph<Integer>(false);
    Assert.assertEquals(true, g.addEdge(1, 2));
    Assert.assertEquals(true, g.addEdge(1, 5));
    Assert.assertEquals(true, g.addEdge(1, 6));
    Assert.assertEquals(true, g.addEdge(2, 3));
    Assert.assertEquals(true, g.addEdge(2, 5));
    Assert.assertEquals(true, g.addEdge(3, 4));
    Assert.assertEquals(true, g.addEdge(4, 5));

    g.dfs(1);
    Assert.assertEquals(null, g.getParent(1));
    Assert.assertEquals(new Integer(1), g.getParent(2));
    Assert.assertEquals(new Integer(2), g.getParent(3));
    Assert.assertEquals(new Integer(3), g.getParent(4));
    Assert.assertEquals(new Integer(4), g.getParent(5));
    Assert.assertEquals(new Integer(1), g.getParent(6));
  }
}
