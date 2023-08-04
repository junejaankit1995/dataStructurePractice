package searching;

public class BinarySearch implements Searching {


    @Override
    public int search(int[] arr, int n, int data) {
        int lb = 0, up = n - 1, mid;
        if (lb > up) {
            return -1;
        }
        while (lb <= up) {
            mid = (lb + up) / 2;
            if (data == arr[mid]) {
                return mid;
            } else if (data < arr[mid]) {
                up = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return -1;
    }

    public int recursiveBinarySearch(int[] arr, int lb, int up, int data) {
        //Terminal Condition
        if (lb > up) {
            return -1;
        }
        int mid = (lb + up) / 2;
        if (arr[mid] == data) {
            return mid;
        } else if (data < arr[mid]) {
            return recursiveBinarySearch(arr, lb, mid - 1, data);
        } else {
            return recursiveBinarySearch(arr,mid + 1, up, data);
        }
    }
}
