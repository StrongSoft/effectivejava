package chapter2.item3;

public class Elvis {

  private static final Elvis INSTANCE = new Elvis();

  private Elvis() {

  }

  public static Elvis getInstance() {
    return INSTANCE;
  }

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }

  private Object readResolve() {
    return INSTANCE;
  }

  public static void main(String[] args) {
    Elvis elvis = Elvis.getInstance();
    elvis.leaveTheBuilding();
  }
}
