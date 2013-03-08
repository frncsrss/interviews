package interviews.numbers;

/**
 * Enum type for operators.
 * Inspired by Effective Java, 2nd Edition. Joshua Bloch.
 * @author Francois Rousseau
 */
public enum Operators { 
  PLUS("+") {
    double apply(double x, double y) {
      return x + y;
    }
  },
  MINUS("-") {
    double apply(double x, double y) {
      return x - y;
    }
  },
  TIMES("*") {
    double apply(double x, double y) {
      return x * y;
    }
  },
  DIVIDE("/") {
    double apply(double x, double y) {
      return x / y;
    }
  };

  private final String symbol;

  private Operators(String symbol) { 
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }

  abstract double apply(double x, double y);
}