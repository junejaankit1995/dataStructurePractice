package sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr, int n) {
        mergeSort(arr, 0, n - 1);

    }

    private void mergeSort(int[] arr, int lb, int up) {
        //Terminal Condition
        if (lb >= up) {
            return;
        }
        //Hypothesis
        int mid = (lb + up) / 2;
        mergeSort(arr, lb, mid);
        mergeSort(arr, mid + 1, up);

        //Induction
        merge(arr, lb, mid, up);
    }

    private void merge(int[] arr, int lb, int mid, int up) {
        int[] sArr = new int[up - lb + 1];
        int idx1 = lb, idx2 = mid + 1, k = 0;
        while (idx1 <= mid && idx2 <= up) {
            if (arr[idx1] <= arr[idx2]) {
                sArr[k++] = arr[idx1++];
            } else {
                sArr[k++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            sArr[k++] = arr[idx1++];
        }
        while (idx2 <= up) {
            sArr[k++] = arr[idx2++];
        }

        k = 0;
        for (int i = lb; i <= up; i++) {
            arr[i] = sArr[k];
            k++;
        }
    }


}
