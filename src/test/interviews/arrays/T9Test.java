package interviews.arrays;

import static interviews.arrays.T9.minKeystrokes;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class T9Test {
  @Test
  public void test() {
    assertEquals(19, minKeystrokes(new int[] {7, 3, 4, 1}, new int[] {2, 2}));
    assertEquals(-1, minKeystrokes(new int[] {13, 7, 4, 20}, new int[] {2, 1}));
    assertEquals(1164, minKeystrokes(new int[] {11, 23, 4, 50, 1000, 7, 18},
        new int[] {3, 1, 4}));
    assertEquals(1234, minKeystrokes(new int[] {100, 1000, 1, 10}, new int[] {50}));
    assertEquals(3353, minKeystrokes(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
        12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
        33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
        new int[] {10, 10, 10, 10, 10, 10, 10, 10}));
  }
}
