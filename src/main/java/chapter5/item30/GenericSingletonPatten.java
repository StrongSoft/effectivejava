package chapter5.item30;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.function.UnaryOperator;

public class GenericSingletonPatten {

  private static final UnaryOperator<Object> IDENTITY_FN = (t) -> t;

  @SuppressWarnings("unchecked")
  public static <T> UnaryOperator<T> identityFunction() {
    return (UnaryOperator<T>) IDENTITY_FN;
  }

  public static <E extends Comparable<? super E>> E max(List<? extends E> c) {
    if (c.isEmpty()) {
      throw new IllegalArgumentException("컬랙션이 비어 있습니다.");
    }
    E result = null;
    for (E e : c) {
      if (result == null || e.compareTo(result) > 0) {
        result = Objects.requireNonNull(e);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    /*String[] strings = {"삼베", "대마", "나일론"};
    UnaryOperator<String> someThing = identityFunction();
    for (String s : strings) {
      System.out.println(someThing.apply(s));
    }

    Number[] numbers = {1, 2.0, 3L};
    UnaryOperator<Number> sameNumber = identityFunction();
    for (Number n : numbers) {
      System.out.println(sameNumber.apply(n));
    }*/

    List<ScheduledFuture<?>> scheduledFutures = new ArrayList<>();
    max(scheduledFutures);
  }
}
