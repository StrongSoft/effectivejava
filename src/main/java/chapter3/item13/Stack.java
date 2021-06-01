package chapter3.item13;

import java.util.Arrays;

public class Stack {

  private Object[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  private Stack() {
    elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  private void push(Object e) {
    ensureCapacity();
    elements[size++] = e;
  }

  //코드 7-2 제대로 구현한 pop 메서드 (37쪽)
  private Object pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Object result = elements[--size];
    elements[size] = null;
    return result;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  /**
   * 원소를 위한 공간을 적어도 하나 이상 확보한다. 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
   */
  private void ensureCapacity() {
    if (elements.length == size) {
      elements = Arrays.copyOf(elements, 2 * size + 1);
    }
  }

  @Override
  public Stack clone() {
    try {
      Stack result = (Stack) super.clone();
      result.elements = elements.clone();
      return result;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    for (String arg : args) {
      stack.push(arg);
    }

    Stack copy = stack.clone();
    while (!stack.isEmpty()) {
      System.out.println(stack.pop() + " ");
    }
    System.out.println();

    while (!copy.isEmpty()) {
      System.err.println(stack.pop() + " ");
    }
  }
}