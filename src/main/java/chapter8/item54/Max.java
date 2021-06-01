package chapter8.item54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Max {
  // 컬렉션에서 최대값을 구한다(컬랙션이 비어있으면 예외를 던진다.)
  /*public static <E extends Comparable<E>> E max(Collection<E> c) {
    if (c.isEmpty()) {
      throw new IllegalArgumentException("빈 컬렉션");
    }

    E result = null;
    for (E e : c) {
      if (result == null || e.compareTo(result) > 0) {
        result = Objects.requireNonNull(e);
      }
    }
    return result;
  }*/

  //컬렉션에서 최대값을 구해 Optional<E> 로 반환한다.
  /*public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
    if (c.isEmpty()) {
      return Optional.empty();
    }

    E result = null;
    for (E e : c) {
      if (result == null | e.compareTo(result) > 0) {
        result = Objects.requireNonNull(e);
      }
    }
    return Optional.of(result);
  }*/
  public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
    return c.stream().max(Comparator.naturalOrder());
  }

  public static void main(String[] args) {
    List<String> words = Arrays.asList("apple", "orange", "banana");

    System.out.println(max(words));
    System.out.println(max(new ArrayList<String>()));

    String lastWordInLexicon = max(words).orElse("단어 없음");
    System.out.println("lastWordInLexicon : " + lastWordInLexicon);

  }

}
