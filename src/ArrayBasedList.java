public class ArrayBasedList {
  private ArrPos[] items;
  private int size;
  private int maxSize;

  public static void main(String[] args) {
    ArrayBasedList arr = new ArrayBasedList();
    arr.insertFirst(200);
    arr.insertBefore(0, 1);
    arr.insertBefore(0, 1);
    arr.printArr();
  }

  public ArrayBasedList() {
    this.maxSize = 10;
    this.size = 0;
    this.items = new ArrPos[maxSize];
  }

  public void grow() {
    ArrPos[] newArr = new ArrPos[maxSize * 2];
    maxSize *= 2;
    for (int i = 0; i < size; i++) {
      newArr[i] = items[i];
    }
    items = newArr;
  }

  public void shrink() {
    ArrPos[] newArr = new ArrPos[maxSize / 2];
    maxSize /= 2;
    for (int i = 0; i < size; i++) {
      newArr[i] = items[i];
    }
    items = newArr;
  }

  public void changeSize() {
    if (size >= maxSize) {
      grow();
      return;
    }
    if (size / maxSize <= 0.25) {
      shrink();
      return;
    }
  }

  public ArrPos first() {
    return items[0];
  }

  public ArrPos last() {
    return items[size];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public ArrPos after(int p) {
    return items[p + 1];
  }

  public ArrPos before(int p) {
    return items[p - 1];
  }

  public void insertFirst(int d) {
    ArrPos pos = new ArrPos(d, 0);
    for (int i = 0; i < size; i++) {
      items[i].increment();
      items[i + 1] = items[i];
    }
    items[0] = pos;
    size++;
  }

  public void insertLast(int d) {
    ArrPos pos = new ArrPos(d, size);
    items[size] = pos;
    size++;
  }

  public void insertAfter(int p, int d) {
    // TODO FIX
    ArrPos pos = new ArrPos(d, p + 1);
    for (int i = p + 1; i < size; i++) {
      items[i].increment();
      items[i + 1] = items[i];
    }
    items[p + 1] = pos;
    size++;
  }

  public void insertBefore(int p, int d) {
    // TODO FIX
    ArrPos pos = new ArrPos(d, p);
    for (int i = p; i < size; i++) {
      items[i].increment();
      items[i + 1] = items[i];
    }
    items[p] = pos;
    size++;
  }

  public ArrPos remove(int p) {
    ArrPos pos = items[p];
    for (int i = p + 1; i < size; i++) {
      items[i].decrement();
      items[i] = items[i + 1];
    }
    size--;
    return pos;
  }

  public void printArr() {
    for (int i = 0; i < size; i++) {
      System.out.println(items[i].element());
    }
  }
}
