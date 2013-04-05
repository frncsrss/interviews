package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ShortestPathTest {

  @Test
  public void test_dijkstra() {
    ShortestPath sp = new ShortestPath(DigraphTest.setUpWeighted());

    sp.dijkstra(0);
    Assert.assertEquals(0,  sp.distTo(0), 0.001);
    Assert.assertEquals(5,  sp.distTo(1), 0.001);
    Assert.assertEquals(14, sp.distTo(2), 0.001);
    Assert.assertEquals(17, sp.distTo(3), 0.001);
    Assert.assertEquals(9,  sp.distTo(4), 0.001);
    Assert.assertEquals(13, sp.distTo(5), 0.001);
    Assert.assertEquals(25, sp.distTo(6), 0.001);
    Assert.assertEquals(8,  sp.distTo(7), 0.001);
    Assert.assertEquals("[0]",             sp.pathTo(0).toString());
    Assert.assertEquals("[0, 1]",          sp.pathTo(1).toString());
    Assert.assertEquals("[0, 4, 5, 2]",    sp.pathTo(2).toString());
    Assert.assertEquals("[0, 4, 5, 2, 3]", sp.pathTo(3).toString());
    Assert.assertEquals("[0, 4]",          sp.pathTo(4).toString());
    Assert.assertEquals("[0, 4, 5]",       sp.pathTo(5).toString());
    Assert.assertEquals("[0, 4, 5, 2, 6]", sp.pathTo(6).toString());
    Assert.assertEquals("[0, 7]",          sp.pathTo(7).toString());


    sp.dijkstra(5);
    Assert.assertEquals(Double.POSITIVE_INFINITY,  sp.distTo(0), 0.001);
    Assert.assertEquals(Double.POSITIVE_INFINITY,  sp.distTo(1), 0.001);
    Assert.assertEquals(1,                         sp.distTo(2), 0.001);
    Assert.assertEquals(4,                         sp.distTo(3), 0.001);
    Assert.assertEquals(Double.POSITIVE_INFINITY,  sp.distTo(4), 0.001);
    Assert.assertEquals(0,                         sp.distTo(5), 0.001);
    Assert.assertEquals(12,                        sp.distTo(6), 0.001);
    Assert.assertEquals(Double.POSITIVE_INFINITY,  sp.distTo(7), 0.001);
    Assert.assertEquals(null,        sp.pathTo(0));
    Assert.assertEquals(null,        sp.pathTo(1));
    Assert.assertEquals("[5, 2]",    sp.pathTo(2).toString());
    Assert.assertEquals("[5, 2, 3]", sp.pathTo(3).toString());
    Assert.assertEquals(null,        sp.pathTo(4));
    Assert.assertEquals("[5]",       sp.pathTo(5).toString());
    Assert.assertEquals("[5, 2, 6]", sp.pathTo(6).toString());
    Assert.assertEquals(null,        sp.pathTo(7));
  }
}
