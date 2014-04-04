package interviews.misc;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class StepRobotTest {
  @Test
  public void test_stepUp() {
    synchronized (StepRobot.class) {
      for(int i = 0; i < 1000; i++) {
        Assert.assertEquals(0, StepRobot.position);
        StepRobot.stepUp();
        Assert.assertEquals(1, StepRobot.position);
        StepRobot.position = 0;
      }
    }
  }

  @Test
  public void test_stepUpNoVariables() {
    synchronized (StepRobot.class) {
      for(int i = 0; i < 1000; i++) {
        Assert.assertEquals(0, StepRobot.position);
        StepRobot.stepUpNoVariables();
        Assert.assertEquals(1, StepRobot.position);
        StepRobot.position = 0;
      }
    }
  }

  @Test
  public void test_step() {
    synchronized (StepRobot.class) {
      StepRobot.r = new Random(1234);
      Assert.assertEquals(0, StepRobot.position);
      int[] expected = new int[]{1, 0, 1, 0, 1, 0, -1, 0, -1, -2, -3, -4, -5, -6, -5, -6, -5, -6, -7};
      for(int i = 0; i < expected.length; i++) {
        StepRobot.step();
        Assert.assertEquals(expected[i], StepRobot.position);
      }
    }
  }
}
