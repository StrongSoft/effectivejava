package chapter5.item30;

import java.util.HashSet;
import java.util.Set;

public class SetMain {


  public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet(s1);
    result.addAll(s2);
    return result;
  }

  public static void main(String[] args) {
    Set<Integer> integers = Set.of(1, 2, 3);
    Set<Double> doubles = Set.of(1.0, 2.0, 3.0);
    Set<Number> numbers = union(integers, doubles);
    System.out.println(numbers);
  }
}
