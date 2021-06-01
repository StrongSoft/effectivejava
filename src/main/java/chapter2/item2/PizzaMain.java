package chapter2.item2;

import chapter2.item2.NyPizza.Size;
import chapter2.item2.Pizza.Topping;

public class PizzaMain {

  public static void main(String[] args) {
    NyPizza pizza = new NyPizza.Builder(Size.SMALL)
        .addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
    Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();
  }

}
