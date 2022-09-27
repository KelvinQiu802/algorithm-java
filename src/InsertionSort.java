public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = { 5, 4, 3, 2, 1, 0 };
    insertionSort(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int value = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > value) {
        // Move elements that are greater than current value, to one position ahead of
        // their current position
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = value;
    }
  }
}
