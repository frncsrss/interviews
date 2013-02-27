package interviews.arrays;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.Subsets.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SubsetsTest {
  @Test
  public void test() {
    Assert.assertEquals(
        2,    f(new ArrayList<Integer>(Arrays.asList(0))).size());
    Assert.assertEquals(
        4,    f(new ArrayList<Integer>(Arrays.asList(0, 1))).size());
    Assert.assertEquals(
        8,    f(new ArrayList<Integer>(Arrays.asList(0, 1, 2))).size());
    Assert.assertEquals(
        16,   f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3))).size());
    Assert.assertEquals(
        32,   f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4))).size());
    Assert.assertEquals(
        64,   f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5))).size());
    Assert.assertEquals(
        128,  f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6))).size());
    Assert.assertEquals(
        256,  f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7))).size());
    Assert.assertEquals(
        512,  f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8))).size());
    Assert.assertEquals(
        1024, f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))).size());
    Assert.assertEquals(
        2048, f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))).size());
    Assert.assertEquals(
        4096, f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))).size());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void test_exception() {
    f(new ArrayList<Integer>(
        Arrays.asList(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
            24, 25, 26, 27, 28, 29, 30, 31))).size();
  }
}
