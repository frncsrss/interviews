package interviews.graphs;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class KCoreTest {

  private static Graph setUp() {
    Graph g = new Graph(21);
    assertEquals(true, g.addEdge(1, 2));
    assertEquals(true, g.addEdge(1, 3));
    assertEquals(true, g.addEdge(2, 4));
    assertEquals(true, g.addEdge(3, 4));
    assertEquals(true, g.addEdge(4, 5));
    assertEquals(true, g.addEdge(6, 7));
    assertEquals(true, g.addEdge(7, 8));
    assertEquals(true, g.addEdge(7, 9));
    assertEquals(true, g.addEdge(7, 10));
    assertEquals(true, g.addEdge(8, 9));
    assertEquals(true, g.addEdge(9, 10));
    assertEquals(true, g.addEdge(9, 11));
    assertEquals(true, g.addEdge(9, 12));
    assertEquals(true, g.addEdge(9, 13));
    assertEquals(true, g.addEdge(10, 14));
    assertEquals(true, g.addEdge(10, 15));
    assertEquals(true, g.addEdge(10, 16));
    assertEquals(true, g.addEdge(11, 12));
    assertEquals(true, g.addEdge(11, 13));
    assertEquals(true, g.addEdge(12, 13));
    assertEquals(true, g.addEdge(13, 17));
    assertEquals(true, g.addEdge(13, 18));
    assertEquals(true, g.addEdge(14, 15));
    assertEquals(true, g.addEdge(14, 16));
    assertEquals(true, g.addEdge(14, 18));
    assertEquals(true, g.addEdge(15, 16));
    assertEquals(true, g.addEdge(17, 18));
    assertEquals(true, g.addEdge(17, 19));
    assertEquals(true, g.addEdge(17, 20));
    return g;
  }

  @Test
  public void test_unweighted1() {
    Graph g = GraphTest.setUp();
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertArrayEquals(new int[]{2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 1, 2, 2}, kc.core());
  }

  @Test
  public void test_unweighted2() {
    Graph g = setUp();
    KCore kc = new KCore(g);
    kc.computeUnweighted();
    assertArrayEquals(new int[]{0, 2, 2, 2, 2, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 1, 1},
        kc.core());
  }

  @Test
  public void test_weighted1() {
    Graph g = GraphTest.setUp();
    KCore kc = new KCore(g);
    kc.computeWeighted();
    assertArrayEquals(new int[]{2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 1, 2, 2}, kc.core());
  }

  @Test
  public void test_weighted2() {
    Graph g = setUp();
    KCore kc = new KCore(g);
    kc.computeWeighted();
    assertArrayEquals(new int[]{0, 2, 2, 2, 2, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 1, 1},
        kc.core());
  }
}
