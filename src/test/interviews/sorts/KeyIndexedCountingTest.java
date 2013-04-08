package interviews.sorts;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class KeyIndexedCountingTest {

  @Test
  public void test()  {
    int[] actuals = new int[]{3, 0, 2, 5, 5, 1, 3, 1, 5, 1, 4, 0};
    KeyIndexedCounting.f(actuals, 6);
    Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 1, 2, 3, 3, 4, 5, 5, 5}, actuals);
  }
}
