package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

public class DigraphHandlerTest {

  public static DigraphHandler setUp() {
    DigraphHandler gh = new DigraphHandler(DigraphTest.setUp());
    return gh;
  }

  @Test
  public void test_bfs() {
    DigraphHandler gh = setUp();
    gh.bfs(0);
    Assert.assertEquals(-1, gh.parent(0));
    Assert.assertEquals(0,  gh.parent(1));
    Assert.assertEquals(4,  gh.parent(2));
    Assert.assertEquals(4,  gh.parent(3));
    Assert.assertEquals(5,  gh.parent(4));
    Assert.assertEquals(0,  gh.parent(5));
    Assert.assertEquals(-1, gh.parent(6));
    Assert.assertEquals(-1, gh.parent(7));
    Assert.assertEquals(-1, gh.parent(8));
    Assert.assertEquals(-1, gh.parent(9));
    Assert.assertEquals(-1, gh.parent(10));
    Assert.assertEquals(-1, gh.parent(11));
    Assert.assertEquals(-1, gh.parent(12));
    Assert.assertEquals("[3, 4, 5, 0]", gh.pathTo(3).toString());
  }

  @Test
  public void test_dfs() {
    DigraphHandler gh = setUp();
    gh.dfs(0);
    Assert.assertEquals(-1, gh.parent(0));
    Assert.assertEquals(0,  gh.parent(1));
    Assert.assertEquals(4,  gh.parent(2));
    Assert.assertEquals(2,  gh.parent(3));
    Assert.assertEquals(5,  gh.parent(4));
    Assert.assertEquals(0,  gh.parent(5));
    Assert.assertEquals(-1, gh.parent(6));
    Assert.assertEquals(-1, gh.parent(7));
    Assert.assertEquals(-1, gh.parent(8));
    Assert.assertEquals(-1, gh.parent(9));
    Assert.assertEquals(-1, gh.parent(10));
    Assert.assertEquals(-1, gh.parent(11));
    Assert.assertEquals(-1, gh.parent(12));
    Assert.assertEquals("[3, 2, 4, 5, 0]", gh.pathTo(3).toString());
  }

  @Test
  public void test_topological() {
    DigraphHandler gh = setUp();
    Assert.assertEquals("[7, 6, 8, 9, 11, 10, 12, 0, 5, 4, 2, 3, 1]", gh.topological().toString());
  }
}
