package interviews.lib;

/**
 * Wrapper class for two objects.
 * @author Francois Rousseau
 */
public class Pair<X,Y> {
  private X first;
  private Y second;
  
  public Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  public X first() {
    return first;
  }
  public Y second() {
    return second;
  }

  public String toString() {
    return "("+first+","+second+")";
  }
}
