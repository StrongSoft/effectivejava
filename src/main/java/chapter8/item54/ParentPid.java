package chapter8.item54;

import java.util.Optional;

public class ParentPid {

  public static void main(String[] args) {
    ProcessHandle ph = ProcessHandle.current();
    Optional<ProcessHandle> parentProcess = ph.parent();
    System.out.println(
        "부모 PID : " + (parentProcess.isPresent() ? String.valueOf(parentProcess.get().pid())
            : "N/A"));

    System.out.println("부모 PID : " + ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));
  }
}
