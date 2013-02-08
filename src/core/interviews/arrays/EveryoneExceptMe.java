package interviews.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * New array where A[i] = product (j­i) A[j]
 * @author Francois Rousseau
 */
public class EveryoneExceptMe {

  public static List<Integer> f1(List<Integer> list) {
    List<Integer> new_list = new ArrayList<Integer>(list.size());
    int product = 1;
    new_list.add(1);
    for(int i=0;i<list.size()-1;i++) {
      product *= list.get(i);
      new_list.add(product);
    }
    product = 1;
    for(int i=list.size()-1;i>0;i--) {
      product *= list.get(i);
      new_list.set(i-1, new_list.get(i-1)*product);
    }
    return new_list;
  }

  public static int[] f2(int[] arr) {
    int[] products = new int[arr.length];
    products[0] = 1;
    int product = 1;
    for(int i=1;i<=arr.length-1;i++) {
      product *= arr[i-1];
      products[i] = product;
    }
    product = arr[arr.length-1];
    for(int i=arr.length-2;i>=0;i--) {
      product *= arr[i+1];
      products[i] *= product;
    }
    return products;
  }

  public static void f3(int[] arr) {
    int product = 1;
    for(int i=0;i<arr.length;i++) {
      product *= arr[i];
    }
    for(int i=0;i<arr.length;i++) {
      arr[i] = product/arr[i];
    }
  }
}
