package interviews.strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Given a list of space separated words, reverse the order of the words.
 * Each line of text contains L letters and W words.
 * A line will only consist of letters and space characters.
 * There will be exactly one space character between each pair of consecutive words.
 * @author Francois Rousseau
 */
public class ReverseWords {
  public static void main(String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out));
    try {
      final int N = Integer.parseInt(stdin.readLine());
      final String prefix = "Case #";
      for(int i = 1; i <= N; i++) {
        StringTokenizer st = new StringTokenizer(stdin.readLine());
        Deque<String> stack = new ArrayDeque<String>();
        while(st.hasMoreTokens()) {
          stack.push(st.nextToken());
        }
        if(stack.isEmpty()) {
          stdout.write(prefix + i + ": ");
          stdout.newLine();
          continue;
        }
        stdout.write(prefix + i + ": " + stack.pop());
        while(!stack.isEmpty()) {
          stdout.write(" " + stack.pop());
        }
        stdout.newLine();
      }
      stdout.flush();
      stdin.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
