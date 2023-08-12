package searching.practice.aditya.series.practice;

public class PeakElement6 {

    public int peakElement(int[] arr, int n) {
        if (n == 1) {
            return 0;
        }
        //Checking for first
        if (arr[0] >= arr[1]) {
            return 0;
        } else if (arr[n - 1] >= arr[n - 2]) { //Checking for last
            return n - 1;
        } else {
            int lb = 1, up = n - 2, mid, result = -1;
            //Check peak in non edge element
            while (lb <= up) {
                mid = lb + ((up - lb) / 2);
                if (arr[mid - 1] <= arr[mid] && arr[mid] >= arr[mid + 1]) {
                    result = mid;
                    break;
                } else if (arr[mid] > arr[mid - 1]) {
                    //Incresing Peak
                    lb = mid + 1;
                } else {
                    //Decreasing Peak
                    up = mid - 1;
                }
            }
            return result;
        }
    }
}
