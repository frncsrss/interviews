package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class CoderTest {
  @Test
  public void test() {
    Assert.assertEquals(0,  Coder.f(null));
    Assert.assertEquals(0,  Coder.f(""));
    Assert.assertEquals(1,  Coder.f("1"));
    Assert.assertEquals(1,  Coder.f("78"));
    Assert.assertEquals(1,  Coder.f("101"));
    Assert.assertEquals(3,  Coder.f("111"));
    Assert.assertEquals(2,  Coder.f("2381"));
    Assert.assertEquals(3,  Coder.f("2181"));
    Assert.assertEquals(4,  Coder.f("2611"));
    Assert.assertEquals(5,  Coder.f("1123"));
    Assert.assertEquals(5,  Coder.f("1111"));
    Assert.assertEquals(8,  Coder.f("11111"));
    Assert.assertEquals(2,  Coder.f("101110"));
    Assert.assertEquals(5,  Coder.f("101126"));
    Assert.assertEquals(2,  Coder.f("3441732"));
    Assert.assertEquals(10, Coder.f("1421132"));
  }
}
