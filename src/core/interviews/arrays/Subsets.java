package interviews.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Return all the 2^n subsets of a list of size n <= 31.
 * @author Francois Rousseau
 */
public class Subsets {
  public static <E> List<List<E>> f(List<E> set) {
    if(set.size() > 31) {
      throw new UnsupportedOperationException();
    }
    final int nb_subsets = 1 << set.size();  // 2^n
    List<List<E>> subsets = new ArrayList<List<E>>(nb_subsets);
    for(int i = 0; i < nb_subsets; i++) {
      subsets.add(subset(set, i));
    }
    return subsets;
  }

  private static <E> List<E> subset(List<E> set, int x) {
    final List<E> subset = new ArrayList<E>();  // up to 32 elements
    for(int k = x, index = 0; k > 0; k >>= 1) {  // up to 32 iterations
      if((k&1) == 1) {  // we add the element of the set if its bit is set to 1
        subset.add(set.get(index));
      }
      index++;
    }
    return subset;
  }
}
