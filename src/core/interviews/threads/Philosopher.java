package interviews.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Five silent philosophers sit at a table around a bowl of spaghetti. A fork is placed between
 * each pair of adjacent philosophers.
 * Each philosopher must alternately think and eat. However, a philosopher can only eat spaghetti
 * when he has both left and right forks. Each fork can be held by only one philosopher and so a
 * philosopher can use the fork only if it's not being used by another philosopher. After he
 * finishes eating, he needs to put down both the forks so they become available to others.
 * A philosopher can grab the fork on his right or the one on his left as they become available,
 * but can't start eating before getting both of them.
 * @author Francois Rousseau
 */
public class Philosopher extends Thread {

  public static void main(String[] argvs) {
    final int n = 1000;
    boolean[] chopsticks = new boolean[n];
    Philosopher[] philosophers = new Philosopher[n];
    List<Philosopher> list = new ArrayList<Philosopher>(n);
    for(int i=0;i<n;i++) {
      chopsticks[i] = true;
      philosophers[i] = new Philosopher(i, chopsticks);
      list.add(philosophers[i]);
    }
    // we shuffle it so the threads don't start in the same order.
    Collections.shuffle(list);
    for(int i=0;i<n;i++) {
      list.get(i).start();
    }
  }

  private static int count = 0;
  private final int id;
  private boolean hasEaten;
  private boolean[] chopsticks;

  public Philosopher(int id, boolean[] chopsticks) {
    this.id = id;
    this.chopsticks = chopsticks;
  }

  @Override
  public void run() {
    if(id == chopsticks.length-1) {
      while(!hasEaten) {
        eat(id, 0);
      }
    } else {
      while(!hasEaten) {
        eat(id, id+1);
      }
    }
    System.out.println(id+" has eaten like "+(count++)+" others before him!");
  }
  
  private void eat(int i, int j) {
    synchronized (this) {
      if(chopsticks[i] && chopsticks[j]) {
        chopsticks[i] = chopsticks[j] = false;
        hasEaten = true;
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        chopsticks[i] = chopsticks[j] = true;
      }
    }    
  }
}
