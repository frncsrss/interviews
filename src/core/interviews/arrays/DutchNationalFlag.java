package interviews.arrays;

/**
 * Dutch national flag.
 * Given an array of N buckets, each containing a red, white, or blue pebble, sort them by color.
 * The allowed operations are:
 *  swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
 *  color(i): color of pebble in bucket i.
 *
 * The performance requirements are as follows:
 *  At most N calls to color().
 *  At most N calls to swap().
 *  Constant extra space.
 *
 * @author Francois Rousseau
 */
public class DutchNationalFlag {
  private static int[] arr;
  private static final int RED = 0;
  private static final int BLUE = 2;

  public static int[] f(int[] arr) {
    if(arr == null) {
      return null;
    }
    DutchNationalFlag.arr = arr;
    int red = 0;
    while(color(red) == RED) {
      red++;
    }
    int blue = arr.length - 1;
    while(color(blue) == BLUE) {
      blue--;
    }
    for(int i = red; i <= blue;) {
      if(color(i) == RED) {
        swap(i, red++);
      } else if(color(i) == BLUE) {
        swap(i, blue--);
      } else {
        i++;
      }
    }
    return arr;
  }

  private static void swap(int i, int j) {
    arr[i] ^= arr[j];
    arr[j] ^= arr[i];
    arr[i] ^= arr[j];
  }

  private static int color(int i) {
    return arr[i];
  }
}
