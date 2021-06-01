package chapter9.item61;

import java.util.Comparator;

public class BrokenComparator {

  public static void main(String[] args) {
    Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

    int result = naturalOrder.compare(new Integer(42), new Integer(42));
    System.out.println(result);

    Comparator<Integer> naturalOrder1 = (iBoxed, jBoxed) -> {
      int i = iBoxed, j = jBoxed; // 오토박싱
      return i < j ? -1 : (i == j ? 0 : 1);
    };
    int result1 = naturalOrder1.compare(new Integer(42), new Integer(42));
    System.out.println(result1);


  }

}
