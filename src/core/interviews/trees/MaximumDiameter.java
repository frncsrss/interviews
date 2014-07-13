package interviews.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the maximum possible diameter of a tree, given the following information:
 *   - Some vertex in the tree is called V.
 *   - The distance between V and the farthest vertex from V is D.
 *   - For each x between 1 and D, inclusive, we know the number of vertices such that their
 *     distance from V is x.
 *
 * We are given a int[] cnt containing D strictly positive integers. For each i, the i-th element of
 * cnt is equal to the number of vertices which have distance i+1 from V. Return the maximum
 * possible diameter of a tree that matches the given information.
 *
 * @author Francois Rousseau
 */
public class MaximumDiameter {
  /**
   * Solve the problem using the following logic:
   *   1. There are only two kinds of branching in the tree: 1 child or >1 children (encoded as 2).
   *      Hence the collapse as a first step.
   *   2. We scan the tree bottom-up, level by level basically.
   *   3. For the maximum diameter, we can only use at most once a branching (with 2 children).
   *   4. The branching (with 2 children), if used, is the last thing we can do when computing the
   *      diameter (we cannot use the path to its ancestor in the diameter since the path is already
   *      using left and right). Hence the Math.max between the best value so far and a path without
   *      branching + current branching.
   */
  public static int f(int[] cnt) {
    List<int[]> list = collapse(cnt);

    int max_1 = 0;  // max so far using no branching
    int max_2 = 0;  // max so far using once a branching
    for(int i = list.size() - 1; i >= 0; i--) {
      if(list.get(i)[0] == 2) {
        max_2 = Math.max(max_2, max_1 + 2 * list.get(i)[1]);
      }
      max_1 += list.get(i)[1];
    }

    return Math.max(max_1, max_2);
  }

  /**
   * Collapse the array into a smaller one containing only 1s and 2s with their multiplicity.
   * Output format is a list of int[2], first element is 1 or 2 and second is its multiplicity.
   */
  private static List<int[]> collapse(int[] cnt) {
    List<int[]> list = new ArrayList<int[]>();
    list.add(new int[]{key(cnt[0]), 0});
    for(int c : cnt) {
      int key = key(c);
      if(list.get(list.size() - 1)[0] == key) {
        list.get(list.size() - 1)[1]++;
      } else {
        list.add(new int[]{key, 1});
      }
    }
    return list;
  }

  private static int key(int i) {
    return i == 1 ? 1 : 2;
  }
}
