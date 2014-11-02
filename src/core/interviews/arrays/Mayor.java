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
   * The idea is: starting from index i=1, check if i knows j with j=i+1, i+2, ..., n.
   * 1) If i doesn't know j then we know j cannot be mayor
   * 2) If i knows j then we know i cannot be mayor and the next candidate is j
   * 3) If for a given i, we reach j=n+1 then i is the only candidate and we do the full check
   *
   * @return the mayor in O(n) time if he exists (-1 otherwise)
   */
  public int mayor() {
    int candidate = 1;  // index of the current candidate for mayor
    for(int j = 2; j <= n; j++) {
      if(knows(candidate, j)) {  // candidate cannot be mayor
        candidate = j;
      }
    }
    return check(candidate) ? candidate : -1;
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
