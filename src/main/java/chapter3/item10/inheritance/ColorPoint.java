package chapter3.item10.inheritance;

import chapter3.item10.Color;
import chapter3.item10.Point;
import java.util.Objects;

public class ColorPoint {

  private final Point point;
  private final Color color;

  public ColorPoint(Point point, Color color) {
    this.point = point;
    this.color = Objects.requireNonNull(color);
  }

  public Point asPoint() {
    return point;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ColorPoint)) {
      return false;
    }
    ColorPoint cp = (ColorPoint) o;
    return cp.point.equals(point) && cp.color.equals(color);
  }
}
