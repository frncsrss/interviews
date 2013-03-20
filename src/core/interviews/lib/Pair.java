package interviews.lib;

/**
 * Wrapper class for a pair of two objects.
 * @author Francois Rousseau
 */
public class Pair<X,Y> {
  private X x;
  private Y y;
  
  public Pair(X x, Y y) {
    this.x = x;
    this.y = y;
  }

  public X x() {
    return x;
  }
  public Y y() {
    return y;
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
