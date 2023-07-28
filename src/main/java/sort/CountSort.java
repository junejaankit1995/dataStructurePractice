package sort;

public class CountSort implements Sort {

    /**
     * Linear Sorting Algorithm with O(n + k) complexity with constraint that array value
     * can't be negative.
     *
     * @param arr input arr to be sorted
     * @param n   number of elements in array
     */
    @Override
    public void sort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        countSort(arr, n, max);

    }

    private void countSort(int[] arr, int n, int k) {
        int[] count = new int[k + 1];
        //Counting occurence of value in array
        for (int i = 0; i < n; i++) {
            ++count[arr[i]];
        }
        //Saving index of value to be store in sorted arry
        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }

        int[] sortedArray = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sortedArray[--count[arr[i]]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sortedArray[i];
        }
    }
}
