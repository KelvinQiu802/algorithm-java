public class ShellSort {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 4, 3, 6, 7, 3, 12, 23, 0, -1, 12, 43 };
    shellSort(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  public static void shellSort(int[] arr) {
    // Determin the gap
    int gap = 1;
    while (gap < arr.length / 3) {
      gap = 3 * gap + 1;
    }

    while (gap > 0) {
      // For each gap, do the insersion sort
      for (int i = gap; i < arr.length; i++) {
        int value = arr[i];
        int j = i - gap;
        while (j >= 0 && arr[j] > value) {
          arr[j + gap] = arr[j];
          j -= gap;
        }
        arr[j + gap] = value;
      }
      gap /= 3;
    }
  }
}
