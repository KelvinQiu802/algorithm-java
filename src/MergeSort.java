public class MergeSort {
  public static void main(String[] args) {
    int[] arr = { 1, 4, 3, 5, 6, 67, 3, 12 };
    mergeSortTopDown(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  public static void mergeSortTopDown(int[] arr) {
    int[] aux = new int[arr.length];
    mergeSortTopDown(arr, aux, 0, arr.length - 1);
  }

  public static void mergeSortTopDown(int[] arr, int[] aux, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    mergeSortTopDown(arr, aux, lo, mid); // First half
    mergeSortTopDown(arr, aux, mid + 1, hi); // Secon half
    merge(arr, aux, lo, mid, hi);
  }

  public static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
    // Tow half of the [arr] must be sorted.
    // Copy all the element in [arr] to [aux]
    for (int k = 0; k <= hi; k++) {
      aux[k] = arr[k];
    }

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        // First half is empty
        arr[k] = aux[j++]; // Add the second half arguments to the [arr]
      } else if (j > hi) {
        // Second half is empty
        arr[k] = aux[i++]; // Add the first half arguments to the [arr]
      } else if (aux[i] < aux[j]) {
        arr[k] = aux[i++];
      } else {
        arr[k] = aux[j++];
      }
    }
  }
}