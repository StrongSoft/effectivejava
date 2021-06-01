package chapter8.item50;

import java.util.Date;

public class Period {

  private final Date start;
  private final Date end;


  /**
   * @param start
   * @param end
   * @throws IllegalArgumentException 시작 시작이 종료 시각보다 늦을때 발생하다.
   * @throws NullPointerException     start나  end가 null이면 발생한다.
   */
  public Period(Date start, Date end) {
    this.start = new Date(start.getTime());
    this.end = new Date(end.getTime());

    if (this.start.compareTo(this.end) > 0) {
      throw new IllegalArgumentException(this.start + "가 " + this.end + "보다 늦다.");
    }
  }
  /*public Period(Date start, Date end) {
    if (start.compareTo(end) > 0) {
      throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
    }
    this.start = start;
    this.end = end;
  }*/


  public Date start() {
    return new Date(start.getTime());
  }

  public Date end() {
    return new Date(end.getTime());
  }

  public static void main(String[] args) {
    Date start = new Date();
    Date end = new Date();
    Period p = new Period(start, end);
    p.end().setYear(78);
  }
}
