package interviews.arrays;

import static interviews.arrays.Rainforest.bruteforce;
import static interviews.arrays.Rainforest.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RainforestTest {
  @Test
  public void test_bruteforce() {
    Assert.assertEquals( 9, bruteforce(new int[]{0, 1, 2, 4, 1, 0, 2, 4}));
    Assert.assertEquals( 9, bruteforce(new int[]{0, 1, 2, 4, 1, 0, 2, 4, 5}));
    Assert.assertEquals(11, bruteforce(new int[]{0, 1, 2, 4, 1, 0, 2, 4, 5, 4, 5, 3, 2, 3, 2, 1}));
    Assert.assertEquals( 0, bruteforce(new int[]{0, 1, 2, 4, 2, 1, 0}));
    Assert.assertEquals(25, bruteforce(new int[]{5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5}));
    Assert.assertEquals( 3, bruteforce(new int[]{1, 0, 0, 0, 1}));
    Assert.assertEquals( 0, bruteforce(new int[]{1, 2, 3, 4, 5}));
    Assert.assertEquals( 0, bruteforce(new int[]{5, 4, 3, 2, 1}));
    Assert.assertEquals( 7, bruteforce(new int[]{5, 4, 3, 2, 4, 6}));
    Assert.assertEquals(21,
        bruteforce(new int[]{1, 2, 3, 5, 1, 0, 2, 5, 4, 5, 3, 2, 3, 2, 1, 0, 0, 0, 2}));
    Assert.assertEquals(22,
        bruteforce(new int[]{1, 2, 3, 5, 4, 1, 0, 2, 5, 4, 5, 3, 2, 3, 2, 1, 0, 0, 0, 2}));
  }

  @Test
  public void test_stack() {
    Assert.assertEquals( 9, stack(new int[]{0, 1, 2, 4, 1, 0, 2, 4}));
    Assert.assertEquals( 9, stack(new int[]{0, 1, 2, 4, 1, 0, 2, 4, 5}));
    Assert.assertEquals(11, stack(new int[]{0, 1, 2, 4, 1, 0, 2, 4, 5, 4, 5, 3, 2, 3, 2, 1}));
    Assert.assertEquals( 0, stack(new int[]{0, 1, 2, 4, 2, 1, 0}));
    Assert.assertEquals(25, stack(new int[]{5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5}));
    Assert.assertEquals( 3, stack(new int[]{1, 0, 0, 0, 1}));
    Assert.assertEquals( 0, stack(new int[]{1, 2, 3, 4, 5}));
    Assert.assertEquals( 0, stack(new int[]{5, 4, 3, 2, 1}));
    Assert.assertEquals( 7, stack(new int[]{5, 4, 3, 2, 4, 6}));
    Assert.assertEquals(21,
        stack(new int[]{1, 2, 3, 5, 1, 0, 2, 5, 4, 5, 3, 2, 3, 2, 1, 0, 0, 0, 2}));
    Assert.assertEquals(22,
        stack(new int[]{1, 2, 3, 5, 4, 1, 0, 2, 5, 4, 5, 3, 2, 3, 2, 1, 0, 0, 0, 2}));
  }
}
