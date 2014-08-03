package interviews.arrays;

import static interviews.arrays.MedianElement.fixed;
import static interviews.arrays.MedianElement.stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MedianElementTest {
  @Test
  public void test_fixed() {
    Assert.assertEquals(6, fixed(new int[]{6}));
    Assert.assertEquals(6, fixed(new int[]{1, 6}));
    Assert.assertEquals(6, fixed(new int[]{6, 1}));
    Assert.assertEquals(6, fixed(new int[]{6, 6}));
    Assert.assertEquals(6, fixed(new int[]{1, 6, 10}));
    Assert.assertEquals(6, fixed(new int[]{6, 1, 10, 3, 7}));
    Assert.assertEquals(4, fixed(new int[]{10, 7, 6, 5, 4, 3, 2, 1, 0}));
    Assert.assertEquals(1, fixed(new int[]{1, 1, 1, 1, 1, 2}));
    Assert.assertEquals(4, fixed(new int[]{1, 2, 3, 4, 5, 6}));
  }

  @Test
  public void test_stream() {
    Assert.assertEquals(6, stream(new int[]{6}));
    Assert.assertEquals(6, stream(new int[]{1, 6}));
    Assert.assertEquals(6, stream(new int[]{6, 1}));
    Assert.assertEquals(6, stream(new int[]{6, 6}));
    Assert.assertEquals(6, stream(new int[]{1, 6, 10}));
    Assert.assertEquals(6, stream(new int[]{6, 1, 10, 3, 7}));
    Assert.assertEquals(4, stream(new int[]{10, 7, 6, 5, 4, 3, 2, 1, 0}));
    Assert.assertEquals(1, stream(new int[]{1, 1, 1, 1, 1, 2}));
    Assert.assertEquals(4, stream(new int[]{1, 2, 3, 4, 5, 6}));
  }
}
