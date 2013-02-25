package interviews.arrays;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * HeapMin.
 * @author Francois Rousseau
 */
public class HeapMin<E> extends Heap<E> {

  public HeapMin(Comparator<E> comparator) {
    super(comparator);
  }

  public HeapMin(Collection<E> collection, Comparator<E> comparator) {
    super(collection, comparator);
  }
  
  @Override
  protected int bubbleUp(int index) {
    try {
      final int parent = parent(index);
      if(comparator.compare(get(index), get(parent)) < 0) {
        swap(index, parent);
        return bubbleUp(parent);
      }     
    } catch(NoSuchElementException exc) {}
    return index;
  }

  @Override
  protected int bubbleDown(int index) {
    try {
      int parent = index;
      final int left = left(index);
      if(comparator.compare(get(parent), get(left)) > 0) {
        parent = left;  // we should at least swap with the left child
      }
      try {
        final int right = right(index);
          if(comparator.compare(get(parent), get(right)) > 0) {
            parent = right;  // we should swap with the right child
          }
        } catch(NoSuchElementException exc) {}  // no right child
      if(parent != index) {  // there is one child with a bigger value
        swap(index, parent);
        return bubbleDown(parent);
      }
    } catch(NoSuchElementException exc) {}  // no child
    return index;   
  }

}
