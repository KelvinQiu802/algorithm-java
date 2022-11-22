public class ArrPos {
  private int data;
  private int index;

  public ArrPos(int data, int index) {
    this.data = data;
    this.index = index;
  }

  public int element() {
    return this.data;
  }

  public int getIndex() {
    return this.index;
  }

  public void increment() {
    this.index++;
  }

  public void decrement() {
    this.index--;
  }
}
