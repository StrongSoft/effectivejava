package chapter2.item6;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {

  private static final Cleaner cleaner = Cleaner.create();

  //청소가 필요한 자원, 절대 Room을 참조해서는 안 된다.!
  private static class State implements Runnable {

    int numJunPiles; //방 (Room) 안의 쓰레기 수

    State(int numJunPiles) {
      this.numJunPiles = numJunPiles;
    }

    @Override
    public void run() {
      System.out.println("방 청소");
      numJunPiles = 0;
    }
  }

  // 방의 상태. cleanable과 공유한다.
  private final State state;

  // cleanable 객체, 수거 대상이 되면 방을 한다.
  private final Cleaner.Cleanable cleanable;

  public Room(int numJunkPiles) {
    state = new State(numJunkPiles);
    cleanable = cleaner.register(this, state);
  }

  @Override
  public void close() throws Exception {
    cleanable.clean();
  }
}
