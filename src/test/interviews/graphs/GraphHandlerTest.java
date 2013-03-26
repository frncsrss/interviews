package interviews.graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    gh.bfs(1);
    Assert.assertEquals(null, gh.parent(1));
    Assert.assertEquals(new Integer(1), gh.parent(2));
    Assert.assertEquals(new Integer(2), gh.parent(3));
    Assert.assertEquals(new Integer(5), gh.parent(4));
    Assert.assertEquals(new Integer(1), gh.parent(5));
    Assert.assertEquals(new Integer(1), gh.parent(6));
    Assert.assertEquals("[4, 5, 1]", gh.pathTo(4).toString());
  }

  @Test
  public void test_dfs() {
    gh.dfs(1);
    Assert.assertEquals(null, gh.parent(1));
    Assert.assertEquals(new Integer(1), gh.parent(2));
    Assert.assertEquals(new Integer(2), gh.parent(3));
    Assert.assertEquals(new Integer(3), gh.parent(4));
    Assert.assertEquals(new Integer(4), gh.parent(5));
    Assert.assertEquals(new Integer(1), gh.parent(6));
    Assert.assertEquals("[4, 3, 2, 1]", gh.pathTo(4).toString());
  }
}
