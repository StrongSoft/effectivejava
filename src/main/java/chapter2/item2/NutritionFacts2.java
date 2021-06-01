package chapter2.item2;

//점측적 생성자 페턴
public class NutritionFacts2 {

  private final int servingsSize; //(ml, 1회 제공량) 필수
  private final int servings;     //(회, 총 n회 제공량) 필수
  private final int calories;     //(1회 제공량당) 선택
  private final int fat;          //(g/1회 제공량) 선택
  private final int sodium;       //(mg/1회 제공량) 선택
  private final int carbohydrate; //(g/1회 제공량) 선택

  public NutritionFacts2(int servingsSize, int servings) {
    this(servingsSize, servings, 0);
  }

  public NutritionFacts2(int servingsSize, int servings, int calories) {
    this(servingsSize, servings, calories, 0);
  }

  public NutritionFacts2(int servingsSize, int servings, int calories, int fat) {
    this(servingsSize, servings, calories, fat, 0);
  }

  public NutritionFacts2(int servingsSize, int servings, int calories, int fat, int sodium) {
    this(servingsSize, servings, calories, fat, sodium, 0);
  }

  public NutritionFacts2(int servingsSize, int servings, int calories, int fat, int sodium,
      int carbohydrate) {
    this.servingsSize = servingsSize;
    this.servings = servings;
    this.calories = calories;
    this.fat = fat;
    this.sodium = sodium;
    this.carbohydrate = carbohydrate;
  }
}
