package chapter3.item10;

public class ColorPoint extends Point {

  private final Color color;

  public ColorPoint(int x, int y, Color color) {
    super(x, y);
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Point)) {
      return false;
    }
    if (!(o instanceof ColorPoint)) {
      return o.equals(this);
    }
    return super.equals(o) && ((ColorPoint) o).color == color;
  }

  public static void main(String[] args) {
    Point p = new Point(1, 2);
    ColorPoint cp = new ColorPoint(1, 2, Color.RED);

    System.out.println(p.equals(cp));
    System.out.println(cp.equals(p));
  }
}
