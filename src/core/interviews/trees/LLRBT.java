package interviews.trees;

import java.util.Collection;
import java.util.Comparator;

/**
 * Left-Leaning Red-Black Tree.
 * Red-Black: no consecutive two red links and perfect balance of black links.
 * Left-Leaning: only left-leaning red links, no right-leaning red links.
 * @author Francois Rousseau
 */
public class LLRBT<E> extends BST<E> {
  private static enum COLOR {RED, BLACK};

  public LLRBT(Comparator<E> comparator) {
    super(comparator);
  }

  public LLRBT(E e, Comparator<E> comparator) {
    super(e, comparator);
  }

  public LLRBT(Collection<E> collection, Comparator<E> comparator) {
    super(collection, comparator);
  }


  /**
   * Delete the given element from under this Node, if it is present.
   * Uses Hibbard deletion: it is not symmetric and can yield to a height of sqrt(N) instead of log(N)
   * TODO: use the red-black tree deletion
   */
  @Override
  protected BST<E>.Node delete(BST<E>.Node node, E e) {
    //TODO: use the red-black tree deletion
    return super.delete(node, e);  // can un-balance the LLRBT
  }

  /**
   * Flip colors: the color of the parent becomes black and the colors of both its children red.
   * Maintains symmetric order and perfect black balance.
   */
  @SuppressWarnings("unchecked")
  private void flipColors(Node parent) {
    assert !isRed(parent);
    assert isRed(parent.left);
    assert isRed(parent.right);
    parent.color = COLOR.RED;
    ((Node) parent.left).color = COLOR.BLACK;
    ((Node) parent.right).color = COLOR.BLACK;
  }

  /**
   * Insert the specified element under this Node and returns it.
   */
  @Override
  @SuppressWarnings("unchecked")
  protected BST<E>.Node insert(BST<E>.Node node, E e) {
    if(node == null) {
      return new Node(e, COLOR.RED);  // new node are always red at first.
    }
    final int result = comparator.compare(e, node.e);
    // we consider our BST as a Set
    // hence, we don't insert an element already in the BST (i.e. result == 0),
    // we just increment its frequency
    if(result == 0) {
      node.frequency++;
    } else if(result > 0) {
      node.right = insert(node.right, e);          
    } else {  // (result < 0)
      node.left = insert(node.left, e);
    }

    if(isRed(node.right) && !isRed(node.left)) {  // lean left
      node = rotateLeft((Node) node);
    }
    if(isRed(node.left) && isRed(node.left.left)) {  // balance 4-node
      node = rotateRight((Node) node);
    }
    if(isRed(node.left) && isRed(node.right)) {  // split 4-node
      flipColors((Node) node);
    }

    node.size = 1 + size(node.left) + size(node.right);
    return node;
  }

  /**
   * Check whether a given node is RED or not.
   */
  @SuppressWarnings("unchecked")
  private boolean isRed(BST<E>.Node node) {
    if (node == null) {
      return false;  // null links are black
    }
    return ((Node) node).color == COLOR.RED;
  }

  /**
   * Rotate left: make a parent node the left child of its right node and the left child of its
   * right node the right child of the parent.
   * Maintains symmetric order and perfect black balance.
   */
  @SuppressWarnings("unchecked")
  private Node rotateLeft(Node parent) {
    assert isRed(parent.right);
    Node right = (Node)parent.right;
    parent.right = right.left;
    right.left = parent;
    right.color = parent.color;
    parent.color = COLOR.RED;
    return right;
  }

  /**
   * Rotate right: make a parent node the right child of its left node and the right child of its
   * left node the left child of the parent.
   * Maintains symmetric order and perfect black balance.
   */
  @SuppressWarnings("unchecked")
  private Node rotateRight(Node parent) {
    assert isRed(parent.left);
    Node left = (Node)parent.left;
    parent.left = left.right;
    left.right = parent;
    left.color = parent.color;
    parent.color = COLOR.RED;
    return left;
  }


  /**
   * Private inner class for an internal LLRBT node.
   */
  protected class Node extends BST<E>.Node {
    private COLOR color;  // color of the link from its parent

    private Node(E e, COLOR color) {
      super(e);
      this.color = color;
    }
  }
}
