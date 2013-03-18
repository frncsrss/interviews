package interviews.sorts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Zipf's song.
 * 
 * Return the m best songs from a set of n songs in O(nlogm) time and O(m) space.
 * Quality is defined as being listened to more often than predicted by Zipf's Law.
 * Use a min-oriented priority queue maintaining the m best songs so far.
 * 
 * Fixes:
 *  1. use ASCII characters in the javadoc (Compile Time Error)
 *  2. use long instead of int for quality (Run Time Error)
 *  3. use Array of best songs instead of List
 *     set initial capacity of the priority queue to m
 *  4. use BufferedReader and StringTokenizer instead of Scanner (Time Limit Exceeded)
 *     (reduce the running time by a factor 2) 
 *  5. use BufferedWriter for the output
 *
 * @author Francois Rousseau
 */
public class ZipfSong {
  public static void main(String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out));
    try {
      StringTokenizer st = new StringTokenizer(stdin.readLine());
      final int n = Integer.parseInt(st.nextToken());  // up to 50,000
      int m = Integer.parseInt(st.nextToken());  // up to n
      // we will maintain a priority queue of the m highest quality songs
      PriorityQueue<Song> pq = new PriorityQueue<Song>(m);
      // we add the first m songs
      for(int i = 0; i < m; i++) {  // O(mlogm)
        st = new StringTokenizer(stdin.readLine());
        Song song = new Song(i + 1, Long.parseLong(st.nextToken()), st.nextToken());
        pq.add(song);  // O(logm)
      }
      // we then scan the remaining n - m songs
      for(int i = m; i < n; i++) {  // O(nlogm)
        st = new StringTokenizer(stdin.readLine());
        Song song = new Song(i + 1, Long.parseLong(st.nextToken()), st.nextToken());
        Song head = pq.peek();
        // add a new song if its quality is higher than the lowest quality in the priority queue
        if(song.compareTo(head) > 0) {
          pq.poll();  // O(logm)
          pq.add(song);  // O(logm)
        }
      }
      // array holding in ascending order of quality the m best songs
      Song[] bestSongs = new Song[m];
      int i = 0;
      while(!pq.isEmpty()) {  // O(mlogm)
        bestSongs[i++] = pq.poll();
      }
      for(i = m - 1; i >= 0; i--) {  // O(m)
        stdout.write(bestSongs[i].name);
        stdout.newLine();
      }
      stdout.flush();
      stdin.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static class Song implements Comparable<Song> {
    private int index;  // up to 50,000
    private long quality;  // up to 50,000 x 10^12 = 5 x 10^16 < 2^63 - 1
    private String name;

    private Song(int index, long listened, String name) {
      this.index = index;
      // ratio being number of times being listened to and predicted by Zipf's Law (1/index)
      this.quality = index * listened;
      this.name = name;
    }

    @Override
    public int compareTo(Song that) {
      if(this == that) return 0;
      // first compare their quality
      if(this.quality < that.quality) return -1;
      if(this.quality > that.quality) return +1;
      // if same quality, give precedence to the one appearing first on the album 
      if(this.index > that.index) return -1;
      if(this.index < that.index) return +1;
      return 0;
    }
  }
}
