package chapter2.item2;

public class NutritionFacts {

  private final int servingsSize; //(ml, 1회 제공량) 필수
  private final int servings;     //(회, 총 n회 제공량) 필수
  private final int calories;     //(1회 제공량당) 선택
  private final int fat;          //(g/1회 제공량) 선택
  private final int sodium;       //(mg/1회 제공량) 선택
  private final int carbohydrate; //(g/1회 제공량) 선택

  public static class Builder {

    private final int servingsSize; //(ml, 1회 제공량) 필수
    private final int servings;     //(회, 총 n회 제공량) 필수
    private int calories = 0;     //(1회 제공량당) 선택
    private int fat = 0;          //(g/1회 제공량) 선택
    private int sodium = 0;       //(mg/1회 제공량) 선택
    private int carbohydrate = 0; //(g/1회 제공량) 선택

    public Builder(int servingsSize, int servings) {
      this.servingsSize = servingsSize;
      this.servings = servings;
    }

    public Builder calories(int val) {
      calories = val;
      return this;
    }

    public Builder fat(int val) {
      fat = val;
      return this;
    }

    public Builder sodium(int val) {
      sodium = val;
      return this;
    }

    public Builder carbohydrate(int val) {
      carbohydrate = val;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }

  }

  public NutritionFacts(Builder builder) {
    servingsSize = builder.servingsSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }
}
