package interviews.arrays;

import static interviews.arrays.Bowling.score;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BowlingTest {
  @Test
  public void test()  {
    Assert.assertEquals(0,
        score(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    Assert.assertEquals(300, score(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    Assert.assertEquals(168,
        score(new int[]{10, 7, 3, 7, 2, 9, 1, 10, 10, 10, 2, 3, 6, 4, 7, 3, 3}));
  }
}
