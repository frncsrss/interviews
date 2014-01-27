package interviews.arrays;

import interviews.sorts.Sorts;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class HeapTest {
  private static Comparator<Integer> getDecreasingComparatorOfIntegers =
      new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return -o1.compareTo(o2);
    }
  };

  @Test(expected = NullPointerException.class)
  public void test_add() {
    Heap<Integer> heap = new Heap<Integer>(Sorts.getComparatorOfIntegers());
    heap.add(null);
  }

  @Test
  public void test_isEmpty() {
    Heap<Integer> heap = new Heap<Integer>(Sorts.getComparatorOfIntegers());
    Assert.assertEquals(true, heap.isEmpty());
    heap.add(1);
    Assert.assertEquals(false, heap.isEmpty());
    heap.poll();
    Assert.assertEquals(true, heap.isEmpty());
  }

  @Test
  public void test_poll() {
    Heap<Integer> heap = new Heap<Integer>(getDecreasingComparatorOfIntegers);
    heap.add(1);
    heap.add(2);
    heap.add(3);
    heap.add(4);
    heap.add(5);
    heap.add(6);
    Assert.assertEquals(new Integer(6), heap.peek());
    heap.add(7);
    heap.add(8);
    heap.add(9);
    heap.add(10);
    Assert.assertEquals(new Integer(10), heap.poll());
    Assert.assertEquals(new Integer(9), heap.poll());
    Assert.assertEquals(new Integer(8), heap.poll());
    Assert.assertEquals(new Integer(7), heap.poll());
    Assert.assertEquals(new Integer(6), heap.poll());
    Assert.assertEquals(new Integer(5), heap.poll());
    Assert.assertEquals(new Integer(4), heap.poll());
    Assert.assertEquals(new Integer(3), heap.poll());
    Assert.assertEquals(new Integer(2), heap.poll());
    Assert.assertEquals(new Integer(1), heap.poll());
  }

  @Test
  public void test_remove() {
    Heap<Integer> heap = new Heap<Integer>(getDecreasingComparatorOfIntegers);
    heap.add(1);
    heap.add(2);
    heap.add(3);
    heap.add(4);
    heap.add(5);
    heap.add(6);
    heap.add(7);
    heap.add(8);
    heap.add(9);
    heap.add(10);
    Assert.assertEquals(false, heap.remove(11));
    Assert.assertEquals(10, heap.size());
    Assert.assertEquals(true, heap.remove(10));  // the heap will be re-heapify
    Assert.assertEquals(9, heap.size());
    Assert.assertArrayEquals(new Integer[] {9, 8, 6, 7, 3, 2, 5, 1, 4}, heap.toArray());
  }

  @Test
  public void test_size() {
    Heap<Integer> heap = new Heap<Integer>(getDecreasingComparatorOfIntegers);
    Assert.assertEquals(0, heap.size());
    heap.add(1);
    Assert.assertEquals(1, heap.size());
    heap.poll();
    Assert.assertEquals(0, heap.size());
  }

  @Test
  public void test_toArray() {
    Heap<Integer> heap = new Heap<Integer>(getDecreasingComparatorOfIntegers);
    heap.add(1);
    Assert.assertArrayEquals(new Integer[] {1}, heap.toArray());
    heap.add(2);
    Assert.assertArrayEquals(new Integer[] {2, 1}, heap.toArray());
    heap.add(3);
    Assert.assertArrayEquals(new Integer[] {3, 1, 2}, heap.toArray());
    heap.add(4);
    Assert.assertArrayEquals(new Integer[] {4, 3, 2, 1}, heap.toArray());
    heap.add(5);
    Assert.assertArrayEquals(new Integer[] {5, 4, 2, 1, 3}, heap.toArray());
    heap.add(6);
    Assert.assertArrayEquals(new Integer[] {6, 4, 5, 1, 3, 2}, heap.toArray());
    heap.add(7);
    Assert.assertArrayEquals(new Integer[] {7, 4, 6, 1, 3, 2, 5}, heap.toArray());
    heap.add(8);
    Assert.assertArrayEquals(new Integer[] {8, 7, 6, 4, 3, 2, 5, 1}, heap.toArray());
    heap.add(9);
    Assert.assertArrayEquals(new Integer[] {9, 8, 6, 7, 3, 2, 5, 1, 4}, heap.toArray());
    heap.add(10);
    Assert.assertArrayEquals(new Integer[] {10, 9, 6, 7, 8, 2, 5, 1, 4, 3}, heap.toArray());
  }

  @Test
  public void test_toString() {
    Heap<Integer> heap = new Heap<Integer>(getDecreasingComparatorOfIntegers);
    heap.add(1);
    Assert.assertEquals("1", heap.toString());
    heap.add(2);
    Assert.assertEquals("2\n1", heap.toString());
    heap.add(3);
    Assert.assertEquals("3\n1 2", heap.toString());
    heap.add(4);
    Assert.assertEquals("4\n3 2\n1", heap.toString());
    heap.add(5);
    Assert.assertEquals("5\n4 2\n1 3", heap.toString());
    heap.add(6);
    Assert.assertEquals("6\n4 5\n1 3 2", heap.toString());
    heap.add(7);
    Assert.assertEquals("7\n4 6\n1 3 2 5", heap.toString());
    heap.add(8);
    Assert.assertEquals("8\n7 6\n4 3 2 5\n1", heap.toString());
    heap.add(9);
    Assert.assertEquals("9\n8 6\n7 3 2 5\n1 4", heap.toString());
    heap.add(10);
    Assert.assertEquals("10\n9 6\n7 8 2 5\n1 4 3", heap.toString());
  }
}
