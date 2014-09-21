package interviews.misc;

/**
 * Mock class for Clock.
 *
 * @author Francois Rousseau
 */
public class MockClock extends Clock {
  private long current = 0;

  @Override
  public long currentTimeMillis() {
    return current;
  }

  public void setCurrentTimeMillis(long current) {
    this.current = current;
  }
}
