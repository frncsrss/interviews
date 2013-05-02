package interviews.sorts;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RadixSortTest {
  @Test
  public void test_lsd()  {
    String[] actuals =
        new String[]{"dab", "add", "cab", "fad", "fee", "bad", "dad", "bee", "fed", "bed", "ebb", "ace"};
    RadixSort.lsd(actuals, 256);
    Assert.assertArrayEquals(
        new String[]{"ace", "add", "bad", "bed", "bee", "cab", "dab", "dad", "ebb", "fad", "fed", "fee"},
        actuals);
  }

  @Test
  public void test_msd()  {
    String[] actuals =
        new String[]{"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells",
            "she", "sells", "are", "surely", "seashells"};
    RadixSort.msd(actuals, 256);
    Assert.assertArrayEquals(
        new String[]{"are", "by", "sea", "seashells", "seashells", "sells", "sells", "she", "she",
            "shells", "shore", "surely", "the", "the"},
        actuals);
  }

  @Test
  public void test_3WayQuicksort()  {
    String[] actuals =
        new String[]{"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells",
            "she", "sells", "are", "surely", "seashells"};
    RadixSort.threeWayQuicksort(actuals);
    Assert.assertArrayEquals(
        new String[]{"are", "by", "sea", "seashells", "seashells", "sells", "sells", "she", "she",
            "shells", "shore", "surely", "the", "the"},
        actuals);
  }
}
