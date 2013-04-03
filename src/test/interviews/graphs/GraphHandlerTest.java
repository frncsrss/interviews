package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class GraphHandlerTest {

  public static GraphHandler setUp() {
    GraphHandler gh = new GraphHandler(GraphTest.setUp());
    return gh;
  }

  @Test
  public void test_bfs() {
    GraphHandler gh = setUp();
    gh.bfs(0);
    Assert.assertEquals(-1, gh.parent(0));
    Assert.assertEquals(0,  gh.parent(1));
    Assert.assertEquals(0,  gh.parent(2));
    Assert.assertEquals(5,  gh.parent(3));
    Assert.assertEquals(6,  gh.parent(4));
    Assert.assertEquals(0,  gh.parent(5));
    Assert.assertEquals(0,  gh.parent(6));
    Assert.assertEquals(-1, gh.parent(7));
    Assert.assertEquals(-1, gh.parent(8));
    Assert.assertEquals(-1, gh.parent(9));
    Assert.assertEquals(-1, gh.parent(10));
    Assert.assertEquals(-1, gh.parent(11));
    Assert.assertEquals(-1, gh.parent(12));
    Assert.assertEquals("[3, 5, 0]", gh.pathTo(3).toString());
    Assert.assertEquals("[4, 6, 0]", gh.pathTo(4).toString());
  }

  @Test
  public void test_dfs() {
    GraphHandler gh = setUp();
    gh.dfs(0);
    Assert.assertEquals(-1, gh.parent(0));
    Assert.assertEquals(0,  gh.parent(1));
    Assert.assertEquals(0,  gh.parent(2));
    Assert.assertEquals(5,  gh.parent(3));
    Assert.assertEquals(3,  gh.parent(4));
    Assert.assertEquals(0,  gh.parent(5));
    Assert.assertEquals(4,  gh.parent(6));
    Assert.assertEquals(-1, gh.parent(7));
    Assert.assertEquals(-1, gh.parent(8));
    Assert.assertEquals(-1, gh.parent(9));
    Assert.assertEquals(-1, gh.parent(10));
    Assert.assertEquals(-1, gh.parent(11));
    Assert.assertEquals(-1, gh.parent(12));
    Assert.assertEquals("[3, 5, 0]", gh.pathTo(3).toString());
    Assert.assertEquals("[4, 3, 5, 0]", gh.pathTo(4).toString());
    Assert.assertEquals("[6, 4, 3, 5, 0]", gh.pathTo(6).toString());
  }
}
