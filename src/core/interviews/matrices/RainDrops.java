package interviews.matrices;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of heights representing the US, first row and first column touching the Pacific
 * and last row and last column touching the Atlantic, return the cells for which a rain drop would
 * fall in both oceans.
 * 
 * A rain drop can only fall from one cell to another cell of height stricly less.
 *
 * @author Francois Rousseau
 */
public class RainDrops {
  /**
   * Let heights be an n by m matrix.
   * Time complexity:  O(nm)
   * Space complexity: O(nm)
   */
  public static List<int[]> f(int[][] heights) {
    final int n = heights.length;
    final int m = heights[0].length;
    MutableType[][] types = new MutableType[n][m];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        types[i][j] = new MutableType();
      }
    }

    List<int[]> both = new ArrayList<int[]>();
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        final MutableType type = types[i][j];
        if(type.type == Type.UNKNOWN) {
          dfs(heights, types, i, j);
        }
        if(type.type == Type.BOTH) {
          both.add(new int[]{i, j});
        }
      }
    }

    // FYI, cells left UNDECIDED represent local minima.

    return both;
  }

  private static enum Type {UNKNOWN, UNDECIDED, PACIFIC, ATLANTIC, BOTH};

  private static class MutableType {
    private Type type = Type.UNKNOWN;

    public void update(Type other) {
      if(type == Type.UNKNOWN || type ==  Type.UNDECIDED) {
        type = other;
      } else if(type == Type.ATLANTIC && other == Type.PACIFIC) {
        type = Type.BOTH;
      } else if(type == Type.PACIFIC && other == Type.ATLANTIC) {
        type = Type.BOTH;
      } else if(type != Type.BOTH && other == Type.BOTH) {
        type = Type.BOTH;
      }
    }

    @Override
    public String toString() {
      return type.name();
    }
  }

  private static Type dfs(int[][] heights, MutableType[][] types, int i, int j) {
    final MutableType type = types[i][j];
    if(type.type != Type.UNKNOWN && type.type != Type.UNDECIDED) {
      return type.type;
    }
    type.update(Type.UNDECIDED);

    final int height = heights[i][j];
    final int n = heights.length;
    final int m = heights[0].length;

    // base case
    if(i == 0 || j == 0) {
      type.update(Type.PACIFIC);
    }
    if(i == n - 1 || j == m - 1) {
      type.update(Type.ATLANTIC);
    }

    // recursive case (we consider that for ties rain drops do not fall)
    if(i > 0 && types[i - 1][j].type != Type.UNDECIDED && height > heights[i - 1][j]) {
      Type other = dfs(heights, types, i - 1, j);
      type.update(other);
    }
    if(i < n - 1 && types[i + 1][j].type != Type.UNDECIDED && height > heights[i + 1][j]) {
      Type other = dfs(heights, types, i + 1, j);
      type.update(other);
    }
    if(j > 0 && types[i][j - 1].type != Type.UNDECIDED && height > heights[i][j - 1]) {
      Type other = dfs(heights, types, i, j - 1);
      type.update(other);
    }
    if(j < m - 1 && types[i][j + 1].type != Type.UNDECIDED && height > heights[i][j + 1]) {
      Type other = dfs(heights, types, i, j + 1);
      type.update(other);
    }

    return type.type;
  }
}
