package interviews.misc;

/**
 * Wrapper around System.currentTimeMillis(), easier to mock.
 *
 * @author Francois Rousseau
 */
public class Clock {
  /**
   * Returns the current time in milliseconds.  Note that
   * while the unit of time of the return value is a millisecond,
   * the granularity of the value depends on the underlying
   * operating system and may be larger.  For example, many
   * operating systems measure time in units of tens of
   * milliseconds.
   *
   * <p> See the description of the class <code>Date</code> for
   * a discussion of slight discrepancies that may arise between
   * "computer time" and coordinated universal time (UTC).
   *
   * @return  the difference, measured in milliseconds, between
   *          the current time and midnight, January 1, 1970 UTC.
   * @see     java.util.Date
   */
  public long currentTimeMillis() {
    return System.currentTimeMillis();
  }
}
