package interviews.sorts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Bucketsort.
 * @author Francois Rousseau
 */
public class BucketSort {
  public static <E> void f(List<E> list, Selector<E> selector) {
    final int nb_passes = selector.size(list);
    final int nb_buckets = selector.base();
    final List<List<E>> buckets = new ArrayList<List<E>>(nb_buckets);
    final List<E> discarded = new ArrayList<E>();
    for(int k=0;k<nb_buckets;k++) {
      buckets.add(new ArrayList<E>());
    }
    for(int i=0; i<nb_passes; i++) {
      for(int k=0; k<nb_buckets; k++) {
        buckets.get(k).clear();
      }
      for(int j=0; j<list.size(); j++) {
        if(selector.size(list.get(j)) < i+1) {
          discarded.add(list.get(j));
        } else {
          buckets.get(selector.select(list.get(j), i)).add(list.get(j));
        }
      }
      list.clear();
      for(int k=0; k<nb_buckets; k++) {
        list.addAll(buckets.get(k));
      }
    }
    discarded.addAll(list);
    list.clear();
    list.addAll(discarded);
  }

  public static Selector<Integer> selectorOfIntegers() {
    return new Selector<Integer>() {
      public int base() {
        return 10;
      }
      public int select(Integer i, int k) {
        return (int)(i/(Math.pow(base(), k))) % base();
      }
      public int size(Collection<Integer> collection) {
        return size(Collections.max(collection)) + 1;
      }
      public int size(Integer i) {
        return (int) Math.log10(i) + 1;
      }
    };
  }

  public static Selector<String> selectorOfASCIIString() {
    return new Selector<String>() {
      public int base() {
        return 128;
      }
      public int select(String s, int k) {
        return s.substring(k, k+1).hashCode();
      }
      public int size(Collection<String> collection) {
        int max = 0;
        for(String s:collection) {
          if(size(s) > max) {
            max = size(s);
          }
        }
        return max;
      }
      public int size(String s) {
        return s.length();
      }
    };
  }
}

interface Selector<E> {
  public int base();
  public int select(E e, int k);
  public int size(Collection<E> collection);
  public int size(E e);
}
