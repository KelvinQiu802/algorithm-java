public class ArrayBasedList {
  private ArrPos[] items;
  private int size;
  private int maxSize;

  public ArrayBasedList() {
    this.size = 0;
    this.maxSize = 2;
    this.items = new ArrPos[maxSize];
  }

  public ArrPos insertFirst(int d) {
    ArrPos n = new ArrPos(d, 0);
    for (int i = size - 1; i >= 0; i--) {
      items[i].increment();
      items[i + 1] = items[i];
    }
    items[0] = n;
    size++;
    changeSize();
    return n;
  }

  public ArrPos insertLast(int d) {
    ArrPos n = new ArrPos(d, size);
    items[size] = n;
    size++;
    changeSize();
    return n;
  }

  public ArrPos insertAfter(ArrPos p, int d) {
    ArrPos n = new ArrPos(d, p.getIndex() + 1);
    for (int i = size - 1; i > p.getIndex(); i--) {
      items[i].increment();
      items[i + 1] = items[i];
    }
    items[n.getIndex()] = n;
    size++;
    changeSize();
    return n;
  }

  public ArrPos insertBefore(ArrPos p, int d) {
    ArrPos n = new ArrPos(d, p.getIndex());
    for (int i = size - 1; i >= p.getIndex(); i--) {
      items[i].increment();
      items[i + 1] = items[i];
    }
    items[n.getIndex()] = n;
    size++;
    changeSize();
    return n;
  }

  public void remove(ArrPos p) {
    for (int i = p.getIndex() + 1; i < size; i++) {
      items[i].decrement();
      items[i - 1] = items[i];
    }
    size--;
    changeSize();
  }

  public void grow() {
    maxSize *= 2;
    ArrPos[] arr = new ArrPos[maxSize];
    for (int i = 0; i < size; i++) {
      arr[i] = items[i];
    }
    items = arr;
  }

  public void shrink() {
    maxSize /= 2;
    ArrPos[] arr = new ArrPos[maxSize];
    for (int i = 0; i < size; i++) {
      arr[i] = items[i];
    }
    items = arr;
  }

  public void changeSize() {
    if (size + 1 >= maxSize) {
      grow();
    } else if ((float) size / maxSize < 0.25) {
      shrink();
    }
  }

  public int first() {
    return items[0].element();
  }

  public int last() {
    return items[size - 1].element();
  }

  public int size() {
    return size;
  }

  public Boolean isEmpty() {
    return size == 0;
  }

  public ArrPos after(ArrPos p) {
    return items[p.getIndex() + 1];
  }

  public ArrPos before(ArrPos p) {
    return items[p.getIndex() - 1];
  }

  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.println(items[i].element());
    }
  }

  public static void main(String[] args) {
    ArrayBasedList list = new ArrayBasedList();
    list.insertFirst(1);
    list.insertFirst(0);
    list.insertLast(3);
    ArrPos a = list.insertLast(4);
    ArrPos b = list.insertAfter(a, 10);
    ArrPos c = list.insertBefore(b, 11);
    list.remove(c);
    // 0, 1, 3, 4, 10
    list.print();
  }
}
