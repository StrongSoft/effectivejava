package chapter2.item2;

//자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다.
public class NutritionFacts1 {

  private int servingsSize = -1; //(ml, 1회 제공량) 필수
  private int servings = -1;     //(회, 총 n회 제공량) 필수
  private int calories = 0;     //(1회 제공량당) 선택
  private int fat = 0;          //(g/1회 제공량) 선택
  private int sodium = 0;       //(mg/1회 제공량) 선택
  private int carbohydrate = 0; //(g/1회 제공량) 선택

  public NutritionFacts1() {
  }

  public void setServingsSize(int servingsSize) {
    this.servingsSize = servingsSize;
  }

  public void setServings(int servings) {
    this.servings = servings;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }

  public void setFat(int fat) {
    this.fat = fat;
  }

  public void setSodium(int sodium) {
    this.sodium = sodium;
  }

  public void setCarbohydrate(int carbohydrate) {
    this.carbohydrate = carbohydrate;
  }
}
