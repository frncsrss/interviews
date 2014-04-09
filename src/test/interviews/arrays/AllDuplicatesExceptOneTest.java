package interviews.arrays;

import static interviews.arrays.AllDuplicatesExceptOne.f2;
import static interviews.arrays.AllDuplicatesExceptOne.f3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class AllDuplicatesExceptOneTest {
  @Test
  public void test_f2() {
    Assert.assertEquals(1, f2(new int[]{1}));
    Assert.assertEquals(1, f2(new int[]{1, 2, 2}));
    Assert.assertEquals(1, f2(new int[]{1, 2, 2, 3, 3}));
    Assert.assertEquals(1, f2(new int[]{3, 2, 1, 3, 2}));
  }

  @Test
  public void test_f3() {
    Assert.assertEquals(1, f3(new int[]{1}));
    Assert.assertEquals(1, f3(new int[]{1, 2, 2, 2}));
    Assert.assertEquals(1, f3(new int[]{1, 2, 2, 2, 3, 3, 3}));
    Assert.assertEquals(1, f3(new int[]{3, 2, 1, 3, 2, 2, 3}));
  }
}
