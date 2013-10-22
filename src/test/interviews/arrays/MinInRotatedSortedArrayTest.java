package interviews.arrays;

import static interviews.arrays.MinInRotatedSortedArray.f;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MinInRotatedSortedArrayTest {
  @Test(expected = NoSuchElementException.class)
  public void test_null() {
    Assert.assertEquals(-1, f(null));
  }

  @Test(expected = NoSuchElementException.class)
  public void test_empty() {
    Assert.assertEquals(-1, f(new int[]{}));
  }

  @Test
  public void test() {
    Assert.assertEquals(1, f(new int[]{1}));
    Assert.assertEquals(1, f(new int[]{1, 2}));
    Assert.assertEquals(1, f(new int[]{2, 1}));
    Assert.assertEquals(1, f(new int[]{1, 2, 3, 4, 5, 6}));
    Assert.assertEquals(1, f(new int[]{6, 1, 2, 3, 4, 5}));
    Assert.assertEquals(1, f(new int[]{5, 6, 1, 2, 3, 4}));
    Assert.assertEquals(1, f(new int[]{4, 5, 6, 1, 2, 3}));
    Assert.assertEquals(1, f(new int[]{3, 4, 5, 6, 1, 2}));
    Assert.assertEquals(1, f(new int[]{2, 3, 4, 5, 6, 1}));
  }

  @Test
  public void test_duplicates() {
    Assert.assertEquals(1, f(new int[]{1, 1}));
    Assert.assertEquals(1, f(new int[]{1, 1, 2}));
    Assert.assertEquals(1, f(new int[]{1, 1, 3, 4, 5, 6}));
    Assert.assertEquals(1, f(new int[]{6, 1, 1, 3, 4, 5}));
    Assert.assertEquals(1, f(new int[]{5, 6, 1, 1, 3, 4}));
    Assert.assertEquals(1, f(new int[]{4, 5, 6, 1, 1, 3}));
    Assert.assertEquals(1, f(new int[]{3, 4, 5, 6, 1, 1}));
    Assert.assertEquals(1, f(new int[]{1, 3, 4, 5, 6, 1}));
  }
}
