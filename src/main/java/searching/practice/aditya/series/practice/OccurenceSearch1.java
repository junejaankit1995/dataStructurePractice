package searching.practice.aditya.series.practice;

import java.util.ArrayList;

public class OccurenceSearch1 {

    public ArrayList<Integer> firstAndLast(int arr[], int n, int x) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        int tempResult;
        tempResult = binarySearchFirstOcc(arr, 0, n - 1, x, true);
        result.add(tempResult);
        if (tempResult != -1) {
            result.add(binarySearchFirstOcc(arr, 0, n - 1, x, false));
        }
        return result;
    }

    private int binarySearchFirstOcc(int[] arr, int lb, int up, int k, boolean firsOcc) {
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
