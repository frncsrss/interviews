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

  public static Graph setUpWeighted() {
    Graph g = new Graph(8);
    Assert.assertEquals(true, g.addEdge(0, 7, 0.16));
    Assert.assertEquals(true, g.addEdge(2, 3, 0.17));
    Assert.assertEquals(true, g.addEdge(1, 7, 0.19));
    Assert.assertEquals(true, g.addEdge(0, 2, 0.26));
    Assert.assertEquals(true, g.addEdge(5, 7, 0.28));
    Assert.assertEquals(true, g.addEdge(1, 3, 0.29));
    Assert.assertEquals(true, g.addEdge(1, 5, 0.32));
    Assert.assertEquals(true, g.addEdge(2, 7, 0.34));
    Assert.assertEquals(true, g.addEdge(4, 5, 0.35));
    Assert.assertEquals(true, g.addEdge(1, 2, 0.36));
    Assert.assertEquals(true, g.addEdge(4, 7, 0.37));
    Assert.assertEquals(true, g.addEdge(0, 4, 0.38));
    Assert.assertEquals(true, g.addEdge(6, 2, 0.40));
    Assert.assertEquals(true, g.addEdge(3, 6, 0.52));
    Assert.assertEquals(true, g.addEdge(6, 0, 0.58));
    Assert.assertEquals(true, g.addEdge(6, 4, 0.93));
    return g;
  }

  public static Graph setUpFlowNetwork() {
    Graph g = new Graph(8);
    Assert.assertEquals(true, g.addEdge(new FlowEdge(0, 1, 10)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(0, 2,  5)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(0, 3, 15)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(1, 2,  4)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(2, 3,  4)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(1, 4,  9)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(1, 5, 15)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(2, 5,  8)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(3, 6, 16)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(4, 7, 10)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(4, 5, 15)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(5, 7, 10)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(5, 6, 15)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(6, 2,  6)));
    Assert.assertEquals(true, g.addEdge(new FlowEdge(6, 7, 10)));
    return g;
  }

  @Test
  public void test_E() {
    Graph g = setUp();
    Assert.assertEquals(12, g.E());
    // add an already existing edge
    Assert.assertEquals(false, g.addEdge(0, 1));
    Assert.assertEquals(12, g.E());

    g = setUpWeighted();
    Assert.assertEquals(16, g.E());
    // add an already existing edge
    Assert.assertEquals(false, g.addEdge(0, 7, 0.16));
    Assert.assertEquals(16, g.E());

    g = setUpFlowNetwork();
    Assert.assertEquals(15, g.E());
    // add an already existing edge
    Assert.assertEquals(false, g.addEdge(new FlowEdge(0, 1, 10)));
    Assert.assertEquals(15, g.E());
  }

  @Test
  public void test_V() {
    Graph g = setUp();
    Assert.assertEquals(13, g.V);

    g = setUpWeighted();
    Assert.assertEquals(8, g.V);

    g = setUpFlowNetwork();
    Assert.assertEquals(8, g.V);
  }

  @Test
  public void test_degree() {
    Graph g = setUp();
    Assert.assertEquals(4, g.degree(0), 0.1);
    Assert.assertEquals(1, g.degree(1), 0.1);
    Assert.assertEquals(1, g.degree(2), 0.1);
    Assert.assertEquals(2, g.degree(3), 0.1);
    Assert.assertEquals(2, g.degree(4), 0.1);
    Assert.assertEquals(2, g.degree(5), 0.1);
    Assert.assertEquals(2, g.degree(6), 0.1);
    Assert.assertEquals(1, g.degree(7), 0.1);
    Assert.assertEquals(1, g.degree(8), 0.1);
    Assert.assertEquals(3, g.degree(9), 0.1);
    Assert.assertEquals(1, g.degree(10), 0.1);
    Assert.assertEquals(2, g.degree(11), 0.1);
    Assert.assertEquals(2, g.degree(12), 0.1);

    g = setUpWeighted();
    Assert.assertEquals(.16 + .26 + .38 + .58, g.degree(0), 0.001);
    Assert.assertEquals(.19 + .29 + .32 + .36, g.degree(1), 0.001);
    Assert.assertEquals(.17 + .26 + .34 + .36 + .40, g.degree(2), 0.001);
    Assert.assertEquals(.17 + .29 + .52, g.degree(3), 0.001);
    Assert.assertEquals(.35 + .37 + .38 + .93, g.degree(4), 0.001);
    Assert.assertEquals(.28 + .32 + .35, g.degree(5), 0.001);
    Assert.assertEquals(.40 + .52 + .58 + .93, g.degree(6), 0.001);
    Assert.assertEquals(.16 + .19 + .28 + .34 + .37, g.degree(7), 0.001);
  }

  @Test
  public void test_removeEdge() {
    Graph g = setUp();
    Assert.assertTrue( g.removeEdge(new Edge(0, 1)));
    Assert.assertFalse(g.removeEdge(new Edge(0, 1)));
    Assert.assertTrue( g.removeEdge(new Edge(0, 2)));
    Assert.assertFalse(g.removeEdge(new Edge(0, 2)));
    Assert.assertFalse(g.removeEdge(new Edge(0, 4)));
    Assert.assertEquals(10, g.E());
  }
}
