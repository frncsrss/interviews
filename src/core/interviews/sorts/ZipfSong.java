package interviews.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

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
 *
 * @author Francois Rousseau
 */
public class ZipfSong {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    final int n = stdin.nextInt();  // up to 50,000
    int m = stdin.nextInt();  // up to n
    // we will maintain a priority queue of the m highest quality songs
    PriorityQueue<Song> pq = new PriorityQueue<Song>();
    for(int i = 0; i < n; i++) {  // O(nlogm)
      Song song = new Song(i + 1, stdin.nextLong(), stdin.nextLine().trim());
      if(pq.size() < m) {  // add at least the first m songs
        pq.add(song);  // O(logm)
      } else {  // add a new song if its quality is higher than the lowest in the priority queue
        Song head = pq.peek();
        if(song.compareTo(head) > 0) {
          pq.poll();  // O(logm)
          pq.add(song);  // O(logm)
        }
      }
    }
    // list holding in ascending order of quality the m best songs
    List<Song> bestSongs = new ArrayList<Song>(m);
    while(!pq.isEmpty()) {  // O(mlogm)
      bestSongs.add(pq.poll());
    }
    for(int i = m - 1; i >= 0; i--) {  // O(m)
      System.out.println(bestSongs.get(i).name);
    }
    stdin.close();
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
