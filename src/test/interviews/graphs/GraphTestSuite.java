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
  DigraphHandlerTest.class,
  DigraphTest.class,
  GraphHandlerTest.class,
  GraphTest.class,
  MinimumSpanningTreeTest.class,
})
public class GraphTestSuite {}
