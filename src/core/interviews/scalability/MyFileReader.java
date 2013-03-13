package interviews.scalability;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find out the missing number in an unsorted list.
 * The list is supposed to be too big in practice so you can only iterate over it.
 * 
 * For example, given an input file with 2 billion non-negative integers, find out the integer
 * missing in that list (stored on file). You have up to 10MB of memory available.
 * @author Francois Rousseau
 */
public class MyFileReader {

  /**
   * Find the missing number inside a file containing an unsorted set of integers (once per line).
   * 
   * Since we only have 10MB, we can only use an array of ~2^21 integers (not enough for the 2^31).
   * The idea is to do a first pass and find out a range around the missing number.
   * We can store at most ~2^21 ranges, hence ranges of size at least ~2^10.
   * With this first pass, we reduce the problem to finding a missing number among ~2^10 integers.
   * 
   * The second pass depends on how much memory we have.
   * With 10MB, we can just have a boolean array of size ~2^10.
   * With less, we can use a bitvector for each cell and reduce the size again by a factor 8.
   * With even less, we can re-do the first pass as many times as needed.
   */
  public static int findMissingNumber(
      String filename, final int rangeSize, final int arraySize, final boolean enoughMemory)
      throws FileNotFoundException, NoMissingNumberFoundException {
    List<Integer> list = new ArrayList<Integer>(rangeSize*arraySize);
    Scanner in = new Scanner(new FileReader(filename));
    while(in.hasNextInt()) {
      list.add(in.nextInt());
    }
    in.close();
    return findMissingNumber(list, rangeSize, arraySize, enoughMemory);
  }

  /**
   * Uses a list but only iterates over it. That mocks perfectly the streaming of a big file.
   * It is easier to test in practice.
   */
  public static int findMissingNumber(
    List<Integer> list, final int rangeSize, final int arraySize, final boolean enoughMemory)
    throws NoMissingNumberFoundException {
    // let list.size() == arraySize*rangeSize
    // there are arraySize blocks, each of size rangeSize
    int[] blocks = new int[arraySize];
    for (int i:list) {
      blocks[i/rangeSize]++;  // i is counted in the block of index i/rangeSize
    }

    int lower = -1;  // will hold the lower bound for the element we seek
    for(int i = 0; i < arraySize; i++) {  // index of the current scanned block
      if(blocks[i] < rangeSize) {  // the block is not full
        lower = i*rangeSize;
        break;
      }
    }
    if(lower == -1) {  // should not happen since there is at least one integer missing
      throw new NoMissingNumberFoundException();
    }
    final int higher = lower + rangeSize;  // the element we seek is in [lower, higher[

    // for now on, we only consider the elements between lower and higher
    // we reduced the problem to rangeSize elements

    // if we have enough memory, we could just store all these elements and return the missing one
    if(enoughMemory) {
      byte[] arr = new byte[rangeSize];  // takes rangeSize bytes in memory
      for (int i:list) {
        if(i >= lower && i < higher) {
          arr[i - lower] = 1;
        }
      }    
      for(int i = 0; i < rangeSize; i++) {
        if(arr[i] == 0) {
          return i + lower;
        }
      }
    } else {  // otherwise we refine again storing 8 values per cell
      byte[] bitvector = new byte[rangeSize/8];  // takes rangeSize/8 bytes in memory
      for (int i:list) {
        if(i >= lower && i < higher) {
          bitvector[(i - lower)/8] |= 1 << (i - lower)%8;
        }
      }

      // we reduced the problem to rangeSize/8 elements
      for(int i = 0; i < rangeSize/8; i++) {
        if(bitvector[i] < 255) {  // bitvector with at least one zero
          for(int j = 0; j < 8; j++) {
            if((bitvector[i] & (1 << j)) == 0) {  // check if the jth element of bitvector[i] is 0
              return lower + i * 8 + j;
            }
          }
        }
      }      
    }
    // should not happen since there is at least one integer missing
    throw new NoMissingNumberFoundException();
  }
}

class NoMissingNumberFoundException extends Exception{
  private static final long serialVersionUID = 1L;
}