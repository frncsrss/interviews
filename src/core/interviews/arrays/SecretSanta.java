package interviews.arrays;

import java.util.Random;

/**
 * Secret Santa is a Western Christmas tradition in which members of a group are randomly assigned
 * a person to whom they anonymously give a gift. Everyone gives to another person than himself and
 * receives from another person than himself.
 *
 * In combinatorial mathematics, this corresponds to "derangement", i.e. a permutation of the
 * elements of a sequence such that none of the elements appear in their original position.
 *
 * @author Francois Rousseau
 */
public class SecretSanta {
  private final Random rnd;

  public SecretSanta() {
    rnd = new Random();
  }

  public SecretSanta(long seed) {
    rnd = new Random(seed);
  }

  public String[][] assign(String[] people) {
    if(people == null || people.length < 2) {
      throw new IllegalArgumentException();
    }

    Shuffle.f(people);

    final int n = people.length;  // number of people
    boolean[] picked = new boolean[n];
    String[][] pairs = new String[n][2];
    for(int i = 0; i < n; i++) {
      int j;
      do {
        j = rnd.nextInt(n);  // [0, n[, exclusive
        if(i == n - 1 && j == i) {  // the last element is a fixed point for the permutation
          return assign(people);
        }
      } while(j == i || picked[j]);  // rejection
      pairs[i][0] = people[i];
      pairs[i][1] = people[j];
      picked[j] = true;
    }
    return pairs;
  }
}
