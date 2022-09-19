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
}
