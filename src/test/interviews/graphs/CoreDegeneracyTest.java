package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class CoreDegeneracyTest {

  @Test
  public void test_kcore1() {
    Graph g = GraphTest.setUp();
    CoreDegeneracy cd = new CoreDegeneracy(g);
    Assert.assertEquals("{0=[], 1=[1, 2, 7, 8, 10], 2=[0, 3, 4, 5, 6, 9, 11, 12]}",
        cd.kcore().toString());
  }

  @Test
  public void test_kcore2() {
    Graph g = new Graph(21);
    Assert.assertEquals(true, g.addEdge(1, 2));
    Assert.assertEquals(true, g.addEdge(1, 3));
    Assert.assertEquals(true, g.addEdge(2, 4));
    Assert.assertEquals(true, g.addEdge(3, 4));
    Assert.assertEquals(true, g.addEdge(4, 5));
    Assert.assertEquals(true, g.addEdge(6, 7));
    Assert.assertEquals(true, g.addEdge(7, 8));
    Assert.assertEquals(true, g.addEdge(7, 9));
    Assert.assertEquals(true, g.addEdge(7, 10));
    Assert.assertEquals(true, g.addEdge(8, 9));
    Assert.assertEquals(true, g.addEdge(9, 11));
    Assert.assertEquals(true, g.addEdge(9, 12));
    Assert.assertEquals(true, g.addEdge(9, 13));
    Assert.assertEquals(true, g.addEdge(9, 10));
    Assert.assertEquals(true, g.addEdge(10, 14));
    Assert.assertEquals(true, g.addEdge(10, 15));
    Assert.assertEquals(true, g.addEdge(10, 16));
    Assert.assertEquals(true, g.addEdge(11, 12));
    Assert.assertEquals(true, g.addEdge(11, 13));
    Assert.assertEquals(true, g.addEdge(12, 13));
    Assert.assertEquals(true, g.addEdge(13, 17));
    Assert.assertEquals(true, g.addEdge(13, 18));
    Assert.assertEquals(true, g.addEdge(14, 18));
    Assert.assertEquals(true, g.addEdge(14, 15));
    Assert.assertEquals(true, g.addEdge(14, 16));
    Assert.assertEquals(true, g.addEdge(15, 16));
    Assert.assertEquals(true, g.addEdge(17, 19));
    Assert.assertEquals(true, g.addEdge(17, 20));
    Assert.assertEquals(true, g.addEdge(17, 18));

    CoreDegeneracy cd = new CoreDegeneracy(g);
    Assert.assertEquals("{0=[0], 1=[19, 20, 5, 6], 2=[17, 1, 2, 18, 3, 4, 7, 8], 3=[16, 9, 10, 11, 12, 13, 14, 15]}",
        cd.kcore().toString());
  }

  @Test
  public void test_fcore1() {
    Graph g = GraphTest.setUp();
    CoreDegeneracy cd = new CoreDegeneracy(g);
    Assert.assertEquals("{0=[], 1=[1, 2, 7, 8, 10], 2=[0, 3, 4, 5, 6, 9, 11, 12]}",
        cd.fcore().toString());
  }

  @Test
  public void test_fcore2() {
    Graph g = new Graph(21);
    Assert.assertEquals(true, g.addEdge(1, 2));
    Assert.assertEquals(true, g.addEdge(1, 3));
    Assert.assertEquals(true, g.addEdge(2, 4));
    Assert.assertEquals(true, g.addEdge(3, 4));
    Assert.assertEquals(true, g.addEdge(4, 5));
    Assert.assertEquals(true, g.addEdge(6, 7));
    Assert.assertEquals(true, g.addEdge(7, 8));
    Assert.assertEquals(true, g.addEdge(7, 9));
    Assert.assertEquals(true, g.addEdge(7, 10));
    Assert.assertEquals(true, g.addEdge(8, 9));
    Assert.assertEquals(true, g.addEdge(9, 11));
    Assert.assertEquals(true, g.addEdge(9, 12));
    Assert.assertEquals(true, g.addEdge(9, 13));
    Assert.assertEquals(true, g.addEdge(9, 10));
    Assert.assertEquals(true, g.addEdge(10, 14));
    Assert.assertEquals(true, g.addEdge(10, 15));
    Assert.assertEquals(true, g.addEdge(10, 16));
    Assert.assertEquals(true, g.addEdge(11, 12));
    Assert.assertEquals(true, g.addEdge(11, 13));
    Assert.assertEquals(true, g.addEdge(12, 13));
    Assert.assertEquals(true, g.addEdge(13, 17));
    Assert.assertEquals(true, g.addEdge(13, 18));
    Assert.assertEquals(true, g.addEdge(14, 18));
    Assert.assertEquals(true, g.addEdge(14, 15));
    Assert.assertEquals(true, g.addEdge(14, 16));
    Assert.assertEquals(true, g.addEdge(15, 16));
    Assert.assertEquals(true, g.addEdge(17, 19));
    Assert.assertEquals(true, g.addEdge(17, 20));
    Assert.assertEquals(true, g.addEdge(17, 18));

    CoreDegeneracy cd = new CoreDegeneracy(g);
    Assert.assertEquals("{0=[0], 1=[19, 20, 5, 6], 2=[17, 1, 2, 18, 3, 4, 7, 8], 3=[16, 9, 10, 11, 12, 13, 14, 15]}",
        cd.fcore().toString());
  }
}
