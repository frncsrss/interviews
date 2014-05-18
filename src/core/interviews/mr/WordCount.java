package interviews.mr;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;

/**
 * Word count using MapReduce.
 * Usage: interviews.mr.WordCount in/ out/
 * @author Francois Rousseau
 */
public class WordCount extends Configured implements Tool {
  public enum Stats {TOTAL_NUMBER_OF_WORDS};

  public static class MyMapper extends Mapper<Object, Text, Text, NullWritable>{
    @Override
    public void map(Object key, Text value, Context context)
        throws IOException, InterruptedException {
      String[] words = value.toString().split("[\\s\\p{Punct}]+");
      for(String word: words) {
        context.write(new Text(word), NullWritable.get());
        context.getCounter(Stats.TOTAL_NUMBER_OF_WORDS).increment(1);
      }
    }
  }

  public static class MyReducer extends Reducer<Text, NullWritable, Text, LongWritable> {
    private final LongWritable cf = new LongWritable();  // collection frequency

    @Override
    public void reduce(Text key, Iterable<NullWritable> values, Context context)
        throws IOException, InterruptedException {
      long n = 0;
      for(@SuppressWarnings("unused") NullWritable nu : values) {
        n++;
      }
      cf.set(n);
      context.write(key, cf);
    }
  }

  @Override
  public int run(String[] arg0) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, getClass().getCanonicalName());
    job.setMapperClass(MyMapper.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(NullWritable.class);
    job.setReducerClass(MyReducer.class);
    FileInputFormat.addInputPath(job, new Path(arg0[0]));
    FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
    return job.waitForCompletion(true) ? 0 : 1;
  }

  public static void main(String[] args) throws Exception {
    WordCount wc = new WordCount();
    wc.run(args);
  }
}
