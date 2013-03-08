package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaxTest {
  @Test
  public void test() {
    Assert.assertEquals(17, Max.f(17, 17));
    Assert.assertEquals(134, Max.f(17, 134));
    Assert.assertEquals(134, Max.f(134, 17));
  }
}
