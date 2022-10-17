public class LinkQueue {
  private Node front;
  private Node rear;
  private int size;

  public LinkQueue() {
    size = 0;
  }

  public void enqueue(int i) {
    Node N = new Node(i);
    if (size == 0) {
      front = N;
    } else {
      rear.next = N;
    }
    rear = N;
    size++;
  }

  public int dequeue() {
    int result = front.data;
    front = front.next;
    size--;
    return result;
  }

  public int front() {
    return front.data;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {
    LinkQueue queue = new LinkQueue();
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