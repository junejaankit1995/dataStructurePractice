package sort;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr, int n) {
        boolean swapDone = false;
        for (int pass = 0; pass < n; pass++) {
            for (int i = 0; i < n - 1 - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapDone = true;
                    swap(arr, i, i + 1);
                }
            }
            if (swapDone == false) {
                break;
            }
        }
    }
}
