package interviews.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static interviews.arrays.Rotation.blockSwap;
import static interviews.arrays.Rotation.reversalAlgorithm1;
import static interviews.arrays.Rotation.reversalAlgorithm2;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RotationTest {
  @Test
  public void test_reversalAlgorithm1() {
    Assert.assertEquals(
        Arrays.asList(7, 1, 5, 2, 4, 3, 0),
        reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 0));
    Assert.assertEquals(
        Arrays.asList(0, 7, 1, 5, 2, 4, 3),
				reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 1));
    Assert.assertEquals(
        Arrays.asList(3, 0, 7, 1, 5, 2, 4),
				reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 2));
    Assert.assertEquals(
        Arrays.asList(4, 3, 0, 7, 1, 5, 2),
				reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 3));
    Assert.assertEquals(
        Arrays.asList(2, 4, 3, 0, 7, 1, 5),
				reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 4));
    Assert.assertEquals(
        Arrays.asList(5, 2, 4, 3, 0, 7, 1),
				reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 5));
    Assert.assertEquals(
        Arrays.asList(1, 5, 2, 4, 3, 0, 7),
				reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 6));
    Assert.assertEquals(
        Arrays.asList(7, 1, 5, 2, 4, 3, 0),
				reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 7));
    Assert.assertEquals(
        Arrays.asList(0, 7, 1, 5, 2, 4, 3),
				reversalAlgorithm1(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 8));
  }

  @Test
  public void test_reversalAlgorithm1_big() {
    final int N = 1000000;
    List<Integer> input = new ArrayList<Integer>(N);
    for(int i = 0; i < N; i++) {
      input.add(i);
    }
    List<Integer> expected = new ArrayList<Integer>(N);
    for(int i = N/2; i < N; i++) {
      expected.add(i);
    }
    for(int i = 0; i < N/2; i++) {
      expected.add(i);
    }
    Assert.assertEquals(expected, reversalAlgorithm1(input, N/2));
  }

  @Test
  public void test_reversalAlgorithm2() {
    Assert.assertEquals(
        Arrays.asList(7, 1, 5, 2, 4, 3, 0),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 0));
    Assert.assertEquals(
        Arrays.asList(0, 7, 1, 5, 2, 4, 3),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 1));
    Assert.assertEquals(
        Arrays.asList(3, 0, 7, 1, 5, 2, 4),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 2));
    Assert.assertEquals(
        Arrays.asList(4, 3, 0, 7, 1, 5, 2),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 3));
    Assert.assertEquals(
        Arrays.asList(2, 4, 3, 0, 7, 1, 5),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 4));
    Assert.assertEquals(
        Arrays.asList(5, 2, 4, 3, 0, 7, 1),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 5));
    Assert.assertEquals(
        Arrays.asList(1, 5, 2, 4, 3, 0, 7),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 6));
    Assert.assertEquals(
        Arrays.asList(7, 1, 5, 2, 4, 3, 0),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 7));
    Assert.assertEquals(
        Arrays.asList(0, 7, 1, 5, 2, 4, 3),
				reversalAlgorithm2(Arrays.asList(7, 1, 5, 2, 4, 3, 0), 8));
  }

  @Test
  public void test_reversalAlgorithm2_big() {
    final int N = 1000000;
    List<Integer> input = new ArrayList<Integer>(N);
    for(int i = 0; i < N; i++) {
      input.add(i);
    }
    List<Integer> expected = new ArrayList<Integer>(N);
    for(int i = N/2; i < N; i++) {
      expected.add(i);
    }
    for(int i = 0; i < N/2; i++) {
      expected.add(i);
    }
    Assert.assertEquals(expected, reversalAlgorithm2(input, N/2));
  }

  @Test
  public void test_blockSwap() {
    Assert.assertArrayEquals(
        new int[]{7, 1, 5, 2, 4, 3, 0},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 0));
    Assert.assertArrayEquals(
        new int[]{1, 5, 2, 4, 3, 0, 7},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 1));
    Assert.assertArrayEquals(
        new int[]{5, 2, 4, 3, 0, 7, 1},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 2));
    Assert.assertArrayEquals(
        new int[]{2, 4, 3, 0, 7, 1, 5},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 3));
    Assert.assertArrayEquals(
        new int[]{4, 3, 0, 7, 1, 5, 2},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 4));
    Assert.assertArrayEquals(
        new int[]{3, 0, 7, 1, 5, 2, 4},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 5));
    Assert.assertArrayEquals(
        new int[]{0, 7, 1, 5, 2, 4, 3},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 6));
    Assert.assertArrayEquals(
        new int[]{7, 1, 5, 2, 4, 3, 0},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 7));
    Assert.assertArrayEquals(
        new int[]{1, 5, 2, 4, 3, 0, 7},
        blockSwap(new int[]{7, 1, 5, 2, 4, 3, 0}, 8));
  }

  @Test
  public void test_blockSwap_big() {
    final int N = 1000000;
    int[] input = new int[N];
    for(int i = 0; i < N; i++) {
      input[i] = i;
    }
    int[] expected = new int[N];
    for(int i = N/2; i < N; i++) {
      expected[i-N/2] = i;
    }
    for(int i = 0; i < N/2; i++) {
      expected[i+N/2] = i;
    }
    Assert.assertArrayEquals(expected, blockSwap(input, N/2));
  }
}
