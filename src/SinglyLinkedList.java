public class SinglyLinkedList {
  private Node first;
  private int size;

  public SinglyLinkedList() {
    this.first = null;
    this.size = 0;
  }

  public Node first() {
    return first;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Node after(Node p) {
    if (p == last() || isEmpty()) {
      return null;
    }

    Node N = first;
    while (N.next != p && N.next != null) {
      N = N.next;
    }
    return N.next.next;
  }

  public Node before(Node p) {
    if (isEmpty() || p == first) {
      return null;
    }

    Node N = first;
    while (N.next != p && N.next != null) {
      N = N.next;
    }
    return N;
  }

  public Node last() {
    Node N = first;
    while (N.next != null) {
      N = N.next;
    }
    return N;
  }

  public Node insertFirst(int d) {
    Node N = new Node(d);
    N.next = first;
    first = N;
    size++;
    return N;
  }

  public Node insertLast(int d) {
    if (isEmpty()) {
      return insertFirst(d);
    }

    Node N = new Node(d);
    Node last = last();
    last.next = N;
    size++;
    return N;
  }

  public Node insertAfter(Node p, int d) {
    Node N = new Node(d);
    N.next = p.next;
    p.next = N;
    size++;
    return N;
  }

  public Node insertBefore(Node p, int d) {
    Node N = new Node(d);
    if (p == first) {
      return insertFirst(d);
    }

    Node beforeP = before(p);
    beforeP.next = N;
    N.next = p;
    size++;
    return N;
  }

  public int remove(Node p) {
    int d = p.data;
    if (p == first) {
      first = p.next;
    } else {
      Node beforeP = before(p);
      beforeP.next = p.next;
    }
    p.next = null;
    size--;
    return d;
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
    SinglyLinkedList list = new SinglyLinkedList();
    Node first = list.insertFirst(0);
    Node second = list.insertAfter(first, 1);
    list.insertBefore(second, -1);
    list.insertLast(9);
    list.remove(second);
    // [0, -1, 9]
    list.print();
  }
}
