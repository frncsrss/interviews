package interviews.mr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class WordCountTest {
  private Configuration conf;
  private Path input;
  private Path output;
  private FileSystem fs;

  @Rule
  public final TemporaryFolder tmp = new TemporaryFolder();

  @Before
  public void setup() throws IOException {
    conf();
    input  = new Path(input());
    output = new Path(tmp.getRoot() + "/output/");
    fs = FileSystem.getLocal(conf);
  }

  @Test
  public void test() throws Exception {
    WordCount wc = new WordCount();
    wc.setConf(conf);

    assertEquals(0, wc.run(new String[] {input.toString(), output.toString()}));

    InputStream in = null;
    try {
      in = fs.open(new Path(output.toString(), "part-r-00000"));

      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      assertEquals("That\t2", br.readLine());
      assertEquals("The\t2", br.readLine());
      assertEquals("a\t1", br.readLine());
      assertEquals("and\t1", br.readLine());
      assertEquals("be\t2", br.readLine());
      assertEquals("behind\t1", br.readLine());
      assertEquals("but\t1", br.readLine());
      assertEquals("form\t1", br.readLine());
      assertEquals("hast\t1", br.readLine());
      assertEquals("left\t1", br.readLine());
      assertEquals("like\t1", br.readLine());
      assertEquals("makeless\t1", br.readLine());
      assertEquals("no\t3", br.readLine());
      assertEquals("of\t2", br.readLine());
      assertEquals("soon\t1", br.readLine());
      assertEquals("still\t1", br.readLine());
      assertEquals("thee\t2", br.readLine());
      assertEquals("thou\t1", br.readLine());
      assertEquals("thy\t1", br.readLine());
      assertEquals("wail\t1", br.readLine());
      assertEquals("weep\t1", br.readLine());
      assertEquals("widow\t2", br.readLine());
      assertEquals("wife\t3", br.readLine());
      assertEquals("will\t3", br.readLine());
      assertEquals("world\t3", br.readLine());
      assertNull(br.readLine());
    } finally {
      IOUtils.closeStream(in);
    }
  }

  private void conf() throws IOException {
    conf = new Configuration();
    conf.set("fs.default.name", "file:///");
    conf.set("mapred.job.tracker", "local");
  }

  private String input() throws IOException {
    File file = tmp.newFile("input");
    BufferedWriter out = new BufferedWriter(new FileWriter(file));
    out.write("The world will wail thee like a makeless wife,");
    out.newLine();
    out.write("The world will be thy widow and still weep,");
    out.newLine();
    out.write("That thou no form of thee hast left behind,");
    out.newLine();
    out.write("That wife of no world will be no wife but widow soon.");
    out.newLine();
    out.close();
    return file.getAbsolutePath();
  }
}
