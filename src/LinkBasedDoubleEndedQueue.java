public class LinkBasedDoubleEndedQueue extends RuntimeException {
  private Node first;
  private Node last;
  private int size;

  public LinkBasedDoubleEndedQueue() {
    this.size = 0;
  }

  public Boolean isEmpyt() {
    return size == 0;
  }

  public void addFirst(int o) {
    Node n = new Node(o);
    if (isEmpyt()) {
      first = n;
      last = n;
    } else {
      first.prev = n;
      n.next = first;
      first = n;
    }
    size++;
  }

  public void addLast(int o) {
    Node n = new Node(o);
    if (isEmpyt()) {
      last = n;
      first = n;
    } else {
      last.next = n;
      n.prev = last;
      last = n;
    }
    size++;
  }

  public int removeFirst() {
    if (isEmpyt()) {
      throw new Error("Is Empty");
    }
    int o = first.data;
    first = first.next;
    if (size == 1) {
      first = null;
      last = null;
    } else {
      first.prev = null;
    }
    size--;
    return o;
  }

  public int removeLast() {
    if (isEmpyt()) {
      throw new Error("Is Empty");
    }
    int o = last.data;
    last = last.prev;
    if (size == 1) {
      first = null;
      last = null;
    } else {
      last.next = null;
    }
    size--;
    return o;
  }

  public void print() {
    Node N = first;
    while (N.next != null) {
      System.out.println(N.data);
      N = N.next;
    }
    System.out.println(N.data);
  }

  public static void main(String[] args) {
    LinkBasedDoubleEndedQueue queue = new LinkBasedDoubleEndedQueue();
    queue.addFirst(0);
    queue.addFirst(1);
    queue.addLast(2);
    queue.addLast(3);
    queue.removeFirst();
    queue.removeLast();
    // [0, 2]
    queue.print();
  }
}
