package interviews.sorts;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class ZipfSongTest {

  @Test
  public void test_input1()  {
    String input = "4 2\n"
        + "30 one\n30 two\n15 three\n25 four\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    ZipfSong.main(null);
    Assert.assertEquals("four\ntwo\n", baos.toString());
  }

  @Test
  public void test_input2()  {
    String input = "15 3\n"
        + "197812 re_hash\n78906 5_4\n189518 tomorrow_comes_today\n39453 new_genious\n"
        + "210492 clint_eastwood\n26302 man_research\n22544 punk\n19727 sound_check\n"
        + "17535 double_bass\n18782 rock_the_house\n198189 19_2000\n13151 latin_simone\n"
        + "12139 starshine\n11272 slow_country\n10521 m1_a1\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    ZipfSong.main(null);
    Assert.assertEquals("19_2000\nclint_eastwood\ntomorrow_comes_today\n", baos.toString());
  }

  @Test
  public void test_long()  {
    String input = "4 2\n"
        + "1000000000000 one\n30 two\n15 three\n25 four\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    ZipfSong.main(null);
    Assert.assertEquals("one\nfour\n", baos.toString());
  }

  @Test
  public void test_50000()  {
    Random random = new Random(1234);
    StringBuilder builder = new StringBuilder();
    builder.append("50000 10\n");
    for(int i = 0; i < 50000; i++) {
      builder.append(((int) random.nextInt(Integer.MAX_VALUE)/(i + 1)) + " song_" + i + "\n");
    }
    System.setIn(new ByteArrayInputStream(builder.toString().getBytes()));
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    ZipfSong.main(null);
    Assert.assertEquals(
        "song_33449\nsong_16408\nsong_35336\nsong_23404\nsong_43725\nsong_6953\nsong_49053\n"
        + "song_21289\nsong_43211\nsong_36468\n",
        baos.toString());
  }

}
