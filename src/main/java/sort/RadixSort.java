package sort;

public class RadixSort implements Sort {
    @Override
    public void sort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
    }

    private void radixSort(int[] arr, int n, int max) {
        for (int pos = 1; max / pos > 0; pos *= 10) {
            countSort(arr, n, pos);

        }
    }

    private void countSort(int[] arr, int n, int pos) {
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            ++count[(arr[i] / pos) % 10];
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        int[] sortedArray = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sortedArray[--count[(arr[i] / pos) % 10]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sortedArray[i];
        }
    }
}
