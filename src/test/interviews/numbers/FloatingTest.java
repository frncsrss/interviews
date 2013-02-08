package interviews.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class FloatingTest {
  @Test
  public void test() {
    final float f = 1.2345f;
    final int bits = Float.floatToIntBits(f);
    final int s = ((bits >> 31) == 0) ? 1 : -1;  // sign
    final int e = ((bits >> 23) & 0xff);  // exponent
    final int m = (e == 0) ?
                    (bits & 0x7fffff) << 1 :
                    (bits & 0x7fffff) | 0x800000;  // mantissa
    Assert.assertEquals(f, s * m * Math.pow(2, e-150), 0.000001f);
  }
}
