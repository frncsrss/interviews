package interviews.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of the number of pins down at each roll of a bowling game (10 frames), compute
 * the total score according to the rules of bowling.
 *
 * @author Francois Rousseau
 */
public class Bowling {

  public static int score(int[] rolls) {
    int score = 0;  // current running score
    boolean new_frame = true;  // is the current roll the first of its frame?
    int frame = 1;  // current frame number
    int i = 0;  // current roll index

    while(frame <= 10) {
      if(new_frame && rolls[i] == 10) {  // strike
        score += 10;
        score += rolls[i + 1];
        score += rolls[i + 2];
        new_frame = true;
        frame++;
      } else if(!new_frame && rolls[i] + rolls[i - 1] == 10) {  // spare
        score += 10;
        score += rolls[i + 1];
        new_frame = true;
        frame++;
      } else if(!new_frame) {  // end of a frame
        score += rolls[i] + rolls[i - 1];
        new_frame = true;
        frame++;
      } else {
        new_frame = false;
      }
      i++;
    }
    assert frame == 11;

    return score;
  }

  public static void main(String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    try {
      final int N = Integer.parseInt(stdin.readLine());
      int[] rolls = new int[N];
      for(int i = 0; i < N; i++) {
        rolls[i] = Integer.parseInt(stdin.readLine());
      }
      System.out.println(score(rolls));
      stdin.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
