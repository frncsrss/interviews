package interviews.arrays;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.MergeInPlace.f;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MergeInPlaceTest {
  @Test
  public void test_basic() {
    List<Integer> test, test1, test2, golden;

    test = Arrays.asList(1, 2, 4, 5, 6, 8, 3, 7, 9, 15);
    golden = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 15);
    f(test, 6);
    Assert.assertEquals(golden, test);

    test = Arrays.asList(1, 2, 4, 5, 6, 8, 10, 3, 7, 9, 15);
    golden = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15);
    f(test, 7);
    Assert.assertEquals(golden, test);

    test1 = Arrays.asList(1, 2, 4, 5, 6, 8, 10, 0, 0, 0, 0);
    test2 = Arrays.asList(3, 7, 9, 15);
    golden = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15);
    f(test1, test2);
    Assert.assertEquals(golden, test1);
  }

  @Test
  public void test_duplicates() {
    List<Integer> test, test1, test2, golden;

    test = Arrays.asList(1, 2, 4, 5, 6, 8, 1, 3, 7, 9, 15);
    golden = Arrays.asList(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 15);
    f(test, 6);
    Assert.assertEquals(golden, test);

    test1 = Arrays.asList(1, 2, 4, 5, 6, 8, 10, 0, 0, 0, 0, 0);
    test2 = Arrays.asList(1, 3, 7, 9, 15);
    golden = Arrays.asList(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15);
    f(test1, test2);
    Assert.assertEquals(golden, test1);
  }
}
