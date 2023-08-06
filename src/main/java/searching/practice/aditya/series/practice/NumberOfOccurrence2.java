package searching.practice.aditya.series.practice;

public class NumberOfOccurrence2 {
    int count(int[] arr, int n, int x) {
        int count = 0;
        int firstOcu = binarySearchOcc(arr, 0, n - 1, x, true);
        if (firstOcu == -1) {
            return count;
        }
        int lastOcu = binarySearchOcc(arr, 0, n - 1, x, false);
        return (lastOcu - firstOcu) + 1;
    }

    private int binarySearchOcc(int[] arr, int lb, int up, int k, boolean firsOcc) {
        int result = -1;
        int mid;
        while (lb <= up) {
            mid = lb + (up - lb) / 2;
            if (arr[mid] == k) {
                result = mid;
                if (firsOcc) {
                    up = mid - 1;
                } else {
                    lb = mid + 1;
                }
            } else if (k < arr[mid]) {
                up = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return result;
    }
}
