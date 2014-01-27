package interviews.lib;

/**
 * Wrapper class for a pair of two objects.
 * @author Francois Rousseau
 */
public class Pair<X,Y> {
  public final X x;
  public final Y y;

  public Pair(X x, Y y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
