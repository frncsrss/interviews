package interviews.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Verbalize numbers.
 * @author Francois Rousseau
 */
public class Verbalizer {
  public static String toString(int n) {
    if(n == 0) {
      return "Zero";
    }
    if(n < 0) {
      return "Minus " + toString(-n);
    }
    return toString(String.valueOf(n));
  }
  
  public static String toString(String s) {
    List<String> list = new ArrayList<String>();
    char[] arr = s.toCharArray();
    final int length = arr.length;
    for(int i = length-1; i>=0; i--) {
      if(arr[i] == '0') {
        continue;
      }
      int j = length-1-i;
      switch(j%3) {
        case 0:
          switch(j) {
            case 0:
              break;
            case 3:
              list.add("Thousand,");
              break;
            case 6:
              list.add("Million,");
              break;
            case 7:
              list.add("Billion,");
              break;
          }
          list.add(digit(arr[i]));
          break;
        case 1:
          switch(arr[i]) {
            case '1':
              if(arr[i+1] != '0') {
                list.remove(list.size()-1);
                list.add(teen(arr[i+1]));                
                break;
              }
            default:
              list.add(ten(arr[i]));
              break;
          }
          break;
        case 2:
          list.add("Hundred");
          list.add(digit(arr[i]));
          break;
      }
    }
    StringBuffer buffer = new StringBuffer(2*list.size());
    for (int i = list.size()-1;i>=0;i--) {
      buffer.append(list.get(i));
      buffer.append(" ");
    }
    buffer.deleteCharAt(buffer.length()-1);  // remove last whitespace
    return buffer.toString();
  }

  private static String digit(char c) {
    switch(c) {
      case '0': return null;
      case '1': return "One";
      case '2': return "Two";
      case '3': return "Three";
      case '4': return "Four";
      case '5': return "Five";
      case '6': return "Six";
      case '7': return "Seven";
      case '8': return "Eight";
      case '9': return "Nine";
      default: return null;
    }
  }

  private static String teen(char c) {
    switch(c) {
      case '1': return "Eleven";
      case '2': return "Twelve";
      case '3': return "Thirteen";
      case '4': return "Fourteen";
      case '5': return "Fifteen";
      case '6': return "Sixteen";
      case '7': return "Seventeen";
      case '8': return "Eighteen";
      case '9': return "Nineteen";
      default: return null;
    }
  }

  private static String ten(char c) {
    switch(c) {
      case '0': return null;
      case '1': return "Ten";
      case '2': return "Twenty";
      case '3': return "Thirty";
      case '4': return "Fourty";
      case '5': return "Fifty";
      case '6': return "Sixty";
      case '7': return "Seventy";
      case '8': return "Eighty";
      case '9': return "Ninety";
      default: return null;
    }
  }
}

