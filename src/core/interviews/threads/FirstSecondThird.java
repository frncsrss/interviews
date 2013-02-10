package interviews.threads;

import java.util.concurrent.Semaphore;

/**
 * 3 threads. Design a mechanism to ensure that the first thread is called before the second one
 * and that the second one is called before the third one.
 * @author Francois Rousseau
 */
public class FirstSecondThird {
  public static void main(String[] args) throws InterruptedException {
    FirstSecondThird firstSecondThird = new FirstSecondThird();
    (new ThreadFirstSecondThird(firstSecondThird, "third")).start();
    (new ThreadFirstSecondThird(firstSecondThird, "second")).start();
    (new ThreadFirstSecondThird(firstSecondThird, "first")).start();
  }

  private Semaphore sem1;
  private Semaphore sem2;

  public FirstSecondThird() throws InterruptedException {
    sem1 = new Semaphore(1);
    sem2 = new Semaphore(1);
    sem1.acquire();
    sem2.acquire();
  }

  public void first() {
    sem1.release();
  }
  public void second() throws InterruptedException {
    sem1.acquire();
    sem2.release();
  }
  public void third() throws InterruptedException {
    sem2.acquire();
    sem2.release();
  }
}

class ThreadFirstSecondThird extends Thread {
  private FirstSecondThird firstSecondThird;
  private final String name;

  public ThreadFirstSecondThird(FirstSecondThird firstSecondThird, String name) {
    this.firstSecondThird = firstSecondThird;
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println("Starting "+name);
    if(name.equals("first")) {
      firstSecondThird.first();
    } else if(name.equals("second")) {
      try {
        firstSecondThird.second();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else if(name.equals("third")){
      try {
        firstSecondThird.third();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }      
    }
    System.out.println("Finishing "+name);
  }
}