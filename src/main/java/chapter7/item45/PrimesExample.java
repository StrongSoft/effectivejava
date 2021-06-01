package chapter7.item45;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import java.math.BigInteger;
import java.util.stream.Stream;

public class PrimesExample {

  static Stream<BigInteger> primes() {
    return Stream.iterate(TWO, BigInteger::nextProbablePrime);
  }

  public static void main(String[] args) {
    primes().map(prime -> TWO.pow(prime.intValueExact()).subtract(ONE))
        .filter(mersenne -> mersenne.isProbablePrime(50))
        .limit(20)
        .forEach(mp -> System.out.println(mp.bitLength() + " : " + mp));
  }
}
