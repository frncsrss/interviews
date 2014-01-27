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
    Assert.assertEquals(true, g.addEdge(0,  1));
    Assert.assertEquals(true, g.addEdge(2,  0));
    Assert.assertEquals(true, g.addEdge(11, 12));
    Assert.assertEquals(true, g.addEdge(12, 9));
    Assert.assertEquals(true, g.addEdge(9,  10));
    Assert.assertEquals(true, g.addEdge(9,  11));
    Assert.assertEquals(true, g.addEdge(7,  9));
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

  public static Digraph setUpWeighted() {
    Digraph g = new Digraph(8);
    Assert.assertEquals(true, g.addEdge(0, 1, 5.0));
    Assert.assertEquals(true, g.addEdge(0, 4, 9.0));
    Assert.assertEquals(true, g.addEdge(0, 7, 8.0));
    Assert.assertEquals(true, g.addEdge(1, 2, 12.0));
    Assert.assertEquals(true, g.addEdge(1, 3, 15.0));
    Assert.assertEquals(true, g.addEdge(1, 7, 4.0));
    Assert.assertEquals(true, g.addEdge(2, 3, 3.0));
    Assert.assertEquals(true, g.addEdge(2, 6, 11.0));
    Assert.assertEquals(true, g.addEdge(3, 6, 9.0));
    Assert.assertEquals(true, g.addEdge(4, 5, 4.0));
    Assert.assertEquals(true, g.addEdge(4, 6, 20.0));
    Assert.assertEquals(true, g.addEdge(4, 7, 5.0));
    Assert.assertEquals(true, g.addEdge(5, 2, 1.0));
    Assert.assertEquals(true, g.addEdge(5, 6, 13.0));
    Assert.assertEquals(true, g.addEdge(7, 5, 6.0));
    Assert.assertEquals(true, g.addEdge(7, 2, 7.0));
    return g;
  }

  @Test
  public void test_E() {
    Digraph g = setUp();
    Assert.assertEquals(22, g.E());
    // add an already existing edge
    Assert.assertEquals(false, g.addEdge(4, 2));
    Assert.assertEquals(22, g.E());

    g = setUpWeighted();
    Assert.assertEquals(16, g.E());
    // add an already existing edge
    Assert.assertEquals(false, g.addEdge(0, 1, 5.0));
    Assert.assertEquals(16, g.E());
  }

  @Test
  public void test_V() {
    Digraph g = setUp();
    Assert.assertEquals(13, g.V);

    g = setUpWeighted();
    Assert.assertEquals(8, g.V);
  }
}
