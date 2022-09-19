public class WeightedQuickUnionPathCompressionUF {
  private int[] id;
  private int[] size;
  private int count;

  public WeightedQuickUnionPathCompressionUF(int N) {
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
    while (i != id[i]) {
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public int count() {
    return count;
  }

  public int find(int p) {
    return root(p);
  }

  public void union(int p, int q) {
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
    WeightedQuickUnionPathCompressionUF weightQuickUnionPathCompression = new WeightedQuickUnionPathCompressionUF(10);
    weightQuickUnionPathCompression.union(1, 2);
    weightQuickUnionPathCompression.union(3, 5);
    weightQuickUnionPathCompression.union(4, 5);
    weightQuickUnionPathCompression.union(2, 8);

    System.out.println(weightQuickUnionPathCompression.count());
    System.out.println(weightQuickUnionPathCompression.find(1));
    System.out.println(weightQuickUnionPathCompression.find(8));
    System.out.println(weightQuickUnionPathCompression.connected(2, 8));
  }
}
