package interviews.trees;

/**
 * Stream of integers. Get the rank of a given number. BST-based.
 * @author Francois Rousseau
 */
public class Ranker {
  
  private static MyBST root;

  public static void track(int[] xs) {
    for(int x:xs) {
      track(x);
    }
  }
  
  public static void track(int x) {
    if(root == null) {
      root = new MyBST(x);
    } else {
      root.insert(x);
    }
  }
  
  public static int getRankOfNumber(int x) {
    if(root == null) {
      return -1;
    } else {
      return root.lefts(x);
    }
  }
}

class MyBST {
  private final int value;
  private MyBST left;
  private MyBST right;
  private int lefts;
  
  public MyBST(int value) {
    this.value = value;
    lefts = 0;
    left = right = null;
  }
  
  public void insert(int n) {
    if(n == value) {
      lefts++;
    } else if(n > value){
      if(right == null) {
        right = new MyBST(n);
      } else {
        right.insert(n);
      }
    } else {
      lefts++;
      if(left == null) {
        left = new MyBST(n);
      } else {
        left.insert(n);
      }
    }
  }

  public int lefts(int n) {
    if(n == value) {
      return lefts;
    } else if(n < value) {
      if(left == null) {
        return -1;
      } else {
        return left.lefts(n);
      }
    } else {
      if(right == null) {
        return -1;
      } else {
        return lefts + 1 + right.lefts(n);
      }
    }
  }
}