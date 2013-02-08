package interviews.strings;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import static interviews.strings.Permutater.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class PermutaterTest {
  @Test
  public void test_permutations() {
    Set<String> result = f("triez");
    Assert.assertEquals(120, result.size());
  }
}
