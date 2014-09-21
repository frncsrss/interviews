package interviews.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class RateLimiterTest {
  @Test
  public void test() {
    MockClock clock = new MockClock();
    clock.setCurrentTimeMillis(0);
    RateLimiter rl = new RateLimiter(5, 10, clock);
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertFalse(rl.shouldAdd());
    clock.setCurrentTimeMillis(1);
    Assert.assertFalse(rl.shouldAdd());
    clock.setCurrentTimeMillis(2);
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertFalse(rl.shouldAdd());
    clock.setCurrentTimeMillis(4);
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertFalse(rl.shouldAdd());
    clock.setCurrentTimeMillis(14);
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertTrue(rl.shouldAdd());
    Assert.assertFalse(rl.shouldAdd());
  }
}
