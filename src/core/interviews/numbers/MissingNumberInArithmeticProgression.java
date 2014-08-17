package interviews.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Given an arithmetic progression, find the missing number.
 *
 * @author Francois Rousseau
 */
public class MissingNumberInArithmeticProgression {

  public static int f(int[] progression) {
    final int n = progression.length;
    final int diff = (progression[n - 1] - progression[0]) / n;
    for(int i = 0; i < n - 1; i++) {
      // missing number between progression[i] and progression[i + 1]
      if(progression[i + 1] - progression[i] != diff) {  // could be == 2 * diff
        return progression[i] + diff;
      }
    }
    return progression[n - 2] + diff;
  }

  public static void main(String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    try {
      final int n = Integer.parseInt(stdin.readLine());
      StringTokenizer st = new StringTokenizer(stdin.readLine());
      int[] numbers = new int[n];
      for(int i = 0; i < n; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(f(numbers));
      stdin.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}