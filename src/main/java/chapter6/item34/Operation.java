package chapter6.item34;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum Operation {
  PLUS("+") {
    @Override
    public double apply(double x, double y) {
      return x + y;
    }
  },
  MINUS("-") {
    @Override
    public double apply(double x, double y) {
      return x - y;
    }
  },
  TIMES("*") {
    @Override
    public double apply(double x, double y) {
      return x * y;
    }
  },
  DIVIDE("/") {
    @Override
    public double apply(double x, double y) {
      return x / y;
    }
  };

  private final String symbol;

  Operation(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }

  public abstract double apply(double x, double y);

  private static final Map<String, Operation> stringToEnum =
      Stream.of(values()).collect(
          toMap(Object::toString, e -> e));

  public static Optional<Operation> fromString(String symbol) {
    return Optional.ofNullable(stringToEnum.get(symbol));
  }

 /* //상수가 뜻하는 연산을 수행한다.
  public double apply(double x, double y) {
    switch (this) {
      case PLUS:
        return x + y;
      case MINUS:
        return x - y;
      case TIMES:
        return x * y;
      case DIVIDE:
        return x / y;
    }
    throw new AssertionError("알 수 없는 연산: " + this);
  }*/

  public static void main(String[] args) {
    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
    for (Operation op : Operation.values()) {
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
  }
}
