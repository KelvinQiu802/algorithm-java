public class QuickUnionUF {
  private int[] id;
  private int count;

  public QuickUnionUF(int N) {
    // O(N)
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int root(int i) {
    // Search up
    // O(N) -> trees can get to tall
    while (i != id[i]) {
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    // O(1)
    return root(p) == root(q);
  }

  public int count() {
    return count;
  }

  public int find(int p) {
    return root(p);
  }

  public void union(int p, int q) {
    // O(N)
    int pRoot = root(p);
    int qRoot = root(q);
    if (pRoot == qRoot)
      return;

    id[pRoot] = qRoot;
    count--;
  }

  public static void main(String[] args) {
    QuickUnionUF quickunion = new QuickUnionUF(10);
    quickunion.union(1, 2);
    quickunion.union(3, 5);
    quickunion.union(4, 5);
    quickunion.union(2, 8);

    System.out.println(quickunion.count());
    System.out.println(quickunion.find(1));
    System.out.println(quickunion.find(8));
    System.out.println(quickunion.connected(2, 8));
  }
}
