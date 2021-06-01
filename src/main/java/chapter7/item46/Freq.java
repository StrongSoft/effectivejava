package chapter7.item46;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Freq {

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File(args[0]);

    /*// 코드 46-1 스트림 패러다임을 이해하지 못한 채 API만 사용했다 - 따라 하지 말 것! (277쪽)
    Map<String, Long> freq = new HashMap<>();
    try (Stream<String> words = new Scanner(file).tokens()) {
      words.forEach(word -> {
        freq.merge(word.toLowerCase(), 1L, Long::sum);
      });
    }*/

    Map<String, Long> freq;
    try (Stream<String> words = new Scanner(file).tokens()) {
      freq = words.collect(groupingBy(String::toLowerCase, counting()));
    }
    System.out.println(freq);

    List<String> topTen = freq.keySet().stream()
        .sorted(comparing(freq::get).reversed())
        .limit(10)
        .collect(toList());

    System.out.println("topTen : " + topTen);

  }


}
