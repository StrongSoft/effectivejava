package chapter9.item59;

import java.util.Random;

public class RandomBug {

  static Random rnd = new Random();

  /*
  1. n이 그리 크지 않은 2의 제곱수라면 얼마 지나지 않아 같은 수열이 반복된다.
  2. n이 2의 제솝수가 아니라면 몇몇 숫자가 평균적으로 더 자주 반환된다.
   */
  static int random(int n) {
    return Math.abs(rnd.nextInt()) % n;
  }

  public static void main(String[] args) {
    int n = 2 * (Integer.MAX_VALUE / 3);
    int low = 0;
    for (int i = 0; i < 1000000; i++) {
      if (random(n) < n / 2) {
        low++;
      }
    }
    System.out.println(low);
  }
}
