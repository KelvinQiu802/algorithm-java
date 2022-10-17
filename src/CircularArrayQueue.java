public class CircularArrayQueue {
  private int[] values;
  private int front;
  private int rear;
  private int maxSize;
  private int size;

  public CircularArrayQueue(int maxSize) {
    this.maxSize = maxSize;
    front = 0;
    rear = 0;
    size = 0;
    values = new int[maxSize];
  }

  public void enqueue(int i) {
    if (size < maxSize) {
      values[rear] = i;
      rear = (rear + 1) % maxSize;
      size++;
    }
  }

  public int dequeue() {
    int result = values[front];
    front = (front + 1) % maxSize;
    size--;
    return result;
  }

  public int front() {
    return values[front];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {
    CircularArrayQueue queue = new CircularArrayQueue(5);
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
