package chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {

  private final List<T> choiceList;

  public Chooser(Collection<? extends T> choices) {
    choiceList = new ArrayList<>(choices);
  }

  public Object choose() {
    Random rnd = ThreadLocalRandom.current();
    return choiceList.get(rnd.nextInt(choiceList.size()));
  }

  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);

    Chooser<Number> chooser = new Chooser<>(integers);
    int number = (int) chooser.choose();
    System.out.println(number);
  }
}
