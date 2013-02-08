package interviews.arrays;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.Swap.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SwapTest {
  @Test
  public void test() {
    List<Integer> test = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    f(test, 0, 1);
    Assert.assertEquals(Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9), test);
    f(test, 0, 0);
    Assert.assertEquals(Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9), test);
    f(test, 0, 4, 2);
    Assert.assertEquals(Arrays.asList(5, 6, 3, 4, 2, 1, 7, 8, 9), test);    
  }
}
