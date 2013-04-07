package interviews.graphs;

/**
 * Flow edge.
 * @author Francois Rousseau
 */
public class FlowEdge extends Edge {
  private double flow;  // flow

  public FlowEdge(int v, int w, int capacity) {
    super(v, w, capacity);  // capacity is considered as weight
  }

  /**
   * Return the current flow.
   */
  public double flow() {
    return flow;
  }

  /**
   * Return the residual capacity of the edge.
   */
  public double residualCapacityTo(int vertex) {
    if(vertex == w) return weight - flow;  // forward edge
    if(vertex == v) return flow;           // backward edge
    throw new IllegalArgumentException("Wrong endpoint");    
  }

  /**
   * Add/substract the flow to the edge.
   */
  public void addResidualFlowTo(int vertex, double delta) {
    if     (vertex == w) flow += delta;  // forward edge
    else if(vertex == v) flow -= delta;  // backward edge    
    else throw new IllegalArgumentException("Wrong endpoint");    
  }

  @Override
  public String toString() {
    return v + "->" + w + "(" + flow + "/" + weight + ")";
  }
}
