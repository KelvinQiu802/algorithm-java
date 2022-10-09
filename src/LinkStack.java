public class LinkStack {
  private Node top;
  private int size;

  public LinkStack() {
    size = 0;
  }

  public void push(int i) {
    Node N = new Node(i);
    N.next = top;
    top = N;
    size++;
  }

  public int pop() {
    int result = top.data;
    top = top.next;
    size--;
    return result;
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    LinkStack arr = new LinkStack();
    arr.push(1);
    arr.push(2);
    arr.push(3);
    arr.push(4);
    System.out.println(arr.pop());
    System.out.println(arr.pop());
    System.out.println(arr.pop());
    System.out.println(arr.pop());
  }
}
