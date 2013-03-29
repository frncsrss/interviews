package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

public class DigraphHandlerTest {

  public static DigraphHandler<Integer> setUp() {
    DigraphHandler<Integer> gh = new DigraphHandler<Integer>(DigraphTest.setUp());
    return gh;
  }

  @Test
  public void test_bfs() {
    DigraphHandler<Integer> gh = setUp();
    gh.bfs(0);
    Assert.assertEquals(null, gh.parent(0));
    Assert.assertEquals(new Integer(0), gh.parent(1));
    Assert.assertEquals(new Integer(4), gh.parent(2));
    Assert.assertEquals(new Integer(4), gh.parent(3));
    Assert.assertEquals(new Integer(5), gh.parent(4));
    Assert.assertEquals(new Integer(0), gh.parent(5));
    Assert.assertEquals(null, gh.parent(6));
    Assert.assertEquals(null, gh.parent(7));
    Assert.assertEquals(null, gh.parent(8));
    Assert.assertEquals(null, gh.parent(9));
    Assert.assertEquals(null, gh.parent(10));
    Assert.assertEquals(null, gh.parent(11));
    Assert.assertEquals(null, gh.parent(12));
    Assert.assertEquals("[3, 4, 5, 0]", gh.pathTo(3).toString());
  }

  @Test
  public void test_dfs() {
    GraphHandler<Integer> gh = setUp();
    gh.dfs(0);
    Assert.assertEquals(null, gh.parent(0));
    Assert.assertEquals(new Integer(0), gh.parent(1));
    Assert.assertEquals(new Integer(3), gh.parent(2));
    Assert.assertEquals(new Integer(4), gh.parent(3));
    Assert.assertEquals(new Integer(5), gh.parent(4));
    Assert.assertEquals(new Integer(0), gh.parent(5));
    Assert.assertEquals(null, gh.parent(6));
    Assert.assertEquals(null, gh.parent(7));
    Assert.assertEquals(null, gh.parent(8));
    Assert.assertEquals(null, gh.parent(9));
    Assert.assertEquals(null, gh.parent(10));
    Assert.assertEquals(null, gh.parent(11));
    Assert.assertEquals(null, gh.parent(12));
    Assert.assertEquals("[2, 3, 4, 5, 0]", gh.pathTo(2).toString());
  }

  @Test
  public void test_topological() {
    DigraphHandler<Integer> gh = setUp();
    Assert.assertEquals("[1, 2, 3, 4, 5, 0, 8, 12, 10, 11, 9, 6, 7]", gh.topological().toString());
  }
}
