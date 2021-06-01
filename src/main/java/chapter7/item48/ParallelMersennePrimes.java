package chapter7.item48;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import java.math.BigInteger;
import java.util.stream.Stream;

public class ParallelMersennePrimes {

  public static void main(String[] args) {
    pries().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        .parallel()
        .filter(mersinne -> mersinne.isProbablePrime(50))
        .limit(20)
        .forEach(System.out::println);
  }

  static Stream<BigInteger> pries() {
    return Stream.iterate(TWO, BigInteger::nextProbablePrime);
  }
}
