package interviews.scalability;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Find out the missing number in an unsorted list.
 * The list is supposed to be too big in practice so you can only iterate over
 * it.
 * @author Francois Rousseau
 */
public class MyFileReader {

  public static int findMissingNumber(
      String filename, final int rangeSize, final int arraySize)
      throws FileNotFoundException, NoMissingNumberFoundException {
    return findMissingNumber(new FileReader(filename), rangeSize, arraySize);
  }

  private static int findMissingNumber(
      FileReader fileReader, final int rangeSize, final int arraySize)
      throws FileNotFoundException, NoMissingNumberFoundException {
    List<Integer> list = new ArrayList<Integer>(rangeSize*arraySize);
    Scanner in = new Scanner(fileReader);
    while(in.hasNextInt()) {
      list.add(in.nextInt());
    }
    in.close();
    return findMissingNumber(list, rangeSize, arraySize);
  }

  public static int findMissingNumber(
    List<Integer> list, final int rangeSize, final int arraySize)
    throws NoMissingNumberFoundException {
    final int[] blocks = new int[arraySize];
    for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
      blocks[iterator.next()/rangeSize]++;
    }

    int lower = -1;
    for(int i=0;i<arraySize;i++) {
      if(blocks[i] < rangeSize) {
        lower = i*rangeSize;
        break;
      }
    }
    if(lower == -1) {
      throw new NoMissingNumberFoundException();
    }
    final int higher = lower + rangeSize;

    final byte[] bitvector = new byte[rangeSize/8];
    for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
      final int n = iterator.next();
      if(n >= lower && n < higher) {
        bitvector[(n - lower)/8] |= 1 << (n - lower)%8;
      }
    }

    for(int i=0; i<rangeSize/8; i++) {
      for(int j=0; j<8; j++) {
        if((bitvector[i] & (1 << j)) == 0) {
          return lower + i*8 + j;
        }
      }
    }

    throw new NoMissingNumberFoundException();
  }
}

class NoMissingNumberFoundException extends Exception{
  private static final long serialVersionUID = 1L;
}