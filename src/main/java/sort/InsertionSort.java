package sort;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr, int n) {
        int temp;
        for (int pass = 0; pass < n - 1; pass++) {
            temp = arr[pass + 1];
            int i = pass;
            for (; i >= 0 && arr[i] > temp; i--) {
                arr[i + 1] = arr[i];
            }
            if (i != pass) {
                arr[i + 1] = temp;
            }
        }
    }
}
