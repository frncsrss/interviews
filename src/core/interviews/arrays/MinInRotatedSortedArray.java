package interviews.arrays;

import java.util.NoSuchElementException;

/**
 * Find the min element in an rotated sorted array of elements.
 * @author Francois Rousseau
 */
public class MinInRotatedSortedArray {
  public static int f(int[] arr) {
    if(arr == null || arr.length == 0) {
      throw new NoSuchElementException();
    }
    if(arr.length == 1) {
      return arr[0];
    }
    for(int i = 0; i < arr.length - 1; i++) {
      if(arr[i + 1] < arr[i]) {
        return arr[i + 1];
      }
    }
    return arr[0];
  }
}
