public class QuickFindUF {
  private int[] id;
  private int count;

  public QuickFindUF(int N) {
    // Create the ID arrya
    // O(N)
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    // O(1)
    return id[p] == id[q];
  }

  public int find(int p) {
    return id[p];
  }

  public int count() {
    return count;
  }

  public void union(int p, int q) {
    // set the ID to the second argument
    // O(N) -> too expensive
    int pId = id[p];
    int qId = id[q];
    // Already connected
    if (pId == qId)
      return;
    // Connect
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pId) {
        id[i] = qId;
      }
    }
    count--;
  }

  public static void main(String[] args) {
    QuickFindUF quickfind = new QuickFindUF(10);
    quickfind.union(1, 2);
    quickfind.union(3, 5);
    quickfind.union(4, 5);
    quickfind.union(2, 8);

    System.out.println(quickfind.count());
    System.out.println(quickfind.find(1));
    System.out.println(quickfind.find(8));
    System.out.println(quickfind.connected(2, 8));
  }
}
