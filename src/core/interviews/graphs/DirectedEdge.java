package interviews.graphs;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Directed edge class.
 * @author Francois Rousseau
 */
public class DirectedEdge extends Edge {

  public DirectedEdge(int v, int w) {
    super(v, w);
  }

  public DirectedEdge(int v, int w, double weight) {
    super(v, w, weight);
  }

  @Override
  public int hashCode() {
    if(hash == 0) {
      hash = new HashCodeBuilder(17, 37)
      .append(v)
      .append(w)
      .append(weight)
      .toHashCode();
    }
    return hash;
  }
}
