package interviews.arrays;

import static interviews.arrays.Rainforest.bruteforce;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RainforestTest {
  @Test
  public void test() {
    Assert.assertEquals( 9, bruteforce(new int[]{0, 1, 2, 4, 1, 0, 2, 4}));
    Assert.assertEquals( 9, bruteforce(new int[]{0, 1, 2, 4, 1, 0, 2, 4, 5}));
    Assert.assertEquals(11, bruteforce(new int[]{0, 1, 2, 4, 1, 0, 2, 4, 5, 4, 5, 3, 2, 3, 2, 1}));
    Assert.assertEquals( 0, bruteforce(new int[]{0, 1, 2, 4, 2, 1, 0}));
    Assert.assertEquals(25, bruteforce(new int[]{5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5}));
  }
}
