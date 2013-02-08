package interviews.strings;

import interviews.arrays.Swap;

import java.util.Set;
import java.util.TreeSet;

/**
 * Return all the permutations of a String.
 * @author Francois Rousseau
 */
public class Permutater {
  public static Set<String> f(String s) {
    Set<String> result = new TreeSet<String>();
    f(s.toCharArray(), s.length(), 0, result);
    return result;
  }

  private static void f(char[] arr, int n, int i, Set<String> result) {
    if(i == n-1) {
      result.add(new String(arr));
      return;
    }
    for(int j=i; j<n; j++) {
      Swap.f(arr, i, j);
      f(arr, n, i+1, result);
      Swap.f(arr, i, j);
    }
  }
}
