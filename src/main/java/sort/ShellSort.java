package sort;

public class ShellSort implements Sort {
    @Override
    public void sort(int[] arr, int n) {
        shellSort(arr, 0, n - 1);
    }

    private void shellSort(int[] arr, int lb, int up) {
        if (lb >= up) {
            return;
        }
        int gap = (lb + (up - lb)) / 2;
        for (; gap >= 1; gap /= 2) {
            for (int j = gap; j <= up; j++) {
                if (arr[j - gap] > arr[j]) {
                    swap(arr, j - gap, j);
                    for (int i = j - gap; i - gap >= 0 && arr[i - gap] > arr[i]; i -= gap) {
                        swap(arr, i - gap, i);
                    }
                }
            }
        }

    }
}
