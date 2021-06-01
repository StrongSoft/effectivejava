package chapter6.item37;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Plant {

  enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

  final String name;
  final LifeCycle lifeCycle;

  public Plant(String name, LifeCycle lifeCycle) {
    this.name = name;
    this.lifeCycle = lifeCycle;
  }

  @Override
  public String toString() {
    return name;
  }

  public static void main(String[] args) {

    Plant[] garden = {
        new Plant("바질", LifeCycle.ANNUAL),
        new Plant("캐러웨이", LifeCycle.BIENNIAL),
        new Plant("딜", LifeCycle.ANNUAL),
        new Plant("라벤더", LifeCycle.PERENNIAL),
        new Plant("파슬리", LifeCycle.BIENNIAL),
        new Plant("로즈마리", LifeCycle.PERENNIAL)
    };

    Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(
        Plant.LifeCycle.class);
    for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
      plantsByLifeCycle.put(lc, new HashSet<>());
    }

    for (Plant p : garden) {
      plantsByLifeCycle.get(p.lifeCycle).add(p);
    }
    System.out.println(plantsByLifeCycle);
    System.out.println(Arrays.stream(garden)
        .collect(groupingBy(p -> p.lifeCycle,
            () -> new EnumMap<>(LifeCycle.class), toSet())));
  }
}
