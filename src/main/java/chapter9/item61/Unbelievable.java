package chapter9.item61;

public class Unbelievable {

  static Integer i;

  public static void main(String[] args) {
    /*if (i == 42) {
      System.out.println("믿을 수 없군!");
    }*/

    Long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }
    System.out.println(sum);
  }

}
