package interviews.strings;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Replacer.escapeWhitespace;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ReplacerTest {
  @Test
  public void test_escapeWhitespace() {
    Assert.assertEquals(
        "Mr%20John%20Smith%20%20%20", escapeWhitespace("Mr John Smith   "));
  }
}
