package chapter6.item39;

import java.util.ArrayList;
import java.util.List;

public class Simple2 {

  @ExceptionTest(ArithmeticException.class)
  public static void m1() { // 성공해야 한다.
    int i = 0;
    i = i / i;
  }

  @ExceptionTest(ArithmeticException.class)
  public static void m2() { // 실패해야 한다. ( 다른 예외가 발생)
    int[] a = new int[0];
    int i = a[1];
  }

  @ExceptionTest(ArithmeticException.class)
  public static void m3() {
  } // 실패해야 한다. (예외가 발생하지 않음)

  @ExceptionTest(IndexOutOfBoundsException.class)
  @ExceptionTest(NullPointerException.class)
  public static void doublyBad() { // 성공해야 한다.
    List<String> list = new ArrayList<>();
    list.addAll(5, null);
  }
}
