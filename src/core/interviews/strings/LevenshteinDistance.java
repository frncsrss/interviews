package interviews.strings;

/**
 * Compute the Levenshtein distance (a.k.a. edit distance) between two strings.
 * It corresponds to the least number of single-character edits (add, delete and substitute) that
 * are necessary to obtain one string from the other.
 *
 * @author Francois Rousseau
 */
public class LevenshteinDistance {
  /**
   * Let n = length(a) and m = length(b).
   * Time complexity:  O(nm)
   * Space complexity: O(n + m)
   */
  public static int f(String a, String b) {
    int len_a = a.length() + 1;
    int len_b = b.length() + 1;

    // the array of distances
    int[] cost = new int[len_a];
    int[] new_cost = new int[len_a];

    // initial cost of skipping prefix in a
    for(int i = 0; i < len_a; i++) {
      cost[i] = i;
    }

    // dynamically computing the array of distances

    // transformation cost for each letter in b
    for(int j = 1; j < len_b; j++) {
      // initial cost of skipping prefix in b
      new_cost[0] = j;

      // transformation cost for each letter in a
      for(int i = 1; i < len_a; i++) {
        // matching current letters in both strings
        int match = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;

        // computing cost for each transformation
        int cost_replace = cost[i - 1] + match;
        int cost_insert  = cost[i] + 1;
        int cost_delete  = new_cost[i - 1] + 1;

        // keep minimum cost
        new_cost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
      }

      // swap cost/new_cost arrays
      int[] swap = cost; cost = new_cost; new_cost = swap;
    }

    // the distance is the cost for transforming all letters in both strings
    return cost[len_a - 1];
  }
}
