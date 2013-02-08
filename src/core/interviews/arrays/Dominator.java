package interviews.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Returns the most frequent element of an array.
 * @author Francois Rousseau
 */
public class Dominator {
  public static int f(int[] A) {
    int dominator = -1, count = 0;
    // main idea is to cancel values which are different by pairs.
    for(int i=0;i<A.length;i++) {
      if(count == 0) {
        dominator = i;
        count = 1;
      } else if(A[dominator] == A[i]) {
        count++;
      } else {
        count--;
      }
    }
    // one more pass to confirm that the value occurs in more than half of the
    // elements of A. [3, 1, 2, 1, 2, 1, 3] would lead to 6 otherwise.
    count = 0;
    for(int i=0;i<A.length;i++) {
      if(A[dominator] == A[i]) {
        count++;
        // force the returned index to be the last one. Easier to test.
        dominator = i;
      }
    }

    // there is a problem with an array like [3, 4, 3, 2, 3, -1, 6, 3]. It would have
    // denominator set to 6. If the previous check fails, we should try the next value
    // in the pair (here 3 which is the real denominator).
    // TODO: there may be something I missed in the core algorithm.
    if(count*2 < A.length && dominator < A.length-1) {
      dominator++;
      count = 0;
      for(int i=0;i<A.length;i++) {
        if(A[dominator] == A[i]) {
          count++;
          // force the returned index to be the last one. Easier to test.
          dominator = i;
        }
      }
    }
    return (count*2 >= A.length)?dominator:-1;
  }

  public static <T> int f(T[] A, int k) {
    Map<T, Integer> buckets = new HashMap<T, Integer>(k);
    for(int i=0;i<A.length;i++) {
      if(buckets.containsKey(A[i])) {
        buckets.put(A[i], buckets.get(A[i])+1);
      } else {
        if(buckets.size() < k) {
          buckets.put(A[i], 1);          
        } else {
          Set<T> keys = new HashSet<T>(buckets.keySet());
          for(T t:keys) {
            if(buckets.get(t) == 1) {
              buckets.remove(t);
            } else {
              buckets.put(t, buckets.get(t)-1);            
            }
          }
        }
      }
    }

    Map.Entry<T, Integer> dominator = null;
    for (Map.Entry<T, Integer> entry : buckets.entrySet()) {
        if (dominator == null
            || entry.getValue().compareTo(dominator.getValue()) >= 0) {
          dominator = entry;
        }
    }
    if (dominator != null) {
      int count = 0;
      for(int i=0;i<A.length;i++) {
        if(dominator.getKey() == A[i]) {
          count++;
          // force the returned index to be the last one. Easier to test.
          // we use the unneeded value to store the index.
          dominator.setValue(i);
        }
      }
      return (count*k >= A.length)?dominator.getValue():-1;
    }
    return -1;
  }
}
