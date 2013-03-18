package interviews.numbers;

import java.util.Scanner;

/**
 * Reversing numbers in binary.
 * 
 * For instance, the binary representation of 13 is 1101,
 * and reversing it gives 1011,which corresponds to number 11.
 * 
 * @author Francois Rousseau
 */
public class ReversedBinary {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    while(stdin.hasNextInt()) {
      System.out.println(reverse(stdin.nextInt()));
    }
    stdin.close();
  }

  public static int reverse(int n) {
    final int numberOfDigits = 32 - Integer.numberOfLeadingZeros(n);
    int reverse = 0;
    for(int i = 0; i < numberOfDigits; i++) {
      if(((n >> i) & 1) == 1) {  // if the ith bit of n is 1
        // set the (n - 1 - i)th bit of reverse to 1
        reverse |= 1 << (numberOfDigits - 1 - i);
      }
      // else, the (n - 1 - i)th bit is already set to 0
    }
    return reverse;
  }
}
