public class DoublyLinkedList {
  private Node first;
  private Node last;
  private int size;

  public DoublyLinkedList() {
    size = 0;
  }

  public Node first() {
    return first;
  }

  public Node last() {
    return last;
  }

  public int size() {
    return size;
  }

  public Boolean isEmpty() {
    return size == 0;
  }

  public Node after(Node p) {
    return p.next;
  }

  public Node before(Node p) {
    return p.prev;
  }

  public Node insertFirst(int d) {
    Node n = new Node(d);
    n.next = first;
    if (first != null) {
      first.prev = n;
    }
    first = n;
    if (size == 0) {
      last = n;
    }
    size++;
    return n;
  }

  public Node insertLast(int d) {
    Node n = new Node(d);
    last.next = n;
    n.prev = last;
    last = n;
    size++;
    return n;
  }

  public Node insertAfter(Node p, int d) {
    if (p.next == null) {
      return insertLast(d);
    }
    Node n = new Node(d);
    n.next = p.next;
    n.prev = p;
    p.next = n;
    n.next.prev = n;
    size++;
    return n;
  }

  public Node insertBefore(Node p, int d) {
    if (p.prev == null) {
      return insertFirst(d);
    }
    Node n = new Node(d);
    n.prev = p.prev;
    n.next = p;
    p.prev = n;
    n.prev.next = n;
    size++;
    return n;
  }

  public void remove(Node p) {
    // last one
    if (p.next == null) {
      p.prev.next = null;
      p.prev = null;
    } else if (p.prev == null) {
      // first one
      p.next.prev = null;
      p.next = null;
    } else {
      p.prev.next = p.next;
      p.next.prev = p.prev;
    }
    size--;
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
    DoublyLinkedList list = new DoublyLinkedList();
    Node first = list.insertFirst(0);
    Node second = list.insertAfter(first, 1);
    list.insertBefore(second, -1);
    list.insertLast(9);
    list.remove(second);
    // [0, -1, 9]
    list.print();
  }
}
