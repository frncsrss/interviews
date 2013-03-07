package interviews.numbers;

/**
 * A non-negative integer is called heavy if the average value of its digits in
 * decimal representation exceeds 7.
 * For example the number 8698 is heavy, because the average value of its digits
 * equal to (8+6+9+8)/4 = 7.75
 * 
 * Given two non-negative integers A and B find the number of heavy integers in
 * the interval [A..B] (A and B included)
 * A and B are integers within the range [0..200,000,000].
 * @author Francois Rousseau
 */
public class Heavy {
  public static int f(int A, int B) {
    int count=0;
    // this solution costs O((B-A)log(B)) in time.
    for(int i = A;i <= B; i++) {
      if(is_heavy(i)) {
        count++;
      }
    }
    return count;
  }

  public static int f2(int a, int b) {
    int offset=0, count=0, num;
    while(a<=b) {
      num=a;
      offset=0;
      while(num > 0) {
        offset += (num % 10) - 7;
        num /= 10;
      }
      if(offset > 0) {
        count++;
        a++;
      }
      else if (offset == 0) {
        a++;
      }
      else {
        a -= offset;
      }
    }
    return count;
  }

  public static int heavy_decimal_count3(int A, int B) {
    return -1;
  }

  protected static int count_heavy(int nb_digits, int min_sum) {
    // the number to reach is too high. no need to go further.
    if (nb_digits * 9 < min_sum) {
      return 0;
    }

    // any number will do.
    if (min_sum <= 0) {
      return (int) Math.pow(10, nb_digits);
    }

    // we take the highest numbers.
    if (nb_digits == 1) {
      return 10-min_sum;
    }

    int count = 0;
    for (int i = 0; i <= 9; i++) {
      // the sum to reach is decreasing as we increase the current digit.
      count += count_heavy(nb_digits-1, min_sum-i);
    }
    return count;
  }

  protected static boolean is_heavy(int A) {
    // this operation costs O(log(A)) in time.
    return (average_value_digits(A) > 7);
  }
  
  protected static double average_value_digits(int A) {
    // there is log(A) digits in A. this operation costs O(log(A)) in time.
    if(A == 0) {
      return 0;
    }
    int sum=0, count=0;
    while(A > 0) {
      sum += A%10;
      A /= 10;
      count++;
    }
    return (sum*1.0)/count;
  }
}
