package sort;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr, int n) {
        int minIndex;
        for (int pass = 0; pass < n - 1; pass++) {
            minIndex = pass;
            for (int i = pass; i < n; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            if (pass != minIndex) {
                swap(arr, pass, minIndex);
            }
        }
    }
}
