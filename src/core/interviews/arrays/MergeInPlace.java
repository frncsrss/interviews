package interviews.arrays;

import java.util.Collections;
import java.util.List;

public class MergeInPlace {
  /**
   * Given a listed in ascending order until index n - 1 and in ascending order from index n,
   * sort in ascending order the entire list 
   */
  public static void f(List<Integer> list, int n) {
    int start_a = 0;
    int start_b = n;
    int scope = 1;
    while(start_a < start_b) {
      if(list.get(start_a) <= list.get(start_b)) {
        start_a++;
        continue;
      }
      scope = 1;
      while(list.get(start_b+scope) < list.get(start_a)) {
        scope++;
      }
      for(int i = 0; i < scope; i++) {
        Collections.swap(list, start_a++, start_b+i);
      }
    }
    while(list.get(start_b+scope-1) > list.get(start_b+scope)) {
      Collections.swap(list, start_b+scope-1, start_b+scope);
      scope++;
    }
  }

  /**
   * Given 2 lists sorted in ascending orders (a[n] and b[n/2]) with the second half of array a[]
   * being empty, create a function that merges both arrays into a single sorted array
   */
  public static void f(List<Integer> a, List<Integer> b) {
    int n = a.size() - b.size() - 1;
    int m = b.size() - 1;
    int current = a.size()-1;
    while(n >= 0 && m >= 0) {
      if(a.get(n) <= b.get(m)) {
        a.set(current--, b.get(m--));
      } else {
        a.set(current--, a.get(n--));        
      }
    }
    while(m >= 0) {
      a.set(current--, b.get(m--));      
    } // no need to do the same for n >= 0 since the elements of a are already in place
  }

  /**
   * Given 2 arrays sorted in ascending orders (a[n] and b[n/2]) with the second half of array a[]
   * being empty, create a function that merges both arrays into a single sorted array
   */
  public static void f(int[] a, int[] b) {
    int n = a.length - b.length - 1;  // index of the highest element of a in a
    int m = b.length - 1;  // index of the highest element of b in b
    int current = a.length-1;  // pointer in a
    while(n >= 0 && m >= 0) {
      if(a[n] <= b[m]) {
        a[current--] = b[m--];
      } else {
        a[current--] = a[n--];        
      }
    }
    while(m >= 0) {
      a[current--] = b[m--];      
    } // no need to do the same for n >= 0 since the elements of a are already in place
  }
}
