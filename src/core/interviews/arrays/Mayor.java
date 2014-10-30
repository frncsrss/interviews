package interviews.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a set of people from 1 to n with some people knowing others (not reciprocal), find the
 * mayor if he exists. The mayor is known by everybody and he knows nobody.
 *
 * @author Francois Rousseau
 */
public class Mayor {
  private final int n;
  private final Map<Integer, Set<Integer>> knows;

  public Mayor(int n, int[][] knows) {
    this.n = n;
    this.knows = new HashMap<Integer, Set<Integer>>();
    for(int[] know : knows) {
      if(!this.knows.containsKey(know[0])) {
        this.knows.put(know[0], new HashSet<Integer>());
      }
      this.knows.get(know[0]).add(know[1]);
    }
  }

  /**
   * @return the mayor in O(n) time if he exists (-1 otherwise)
   */
  public int mayor() {
    int i = 1;  // index of the current potential mayor
    while(i <= n) {
      int j = i + 1;  // index of the current next person
      for(; j <= n; j++) {
        if(knows(i, j)) {  // none of the people until j can be mayor
          break;
        }
      }
      if(j == n + 1) {  // none of the people after i can be mayor
        if(check(i)) {
          return i;
        }
      }
      i = j;  // j is the new potential mayor
    }
    return -1;
  }

  /**
   * @return whether i knows j in O(1)
   */
  private boolean knows(int i, int j) {
    return knows.containsKey(i) && knows.get(i).contains(j);
  }

  /**
   * @return whether i is the mayor in O(n)
   */
  private boolean check(int i) {
    for(int j = 1; j <= n; j++) {
      if(i == j) {
        continue;
      }
      if(knows(i, j)) {
        return false;
      }
      if(!knows(j, i)) {
        return false;
      }
    }
    return true;
  }
}
