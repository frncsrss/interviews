package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

import static interviews.numbers.Max.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MaxTest {
  @Test
  public void test() {
    Assert.assertEquals(17, f(17, 17));
    Assert.assertEquals(134, f(17, 134));
    Assert.assertEquals(134, f(134, 17));
  }
}
