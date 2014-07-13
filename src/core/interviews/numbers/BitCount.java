package interviews.numbers;

/**
 * Number of bits set to 1 in an integer.
 *
 * @author Francois Rousseau
 */
public class BitCount {
  /**
   * Simplest method. Go bit by bit and check if it is set to 1.
   */
  public static int f1(int i) {
    int count = 0;
    while(i > 0) {
      count += i & 1;
      i >>= 1;
    }
    return count;
  }

  public static int f2(int i) {
    i = i - (i >> 1 & 0x55555555);
    i = (i & 0x33333333) + (i >> 2 & 0x33333333);
    return (i + (i >> 4) & 0x0F0F0F0F) * 0x01010101 >> 24;
  }

  public static int f3(int i) {
    int count; // c accumulates the total bits set in v
    for (count = 0; i > 0; count++) {
      i &= i - 1; // clear the least significant bit set
    }
    return count;
  }
}