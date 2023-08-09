package searching.practice.aditya.series.practice;

public class FindElementInRotatedArray4 {

    int search(int arr[], int lb, int up, int key) {
        int temp;
        int krotation = findKRotation(arr, up + 1);
        if (krotation <= 0) {
            return binarySearch(arr, lb, up, key);
        } else {
            temp = binarySearch(arr, lb, krotation - 1, key);
            return temp == -1 ? binarySearch(arr, krotation, up, key) : temp;
        }
    }

    int binarySearch(int[] arr, int lb, int up, int key) {
        int mid, result = -1;
        while (lb <= up) {
            mid = lb + ((up - lb) / 2);
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                up = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return -1;
    }

    int findKRotation(int arr[], int n) {
        int lb = 0, up = n - 1;
        if (arr[lb] <= arr[up]) {
            return lb;
        }
        int mid = -1, prev, next, result = -1;
        while (lb <= up) {
            if (arr[lb] < arr[up]) {
                return lb;
            }
            mid = lb + ((up - lb) / 2);
            prev = (mid + n - 1) % n;
            next = (mid + 1) % n;
            if (arr[mid] < arr[prev] && arr[mid] < arr[next]) {
                return mid;
            }
            if (arr[mid] <= arr[up]) {
                up = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return -1;
    }
}
