package interviews.trees;

/**
 * Binary Tree Node.
 * @author Francois Rousseau
 */
public class BTNode<E> {
  protected E value;
  protected BTNode<E> left;
  protected BTNode<E> right;

  public BTNode() {}

  public BTNode(E value) {
    this.value = value;
  }
}
