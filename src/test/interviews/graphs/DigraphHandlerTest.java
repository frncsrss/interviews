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
  public void test_cc() {
    DigraphHandler<Integer> gh = setUp();
    gh.cc();
    Assert.assertEquals(5, gh.count());
    Assert.assertEquals(1, gh.id(0));
    Assert.assertEquals(0, gh.id(1));
    Assert.assertEquals(1, gh.id(2));
    Assert.assertEquals(1, gh.id(3));
    Assert.assertEquals(1, gh.id(4));
    Assert.assertEquals(1, gh.id(5));
    Assert.assertEquals(3, gh.id(6));
    Assert.assertEquals(4, gh.id(7));
    Assert.assertEquals(3, gh.id(8));
    Assert.assertEquals(2, gh.id(9));
    Assert.assertEquals(2, gh.id(10));
    Assert.assertEquals(2, gh.id(11));
    Assert.assertEquals(2, gh.id(12));

    Assert.assertEquals(false, gh.connected(0, 1));
    Assert.assertEquals(false, gh.connected(0, 7));
    Assert.assertEquals(true, gh.connected(0, 2));
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
    Assert.assertEquals("[7, 6, 9, 11, 10, 12, 8, 0, 5, 4, 3, 2, 1]", gh.topological().toString());
  }
}
