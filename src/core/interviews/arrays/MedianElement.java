package interviews.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array of elements, return the median element. The array can either be considered fixed
 * or as an incoming stream.
 *
 * For an even number n of elements, return the n/2th element.
 *
 * @author Francois Rousseau
 */
public class MedianElement {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static int fixed(int[] arr) {
    int k = arr.length / 2;  // works for both odd and even numbers of elements
    int lo = 0;
    int hi = arr.length - 1;
    while(lo < hi) {
      int p = partition(arr, lo, hi);
      if(p == k) {
        break;
      } else if(p < k) {
        lo = p + 1;
      } else {
        hi = p - 1;
      }
    }
    return arr[k];
  }

  private static int partition(int[] arr, int lo, int hi) {
    int p = hi;
    int first_high = lo;
    for(int i = lo; i < hi; i++) {
      if(arr[i] < arr[p]) {
        swap(arr, i, first_high);
        first_high++;
      }
    }
    swap(arr, first_high, p);
    return first_high;
  }

  private static void swap(int[] arr, int i, int j) {
    if(i == j) {
      return;
    }
    arr[i] ^= arr[j];
    arr[j] ^= arr[i];
    arr[i] ^= arr[j];
  }

  /**
   * Let n = length(arr).
   * Time complexity:  O(nlogn)
   * Space complexity: O(n)
   */
  public static int stream(int[] arr) {
    // max-oriented
    PriorityQueue<Integer> less = new PriorityQueue<Integer>(1, Collections.reverseOrder());
    // min-oriented
    PriorityQueue<Integer> more = new PriorityQueue<Integer>();
    for(int i : arr) {  // stream
      // insert
      if(more.isEmpty() || i > more.peek()) {
        more.add(i);
      } else {
        less.add(i);
      }

      // balance
      if(less.size() > more.size()) {  // always have at least as many elements in more
        more.add(less.poll());
      } else if(more.size() > less.size() + 1) {  // but not more than 2
        less.add(more.poll());
      }
    }
    return more.poll();
  }
}
