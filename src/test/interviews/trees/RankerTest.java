package interviews.trees;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RankerTest {
  @Test
  public void test_basic() {
    int[] arr = {5, 1, 4, 4, 5, 9, 7, 13, 3, 0};
    Ranker.track(arr);
    Assert.assertEquals(1, Ranker.getRankOfNumber(1));
    Assert.assertEquals(2, Ranker.getRankOfNumber(3));
    Assert.assertEquals(4, Ranker.getRankOfNumber(4));
    Assert.assertEquals(6, Ranker.getRankOfNumber(5));
  }
}
