package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Nesting.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class NestingTest {
  @Test
  public void test() {
    Assert.assertEquals(true, f("(()(())())"));
    Assert.assertEquals(true, f("(())"));
    Assert.assertEquals(true, f("()"));
    Assert.assertEquals(false, f("())"));
    Assert.assertEquals(false, f("))(("));
    Assert.assertEquals(true, f(""));
    Assert.assertEquals(false, f(")"));
    Assert.assertEquals(false, f("("));
    Assert.assertEquals(true, f("(()())"));
    Assert.assertEquals(false, f("(()()"));
  }
}
