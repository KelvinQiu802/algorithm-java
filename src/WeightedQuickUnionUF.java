public class WeightedQuickUnionUF {
  private int[] id;
  private int[] size;
  private int count;

  public WeightedQuickUnionUF(int N) {
    // O(N)
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
    size = new int[N];
    for (int i = 0; i < N; i++) {
      size[i] = 1;
    }
  }

  public int root(int i) {
    // Search up
    // O(lgN)
    while (i != id[i]) {
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    // O(lgN)
    return root(p) == root(q);
  }

  public int count() {
    return count;
  }

  public int find(int p) {
    // O(lgN)
    return root(p);
  }

  public void union(int p, int q) {
    // O(lgN)
    int pRoot = root(p);
    int qRoot = root(q);
    if (pRoot == qRoot)
      return;

    if (size[pRoot] < size[qRoot]) {
      id[pRoot] = qRoot;
      size[pRoot] += size[qRoot];
    } else {
      id[qRoot] = pRoot;
      size[qRoot] += size[pRoot];
    }
    count--;
  }

  public static void main(String[] args) {
    WeightedQuickUnionUF weightedQuickUnion = new WeightedQuickUnionUF(10);
    weightedQuickUnion.union(1, 2);
    weightedQuickUnion.union(3, 5);
    weightedQuickUnion.union(4, 5);
    weightedQuickUnion.union(2, 8);

    System.out.println(weightedQuickUnion.count());
    System.out.println(weightedQuickUnion.find(1));
    System.out.println(weightedQuickUnion.find(8));
    System.out.println(weightedQuickUnion.connected(2, 8));
  }
}
