package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaxFlowTest {

  @Test
  public void test_fordFulkerson() {
    MaxFlow mf = new MaxFlow(GraphTest.setUpFlowNetwork());
    mf.fordFulkerson(0, 7);
    Assert.assertEquals(28, mf.value(), 0.01);
  }
}
