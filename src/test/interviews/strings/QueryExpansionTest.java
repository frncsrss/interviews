package interviews.strings;

import interviews.strings.QueryExpansion.Node;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class QueryExpansionTest {
  @Test
  public void test() {
    QueryExpansion qe = new QueryExpansion();
    qe.put("pictures", new Node[]{new Node("pictures", 1.0), new Node("photos", 0.8)});
    qe.put("of", new Node[]{new Node("of", 1.0)});
    qe.put("puppies", new Node[]{new Node("puppies", 1.0), new Node("dogs", 0.6), new Node("pets", 0.2)});
    Assert.assertEquals(
        Arrays.asList("pictures of puppies", "photos of puppies"),
        qe.expansions("pictures of puppies", 2));
    Assert.assertEquals(
        Arrays.asList("pictures of puppies", "photos of puppies", "pictures of dogs"),
        qe.expansions("pictures of puppies", 3));
    Assert.assertEquals(
        Arrays.asList("pictures of puppies", "photos of puppies", "pictures of dogs", "photos of dogs"),
        qe.expansions("pictures of puppies", 4));
  }
}
