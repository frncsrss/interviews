package interviews.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class SortsTest {
  private static final Comparator<Integer> comparator = Sorts.getComparatorOfIntegers();
  private static final Selector<Integer> selector = BucketSort.selectorOfIntegers();
  private static final List<Integer> shuffled_10000 = getShuffledListOfIntegers(10000);
  private static final List<Integer> sorted_10000 = getSortedListOfIntegers(shuffled_10000, comparator);
  private static final List<Integer> duplicated_10000 = getDuplicatedListOfIntegers(10000);
  private static final List<Integer> duplicated2_10000 = getSomeDuplicatedListOfIntegers(10000);
  private static final List<Integer> sorted2_10000 = getSortedListOfIntegers(duplicated2_10000, comparator);
  private static final List<Integer> shuffled_1000000 = getShuffledListOfIntegers(1000000);
  private static final List<Integer> sorted_1000000 = getSortedListOfIntegers(shuffled_1000000, comparator);
  private static final List<Integer> reverse_1000000 = getReverseListOfIntegers(sorted_1000000);

  private static List<Integer> getShuffledListOfIntegers(int max_value) {
    List<Integer> list = new ArrayList<Integer>(max_value);
    for (int i = 0; i < max_value; i++) {
      list.add(new Integer(i));
    }
    Collections.shuffle(list);
    return list;
  }

  private static List<Integer> getSortedListOfIntegers(
      List<Integer> list, Comparator<Integer> comparator) {
    List<Integer> sorted = new ArrayList<Integer>(list);
    Collections.sort(sorted, comparator);
    return sorted;
  }

  private static List<Integer> getReverseListOfIntegers(List<Integer> list) {
    List<Integer> reverse = new ArrayList<Integer>(list);
    Collections.reverse(reverse);
    return reverse;
  }

  private static List<Integer> getDuplicatedListOfIntegers(int max_value) {
    List<Integer> duplicated = new ArrayList<Integer>(max_value);
    final int duplicate = Math.abs(new Random(1234).nextInt());
    for (int i = 0; i < max_value; i++) {
      duplicated.add(new Integer(duplicate));
    }
    return duplicated;
  }

  private static List<Integer> getSomeDuplicatedListOfIntegers(int max_value) {
    List<Integer> duplicated = new ArrayList<Integer>(max_value);
    Random rnd = new Random(1234);
    for (int i = 0; i < max_value/100; i++) {
      final int duplicate = Math.abs(rnd.nextInt());
      for (int j = 0; j < 100; j++) {
        duplicated.add(new Integer(duplicate));
      }
    }
    Collections.shuffle(duplicated);
    return duplicated;
  }


  @Test
  public void test_shuffled_10000_quicksort1()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_10000), comparator, 1);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_quicksort2()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_10000), comparator, 2);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_quicksort3()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_10000), comparator, 3);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_quicksort4()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_10000), comparator, 4);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_quicksort5()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_10000), comparator, 5);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_quicksort6()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_10000), comparator, 6);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_mergesort1()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(shuffled_10000), comparator, Mergesort.TYPE.AUX_ARRAY);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_mergesort2()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(shuffled_10000), comparator, Mergesort.TYPE.AUX_QUEUE);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_mergesort3()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(shuffled_10000), comparator, Mergesort.TYPE.TOP_DOWN);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_mergesort4()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(shuffled_10000), comparator, Mergesort.TYPE.BOTTOM_UP);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_bstTraversalSort()  {
    List<Integer> test;
    Sorts.bstTraversalSort(test = new ArrayList<Integer>(shuffled_10000), comparator);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_buckesort()  {
    List<Integer> test;
    Sorts.bucketsort(test = new ArrayList<Integer>(shuffled_10000), selector);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_heapsort()  {
    List<Integer> test;
    Sorts.heapsort(test = new ArrayList<Integer>(shuffled_10000), comparator);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_shellsort()  {
    List<Integer> test;
    Sorts.shellsort(test = new ArrayList<Integer>(shuffled_10000), comparator);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_insertionSort()  {
    List<Integer> test;
    Sorts.insertionSort(test = new ArrayList<Integer>(shuffled_10000), comparator);
    Assert.assertEquals(sorted_10000, test);
  }

  @Test
  public void test_shuffled_10000_selectionSort()  {
    List<Integer> test;
    Sorts.selectionSort(test = new ArrayList<Integer>(shuffled_10000), comparator);
    Assert.assertEquals(sorted_10000, test);
  }


  @Test
  public void test_shuffled_1000000_quicksort1()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_1000000), comparator, 1);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_quicksort2()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_1000000), comparator, 2);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_quicksort3()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_1000000), comparator, 3);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_quicksort4()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_1000000), comparator, 4);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_quicksort5()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_1000000), comparator, 5);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_quicksort6()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(shuffled_1000000), comparator, 6);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_mergesort1()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(shuffled_1000000), comparator, Mergesort.TYPE.AUX_ARRAY);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_mergesort2()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(shuffled_1000000), comparator, Mergesort.TYPE.AUX_QUEUE);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_mergesort3()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(shuffled_1000000), comparator, Mergesort.TYPE.TOP_DOWN);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_mergesort4()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(shuffled_1000000), comparator, Mergesort.TYPE.BOTTOM_UP);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_bstTraversalSort()  {
    List<Integer> test;
    Sorts.bstTraversalSort(test = new ArrayList<Integer>(shuffled_1000000), comparator);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_buckesort()  {
    List<Integer> test;
    Sorts.bucketsort(test = new ArrayList<Integer>(shuffled_1000000), selector);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_shellsort()  {
    List<Integer> test;
    Sorts.shellsort(test = new ArrayList<Integer>(shuffled_1000000), comparator);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_shuffled_1000000_CollectionsSort()  {
    List<Integer> test;
    Collections.sort(test = new ArrayList<Integer>(shuffled_1000000), comparator);
    Assert.assertEquals(sorted_1000000, test);
  }


  @Test
  public void test_sorted_1000000_quicksort1()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(sorted_1000000), comparator, 1);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_quicksort2()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(sorted_1000000), comparator, 2);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_quicksort3()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(sorted_1000000), comparator, 3);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_quicksort4()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(sorted_1000000), comparator, 4);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_quicksort5()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(sorted_1000000), comparator, 5);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_quicksort6()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(sorted_1000000), comparator, 6);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_mergesort1()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(sorted_1000000), comparator, Mergesort.TYPE.AUX_ARRAY);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_mergesort2()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(sorted_1000000), comparator, Mergesort.TYPE.AUX_QUEUE);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_mergesort3()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(sorted_1000000), comparator, Mergesort.TYPE.TOP_DOWN);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_mergesort4()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(sorted_1000000), comparator, Mergesort.TYPE.BOTTOM_UP);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_buckesort()  {
    List<Integer> test;
    Sorts.bucketsort(test = new ArrayList<Integer>(sorted_1000000), selector);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_shellsort()  {
    List<Integer> test;
    Sorts.shellsort(test = new ArrayList<Integer>(sorted_1000000), comparator);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_sorted_1000000_CollectionsSort()  {
    List<Integer> test;
    Collections.sort(test = new ArrayList<Integer>(sorted_1000000), comparator);
    Assert.assertEquals(sorted_1000000, test);
  }


  @Test
  public void test_reverse_1000000_quicksort1()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(reverse_1000000), comparator, 1);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_quicksort2()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(reverse_1000000), comparator, 2);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_quicksort3()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(reverse_1000000), comparator, 3);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_quicksort4()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(reverse_1000000), comparator, 4);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_quicksort5()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(reverse_1000000), comparator, 5);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_quicksort6()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(reverse_1000000), comparator, 6);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_mergesort1()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(reverse_1000000), comparator, Mergesort.TYPE.AUX_ARRAY);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_mergesort2()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(reverse_1000000), comparator, Mergesort.TYPE.AUX_QUEUE);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_mergesort3()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(reverse_1000000), comparator, Mergesort.TYPE.TOP_DOWN);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_mergesort4()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(reverse_1000000), comparator, Mergesort.TYPE.BOTTOM_UP);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_buckesort()  {
    List<Integer> test;
    Sorts.bucketsort(test = new ArrayList<Integer>(reverse_1000000), selector);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_shellsort()  {
    List<Integer> test;
    Sorts.shellsort(test = new ArrayList<Integer>(reverse_1000000), comparator);
    Assert.assertEquals(sorted_1000000, test);
  }

  @Test
  public void test_reverse_1000000_CollectionsSort()  {
    List<Integer> test;
    Collections.sort(test = new ArrayList<Integer>(reverse_1000000), comparator);
    Assert.assertEquals(sorted_1000000, test);
  }


  @Test
  public void test_duplicated_10000_quicksort1()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated_10000), comparator, 1);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_quicksort2()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated_10000), comparator, 2);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_quicksort3()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated_10000), comparator, 3);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_quicksort4()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated_10000), comparator, 4);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_quicksort5()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated_10000), comparator, 5);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_quicksort6()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated_10000), comparator, 6);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_mergesort1()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(duplicated_10000), comparator, Mergesort.TYPE.AUX_ARRAY);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_mergesort2()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(duplicated_10000), comparator, Mergesort.TYPE.AUX_QUEUE);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_mergesort3()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(duplicated_10000), comparator, Mergesort.TYPE.TOP_DOWN);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_mergesort4()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(duplicated_10000), comparator, Mergesort.TYPE.BOTTOM_UP);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_bstTraversalSort()  {
    List<Integer> test;
    Sorts.bstTraversalSort(test = new ArrayList<Integer>(duplicated_10000), comparator);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_buckesort()  {
    List<Integer> test;
    Sorts.bucketsort(test = new ArrayList<Integer>(duplicated_10000), selector);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_shellsort()  {
    List<Integer> test;
    Sorts.shellsort(test = new ArrayList<Integer>(duplicated_10000), comparator);
    Assert.assertEquals(duplicated_10000, test);
  }

  @Test
  public void test_duplicated_10000_CollectionsSort()  {
    List<Integer> test;
    Collections.sort(test = new ArrayList<Integer>(duplicated_10000), comparator);
    Assert.assertEquals(duplicated_10000, test);
  }


  @Test
  public void test_duplicated2_10000_quicksort1()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated2_10000), comparator, 1);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_quicksort2()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated2_10000), comparator, 2);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_quicksort3()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated2_10000), comparator, 3);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_quicksort4()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated2_10000), comparator, 4);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_quicksort5()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated2_10000), comparator, 5);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_quicksort6()  {
    List<Integer> test;
    Sorts.quicksort(test = new ArrayList<Integer>(duplicated2_10000), comparator, 6);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_mergesort1()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(duplicated2_10000), comparator, Mergesort.TYPE.AUX_ARRAY);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_mergesort2()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(duplicated2_10000), comparator, Mergesort.TYPE.AUX_QUEUE);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_mergesort3()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(duplicated2_10000), comparator, Mergesort.TYPE.TOP_DOWN);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_mergesort4()  {
    List<Integer> test;
    Sorts.mergesort(test = new ArrayList<Integer>(duplicated2_10000), comparator, Mergesort.TYPE.BOTTOM_UP);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_bstTraversalSort()  {
    List<Integer> test;
    Sorts.bstTraversalSort(test = new ArrayList<Integer>(duplicated2_10000), comparator);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_buckesort()  {
    List<Integer> test;
    Sorts.bucketsort(test = new ArrayList<Integer>(duplicated2_10000), selector);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_shellsort()  {
    List<Integer> test;
    Sorts.shellsort(test = new ArrayList<Integer>(duplicated2_10000), comparator);
    Assert.assertEquals(sorted2_10000, test);
  }

  @Test
  public void test_duplicated2_10000_CollectionsSort()  {
    List<Integer> test;
    Collections.sort(test = new ArrayList<Integer>(duplicated2_10000), comparator);
    Assert.assertEquals(sorted2_10000, test);
  }
}
