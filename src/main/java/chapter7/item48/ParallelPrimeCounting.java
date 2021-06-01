package chapter7.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelPrimeCounting {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    pi(10_000_000);
    long end = System.currentTimeMillis();
    System.out.println(">>>>> time : " + (end - start) / 1000);
  }

  static long pi(long n) {
    return LongStream.rangeClosed(2, n)
        .parallel()
        .mapToObj(BigInteger::valueOf)
        .filter(i -> i.isProbablePrime(50))
        .count();
  }

}
