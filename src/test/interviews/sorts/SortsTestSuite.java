package interviews.sorts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite.
 * @author Francois Rousseau
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  BSTTraversalSortTest.class,
  BubbleSortTest.class,
  InsertionSortTest.class,
  KeyIndexedCountingTest.class,
  MergesortTest.class,
  QuicksortTest.class,
  RadixSortTest.class,
  SelectionSortTest.class
})
public class SortsTestSuite {}
