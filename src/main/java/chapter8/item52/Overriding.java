package chapter8.item52;

import java.util.List;

public class Overriding {

  public static void main(String[] args) {
    List<Wine> wineList = List.of(new Wine(), new SparkingWine(), new Champagne());

    for (Wine wine : wineList) {
      System.out.println(wine.name());
    }
  }
}
