public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = { 5, 4, 3, 2, 1, 0 };
    selectionSort(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      swap(arr, i, minIndex);
    }
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
