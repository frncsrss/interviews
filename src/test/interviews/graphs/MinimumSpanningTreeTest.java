package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MinimumSpanningTreeTest {

  @Test
  public void test_kruskal() {
    MinimumSpanningTree mst = new MinimumSpanningTree(GraphTest.setUpWeighted());
    mst.kruskal();
    Assert.assertEquals(
        "[0->7(0.16), 2->3(0.17), 1->7(0.19), 0->2(0.26), 5->7(0.28), 4->5(0.35), 6->2(0.4)]",
        mst.edges().toString());
  }

  @Test
  public void test_prim() {
    MinimumSpanningTree mst = new MinimumSpanningTree(GraphTest.setUpWeighted());
    mst.prim(0);
    Assert.assertEquals(
        "[0->7(0.16), 1->7(0.19), 0->2(0.26), 2->3(0.17), 5->7(0.28), 4->5(0.35), 6->2(0.4)]",
        mst.edges().toString());
  }
}
