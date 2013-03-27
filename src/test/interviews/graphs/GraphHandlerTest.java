package interviews.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class GraphHandlerTest extends GraphTest {
  protected GraphHandler<Integer> gh;

  @Override
  @Before
  public void setUp() {
    super.setUp();
    gh = new GraphHandler<Integer>(g);
  }

  @Test
  public void test_bfs() {
    gh.bfs(0);
    Assert.assertEquals(null, gh.parent(0));
    Assert.assertEquals(new Integer(0), gh.parent(1));
    Assert.assertEquals(new Integer(0), gh.parent(2));
    Assert.assertEquals(new Integer(5), gh.parent(3));
    Assert.assertEquals("[3, 5, 0]", gh.pathTo(3).toString());
    Assert.assertEquals(new Integer(6), gh.parent(4));
    Assert.assertEquals("[4, 6, 0]", gh.pathTo(4).toString());
    Assert.assertEquals(new Integer(0), gh.parent(5));
    Assert.assertEquals(new Integer(0), gh.parent(6));
    Assert.assertEquals(null, gh.parent(7));
    Assert.assertEquals(null, gh.parent(8));
    Assert.assertEquals(null, gh.parent(9));
    Assert.assertEquals(null, gh.parent(10));
    Assert.assertEquals(null, gh.parent(11));
    Assert.assertEquals(null, gh.parent(12));
  }

  @Test
  public void test_cc() {
    gh.cc();
    Assert.assertEquals(3, gh.count());
    Assert.assertEquals(0, gh.id(0));
    Assert.assertEquals(0, gh.id(1));
    Assert.assertEquals(0, gh.id(2));
    Assert.assertEquals(0, gh.id(3));
    Assert.assertEquals(0, gh.id(4));
    Assert.assertEquals(0, gh.id(5));
    Assert.assertEquals(0, gh.id(6));
    Assert.assertEquals(1, gh.id(7));
    Assert.assertEquals(1, gh.id(8));
    Assert.assertEquals(2, gh.id(9));
    Assert.assertEquals(2, gh.id(10));
    Assert.assertEquals(2, gh.id(11));
    Assert.assertEquals(2, gh.id(12));

    Assert.assertEquals(null, gh.parent(0));
    Assert.assertEquals(new Integer(0), gh.parent(1));
    Assert.assertEquals(new Integer(0), gh.parent(2));
    Assert.assertEquals(new Integer(5), gh.parent(3));
    Assert.assertEquals(new Integer(3), gh.parent(4));
    Assert.assertEquals(new Integer(0), gh.parent(5));
    Assert.assertEquals(new Integer(4), gh.parent(6));
    Assert.assertEquals(null, gh.parent(7));
    Assert.assertEquals(new Integer(7), gh.parent(8));
    Assert.assertEquals(null, gh.parent(9));
    Assert.assertEquals(new Integer(9), gh.parent(10));
    Assert.assertEquals(new Integer(9), gh.parent(11));
    Assert.assertEquals(new Integer(11), gh.parent(12));
  }

  @Test
  public void test_dfs() {
    gh.dfs(0);
    Assert.assertEquals(null, gh.parent(0));
    Assert.assertEquals(new Integer(0), gh.parent(1));
    Assert.assertEquals(new Integer(0), gh.parent(2));
    Assert.assertEquals(new Integer(5), gh.parent(3));
    Assert.assertEquals("[3, 5, 0]", gh.pathTo(3).toString());
    Assert.assertEquals(new Integer(3), gh.parent(4));
    Assert.assertEquals("[4, 3, 5, 0]", gh.pathTo(4).toString());
    Assert.assertEquals(new Integer(0), gh.parent(5));
    Assert.assertEquals(new Integer(4), gh.parent(6));
    Assert.assertEquals("[6, 4, 3, 5, 0]", gh.pathTo(6).toString());
    Assert.assertEquals(null, gh.parent(7));
    Assert.assertEquals(null, gh.parent(8));
    Assert.assertEquals(null, gh.parent(9));
    Assert.assertEquals(null, gh.parent(10));
    Assert.assertEquals(null, gh.parent(11));
    Assert.assertEquals(null, gh.parent(12));
  }
}
