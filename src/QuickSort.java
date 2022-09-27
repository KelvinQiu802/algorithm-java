public class QuickSort {
  public static void main(String[] args) {
    int[] arr = { 5, 3, 2, 1, 5, 7, 19, 10 };
    quickSort(arr, 0, arr.length - 1);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  public static void quickSort(int[] arr, int begin, int end) {
    if (begin >= end) {
      return;
    }
    int p = partition(arr, begin, end);
    quickSort(arr, begin, p - 1);
    quickSort(arr, p + 1, end);
  }

  public static int partition(int[] arr, int begin, int end) {
    int pivot = arr[end]; // choose last value as the pivot
    int i = begin - 1;
    for (int j = begin; j < end; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, end);
    return i + 1;
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
