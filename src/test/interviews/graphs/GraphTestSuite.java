package interviews.graphs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite.
 * @author Francois Rousseau
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  ConnectedComponentTest.class,
  DigraphTest.class,
  GraphTest.class,
  MaxFlowTest.class,
  MinimumSpanningTreeTest.class,
  ShortestPathTest.class,
  TraversalTest.class,
})
public class GraphTestSuite {}
