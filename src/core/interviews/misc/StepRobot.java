package interviews.misc;

import java.util.Random;

/**
 * Given a robot on a (infinite) staircase, write a function that makes it step up exactly one step.
 * The only interface you have to this robot is a function step() that makes it randomly step up or
 * down one step, and returns 1 if it stepped up and 0 if it stepped down.
 *
 * @author Francois Rousseau
 */
public class StepRobot {
  protected static int position = 0;
  protected static Random r = new Random();

  public static void stepUp() {
    int steps = 0;
    while(steps < 1) {
      if(step() == 0) {
        steps--;
      } else {
        steps++;
      }
    }
  }

  public static void stepUpNoVariables() {
    while(step() != 1) {
      stepUpNoVariables();
    }
  }

  protected static int step() {
    int step = r.nextInt(2);
    position += step == 0 ? -1 : +1;
    return step;
  }
}
