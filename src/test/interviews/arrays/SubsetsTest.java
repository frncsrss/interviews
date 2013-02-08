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
        2, f(new ArrayList<Integer>(Arrays.asList(0))).size());
    Assert.assertEquals(
        4, f(new ArrayList<Integer>(Arrays.asList(0, 1))).size());
    Assert.assertEquals(
        8, f(new ArrayList<Integer>(Arrays.asList(0, 1, 2))).size());
    Assert.assertEquals(
        16, f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3))).size());
    Assert.assertEquals(
        32, f(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4))).size());
  }
}
