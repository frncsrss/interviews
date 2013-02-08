package interviews.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static interviews.sorts.Bucketsort.f;
import static interviews.sorts.Bucketsort.selectorOfASCIIString;
import static interviews.sorts.Bucketsort.selectorOfIntegers;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class BucketsortTest {
  @Test
  public void test_sortIntegers()  {
    final int MAX_VALUE = 100000;
    List<Integer> golden = new ArrayList<Integer>(MAX_VALUE);
    for (int i = 0; i < MAX_VALUE; i++) {
      golden.add(new Integer(i));
    }
    Collections.shuffle(golden);
    List<Integer> list = new ArrayList<Integer>(golden);

    Comparator<Integer> comparator = new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };
    Collections.sort(golden, comparator);
    
    List<Integer> test;
    f(test = new ArrayList<Integer>(list), selectorOfIntegers());
    Assert.assertEquals(golden, test);
  }

  @Test
  public void test_sortStrings()  {
    List<String> golden = new ArrayList<String>();
    golden.add("amaranth");
    golden.add("amber");
    golden.add("apricot");
    golden.add("aquamarine");
    Collections.shuffle(golden);
    List<String> list = new ArrayList<String>(golden);

    Comparator<String> comparator = new Comparator<String>() {
      public int compare(String s1, String s2) {
        return (new Integer(s1.length())).compareTo(s2.length());
      }
    };
    Collections.sort(golden, comparator);
    
    List<String> test;
    f(test = new ArrayList<String>(list), selectorOfASCIIString());
    Assert.assertEquals(golden, test);
  }
}
