package interviews.numbers;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given an integer N, return the number of prime numbers less than N.
 */
public class NumberOfPrimeNumbersBelow {
  /**
   * Time complexity:  O(NlogN)
   * Space complexity: O(N)
   */
  public static int f(int N) {
    if(N < 2) return 0;
    if(N == 2) return 1;
    if(N == 3) return 2;
    Set<Integer> primes = new TreeSet<Integer>();
    primes.add(2);
    primes.add(3);
    for(int i = 5; i <= N; i += 2) {  // no need to check for even numbers above 2
      boolean isPrime = false;
      for(int j : primes) {
        if(j > Math.sqrt(i)) {  // early stop
          isPrime = true;
          break;
        }
        if(i % j == 0) {
          break;
        }
      }
      if(isPrime) {
        primes.add(i);
      }
    }
    return primes.size();
  }
}
