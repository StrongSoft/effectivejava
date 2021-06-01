package chapter3.item14;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;

// 코드 10-6 전형적인 equals 메서드의 예 (64쪽)
public final class PhoneNumber implements Comparable<PhoneNumber> {

  private final short areaCode, prefix, lineNum;

  public PhoneNumber(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "지역코드");
    this.prefix = rangeCheck(prefix, 999, "프리픽스");
    this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
  }

  private static short rangeCheck(int val, int max, String arg) {
    if (val < 0 || val > max) {
      throw new IllegalArgumentException(arg + ": " + val);
    }
    return (short) val;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof PhoneNumber)) {
      return false;
    }
    PhoneNumber pn = (PhoneNumber) o;
    return pn.lineNum == lineNum && pn.prefix == prefix
        && pn.areaCode == areaCode;
  }


/*  @Override
  public int compareTo(PhoneNumber pn) {
    int result = Short.compare(areaCode, pn.areaCode); //가장 중요한 필드
    if (result == 0) {
      result = Short.compare(prefix, pn.prefix); //두번째로 중요한 필드
      if (result == 0) {
        result = Short.compare(lineNum, pn.lineNum); //세번째로 중요한 필드
      }
    }
    return result;
  }*/

  private static final Comparator<PhoneNumber> COMPARATOR = comparingInt(
      (PhoneNumber pn) -> pn.areaCode)
      .thenComparingInt(pn -> pn.prefix)
      .thenComparingInt(pn -> pn.lineNum);

  @Override
  public int compareTo(PhoneNumber pn) {
    return COMPARATOR.compare(this, pn);
  }

  //정적 compare 메서드를 활용한 비교
  static Comparator<Object> hashCodeOrder = new Comparator<>() {
    @Override
    public int compare(Object o1, Object o2) {
      return Integer.compare(o1.hashCode(), o2.hashCode());
    }
  };

}
