package chapter3.item13;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber implements Cloneable {

  private final short areaCode, prefix, lineNum;

  public PhoneNumber(short areaCode, short prefix, short lineNum) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNum = lineNum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PhoneNumber)) {
      return false;
    }
    PhoneNumber that = (PhoneNumber) o;
    return areaCode == that.areaCode &&
        prefix == that.prefix &&
        lineNum == that.lineNum;
  }

  @Override
  public int hashCode() {
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);
    return result;
  }

  /**
   * 이 전화번호의 문자열 표현을 반환한다. 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다. XXX는 지역 코드, YYY는 프리픽스, ZZZZ는 가입자
   * 번호다. 각각의 대문자는 10진수 숫자 하나를 나타낸다.
   * <p>
   * 전화번호의 각 부분의 값이 너무 작아서 채울 수 없다며, 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면 전화번호의 마지막 네 문자는 "0123"이
   * 된다.
   */
  @Override
  public String toString() {
    return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
  }

  @Override
  public PhoneNumber clone() {
    try {
      return (PhoneNumber) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  public static void main(String[] args) {
    PhoneNumber pn = new PhoneNumber((short) 707, (short) 867, (short) 5309);
    Map<PhoneNumber, String> m = new HashMap<>();
    m.put(pn, "제니");
    System.out.println(m.get(pn.clone()));
  }
}
