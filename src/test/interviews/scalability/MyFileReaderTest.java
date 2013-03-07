package interviews.scalability;

import interviews.lib.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static interviews.scalability.MyFileReader.findMissingNumber;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class MyFileReaderTest {

  @Test
  public void test_basic() throws NoMissingNumberFoundException {
    Pair<List<Integer>, List<Integer>> pair = generateMissingNumber(1 << 16);
    List<Integer> list = pair.first();
    final int golden = Collections.min(pair.second());
    final int res = findMissingNumber(list, 1 << 12, 1 << 4);  // max_value = 1 << 16;
    Assert.assertEquals(golden, res);
  }

  @Test(expected=NoMissingNumberFoundException.class)
  public void test_noMissingNumber() throws NoMissingNumberFoundException {
    List<Integer> list = generateNumbers(1 << 16);
    Assert.assertEquals(true, findMissingNumber(list, 1 << 12, 1 << 4));
  }

  @Rule
  public TemporaryFolder tmp_dir = new TemporaryFolder();

  @Test
  public void test_file() throws NoMissingNumberFoundException, IOException {
    final String filename = tmp_dir.getRoot() + "/file.txt";
    Pair<List<Integer>, List<Integer>> pair =
        generateMissingNumberFile(filename, 1 << 16);  // max_value = 1 << 16;
    final int golden = Collections.min(pair.second());
    final int res = findMissingNumber(filename, 1 << 12, 1 << 4);
    Assert.assertEquals(golden, res);
  }

  private static Pair<List<Integer>, List<Integer>> generateMissingNumberFile(
      String filename, int max_value) throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter(filename));
    Pair<List<Integer>, List<Integer>> pair = generateMissingNumber(max_value);
    for(int i = 0; i < pair.first().size(); i++) {
      out.println(pair.first().get(i));
    }
    out.close();
    return pair;
  }

  private static Pair<List<Integer>, List<Integer>> generateMissingNumber(
      int max_value) {
    List<Integer> list = generateNumbers(max_value);
    List<Integer> removed = new ArrayList<Integer>(10);
    // we remove at the end for efficiency reason
    for(int i=max_value-1; i>max_value-10; i--) {
      removed.add(list.remove(i));
    }
    return new Pair<List<Integer>, List<Integer>>(list, removed);
  }

  private static List<Integer> generateNumbers(int max_value) {
    List<Integer> list = new ArrayList<Integer>(max_value);
    for(int i = 0; i < max_value; i++) {
      list.add(i);
    }
    Collections.shuffle(list);
    return list;
  }
}
