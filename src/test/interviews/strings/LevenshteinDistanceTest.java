package interviews.strings;

import static interviews.strings.LevenshteinDistance.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class LevenshteinDistanceTest {
  @Test
  public void test() {
    Assert.assertEquals(3,  f("kitten", "sitting"));
    Assert.assertEquals(4,  f("levenshtein", "meilenstein"));
    Assert.assertEquals(3,  f("saturday", "sunday"));
  }
}
