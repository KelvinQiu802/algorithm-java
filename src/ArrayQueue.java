public class ArrayQueue {
  private int[] values;
  private int maxSize;
  private int rear;

  public ArrayQueue(int maxSize) {
    this.maxSize = maxSize;
    rear = 0;
    values = new int[maxSize];
  }

  public void enqueue(int i) {
    if (rear < maxSize) {
      values[rear++] = i;
    }
  }

  public int dequeue() {
    int result = values[0];
    // O(N)
    for (int i = 1; i < rear; i++) {
      values[i - 1] = values[i];
    }
    rear--;
    return result;
  }

  public int front() {
    return values[0];
  }

  public int size() {
    return rear;
  }

  public boolean isEmpty() {
    return rear == 0;
  }

  public static void main(String[] args) {
    ArrayQueue queue = new ArrayQueue(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }
}
