package chapter7.item45;

import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Anagrams {

  /*public static void main(String[] args) throws IOException {
    File dictionary = new File(args[0]);
    int minGroupSize = Integer.parseInt(args[1]);

    Map<String, Set<String>> groups = new HashMap<>();
    try (Scanner s = new Scanner(dictionary)) {
      while (s.hasNext()) {
        String word = s.next();
        groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
      }
    }

    for (Set<String> group : groups.values()) {
      if (group.size() >= minGroupSize) {
        System.out.println(group.size() + ": " + group);
      }
    }
  }*/
  public static void main(String[] args) throws IOException {
    Path path = Paths.get(args[0]);
    int minGroupSize = Integer.parseInt(args[1]);

    try (Stream<String> words = Files.lines(path)) {
      words.collect(groupingBy(Anagrams::alphabetize))
          .values().stream()
          .filter(group -> group.size() >= minGroupSize)
          .forEach(group -> System.out.println(group.size() + ": " + group));
    }

  }

  private static String alphabetize(String s) {
    char[] a = s.toCharArray();
    Arrays.sort(a);
    return new String(a);
  }
}
