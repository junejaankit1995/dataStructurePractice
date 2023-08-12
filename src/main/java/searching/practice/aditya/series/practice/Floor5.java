package searching.practice.aditya.series.practice;

public class Floor5 {

    static int findFloor(long arr[], int n, long x) {
        return binarySearch(arr, 0, n - 1, x);
    }

    static int binarySearch(long[] arr, int lb, int up, long x) {
        int mid, res = -1;
        while (lb <= up) {
            mid = lb + (up - lb) / 2;
            if (arr[mid] == x) {
                res = mid;
                break;
            } else if (x < arr[mid]) {
                up = mid - 1;
            } else {
                res = mid;
                lb = mid + 1;
            }
        }
        return res;
    }
 }
