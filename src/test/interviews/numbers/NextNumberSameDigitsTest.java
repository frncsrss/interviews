package interviews.numbers;

import static interviews.numbers.NextNumberSameDigits.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class NextNumberSameDigitsTest {
  @Test
  public void test() {
    Assert.assertEquals(250167, f(217650));
    Assert.assertEquals(3501267, f(3276510));
    Assert.assertEquals(3501267, f(3276510));
    Assert.assertEquals(12310, f(12301));
    Assert.assertEquals(241567, f(217654));
  }
}
