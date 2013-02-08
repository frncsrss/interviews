package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Palindrome.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class PalindromeTest {
  @Test
  public void test() {
    Assert.assertEquals(true, f("laval"));
    Assert.assertEquals(true, f("Laval"));
    Assert.assertEquals(true, f("lavval"));
    Assert.assertEquals(false, f("palindrome"));
    Assert.assertEquals(false, f("traebceart"));
  }
}
