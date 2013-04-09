package interviews.sorts;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RadixSortTest {
  @Test
  public void test()  {
    String[] actuals =
        new String[]{"dab", "add", "cab", "fad", "fee", "bad", "dad", "bee", "fed", "bed", "ebb", "ace"};
    RadixSort.lsd(actuals, 256);
    Assert.assertArrayEquals(
        new String[]{"ace", "add", "bad", "bed", "bee", "cab", "dab", "dad", "ebb", "fad", "fed", "fee"},
        actuals);
  }
}
