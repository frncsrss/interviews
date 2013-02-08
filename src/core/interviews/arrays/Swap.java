package interviews.arrays;

import java.util.List;

/**
 * Swap integer-value elements of a list without temporary variable.
 * Swap values of a char array.
 * @author Francois Rousseau
 */
public class Swap {
  /**
   * This function swaps 2 elements of a list at index i and j.
   */
  public static <E> void f(List<E> list, int i, int j) {
    E tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
  }

  /**
   * This function swaps 2 elements of an array at index i and j.
   */
  public static <E> void f(E[] arr, int i, int j) {
    E tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /**
   * This function swaps 2 integers of an array at index i and j.
   */
  public static void f(int[] arr, int i, int j) {
    if(i!=j) {
      arr[i] = arr[i]^arr[j];
      arr[j] = arr[i]^arr[j];
      arr[i] = arr[i]^arr[j];
    }
  }

  /**
   * This function swaps 2 characters of an array at index i and j.
   */
  public static void f(char[] arr, int i, int j) {
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /**
   * This function swaps d elements of an array starting at index start1
   * with d elements starting at index start2.
   */
  public static <E> void f(List<E> list, int start1, int start2, int d) {
    while(d-- > 0) {
      f(list, start1++, start2++);
    }
  }

  /**
   * This function swaps d elements of an array starting at index start1
   * with d elements starting at index start2.
   */
  public static void f(int[] arr, int start1, int start2, int d) {
    while(d-- > 0) {
      f(arr, start1++, start2++);
    }
  }
}
