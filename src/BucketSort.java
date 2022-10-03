import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
  public static void main(String[] args) {
    double[] arr = { 0.13, 0.24, 0.16, 0.53, 0.22, 0.78 };
    bucketSort(arr, 10);
    for (double d : arr) {
      System.out.println(d);
    }
  }

  public static void bucketSort(double[] arr, int n) {
    // Create empty buckets
    @SuppressWarnings("unchecked")
    ArrayList<Double>[] bucket = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      bucket[i] = new ArrayList<Double>();
    }

    // Add element into the bucket
    for (int i = 0; i < arr.length; i++) {
      int index = (int) Math.floor(arr[i] * n);
      bucket[index].add(arr[i]);
    }

    // Sort each bucket
    for (int i = 0; i < n; i++) {
      Collections.sort(bucket[i]);
    }

    // Concatenate buckets into arr
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < bucket[i].size(); j++) {
        arr[index] = bucket[i].get(j);
        index++;
      }
    }
  }
}
