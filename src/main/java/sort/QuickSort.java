package sort;


public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr, int n) {
        quickSort(arr, 0, n - 1);

    }

    private void quickSort(int[] arr, int lb, int up) {
        //Terminal Condition
        if (lb >= up) {
            return;
        }

        //Hypothesis
        int pivotIndex = partition(arr, lb, up);
        quickSort(arr, lb, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, up);
    }

    private int partition(int[] arr, int lb, int up) {
        int pivot = arr[lb];
        int start = lb, end = up;
        while (start < end) {
            while (start <= up && arr[start] <= pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }
        if (start != end) {
            swap(arr, lb, end);
        }
        return end;
    }

}
