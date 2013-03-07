package interviews.arrays;

/**
 * Equilibrium. Return, if it exists, the index in the array where the sum
 * of the elements at its right equals the one at its left.
 * @author Francois Rousseau
 */
public class Equilibrium {
  public static int f(int[] A) {
    long sum_right = 0, sum_left = 0;
    int i = 0, length = A.length;
    if(length == 0) {
      return -1;
    }
    for(i = 1; i < length; i++) {
      sum_right += A[i];
    }
    for(i = 0; i < length - 1; i++) {
      if(sum_left == sum_right) {
        return i;
      }
      sum_left+=A[i];
      sum_right-=A[i+1];
    }
    if(sum_left == sum_right) {
      return length-1;
    }
    return -1;
  }
}
