public class ArrayStack {
  private int[] values;
  private int top;
  private int maxSize;

  public ArrayStack(int maxSize) {
    this.maxSize = maxSize;
    values = new int[maxSize];
    top = 0;
  }

  public void push(int i) {
    if (top < maxSize) {
      values[top++] = i;
    }
  }

  public int pop() {
    return values[--top];
  }

  public int size() {
    return top;
  }

  public boolean isEmpty() {
    return top == 0;
  }

  public static void main(String[] args) {
    ArrayStack arr = new ArrayStack(5);
    arr.push(1);
    arr.push(2);
    arr.push(3);
    arr.push(4);
    arr.push(5);
    System.out.println(arr.pop());
    System.out.println(arr.pop());
    System.out.println(arr.pop());
    System.out.println(arr.pop());
    System.out.println(arr.pop());
  }
}
