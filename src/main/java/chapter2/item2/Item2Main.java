package chapter2.item2;

public class Item2Main {

  public static void main(String[] args) {
    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
        .calories(100)
        .sodium(35)
        .carbohydrate(27)
        .build();
  }

}
