package interviews.strings;

import static interviews.strings.SubstringReversal.f;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SubstringReversalTest {
  @Test
  public void test() {
    Assert.assertArrayEquals(new int[]{2, 3}, f("abdc"));
    Assert.assertArrayEquals(new int[]{0, 0}, f("aabbcc"));
    Assert.assertArrayEquals(new int[]{2, 5}, f("aabbca"));
    Assert.assertArrayEquals(new int[]{0, 4}, f("misof"));
    Assert.assertArrayEquals(new int[]{0, 2}, f("ivan"));
    Assert.assertArrayEquals(new int[]{0, 13}, f("thisseemstobeaneasyproblem"));
    Assert.assertArrayEquals(new int[]{0, 16}, f("thisseemstoneabeasyproblem"));
    Assert.assertArrayEquals(new int[]{0, 27}, f("thisseemstoneabeasyproblemaa"));
  }
}
