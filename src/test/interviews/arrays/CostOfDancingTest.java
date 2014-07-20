package interviews.arrays;

import static interviews.arrays.CostOfDancing.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class CostOfDancingTest {
  @Test
  public void test() {
    Assert.assertEquals(4, f(new int[]{1, 5, 3, 4}, 2));
    Assert.assertEquals(10, f(new int[]{1, 5, 4}, 3));
    Assert.assertEquals(2, f(new int[]{2, 2, 4, 5, 3}, 1));
    Assert.assertEquals(20431, f(new int[]{973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284,
        794, 913, 93, 129, 758, 108, 433, 181, 163, 96, 932, 703, 989, 884, 420, 615, 991, 364, 657,
        421, 336, 801, 142, 908, 321, 709, 752, 346, 656, 413, 629, 801}, 39));
  }
}
