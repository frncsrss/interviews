package interviews.matrices;

/**
 * Given a matrix of costs and a budget, find the largest submatrix whose sum of cell values is
 * below the budget.
 *
 * @author Francois Rousseau
 */
public class LargestSubmatrixBelowBudget {
  /**
   * Let costs be a n by m matrix.
   * Time complexity:  O(nm * (n + m))
   * Space complexity: O(nm)
   */
  public static int[][] f(int[][] costs, int budget) {
    final int n = costs.length;
    final int m = costs[0].length;

    final int[][] cumulative_costs = buildCumulativeCostsMatrix(costs);  // O(nm)

    int[][] largest_submatrix = new int[2][2];
    int largest_area = 0;

    for(int i = 0; i < n; i++) {  // O(nm * (n + m))
      for(int j = 0; j < m; j++) {  // O(m * (n + m))
        int k = i;
        int l = m - 1;
        while(k < n && l >= j) {  // O(n + m)
          final int cost = cost(cumulative_costs, i, j, k, l);  // O(1)
          if(cost > budget) {
            l--;
          } else {
            final int area = (k - i + 1) * (l - j + 1);
            if(area > largest_area) {
              largest_submatrix = new int[][]{new int[]{i, j}, new int[]{k, l}};
              largest_area = area;
            }
            k++;
          }
        }
      }
    }

    return largest_submatrix;
  }

  /**
   * @return a matrix of cumulative costs between costs[0][0] and costs[i][j]
   */
  private static int[][] buildCumulativeCostsMatrix(int[][] costs) {
    final int n = costs.length;
    final int m = costs[0].length;

    int[][] cumulative_costs = new int[n][m];

    cumulative_costs[0][0] = costs[0][0];
    // i == 0
    for(int j = 1; j < m; j++) {
      cumulative_costs[0][j] = cumulative_costs[0][j - 1] + costs[0][j];
    }
    // j == 0
    for(int i = 1; i < n; i++) {
      cumulative_costs[i][0] = cumulative_costs[i - 1][0] + costs[i][0];
    }
    for(int i = 1; i < n; i++) {
      for(int j = 1; j < m; j++) {
        cumulative_costs[i][j] = cumulative_costs[i - 1][j] + cumulative_costs[i][j - 1]
            - cumulative_costs[i - 1][j - 1] + costs[i][j];
      }
    }

    return cumulative_costs;
  }

  /**
   * @return sum of the costs in the submatrix delimited by [i1, j1] and [i2, j2].
   */
  private static int cost(int[][] cumulative_costs, int i1, int j1, int i2, int j2) {
    int cost = cumulative_costs[i2][j2];
    if(i1 > 0) {
      cost -= cumulative_costs[i1 - 1][j2];
    }
    if(j1 > 0) {
      cost -= cumulative_costs[i2][j1 - 1];
    }
    if(i1 > 0 && j1 > 0) {
      cost += cumulative_costs[i1 - 1][j1 - 1];
    }
    return cost;
  }
}
