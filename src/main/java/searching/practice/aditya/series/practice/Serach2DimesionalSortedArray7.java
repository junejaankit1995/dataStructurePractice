package searching.practice.aditya.series.practice;

public class Serach2DimesionalSortedArray7 {

    static boolean search(int arr[][], int n, int m, int x) {
        boolean result = false;
        int row = 0, col = m - 1;
        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (arr[row][col] == x) {
                result = true;
                break;
            } else if (x < arr[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return result;
    }

    static boolean searchInNlogM(int matrix[][], int n, int m, int x) {
        int result = -1;
        for (int i = 0; i < n; i++) {
            result = binarySearch(matrix[i], 0, m - 1, x);
            if (result != -1) {
                break;
            }
        }
        return result != -1;
    }

    static int binarySearch(int[] arr, int lb, int up, int x) {
        int mid, result = -1;
        while (lb <= up) {
            mid = lb + (up - lb) / 2;
            if (arr[mid] == x) {
                result = mid;
                break;
            } else if (x < arr[mid]) {
                up = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return result;
    }
}
