package chapter3.item11;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {

  private int hashCode;

  private final short areaCode, prefix, lineNum;

  public PhoneNumber(short areaCode, short prefix, short lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "지역코드");
    this.prefix = prefix;
    this.lineNum = lineNum;
  }

  private short rangeCheck(int val, int max, String arg) {
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
    return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
  }

/*  @Override
  public int hashCode() {
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);
    return result;
  }*/
/*  @Override
  public int hashCode(){
    return Objects.hash(lineNum, prefix, areaCode);
  }*/

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = Short.hashCode(areaCode);
      result = 31 * result + Short.hashCode(prefix);
      result = 31 * result + Short.hashCode(lineNum);
      hashCode = result;
    }
    return hashCode;
  }

  public static void main(String[] args) {
    Map<PhoneNumber, String> m = new HashMap<>();
    m.put(new PhoneNumber((short) 707, (short) 867, (short) 5309), "제니");
    System.out.println(m.get(new PhoneNumber((short) 707, (short) 867, (short) 5309)));
  }
}
