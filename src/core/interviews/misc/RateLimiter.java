package interviews.misc;

/**
 * Implement a rate limiter.
 *
 * @author Francois Rousseau
 */
public class RateLimiter {
  private final Clock clock;
  private final int rate;   // in number of messages
  private final double rate_per;  // rate per milliseconds
  private long last_check;  // in milliseconds
  private double allowance;

  public RateLimiter(int rate, int per, Clock clock) {
    this.clock = clock;
    this.rate = rate;
    this.rate_per = rate * 1.0 / per;
    this.last_check = clock.currentTimeMillis();
    this.allowance = rate;
  }

  public RateLimiter(int rate, int per) {
    this(rate, per, new Clock());
  }

  public boolean shouldAdd() {
    final long now = clock.currentTimeMillis();
    final long elapsed = now - last_check;
    last_check = now;
    allowance += elapsed * rate_per;

    if(allowance > rate) {
      allowance = rate;  // throttle
    }

    if(allowance < 1.0) {
      return false;
    } else {
      allowance--;
      return true;
    }
  }
}
