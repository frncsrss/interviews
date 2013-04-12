package interviews.strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Translate input cipher text from Googlerese to English.
 * @author Francois Rousseau
 */
public class Googlerese {
  public static void main(String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out));
    try {
      final int N = Integer.parseInt(stdin.readLine());
      final String prefix = "Case #";
      char[] mapping = new char[] {
          'y', 'h', 'e', 's', 'o', 'c', 'v', 'x', 'd', 'u', 'i', 'g', 'l', 'b', 'k', 'r', 'z', 't',
          'n', 'w', 'j', 'p', 'f', 'm', 'a', 'q'};
      for(int i = 1; i <= N; i++) {
        char[] G = stdin.readLine().toCharArray();
        char[] S = new char[G.length];
        for(int j = 0; j < G.length; j++) {
          if(G[j] == ' ') {
            S[j] = ' ';
          } else {
            S[j] = mapping[G[j] - 'a'];
          }
        }
        stdout.write(prefix + i + ": " + new String(S));
        stdout.newLine();
      }
      stdout.flush();
      stdin.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
